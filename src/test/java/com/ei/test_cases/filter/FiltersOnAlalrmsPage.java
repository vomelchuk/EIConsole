package com.ei.test_cases.filter;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.ei.businessObjects.NavigateToViewBO;
import com.ei.businessObjects.SortingBO;
import com.ei.pageObjects.common.enumeration.FilterType;
import com.ei.pageObjects.common.enumeration.implementation.Alarms;
import com.ei.test_cases.BaseTestLogged;
import com.ei.util.EIDataProvider;
import com.ei.util.TestUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class FiltersOnAlalrmsPage extends BaseTestLogged {

	Logger log = Logger.getLogger(FiltersOnAlalrmsPage.class.getName());

	@Test
	@Description("Navigate to Alarms page")
	@Story("After login has done user is navigating to Alarms view")
	@Severity(SeverityLevel.CRITICAL)
	public void navigationToAlarmsPageTest() {
		NavigateToViewBO.getAlarmsPage();
		String pageName = SortingBO.getViewName();
		sa.assertEquals(pageName, "Alarms");
		sa.assertAll();
	}

	@Test(enabled = true)
	@Description("Verifying text filters based on real values")
	@Story("Each text filter on Alarm view is verifying based on random value taken from the view")
	@Severity(SeverityLevel.MINOR)
	public void textFiltersTest() {
		NavigateToViewBO.getAlarmsPage();
//		SoftAssert asserts = new SoftAssert();
		for (Alarms filter : Alarms.values()) {
			if (filter.getFilterType() != FilterType.TEXT)
				continue;
			TestUtils.getFilterResult(filter, sa);
		}
		sa.assertAll();
	}
	
	
	@Test(enabled=true)
	@Description("Verifying numeric filters based on real values")
	@Story("Each numeric filter on Alarm view is verifying based on random value taken from the view")
	@Severity(SeverityLevel.MINOR)
	public void numericFiltersTest() {
		NavigateToViewBO.getAlarmsPage();
//		SoftAssert asserts = new SoftAssert();
		for (Alarms filter : Alarms.values()) {
			if (filter.getFilterType() != FilterType.NUMERIC)
				continue;
			TestUtils.getFilterResult(filter, sa);
		}
		sa.assertAll();
	}

	@Test(dataProvider = "specificValues", dataProviderClass = EIDataProvider.class)
	@Description("Verifying text filters based on specific characters")
	@Story("Each text filter on Alarm view is verifying based on specific values")
	@Severity(SeverityLevel.MINOR)
	public void textFiltersSpecificCharactersTest(String value) {
		NavigateToViewBO.getAlarmsPage();
//		SoftAssert asserts = new SoftAssert();
		TestUtils.getFilterResult(Alarms.COMMAND_LINE, value, sa);
		sa.assertAll();
	}

}
