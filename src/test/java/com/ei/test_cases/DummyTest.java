package com.ei.test_cases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.ei.utils.Configuration;

public class DummyTest {

	@Test
	public void test1() {

		try (FileInputStream file = new FileInputStream(Configuration.getUserDataFile());) {

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Alarms");
//			Iterator<Row> rowIterator = sheet.iterator();
//			while(rowIterator.hasNext()) {
//				Row row= rowIterator.next();
//				Iterator<Cell> cellIterator = row.cellIterator();
//				while(cellIterator.hasNext()) {
//					Cell cell = cellIterator.next();
//					System.out.print(cell.getStringCellValue()+"\t");
//				}
//				System.out.println();
//			}
			int rows = sheet.getLastRowNum();
			for (int i = 1; i <= rows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					System.out.print(row.getCell(j));
				}
				System.out.println();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
