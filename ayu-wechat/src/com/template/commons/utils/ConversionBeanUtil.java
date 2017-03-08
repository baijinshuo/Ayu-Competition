package com.template.commons.utils;

import java.lang.reflect.Method;

public class ConversionBeanUtil {

	/**
	 * Bean对象属性赋值
	 * 
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 * @throws Exception
	 */
	public static void conversion(Object source, Object target) throws Exception {
		Method[] targetMethods = target.getClass().getDeclaredMethods();
		for (Method targetMethod : targetMethods) {
			String methodName = targetMethod.getName();
			if (methodName.startsWith("get")) {
				Method getMethod = source.getClass().getMethod(methodName);
				Object sourceValue = getMethod.invoke(source);
				if (sourceValue != null) {
					String setMethod = "s" + methodName.substring(1);
					Class<?> className = targetMethod.getReturnType();
					Class<?>[] paramTypes = new Class[] { className };
					Method method = target.getClass().getMethod(setMethod, paramTypes);
					Object[] params = new Object[] { sourceValue };
					method.invoke(target, params);
				}
			}
		}
	}

}
