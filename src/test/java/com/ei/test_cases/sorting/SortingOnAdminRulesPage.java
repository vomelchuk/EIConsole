package com.ei.test_cases.sorting;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.ei.businessObjects.FilterAndColumnVisibilityBO;
import com.ei.businessObjects.NavigateToViewBO;
import com.ei.businessObjects.SortingBO;
import com.ei.pageObjects.common.enumeration.FilterType;
import com.ei.pageObjects.common.enumeration.Sortable;
import com.ei.pageObjects.common.enumeration.implementation.AlarmRules;
import com.ei.test_cases.BaseTestLogged;
import com.ei.test_cases.filter.FiltersOnAlarmRulesPage;
import com.ei.util.TestUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SortingOnAdminRulesPage extends BaseTestLogged {
	
	Logger log = Logger.getLogger(FiltersOnAlarmRulesPage.class);
	
	@Test
	@Description("Navigate to Alarm Rules page")
	@Story("After login has done user is navigating to Alarm Rules view")
	@Severity(SeverityLevel.CRITICAL)
	public void navigationToAdminRulesPageTest() {
		NavigateToViewBO.getAdminRulesPage();
		
		String pageName = SortingBO.getViewName();
		sa.assertEquals(pageName, "Admin");
		FilterAndColumnVisibilityBO.resetFiltersAndColumns();
		sa.assertAll();
	}

	@Test
	@Description("Verifying sorting columns")
	@Story("Sorting columns by ASC and DESC")
	@Severity(SeverityLevel.MINOR)
	public void sortingTextColumnsTest() {
		NavigateToViewBO.getAdminRulesPage();
		FilterAndColumnVisibilityBO.resetFiltersAndColumns();
		for (AlarmRules column : AlarmRules.values()) {
			if (column.getFilterType() != FilterType.TEXT || column.sorted() == Sortable.NO)
				continue;
			log.debug("Trying to sort by: "+ column);
			TestUtils.performSorting(column, sa);
		}
		sa.assertAll();
	}

}
