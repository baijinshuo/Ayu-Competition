package com.template.commons.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {
	/**
	 * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static String getIpAddress(HttpServletRequest request) throws IOException {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
				if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
					// 根据网卡取本机配置的IP
					List<String> ipList = new ArrayList<String>();
					for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements();) {
						NetworkInterface networkInterface = interfaces.nextElement();
						if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
							continue;
						}
						Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
						if (addresses.hasMoreElements()) {
							String clientIP = addresses.nextElement().getHostAddress();
							ipList.add(clientIP);
						}
					}
					ip = ipList.get(0);
				}
			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}

}
