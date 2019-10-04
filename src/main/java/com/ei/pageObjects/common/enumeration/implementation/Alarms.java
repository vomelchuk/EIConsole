package com.ei.pageObjects.common.enumeration.implementation;

import com.ei.pageObjects.common.enumeration.FilterType;
import com.ei.pageObjects.common.enumeration.Sortable;

public enum Alarms implements AbstractEnum {
	ALARMS("description", 0, "userType", FilterType.DROP_DOWN, Sortable.YES), 
	SEVERITY("severity", 2, null, FilterType.SEVERITY, Sortable.YES),
	SEVERITY_SCORE("severityScore", 3, "severityScore", FilterType.NUMERIC, Sortable.YES),
	PRIORITY("priority", 4, null, FilterType.PRIORITY, Sortable.YES), 
	RESOLVED("resolved", 5, "resolved", FilterType.LOGIC, Sortable.YES),
	OCCURED_TIME("timestamp", 6, "resolved", FilterType.TIME, Sortable.YES),
	TRIGGERED_TIME("triggerTime", 7, "triggerTime", FilterType.TIME, Sortable.YES),
	COMPUTER("computerName", 8, "computerName", FilterType.TEXT, Sortable.YES),
	EXECUTABLE("fileName", 9, "fileName", FilterType.TEXT, Sortable.YES), 
	PROCESS_NAME("process", 10, "processName", FilterType.TEXT, Sortable.YES),
	PROCESS_ID("process", 10, "systemProcessId", FilterType.NUMERIC, Sortable.YES),
	PARENT_PROCESS_NAME("parentProcess", 11, "parentProcessName", FilterType.TEXT, Sortable.YES),
	PARENT_PROCESS_ID("parentProcess", 11, "systemParentProcessId", FilterType.NUMERIC, Sortable.YES),
	COMMAND_LINE("commandLine", 12, "commandLine", FilterType.TEXT, Sortable.YES), 
	USERNAME("user", 13, "user", FilterType.TEXT, Sortable.YES),
	FULL_NAME("userRealName", 14, "userRealName", FilterType.TEXT, Sortable.YES),
	JOB_POSITION("jobPosition", 15, "jobPosition", FilterType.TEXT, Sortable.YES),
	USER_DEPARTMENT("orgPosition", 16, "orgPosition", FilterType.TEXT, Sortable.YES),
	USER_DESCRIPTION("userDescription", 17, "userDescription", FilterType.TEXT, Sortable.YES),
	RULE("ruleName", 18, "ruleName", FilterType.TEXT, Sortable.YES), 
	CATEGORY("category", 19, "category", FilterType.TEXT, Sortable.YES),
	THREAT_NAME("threatName", 20, "threatName", FilterType.TEXT, Sortable.YES),
	SHA_1("sha1", 21, "sha1", FilterType.TEXT, Sortable.YES),
	TASK_NAME("taskName", 22, "taskName", FilterType.TEXT, Sortable.YES), 
	COMMENT("comment", 23, "comment", FilterType.TEXT, Sortable.YES),
	URL("url", 24, "url", FilterType.TEXT, Sortable.YES), 
	TRIGGER_EVENT("triggerEvent", 25, null, null, Sortable.NO),
	SCANNER("scannerId", 26, "scannerId", FilterType.DROP_DOWN, Sortable.YES),
	MITRE_ATTACK_TECHNIQUES("mitreFields", 27, "mitreFields", FilterType.TEXT, Sortable.NO),
	LAST_CHANGE_DATE("changeDate", 28, "changeDate", FilterType.TIME, Sortable.YES),
	LAST_CHANGE_BY("changedBy", 29, "changedBy", FilterType.TEXT, Sortable.YES),
	LAST_CHANGE_TYPE("changeType", 30, "changeType", FilterType.DROP_DOWN, Sortable.YES);
	;

	private String columnName;
	private int columnIndex;
	private String filterName;
	private FilterType filterType;
	private Sortable isSorted;

	private Alarms(String columnName, int columnIndex, String filterName, FilterType filterType, Sortable isSorted) {
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
