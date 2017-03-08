package com.template.commons.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final String yyyyMMddTHHmmssSSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	private static final String yyyyMMddhhmmss = "yyyy-MM-dd hh:mm:ss";// 12小时制
	private static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";// 24小时制

	/**
	 * yyyy-MM-dd'T'HH:mm:ss.SSSZ
	 * 
	 * @return
	 */
	public static DateFormat getFormatByyyyyMMddTHHmmssSSSZ() {
		return new SimpleDateFormat(yyyyMMddTHHmmssSSSZ);
	}

	/**
	 * yyyy-MM-dd hh:mm:ss 12小时制
	 * 
	 * @return
	 */
	public static DateFormat getFormatByyyyyMMddhhmmss() {
		return new SimpleDateFormat(yyyyMMddhhmmss);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss 24小时制
	 * 
	 * @return
	 */
	public static DateFormat getFormatByyyyyMMddHHmmss() {
		return new SimpleDateFormat(yyyyMMddHHmmss);
	}

	/**
	 * 获取yyyy-MM-dd'T'HH:mm:ss.SSSZ日期格式字符串
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static String getStringByyyyyMMddTHHmmssSSSZ(Date date) {
		return getFormatByyyyyMMddTHHmmssSSSZ().format(date);
	}

	/**
	 * 获取yyyy-MM-dd hh:mm:ss 12小时制日期格式字符串
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static String getStringByyyyyMMddhhmmss(Date date) {
		return getFormatByyyyyMMddhhmmss().format(date);
	}

	/**
	 * 获取yyyy-MM-dd HH:mm:ss 24小时制日期格式字符串
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static String getStringByyyyyMMddHHmmss(Date date) {
		return getFormatByyyyyMMddHHmmss().format(date);
	}

	/**
	 * 获取yyyy-MM-dd'T'HH:mm:ss.SSSZ格式日期
	 * 
	 * @param date
	 *            日期字符串
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateByyyyyMMddTHHmmssSSSZ(String date) throws ParseException {
		return getFormatByyyyyMMddTHHmmssSSSZ().parse(date);
	}

	/**
	 * 获取yyyy-MM-dd hh:mm:ss 12小时制格式日期
	 * 
	 * @param date
	 *            日期字符串
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateByyyyyMMddhhmmss(String date) throws ParseException {
		return getFormatByyyyyMMddhhmmss().parse(date);
	}

	/**
	 * 获取yyyy-MM-dd HH:mm:ss 24小时制格式日期
	 * 
	 * @param date
	 *            日期字符串
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateByyyyyMMddHHmmss(String date) throws ParseException {
		return getFormatByyyyyMMddHHmmss().parse(date);
	}

	/**
	 * 取得当前UTC时间
	 * 
	 * @return
	 */
	public static Date getUTCTime() {
		// 1、取得本地时间：
		Calendar cal = Calendar.getInstance();
		// 2、取得时间偏移量：
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		// 3、取得夏令时差：
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		// 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		// 之后调用cal.get(int x)或cal.getTimeInMillis()方法所取得的时间即是UTC标准时间
		Date date = new Date(cal.getTimeInMillis());
		return date;
	}
}
