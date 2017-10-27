package com.srbtj.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

public class Utils {

	public static Object stringToJson(String str) {

		JSONObject jsonObject = JSONObject.parseObject(str);

		System.out.println(jsonObject);
		return jsonObject;

	}

	/***
	 * 随机字符串
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static String formatToString() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		String format = simpleDateFormat.format(date.getTime());
		return format;
	}

	public static Timestamp geTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
}
