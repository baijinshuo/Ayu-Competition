package com.template.commons.utils;

public class LogStatisticsUtils {
	protected static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger("LogCreate");
	private static String DESTFILE = null;// 统计日志路径
	private static String NAMEDATE = null;// 统计日志名称(时间戳)
	private static String TEXTDATE = null;// 内容时间串

	public LogStatisticsUtils() {
		String tomcatDir = System.getProperty("catalina.base");
		java.util.Calendar cald = java.util.Calendar.getInstance();
		NAMEDATE = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cald.getTime());
		TEXTDATE = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SS").format(cald.getTime());
		StringBuffer destBuffer = new StringBuffer();
		if (tomcatDir != null && !"".equals(tomcatDir)) {
			destBuffer.append(tomcatDir);
			destBuffer.append("/logs/ylcm-pc/statistics");
		} else {
			destBuffer.append(javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory());
		}
		destBuffer.append("/optLog_");
		destBuffer.append(NAMEDATE);
		destBuffer.append(".log");
		DESTFILE = destBuffer.toString();
		log.info("toDest:" + DESTFILE);
	}

	/**
	 * 统计功能日志参数(生成日志文件)
	 * 
	 * @param optId
	 *            统计枚举类-id,非空
	 * @param userId
	 *            用户Id,如果是登录用户就传，否则null
	 * @param relativeId
	 *            关联id，可空(页面访问时非空,relativeType非空)
	 * @param relativeType
	 *            关联类型(2活动或者1社区)，可空(页面访问时非空,relativeType非空)
	 * @param ip
	 *            客户端Ip,非空(request获取)
	 * @param url
	 *            客户访问url,非空(request获取)
	 */
	public final void logInit(final int optId, final Integer userId, final Integer relativeId, final Integer relativeType, final String ip, final String url) {
		if (optId > 0) {
			nioWriteLog(optId, userId, relativeId, relativeType, ip, url);
		}
	}

	/**
	 * 写日志
	 * 
	 * @param optId
	 * @param userId
	 * @param relativeId
	 * @param ip
	 * @param url
	 */
	private void nioWriteLog(int optId, Integer userId, Integer relativeId, Integer relativeType, String ip, String url) {
		StringBuffer sbf = new StringBuffer();
		try {
			java.io.File nFile = new java.io.File(DESTFILE);
			if (!nFile.getParentFile().exists()) {
				nFile.getParentFile().mkdirs();
			}
			if (!nFile.exists()) {
				nFile.createNewFile();
			}

			// 获取当前文件的大小
			long nFileLen = nFile.length();
			// 为了以可读可写的方式打开文件，这里使用RandomAccessFile来创建文件
			java.io.RandomAccessFile raf = new java.io.RandomAccessFile(nFile, "rw");
			// 设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作
			raf.seek(nFileLen);

			if (nFileLen > 0) {
				sbf.append(",\r\n");
			}
			sbf.append("{");
			sbf.append("\"optId\":\"" + optId + "\"");
			sbf.append(",\"createTime\":\"" + TEXTDATE + "\"");
			if (userId != null) {
				sbf.append(",\"userId\":\"" + userId + "\"");
			}
			if (relativeId != null) {
				sbf.append(",\"relativeId\":\"" + relativeId + "\"");
			}
			if (relativeType != null) {
				sbf.append(",\"relativeType\":\"" + relativeType + "\"");
			}
			if (ip != null && !"".equals(ip)) {
				sbf.append(",\"ip\":\"" + ip + "\"");
			}
			if (url != null && !"".equals(url)) {
				sbf.append(",\"url\":\"" + url + "\"");
			}
			sbf.append("}");

			raf.writeBytes(sbf.toString());

			java.nio.channels.FileChannel fileChannel = raf.getChannel();

			// 文件通道的可读可写要建立在文件流本身可读写的基础之上
			java.nio.MappedByteBuffer mpbb = fileChannel.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0, nFileLen);

			// 写入
			mpbb.flip();

			if (raf.length() > 0) {
				raf.close();
			}

		} catch (Exception ex) {
			log.error("logDeal:" + ex);
		}
	}

}
