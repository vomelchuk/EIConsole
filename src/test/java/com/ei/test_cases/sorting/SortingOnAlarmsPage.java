package com.ei.test_cases.sorting;

import org.testng.annotations.Test;

import com.ei.businessObjects.FilterAndColumnVisibilityBO;
import com.ei.businessObjects.NavigateToViewBO;
import com.ei.pageObjects.common.enumeration.FilterType;
import com.ei.pageObjects.common.enumeration.Sortable;
import com.ei.pageObjects.common.enumeration.implementation.Alarms;
import com.ei.test_cases.BaseTestLogged;
import com.ei.util.TestUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SortingOnAlarmsPage extends BaseTestLogged {

	@Test
	@Description("Verifying sorting columns")
	@Story("Sorting columns by ASC and DESC")
	@Severity(SeverityLevel.MINOR)
	public void sortingTextColumnsTest() {
		NavigateToViewBO.getAlarmsPage();
		FilterAndColumnVisibilityBO.resetFiltersAndColumns();
		for (Alarms column : Alarms.values()) {
			if (column.getFilterType() != FilterType.TEXT || column.sorted() == Sortable.NO)
				continue;
			TestUtils.performSorting(column, sa);
		}
		sa.assertAll();
	}

//	@Test
//	public void sortingByAlarmsTest() {
//		Alarms column = Alarms.ALARMS;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingBySeverityScoreTest() {
//		Alarms column = Alarms.SEVERITY_SCORE;
//		TestUtils.performSorting(column);
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(1, 1);
//		Assert.assertEquals(1, 21);
//
//		sa.assertAll();
//
//	}
//
//	@Test
//	public void sortingByOccuredTimeTest() {
//		Alarms column = Alarms.OCCURED_TIME;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByTriggeredTimeTest() {
//		Alarms column = Alarms.TRIGGERED_TIME;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByComputerTest() {
//		Alarms column = Alarms.COMPUTER;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByEecutableTest() {
//		Alarms column = Alarms.EXECUTABLE;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByProcessNameTest() {
//		Alarms column = Alarms.PROCESS_NAME;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByParentProcessNameTest() {
//		Alarms column = Alarms.PARENT_PROCESS_NAME;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByCommandLineTest() {
//		Alarms column = Alarms.COMMAND_LINE;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByUserNameTest() {
//		Alarms column = Alarms.USERNAME;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByFulleNameTest() {
//		Alarms column = Alarms.FULL_NAME;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByJobPositionTest() {
//		Alarms column = Alarms.JOB_POSITION;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByUserDepartmentTest() {
//		Alarms column = Alarms.USER_DEPARTMENT;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByUserDescriptionTest() {
//		Alarms column = Alarms.USER_DESCRIPTION;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByRuleTest() {
//		Alarms column = Alarms.RULE;
//		TestUtils.performSorting(column);
//	}
//
//	@Test
//	public void sortingByCategoryTest() {
//		Alarms column = Alarms.CATEGORY;
//		TestUtils.performSorting(column);
//	}

}
