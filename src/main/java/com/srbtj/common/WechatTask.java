package com.srbtj.common;

import java.util.HashMap;
import java.util.Map;

import com.srbtj.util.GlobalConstants;
import com.srbtj.util.HttpUtil;

import net.sf.json.JSONObject;

/***
 *  微信两小时定时任务
 * @author tougou
 *
 */
public class WechatTask {

	public void getToken() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		// 设置请求 access_token 参数 
		params.put("grant_type", "client_credential");
		params.put("appid", GlobalConstants.getInterfaceUrl("appid"));
		params.put("secret", GlobalConstants.getInterfaceUrl("appSecret"));
		// 获取 返回的 access_token
		String jstoken = HttpUtil.sendGet(GlobalConstants.getInterfaceUrl("tokenUrl"), params);
		// 撮取返回的 access_token
		String access_token = JSONObject.fromObject(jstoken).getString("access_token");
		
		// 保存获得的 access_token
		GlobalConstants.interfaceUrlProperties.put("access_token", access_token);
		System.out.println("获取的token:" + GlobalConstants.interfaceUrlProperties.get("access_token"));
	}
}
