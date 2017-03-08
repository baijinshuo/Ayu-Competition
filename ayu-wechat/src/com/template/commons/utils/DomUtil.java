package com.template.commons.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DomUtil {
	private static final Logger log = LoggerFactory.getLogger(DomUtil.class);
	/**
	 * XML字符串转换成org.dom4j.Document对象
	 * 
	 * @param xmlContext
	 * @return
	 * @throws DocumentException
	 */
	public static Document getDocument(String xmlContext) throws DocumentException {
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xmlContext);
		} catch (DocumentException e) {
			log.error("XML字符串转换成org.dom4j.Document对象", e);
			throw e;
		}
		return doc;
	}

	/**
	 * XML文件转换成org.dom4j.Document对象
	 * 
	 * @param file
	 * @return
	 * @throws DocumentException
	 */
	public static Document getDocument(File file) throws DocumentException {
		SAXReader saxReader = new SAXReader();
		Document doc = null;
		try {
			doc = saxReader.read(file);
		} catch (DocumentException e) {
			log.error("XML文件转换成org.dom4j.Document对象", e);
			throw e;
		}
		return doc;
	}

	/**
	 * org.dom4j.Document对象转换成XML文件
	 * 
	 * @param doc
	 * @param xmlFileName
	 * @throws IOException
	 */
	public static void documentToFile(Document doc, File xmlFile) throws IOException {
		try {
			// 输出格式使用4个空格作为缩进字符串，元素之间添加新行
			OutputFormat format = new OutputFormat("    ", true);
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(xmlFile), format);
			xmlWriter.write(doc);
			xmlWriter.close();
		} catch (IOException e) {
			log.error("org.dom4j.Document对象转换成XML文件", e);
			throw e;
		}
	}

	/**
	 * org.dom4j.Document对象转换成XML字符串
	 * 
	 * @param doc
	 * @throws IOException
	 */
	public static String documentToFile(Document doc) throws IOException {
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			StringWriter writer = new StringWriter();
			XMLWriter xmlWriter = new XMLWriter(writer, format);
			xmlWriter.write(doc);
			xmlWriter.close();
			return writer.toString();
		} catch (IOException e) {
			log.error("org.dom4j.Document对象转换成XML字符串", e);
			throw e;
		}
	}

}
