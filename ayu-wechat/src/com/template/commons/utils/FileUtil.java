package com.template.commons.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
	private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

	// //////// 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。///////////////

	/**
	 * 字节流处理，从文件到文件
	 * 
	 * @param inFile
	 * @param outFile
	 * @throws IOException
	 */
	public static void streamHandle(File inFile, File outFile) throws IOException {
		OutputStream out = null;
		try {
			out = new FileOutputStream(outFile);
			streamHandle(inFile, out);
		} catch (IOException e) {
			log.error("字节流处理，从文件到文件", e);
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 字节流处理，从文件到输出流
	 * 
	 * @param inFile
	 * @param out
	 * @throws IOException
	 */
	public static void streamHandle(File inFile, OutputStream out) throws IOException {
		InputStream in = null;
		try {
			in = new FileInputStream(inFile);
			streamHandle(in, out);
		} catch (IOException e) {
			log.error("字节流处理，从文件到输出流", e);
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	/**
	 * 字节流处理，从文件到字节
	 * 
	 * @param inFile
	 * @return
	 * @throws IOException
	 */
	public static byte[] streamHandle(File inFile) throws IOException {
		InputStream in = null;
		byte[] b = null;
		try {
			// 为另一个输入流添加一些功能，即缓冲输入以及支持 mark 和 reset 方法的能力
			// in = new BufferedInputStream(new FileInputStream(inFile));
			in = new FileInputStream(inFile);
			b = streamHandle(in);
		} catch (IOException e) {
			log.error("字节流处理，从文件到字节", e);
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return b;
	}

	/**
	 * 字节流处理，从输入流到输出流
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void streamHandle(InputStream in, OutputStream out) throws IOException {
		try {
			byte[] b = new byte[1024];
			int length;
			while ((length = in.read(b)) != -1) {
				out.write(b, 0, length);
			}
			out.flush();
		} catch (IOException e) {
			log.error("字节流处理，从输入流到输出流", e);
			throw e;
		}
	}

	/**
	 * 字节流处理，从输入流到文件
	 * 
	 * @param in
	 * @param outFile
	 * @throws IOException
	 */
	public static void streamHandle(InputStream in, File outFile) throws IOException {
		OutputStream out = null;
		try {
			out = new FileOutputStream(outFile);
			streamHandle(in, out);
		} catch (IOException e) {
			log.error("字节流处理，从输入流到文件", e);
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 字节流处理，从输入流到字节
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static byte[] streamHandle(InputStream in) throws IOException {
		byte[] result = null;
		try {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream(); 
			byte[] temp = new byte[1024];
			int length;
			while ((length = in.read(temp)) != -1) {
				buffer.write(temp, 0, length);
			}
			result = buffer.toByteArray();
			buffer.flush();
			buffer.close();
		} catch (IOException e) {
			log.error("字节流处理，从输入流到字节", e);
			throw e;
		}
		return result;
	}

	/**
	 * 字节流处理，从字节到文件
	 * 
	 * @param b
	 * @param outFile
	 * @throws IOException
	 */
	public static void streamHandle(byte[] b, File outFile) throws IOException {
		OutputStream out = null;
		try {
			// 实现缓冲的输出流
			// out = new BufferedOutputStream(new FileOutputStream(outFile));
			out = new FileOutputStream(outFile);
			streamHandle(b, out);
		} catch (IOException e) {
			log.error("字节流处理，从字节到文件", e);
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 字节流处理，从字节到输出流
	 * 
	 * @param b
	 * @param out
	 * @throws IOException
	 */
	public static void streamHandle(byte[] b, OutputStream out) throws IOException {
		out.write(b);
		out.flush();
	}

	// //////////// 以字符为单位读取文件，常用于读文本，数字等类型的文件/////////////////////

	/**
	 * 字符流处理，从文件到文件
	 * 
	 * @param inFile
	 * @param outFile
	 * @throws IOException
	 */
	public static void readerHandle(File inFile, File outFile) throws IOException {
		Reader reader = null;
		try {
			reader = new BufferedReader(new FileReader(inFile));
			readerHandle(reader, outFile);
		} catch (IOException e) {
			log.error("字符流处理，从文件到输出流", e);
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	/**
	 * 字符流处理，从文件到输出流
	 * 
	 * @param inFile
	 * @param writer
	 * @throws IOException
	 */
	public static void readerHandle(File inFile, Writer writer) throws IOException {
		Reader reader = null;
		try {
			reader = new BufferedReader(new FileReader(inFile));
			readerHandle(reader, writer);
		} catch (IOException e) {
			log.error("字符流处理，从文件到输出流", e);
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	/**
	 * 字符流处理，从文件到字符
	 * 
	 * @param inFile
	 * @return
	 * @throws IOException
	 */
	public static String readerHandle(File inFile) throws IOException {
		String result = null;
		Reader reader = null;
		try {
			// 字符流通向字节流的桥梁
			// Reader reader = new InputStreamReader(new FileInputStream(inFile));
			// 用来写入字符文件的便捷类
			// Reader reader = new FileReader(inFile);
			// 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
			reader = new BufferedReader(new FileReader(inFile));
			result = readerHandle(reader);
		} catch (IOException e) {
			log.error("字符流处理，从文件到字符", e);
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return result;
	}

	/**
	 * 字符流处理，从输入流到输出流
	 * 
	 * @param reader
	 * @param writer
	 * @throws IOException
	 */
	public static void readerHandle(Reader reader, Writer writer) throws IOException {
		char[] tempchars = new char[1024];
		int length;
		while ((length = reader.read(tempchars)) != -1) {
			writer.write(tempchars, 0, length);
		}
		writer.flush();
	}

	/**
	 * 字符流处理，从输入流到文件
	 * 
	 * @param reader
	 * @param outFile
	 * @throws IOException
	 */
	public static void readerHandle(Reader reader, File outFile) throws IOException {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(outFile));
			readerHandle(reader, writer);
		} catch (IOException e) {
			log.error("字符流处理，从输入流到文件", e);
			throw e;
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * 字符流处理，从输入流到字符
	 * 
	 * @param reader
	 * @throws IOException
	 */
	public static String readerHandle(Reader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		char[] temp = new char[1024];
		int length;
		while ((length = reader.read(temp)) != -1) {
			sb.append(temp, 0, length);
		}
		return sb.toString();
	}

	/**
	 * 字符流处理，从字符到文件
	 * 
	 * @param tempchars
	 * @param outFile
	 * @throws IOException
	 */
	public static void readerHandle(char[] tempchars, File outFile) throws IOException {
		Writer writer = null;
		try {
			// 字符流通向字节流的桥梁
			// writer = new OutputStreamWriter(new FileOutputStream(outFile));
			// 用来写入字符文件的便捷类
			// writer = new FileWriter(outFile);
			// 将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
			writer = new BufferedWriter(new FileWriter(outFile));
			readerHandle(tempchars, writer);
		} catch (IOException e) {
			log.error("字符流处理，从字节到文件", e);
			throw e;
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * 字符流处理，从字符到输出流
	 * 
	 * @param tempchars
	 * @param writer
	 * @throws IOException
	 */
	public static void readerHandle(char[] tempchars, Writer writer) throws IOException {
		writer.write(tempchars);
		writer.flush();
	}

	/**
	 * 随机读取文件内容
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static void readFileByRandomAccess(File file) throws IOException {
		RandomAccessFile randomFile = null;
		try {
			// 打开一个随机访问文件流，按只读方式
			randomFile = new RandomAccessFile(file, "r");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 读文件的起始位置
			int beginIndex = (fileLength > 4) ? 4 : 0;
			// 将读文件的开始位置移到beginIndex位置。
			randomFile.seek(beginIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			// 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
			// 将一次读取的字节数赋给byteread
			while ((byteread = randomFile.read(bytes)) != -1) {
				System.out.write(bytes, 0, byteread);
			}
		} catch (IOException e) {
			log.error("随机读取文件内容", e);
			throw e;
		} finally {
			if (randomFile != null) {
				randomFile.close();
			}
		}
	}

	/**
	 * A方法追加文件：使用RandomAccessFile
	 * 
	 * @param content
	 * @param file
	 * @throws IOException
	 */
	public static void appendMethodA(String content, File file) throws IOException {
		RandomAccessFile randomFile = null;
		try {
			// 打开一个随机访问文件流，按读写方式
			randomFile = new RandomAccessFile(file, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes(content);
		} catch (IOException e) {
			log.error("随机读取文件内容", e);
			throw e;
		} finally {
			if (randomFile != null) {
				randomFile.close();
			}
		}
	}

	/**
	 * B方法追加文件：使用FileWriter
	 * 
	 * @param content
	 * @param file
	 * @throws IOException
	 */
	public static void appendMethodB(String content, File file) throws IOException {
		Writer writer = null;
		try {
			// 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
			writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(content);
			writer.flush();
		} catch (IOException e) {
			log.error("随机读取文件内容", e);
			throw e;
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * C方法追加文件：使用FileOutputStream
	 * 
	 * @param content
	 * @param file
	 * @throws IOException
	 */
	public static void appendMethodC(byte[] content, File file) throws IOException {
		OutputStream out = null;
		try {
			// 创建一个向指定 File 对象表示的文件中写入数据的文件输出流。如果第二个参数为 true，则将字节写入文件末尾处，而不是写入文件开始处。
			out = new FileOutputStream(file, true);
			out.write(content);
			out.flush();
		} catch (IOException e) {
			log.error("随机读取文件内容", e);
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 复制文件
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		FileChannel fcin = null;
		FileChannel fcout = null;
		try {
			fcin = new FileInputStream(srcFile).getChannel();
			fcout = new FileOutputStream(destFile).getChannel();
			fcin.transferTo(0, fcin.size(), fcout);
			fcout.force(true);
		} catch (IOException e) {
			log.error("复制文件", e);
			throw e;
		} finally {
			if (fcout != null) {
				fcout.close();
			}
			if (fcin != null) {
				fcin.close();
			}
		}
	}

}
