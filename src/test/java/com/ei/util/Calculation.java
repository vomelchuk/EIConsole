package com.ei.util;

import java.util.List;
import com.ei.pageObjects.common.enumeration.SortingMode;

public class Calculation {
//	EILogger log = EILogger.getInstance();

	public static boolean areValuesSorted(List<String> list, SortingMode sortMode) {

		boolean isSorted = true;
		if (list.size() == 0)
			return isSorted;
		String previous = list.get(0);
		for (String current : list) {
			if ((current.equalsIgnoreCase("Unknown") || current.equalsIgnoreCase("None"))
					|| (previous.equalsIgnoreCase("Unknown") || previous.equalsIgnoreCase("None")))
				continue;
			int compare_result;
			try {
				compare_result = Integer.valueOf(previous).compareTo(Integer.valueOf(current));
			} catch (NumberFormatException e) {
				compare_result = previous.toLowerCase().compareTo(current.toLowerCase());
			}
//			System.out.println("\tCompare `" + previous + "` and `" + current + "` : " + compare_result);
			switch (sortMode) {
			case ASCEND:
				if (compare_result > 0) {
					isSorted = false;
				}
				break;
			case DESCEND:
				if (compare_result < 0) {
					isSorted = false;
				}
				break;
			default:
				break;
			}
			previous = current;
		}

		return isSorted;

	}

}
