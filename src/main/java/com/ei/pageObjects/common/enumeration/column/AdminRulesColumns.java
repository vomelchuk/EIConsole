package com.ei.pageObjects.common.enumeration.column;

import com.ei.pageObjects.common.enumeration.CustomItems;

public enum AdminRulesColumns implements CustomItems {

	name(0), author(1), enabled(2), valid(3), severity(4), severityScore(5), category(6), timestamp(7), mitreFields(8),
	changedBy(9), changeType(10);

	private int ind;

	private AdminRulesColumns(int ind) {
		this.ind = ind;
	}

	@Override
	public int getIndex() {
		return this.ind;
	}

}
