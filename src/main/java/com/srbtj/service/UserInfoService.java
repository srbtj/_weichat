package com.srbtj.service;

import org.springframework.stereotype.Service;

import com.srbtj.entity.UserInfo;

@Service
public interface UserInfoService {

	/***
	 *  将获得的 json 字符串保存至数据库
	 * @param str
	 */
	public String addUserOpenIdAndSessionKey(String str);
	
	public UserInfo queryUserInfoByOpenId(String openId);
}
