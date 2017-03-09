package com.template.commons.utils;

public class MathUtil {
	
	public static String toK(Integer n){
		String nstr = n+"";
		String str = "";
		if(n >= 1000){
			str = nstr.substring(0, 2);
			if(str.contains("0")){
				str = str.substring(0, 1)+"K";
			}else{
				str = str.substring(0, 1)+"."+str.substring(1, 2)+"K";
			}
		}else{
			str = n.toString();
		}
		return str;
	}

}
