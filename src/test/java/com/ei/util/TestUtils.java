package com.ei.util;

import java.util.List;

import org.apache.log4j.Logger;
import com.ei.businessObjects.FilterAndColumnVisibilityBO;
import com.ei.businessObjects.FilterOperationsBO;
import com.ei.businessObjects.SortingBO;
import com.ei.pageObjects.common.enumeration.SortingMode;
import com.ei.pageObjects.common.enumeration.implementation.AbstractEnum;

public class TestUtils {

	static Logger log = Logger.getLogger(TestUtils.class);

	public static void performSorting(AbstractEnum column, EISoftAssert asserts) {
		if (column.getColumnIndex() != 0) {
			FilterAndColumnVisibilityBO.addColumn(column);
		} else {
			return;
		}
		getSortResult(SortingMode.ASCEND, column, asserts);
		getSortResult(SortingMode.DESCEND, column, asserts);
	}

	private static void getSortResult(SortingMode sort, AbstractEnum column, EISoftAssert asserts) {
		SortingBO.sortTableByColumn(column, sort);
		List<String> values = SortingBO.getColumnValues(column);
		log.debug("Sorting column " + column + " by " + sort);
		log.debug(values.size() + " items sorted");
		boolean sorted = Calculation.areValuesSorted(values, sort);
		log.debug("Sorted result: " + sorted);
		asserts.assertTrue(sorted);

	}

	public static void getFilterResult(AbstractEnum filter, EISoftAssert asserts) {
		FilterAndColumnVisibilityBO.resetFiltersAndColumns();
		FilterAndColumnVisibilityBO.addFilter(filter);
		if (filter.getColumnIndex() != 0)
			FilterAndColumnVisibilityBO.addColumn(filter);
		log.debug("Verifying filter: " + filter);

		for (int i = 0; i < 1; i++) {
			switch (filter.getFilterType()) {
			case TEXT:
				FilterOperationsBO.clearTextValue();
				break;
			case NUMERIC:
				FilterOperationsBO.clearNumberValue();
			default:
				break;
			}
			;
			String test = FilterOperationsBO.getRandomValue(filter);
			String matchedValue = test;
			switch (filter.getFilterType()) {
			case TEXT:
				FilterOperationsBO.setTextValue(matchedValue);
				break;
			case NUMERIC:
				int n;
				try {
					n = Integer.valueOf(matchedValue);
				} catch (NumberFormatException e) {
					n = Integer
							.valueOf(matchedValue.substring(matchedValue.indexOf("(") + 1, matchedValue.length() - 1));
				}
				FilterOperationsBO.setNumberValue(n);
			default:
				break;
			}
			List<String> items = FilterOperationsBO.getFilteredValuesByColumn(filter);
			log.debug("Filter set to " + matchedValue);
			log.debug("returned " + items.size() + " rows");
			asserts.assertTrue(items.size() > 0,
					filter + " set to " + matchedValue + ". 0 records returned, had to be at least 1 record");
			for (String item : items) {
				asserts.assertTrue(item.toLowerCase().contains(matchedValue.toLowerCase()),
						matchedValue + " doesn`t match " + item);
			}

		}
	}

	public static void getFilterResult(AbstractEnum filter, String value, EISoftAssert asserts) {
		FilterAndColumnVisibilityBO.resetFiltersAndColumns();
		FilterAndColumnVisibilityBO.addFilter(filter);
		if (filter.getColumnIndex() != 0)
			FilterAndColumnVisibilityBO.addColumn(filter);
		log.debug("Verifying filter: " + filter);
		FilterOperationsBO.clearTextValue();
		FilterOperationsBO.setTextValue(value);
		List<String> items = FilterOperationsBO.getFilteredValuesByColumn(filter);
		log.debug("Filter set to " + value);
		log.debug("returned " + items.size() + " rows");
		for (String item : items) {
			asserts.assertTrue(item.toLowerCase().contains(value.toLowerCase()), value + " doesn`t match " + item);
		}

	}

}
