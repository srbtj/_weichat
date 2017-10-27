package com.srbtj.entity;

import java.sql.Timestamp;

public class UserInfo {

	private int id;
	private String openId;
	private String sessionKey;
	private Timestamp createTime;
	private String openIdSessionKey;
	private String thirdKey;
	
	public UserInfo(){}
	
	public UserInfo(String openId, String sessionKey) {
		this.openId = openId;
		this.sessionKey = sessionKey;
	}
	
	public UserInfo(String openId, String sessionKey, String openIdSessionKey, String key) {
		this.openId = openId;
		this.sessionKey = sessionKey;
		this.openIdSessionKey = openIdSessionKey;
		this.setThirdKey(key);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	 

	public String getOpenIdSessionKey() {
		return openIdSessionKey;
	}

	public void setOpenIdSessionKey(String openIdSessionKey) {
		this.openIdSessionKey = openIdSessionKey;
	}


	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", openId=" + openId + ", sessionKey=" + sessionKey + ", createTime="+ createTime +"]";
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getThirdKey() {
		return thirdKey;
	}

	public void setThirdKey(String thirdKey) {
		this.thirdKey = thirdKey;
	}
}
