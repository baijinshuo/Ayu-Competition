package com.template.commons.utils;

import java.util.Map;



public class MapUitil {
	
	//将map转为xml格式
		public static String mapToXml(Map<String, String> params){
		StringBuilder xml = new StringBuilder();
		xml.append("<xml>\n");
			for (Map.Entry<String, String> entry : params.entrySet()) {
				if(entry.getValue()!=null){
					xml.append("<" + entry.getKey() + ">").append(entry.getValue()).append("</" + entry.getKey() + ">\n");
				}
			}
		xml.append("</xml>");
		return xml.toString();
		}

}
