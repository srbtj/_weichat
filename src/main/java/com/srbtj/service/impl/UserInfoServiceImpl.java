package com.srbtj.service.impl;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.srbtj.dao.UserInfoDao;
import com.srbtj.entity.UserInfo;
import com.srbtj.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	public void addUserOpenIdAndSessionKey(String str) {
		// TODO Auto-generated method stub
		JSONObject object = JSONObject.parseObject(str);
		String _openId = (String) object.get("openid");
		String _sessionKey = (String) object.get("session_key");
		
		UserInfo userInfo = null;
		
		userInfo = queryUserInfoByOpenId(_openId);
		
		if (null == userInfo) {
			userInfo = new UserInfo(_openId, _sessionKey);
			userInfoDao.addUserOpenIdAndSessionKey(userInfo);
		} else {
			userInfo.setSessionKey(_sessionKey);
			userInfoDao.updateUserInfoByOpenId(userInfo);
		}
		
		System.out.println("userinfo =====" + userInfo.toString());
		//
		//
	}

	public UserInfo queryUserInfoByOpenId(String openId) {
		// TODO Auto-generated method stub
		return userInfoDao.queryUserInfoByOpenId(openId);
	}

}
