package com.ei.util;

import org.testng.annotations.DataProvider;

public class EIDataProvider {

	@DataProvider(name = "specificValues")
	public static Object[][] getFilterValues() {
		return new Object[][] { { "!" }, { "@" }, { "#" }, { "$" }, {"\\"} };
	}
}
