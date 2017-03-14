package com.template.commons.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCodeUtil {
	/** 验证码图片宽度 */
	private int width = 80;
	/** 验证码图片高度 */
	private int height = 30;
	/** 验证码字符个数 */
	private int codeCount = 4;
	/** 验证码字符串 */
	private String code;
	/** 验证码图片 */
	private BufferedImage image;
	private Random random = new Random();

	public VerifyCodeUtil() {
		createVerifyCode();
	}

	public VerifyCodeUtil(int w, int h) {
		this.width = w;
		this.height = h;
		createVerifyCode();
	}

	private void createVerifyCode() {
		// 验证码字符
		// String codeSequence = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
		String codeSequence = "0123456789";
		StringBuilder sb = new StringBuilder();
		// 产生随机验证码字符
		for (int i = 0; i < codeCount; i++) {
			String strRand = String.valueOf(codeSequence.charAt(random.nextInt(codeSequence.length())));
			sb.append(strRand);
		}
		code = sb.toString();
		// 字体高度
		int fontHeight = height - 2;
		// 创建字体
		Font font = new Font("Fixedsys", Font.ITALIC, fontHeight);
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		// 填充背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 加一道线
		drawThickLine(g, 0, random.nextInt(fontHeight / 2) + 10, width, random.nextInt(fontHeight / 2) + 10, 4, Color.BLACK);
		// 设置字体。
		g.setFont(font);
		int codeY = height - 4;
		// 验证码颜色
		g.setColor(Color.BLACK);
		// 写字符串
		g.drawString(code, 5, codeY);
		g.dispose();
	}

	private void drawThickLine(Graphics g, int x1, int y1, int x2, int y2, int thickness, Color c) {
		g.setColor(c);
		int dX = x2 - x1;
		int dY = y2 - y1;
		double lineLength = Math.sqrt(dX * dX + dY * dY);
		double scale = (double) (thickness) / (2 * lineLength);
		double ddx = -scale * (double) dY;
		double ddy = scale * (double) dX;
		ddx += (ddx > 0) ? 0.5 : -0.5;
		ddy += (ddy > 0) ? 0.5 : -0.5;
		int dx = (int) ddx;
		int dy = (int) ddy;
		int xPoints[] = new int[4];
		int yPoints[] = new int[4];
		xPoints[0] = x1 + dx;
		yPoints[0] = y1 + dy;
		xPoints[1] = x1 - dx;
		yPoints[1] = y1 - dy;
		xPoints[2] = x2 - dx;
		yPoints[2] = y2 - dy;
		xPoints[3] = x2 + dx;
		yPoints[3] = y2 + dy;
		g.fillPolygon(xPoints, yPoints, 4);
	}

	/** 验证码字符串 */
	public String getCode() {
		return code;
	}

	/** 验证码图片 */
	public BufferedImage getImage() {
		return image;
	}
}
