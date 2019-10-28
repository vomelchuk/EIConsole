package com.ei.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.ei.utils.Configuration;

public class EIDataProvider {

	@DataProvider(name = "specificValues")
	public static Object[][] getFilterValues() {
		return new Object[][] { { "!" }, { "@" }, { "#" }, { "$" }, { "\\" } };
	}

	@DataProvider(name = "fileValues")
	public static Object[][] getDataFromFile(Method methodName) {

		Object[][] obj = null;
		String viewName = null;

		String view = methodName.getName();
		if (view.toUpperCase().contains("ALARM")) {
			viewName = "Alarms";
		}

		try (FileInputStream file = new FileInputStream(Configuration.getUserDataFile());
				XSSFWorkbook workbook = new XSSFWorkbook(file);) {
			XSSFSheet sheet = workbook.getSheet(viewName);
			obj = new Object[sheet.getLastRowNum()][2];
			int rows = sheet.getLastRowNum();
			for (int i = 1; i <= rows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					obj[i - 1][j] = row.getCell(j).toString();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return obj;
	}
}
