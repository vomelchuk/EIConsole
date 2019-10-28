package com.ei.test_cases.filter;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ei.businessObjects.NavigateToViewBO;
import com.ei.businessObjects.SortingBO;
import com.ei.pageObjects.common.enumeration.FilterType;
import com.ei.pageObjects.common.enumeration.implementation.AlarmRules;
import com.ei.pageObjects.common.enumeration.implementation.Alarms;
import com.ei.test_cases.BaseTestLogged;
import com.ei.util.TestUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class FiltersOnAlarmRulesPage extends BaseTestLogged {

	Logger log = Logger.getLogger(FiltersOnAlarmRulesPage.class.getName());

	@Test(enabled = true)
	@Description("Verifying text filters on Alarm Rules page")
	@Story("Each text filter on Alarm Rules view is verifying based on random value taken from the view")
	@Severity(SeverityLevel.MINOR)
	public void textFiltersTest() {
		NavigateToViewBO.getAdminRulesPage();
//		SoftAssert asserts = new SoftAssert();
		for (AlarmRules filter : AlarmRules.values()) {
			if (filter.getFilterType() != FilterType.TEXT)
				continue;
			TestUtils.getFilterResult(filter, sa);
		}
		sa.assertAll();
	}

	@Test(enabled = true)
	@Description("Verifying numeric filters on Alarm Rules page")
	@Story("Each text number on Alarm Rules view is verifying based on random value taken from the view")
	@Severity(SeverityLevel.MINOR)
	public void numericFiltersTest() {
		NavigateToViewBO.getAdminRulesPage();
//		SoftAssert asserts = new SoftAssert();
		for (AlarmRules filter : AlarmRules.values()) {
			if (filter.getFilterType() != FilterType.NUMERIC)
				continue;
			TestUtils.getFilterResult(filter, sa);
		}
		sa.assertAll();
		Assert.assertEquals(1, 1);
	}
}
