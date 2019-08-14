package com.ei.pageObjects.common.enumeration.column;

import com.ei.pageObjects.common.enumeration.CustomItems;

public enum AlarmsColumns implements CustomItems {
	description(0), severity(2), severityScore(3), priority(4), resolved(5), timestamp(6), triggerTime(7),
	computerName(8), fileName(9), process(10), parentProcess(11), commandLine(12), user(13), userRealName(14),
	jobPosition(15), orgPosition(16), userDescription(17), ruleName(18), category(19), threatName(20), sha1(21),
	taskName(22), comment(23), url(24), triggerEvent(25), scannerId(26), mitreFields(27), changeDate(28), changedBy(29),
	changeType(30);

	private int ind;

	private AlarmsColumns(int ind) {
		this.ind = ind;
	}

	@Override
	public int getIndex() {
		return this.ind;
	}

}
