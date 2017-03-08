package com.template.commons.utils;

import java.math.BigDecimal;

public class BigDecimalUtil {
	/**
	 * 加法运算
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double add(double d1, double d2) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.add(b2).doubleValue();
	}

	/**
	 * 减法运算
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double sub(double d1, double d2) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 乘法运算
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double mul(double d1, double d2) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 除法运算
	 * 
	 * @param d1
	 * @param d2
	 * @param len
	 * @return
	 */
	public static double div(double d1, double d2, int len) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 元转换为分
	 * 
	 * @param price
	 * @return
	 */
	public static String convertMoney(String price) {
		BigDecimal refundMoney = new BigDecimal(price).multiply(new BigDecimal("100")).setScale(0);
		return refundMoney.toString();
	}

}
