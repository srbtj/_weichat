package com.srbtj.common;

import java.util.HashMap;
import java.util.Map;

import com.srbtj.util.GlobalConstants;
import com.srbtj.util.HttpUtil;

import net.sf.json.JSONObject;
//import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

/***
 *  微信两小时定时任务
 * @author tougou
 *	使用 quartz 创建定时任务的步骤
 *   1. 创建一个普通的 Java 类
 *   2. spring 配置文件中配置  JobDetail, Trigger, SchedulerFactoryBean
 */
public class WechatTask {

	/***
	 *  获取 access_token
	 * @throws Exception
	 */
	public void getToken() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		// 设置请求 access_token 参数 
		params.put("grant_type", "client_credential");
		params.put("appid", GlobalConstants.getInterfaceUrl("appid"));
		params.put("secret", GlobalConstants.getInterfaceUrl("appSecret"));
		System.out.println("我是定时器 我执行了...");
		// 获取 返回的 access_token
		String jstoken = HttpUtil.sendGet(GlobalConstants.getInterfaceUrl("tokenUrl"), params);
//		// 撮取返回的 access_token
		String access_token = JSONObject.fromObject(jstoken).getString("access_token");
//		
//		// 保存获得的 access_token
		GlobalConstants.interfaceUrlProperties.put("access_token", access_token);
		System.out.println("获取的token:" + GlobalConstants.interfaceUrlProperties.get("access_token"));
	}
}
