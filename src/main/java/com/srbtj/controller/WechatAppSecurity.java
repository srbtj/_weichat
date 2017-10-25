package com.srbtj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.srbtj.service.impl.UserInfoServiceImpl;
import com.srbtj.util.GlobalConstants;
import com.srbtj.util.HttpUtil;
import com.srbtj.util.Utils;

@Controller
@RequestMapping("/wechatapp")
public class WechatAppSecurity {
	
	@Autowired
	private UserInfoServiceImpl UserInfoServiceImpl;

	/**
	 * 根据微信小程序传递的 code , 向微信服务器发送 get 请求，获取 openId and session_key(加密签名密钥)
	 *  wx.login() => 以 code 换取用户登录态信息
	 * @param request
	 * @param response
	 * @param code
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "openIdAndSession", method = RequestMethod.GET)
	public String openIdAndSession(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "code") String code) throws Exception {

		System.out.println("i hava running ..............");
		System.out.println("webappInfo:" + GlobalConstants.getInterfaceUrl("webappid") + "====" + GlobalConstants.getInterfaceUrl("webappSecret"));
		String sessionKeyUrl = GlobalConstants.getInterfaceUrl("sessionKey");
		String webappid = GlobalConstants.getInterfaceUrl("webappid");
		String webappSecret = GlobalConstants.getInterfaceUrl("webappSecret");
		String grantType = GlobalConstants.getInterfaceUrl("grantType");
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("appid", webappid);
		maps.put("secret", webappSecret);
		maps.put("js_code", code);
		maps.put("grant_type", grantType);
		String result = HttpUtil.sendGet(sessionKeyUrl, maps);
		System.out.println("code=====" + code + "返回结果=====" + result);
		System.out.println(Utils.stringToJson(result));
		
		UserInfoServiceImpl.addUserOpenIdAndSessionKey(result);
		// 将获得的 openId 与 sessionKey 保存至数据库
		return "";
	}
}
