package com.template.commons.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SpringHelper {

	public static Object getBean(String name) {
		WebApplicationContext ctx = AppContext.getInstance().getAppContext();
		return ctx.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		WebApplicationContext ctx = AppContext.getInstance().getAppContext();
		return ctx.getBean(name, clazz);
	}

	static class AppContext {
		private static AppContext instance;
		private volatile WebApplicationContext appContext;

		public synchronized static AppContext getInstance() {
			if (instance == null) {
				instance = new AppContext();
			}
			return instance;
		}

		private AppContext() {
			this.appContext = ContextLoader.getCurrentWebApplicationContext();
		}

		public WebApplicationContext getAppContext() {
			return appContext;
		}
	}

}
