package com.ei.testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ei.pageObjects._later.DashboardPage;
import com.ei.pageObjects.admin.tabs.alarmRules.AdminAlalrmRulesSelectColumnsPage;
import com.ei.pageObjects.admin.tabs.alarmRules.AdminAlarmRulesPage;
import com.ei.pageObjects.alarms.AlarmsPage;
import com.ei.pageObjects.alarms.AlarmsSelectColumnsPage;
import com.ei.pageObjects.common.enumeration.column.AdminRulesColumns;
import com.ei.pageObjects.common.enumeration.column.AlarmsColumns;
import com.ei.pageObjects.common.enumeration.filter.AdminRulesFilters;
import com.ei.pageObjects.common.enumeration.filter.AlarmsFilters;
import com.ei.utils.Configuration;

public class DummyTest extends BaseTest {

	DashboardPage dashboard;
	AlarmsPage alarms;
	AdminAlalrmRulesSelectColumnsPage addFilter;
	AlarmsSelectColumnsPage selectColumns;

	@Test(priority = 1)
	public void dummyTest() {

		String user = Configuration.get("username");
		String passw = Configuration.get("password");
		dashboard = login.loginAsNativeUser(user, passw);
		String loggedUser = dashboard.getLoggedUsername();
		// testWait();
		Assert.assertEquals(loggedUser, user.toUpperCase());
		alarms = dashboard.getAlarmsPage();
		// testWait();

		/*
		 * addFilter = alarms.getAddFilterPage();
		 * 
		 * for(Enum<?> item: AlarmRulesColumnNames.values()) { testWait(1); if (item ==
		 * AlarmRulesColumnNames.name) continue;
		 * alarmRules.clickTableElement(item.toString(), 1); }
		 * 
		 * 
		 * for(Enum<?> filter: AlarmsFilters.values()) { //testWait(1);
		 * addFilter.checkFilter(filter.toString());
		 * //System.out.println("Filter ["+addFilter.getFilterName(filter.toString())
		 * +"] checked ["+addFilter.isFilterChosen(filter.toString())+"]"); }
		 * 
		 * addFilter.applyAddingFilters();
		 * 
		 */
		/*
		 * for(Enum<?> filter: AlarmsColumns.values()) { //testWait(1);
		 * //System.out.println(filter);
		 * alarms.clickColumnByColumnName(filter.toString());
		 * //System.out.println("Filter ["+addFilter.getFilterName(filter.toString())
		 * +"] checked ["+addFilter.isFilterChosen(filter.toString())+"]"); }
		 */
		/*
		 *
		 * 
		 * for(Enum<?> item: AlarmsColumns.values() ) {
		 * System.out.println("item:"+item+"; ordinal:" + item.ordinal()); }
		 */
		//
		//alarms.refreshView();
		
		
		//alarms.clickTableElement(AlarmsColumns.fileName.toString(), 3);
		//selectColumns = alarms.getSelectColumnsPage();


		//testWait(7);
		/*
		 * String column = AlarmsColumns.commandLine.toString();
		 * 
		 * alarms.clickColumnByColumnName(column); //testWait(4); int c = 0;
		 * List<WebElement> columnValues =
		 * alarms.getAllColumnValuesByColumnName(column); for (WebElement columnValue :
		 * columnValues) { System.out.println(++c + ": " + columnValue.getText()); }
		 */
		AdminAlarmRulesPage rules =  alarms.getAdminAlarmsRulesPage();
		//String column = AdminRulesColumns.category.toString();

		//rules.clickColumnByColumnName(column);
		//testWait(4);
		//int c = 0;
		//List<WebElement> columnValues = rules.getAllColumnValuesByColumnName(column);
		for (Enum<?> item : AdminRulesColumns.values()) {
			System.out.println("\nclicking on columnName: " + item.toString());
			rules.clickColumnByColumnName(item.toString());
			//System.out.println("Column " + item + ": "+ selectColumns.isFilterChosen(item.toString()));
			
		}
		//testWait(15);

	}

	public void testWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
