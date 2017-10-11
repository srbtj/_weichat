package com.srbtj.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.srbtj.util.GlobalConstants;

public class InterfaceUrlInit {

	public synchronized static void init() {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();

		if (GlobalConstants.interfaceUrlProperties == null) {
			GlobalConstants.interfaceUrlProperties = new Properties();
		}

		InputStream inputStream = null;

		try {
			// 读取 url 配置文件 
			inputStream = loader.getResourceAsStream("interface_url.properties");
			properties.load(inputStream);

			for (Object key : properties.keySet()) {
				GlobalConstants.interfaceUrlProperties.put(key, properties.get(key));
			}
			
			// 读取 微信配置 文件 
			properties = new Properties();
			inputStream = loader.getResourceAsStream("wechat.properties");
			properties.load(inputStream);
			
			for(Object key : properties.keySet()){
				GlobalConstants.interfaceUrlProperties.put(key, properties.get(key));
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
