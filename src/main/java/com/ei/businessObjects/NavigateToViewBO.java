package com.ei.businessObjects;

import com.ei.pageObjects.dashboard.DashboardPage;

public class NavigateToViewBO {
	private static DashboardPage dashboard = new DashboardPage();

	public static void getAlarmsPage() {
		dashboard.navigateToAlarmsPage();
	}
	
	public static void getAdminRulesPage() {
		dashboard.navigateToAdminAlarmsRulesPage();
	}
}
