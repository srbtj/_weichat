package com.srbtj.service.impl;

import java.io.Console;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.srbtj.dao.UserInfoDao;
import com.srbtj.entity.UserInfo;
import com.srbtj.service.UserInfoService;
import com.srbtj.util.Utils;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	@SuppressWarnings("null")
	public String addUserOpenIdAndSessionKey(String str) {
		// TODO Auto-generated method stub
		JSONObject object = JSONObject.parseObject(str);
		String _openId = (String) object.get("openid");
		String _sessionKey = (String) object.get("session_key");
		String _openIdSessionKey = _openId + _sessionKey;
		UserInfo userInfo = null;
		
		userInfo = queryUserInfoByOpenId(_openId);
		
		if (null == userInfo) {
			userInfo = new UserInfo();
			String uuid = Utils.getUUID();
			Timestamp timestamp = new Timestamp(new Date().getTime());
			userInfo.setCreateTime(timestamp);
			userInfo.setThirdKey(uuid);
			userInfo.setOpenId(_openId);
			userInfo.setSessionKey(_sessionKey);
			userInfo.setOpenIdSessionKey(_openIdSessionKey);
			
//			userInfo = new UserInfo(_openId, _sessionKey);
			userInfoDao.addUserOpenIdAndSessionKey(userInfo);
		} else {
			userInfo.setSessionKey(_sessionKey);
			userInfo.setOpenIdSessionKey(_openIdSessionKey);
			userInfoDao.updateUserInfoByOpenId(userInfo);
		}
		
		System.out.println("userinfo =====" + userInfo.toString());
	
		return userInfo.getThirdKey();
	}

	public UserInfo queryUserInfoByOpenId(String openId) {
		// TODO Auto-generated method stub
		return userInfoDao.queryUserInfoByOpenId(openId);
	}

}
