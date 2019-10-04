package com.ei.pageObjects.common.enumeration.implementation;

import com.ei.pageObjects.common.enumeration.FilterType;
import com.ei.pageObjects.common.enumeration.Sortable;

public enum AlarmRules implements AbstractEnum {
	RULE_NAME("name", 0, "name", FilterType.TEXT, Sortable.YES), 
	AUTHOR("author", 1, "author", FilterType.TEXT, Sortable.YES),
	ENABLED("enabled", 2, "enabled", FilterType.LOGIC, Sortable.YES), 
	VALID("valid", 3, "valid", FilterType.LOGIC, Sortable.YES),
	SEVERITY("severity", 4, null, FilterType.SEVERITY, Sortable.YES),
	SEVERITY_SCORE("severityScore", 5, "severityScore", FilterType.NUMERIC, Sortable.YES),
	CATEGORY("category", 6, "category", FilterType.TEXT, Sortable.YES),
	LAST_CHANGE_DATE("timestamp", 7, "timestamp", FilterType.TIME, Sortable.YES),
	MITRE_ATTACK_TECHNIQUES("mitreFields", 8, "mitreFields", FilterType.TEXT, Sortable.NO),
	LAST_CHANGE_BY("changedBy", 9, "changedBy", FilterType.TEXT, Sortable.YES),
	LAST_CHANGE_TYPE("changeType", 10, "changeType", FilterType.DROP_DOWN, Sortable.YES);

	private String columnName;
	private int columnIndex;
	private String filterName;
	private FilterType filterType;
	private Sortable isSorted;

	private AlarmRules(String columnName, int columnIndex, String filterName, FilterType filterType, Sortable isSorted) {
		this.columnName = columnName;
		this.columnIndex = columnIndex;
		this.filterName = filterName;
		this.filterType = filterType;
		this.isSorted = isSorted;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public int getColumnIndex() {
		return this.columnIndex;
	}

	public String getFilterName() {
		return this.filterName;
	}

	public FilterType getFilterType() {
		return this.filterType;
	}

	public Sortable sorted() {
		return isSorted;
	}

}
