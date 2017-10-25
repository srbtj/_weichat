package com.srbtj.util;

import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

public class Utils {

	public static Object stringToJson(String str) {

		JSONObject jsonObject = JSONObject.parseObject(str);
		
		System.out.println(jsonObject);
		return jsonObject;
				
	}
	
	/***
	 *  随机字符串
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
}
