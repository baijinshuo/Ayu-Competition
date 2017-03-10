package com.template.commons.utils;

import java.util.Random;

public class RandomUtil {
	private static final Random r = new Random();
	/**
	 * 默认生成6位随机数
	 * @return
	 */
	public static String random(){
		return random(6);
	}
	/**
	 * 生成9位以下随机数
	 * @param num
	 * @return
	 */
	public static String random(int num) {
		if (num < 1 || num > 9) {
			return "";
		}
		int a = (int) (Math.pow(10, num) - Math.pow(10, num - 1));
		int result = r.nextInt(a) + (int) Math.pow(10, num - 1);
		return result + "";
	}
}
