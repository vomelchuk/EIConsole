package com.ei.pageObjects.common.pages.localFilters;

public interface LocalFilter {

	<T> void setValue(T value);

	void clearValue();

	void setFilterOption(FilterOption option);
	

}
