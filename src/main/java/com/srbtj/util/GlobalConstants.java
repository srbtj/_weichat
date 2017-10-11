package com.srbtj.util;

import java.util.Properties;

public class GlobalConstants {

	public static Properties interfaceUrlProperties;
	
	/**
	 *  根据传入的参数获取配置信息中对应的 URL
	 * @param key
	 * @return
	 */
	public static String getInterfaceUrl(String key) {
		System.out.println(interfaceUrlProperties);
		return (String)interfaceUrlProperties.get(key);
	}
}
