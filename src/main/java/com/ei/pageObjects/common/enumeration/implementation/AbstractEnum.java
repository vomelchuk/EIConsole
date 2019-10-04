package com.ei.pageObjects.common.enumeration.implementation;

import com.ei.pageObjects.common.enumeration.FilterType;
import com.ei.pageObjects.common.enumeration.Sortable;

public interface AbstractEnum {
	String getColumnName();

	int getColumnIndex();

	String getFilterName();

	FilterType getFilterType();
	
	Sortable sorted();
}
