package com.srbtj.dao;

import com.srbtj.entity.UserInfo;

public interface UserInfoDao {

	public void addUserOpenIdAndSessionKey(UserInfo userInfo);
	
	public UserInfo queryUserInfoByOpenId(String openId);

	public int updateUserInfoByOpenId(UserInfo userInfo);
}
