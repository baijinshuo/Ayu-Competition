package com.template.commons.sign;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class RSA {

	private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	/**
	 * RSA签名
	 * 
	 * @param content
	 *            待签名数据
	 * @param privateKey
	 *            私钥
	 * @param input_charset
	 *            编码格式
	 * @return 签名值
	 * @throws Exception
	 */
	public static String sign(String content, PrivateKey privateKey, String input_charset) throws Exception {
		Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
		signature.initSign(privateKey);
		signature.update(content.getBytes(input_charset));
		byte[] signed = signature.sign();
		return Base64.encode(signed);
	}

	/**
	 * RSA验签
	 * 
	 * @param content
	 *            待签名数据
	 * @param sign
	 *            签名值
	 * @param publicKey
	 *            公钥
	 * @param input_charset
	 *            编码格式
	 * @return 布尔值
	 * @throws Exception
	 */
	public static boolean verify(String content, String sign, PublicKey publicKey, String input_charset) throws Exception {
		Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
		signature.initVerify(publicKey);
		signature.update(content.getBytes(input_charset));
		boolean bverify = signature.verify(Base64.decode(sign));
		return bverify;
	}

}
