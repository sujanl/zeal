package com.maggots.zeal.utils;



import java.util.List;

/**
 * String utility class
 * 
 * @author
 * @version 1.0.0
 * @since 1.0.0
 */
public class StringUtils {
	public static boolean contains(List<String> stringList, String value) {
		return stringList.contains(value);
	}


	public static String capitalizeFirstLetter(String original) {
		if (original == null || original.length() == 0) {
			return original;
		}
		String lowerCase = original.toLowerCase();
		return lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1);
	}

}
