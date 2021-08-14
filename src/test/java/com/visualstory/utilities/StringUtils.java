package com.visualstory.utilities;

public class StringUtils {

	public static String getClassName(String targetValue) {
		if (targetValue != null) {
			return targetValue.substring(targetValue.lastIndexOf(".") + 1, targetValue.length());
		} else
			return "";
	}

}
