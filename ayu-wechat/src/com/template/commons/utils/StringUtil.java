package com.template.commons.utils;

public class StringUtil {
	
	public static String convert(String utfString)
    {
              StringBuilder sb = new StringBuilder();
              int i=-1;
              int pos=0;
              while((i=utfString.indexOf("\\u",pos))!=-1)
              {
                  sb.append(utfString.substring(pos,i));
                  if(i+5<utfString.length())
                  { 
                      pos=i+6;
                      sb.append((char)Integer.parseInt(utfString.substring(i+2,i+6),16));
                  }//if
              }//while
              return sb.toString();
    }
	
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim());
	}

	public static boolean isNotEmpty(String str) {
		return str != null && !"".equals(str);
	}
	
}
