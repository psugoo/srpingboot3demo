package com.wtkj.springbootdemo.utils;

/**
 * 
 * @author 宋琰
 */
public class Assert {
	/**
	 * 判断 对象 不为 NULL
	 * 
	 * @param obj
	 *            任意对象
	 * @return 如果不为NULL，返回true
	 */
	public static boolean notNull(Object obj) {
		return obj != null;
	}

	/**
	 * 判断 对象 为 NULL
	 * 
	 * @param obj
	 *            任意对象
	 * @return 如果为NULL，返回true
	 */
	public static boolean isNull(Object obj) {
		return !notNull(obj);
	}

	/**
	 * 判断 字符串 不为 空（字符串的Empty）
	 * 
	 * @param str
	 *            任意字符串
	 * @return 如果字符串不为NULL,平且不为EMPTY，返回true
	 */
	public static boolean notEmpty(String str) {
		return notNull(str) && (str.trim().length() > 0);
	}

	/**
	 * 判断 字符串 为 空（字符串的Empty）
	 * 
	 * @param str
	 *            任意字符串
	 * @return 如果字符串为NULL,或者为EMPTY，返回true
	 */
	public static boolean isEmpty(String str) {
		return !notEmpty(str);
	}

	/**
	 * 判断 字符串 不为 NULL或EMPTY（字符串的Empty）
	 * 
	 * @param str
	 *            任意字符串
	 * @return 如果字符串不为NULL,并且不为EMPTY，返回true
	 */
	public static boolean notNullOrEmpty(String str) {
		return notNull(str) && notEmpty(str);
	}

	/**
	 * 判断 字符串 为 空（字符串的Empty）
	 * 
	 * @param str
	 *            任意字符串
	 * @return 如果字符串为NULL,并且为EMPTY，返回true
	 */
	public static boolean isNullOrEmpty(String str) {
		return !notNullOrEmpty(str);
	}
}
