package com.srbtj.util;

import java.security.MessageDigest;
import java.util.Arrays;

public class SignUtil {

	private static String TOKEN = "wechat";
	private static String KEY_SHA1 = "SHA-1";
	private static char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/***
	 * 验证请求是否由微信发起
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce) {

		String[] arr = new String[] { signature, timestamp, nonce };
		// 将 token, timestamp, nonce 进行字符串排序
		Arrays.sort(arr);

		StringBuilder sBuilder = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			sBuilder.append(arr[i]);
		}

		MessageDigest digest = null;

		String tempStr = null;

		try {
			digest = MessageDigest.getInstance(KEY_SHA1);
			byte[] bytes = digest.digest(sBuilder.toString().getBytes());

			tempStr = byteToString(bytes);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		sBuilder = null;
		return tempStr != null ? tempStr.equals(signature) : false;
	}

	/***
	 * 将字节数组转换成十六进制字符串
	 * 
	 * @param bytes
	 * @return
	 */
	private static String byteToString(byte[] bytes) {
		// TODO Auto-generated method stub
		String strDigest = "";

		for (int i = 0, len = bytes.length; i < len; i++) {
			strDigest += byteToHexStr(bytes[i]);
		}
		return strDigest;
	}

	/***
	 * 将字节转换成十六进制字符串
	 * 
	 * @param b
	 * @return
	 */
	private static String byteToHexStr(byte b) {
		// TODO Auto-generated method stub
		char[] tempChar = new char[2];
		tempChar[0] = digit[(b >>> 4) & 0X0F];
		tempChar[1] = digit[b & 0X0F];
		String s = new String(tempChar);

		return s;
	}
}
