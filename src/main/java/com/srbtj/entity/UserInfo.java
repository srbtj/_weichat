package com.srbtj.entity;

public class UserInfo {

	private int id;
	private String openId;
	private String sessionKey;
	private String createTime;
	private String openIdSessionKey;
	private String key;
	
	public UserInfo(){}
	
	public UserInfo(String openId, String sessionKey) {
		this.openId = openId;
		this.sessionKey = sessionKey;
	}
	
	public UserInfo(String openId, String sessionKey, String openIdSessionKey, String key) {
		this.openId = openId;
		this.sessionKey = sessionKey;
		this.openIdSessionKey = openIdSessionKey;
		this.key = key;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOpenIdSessionKey() {
		return openIdSessionKey;
	}

	public void setOpenIdSessionKey(String openIdSessionKey) {
		this.openIdSessionKey = openIdSessionKey;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", openId=" + openId + ", sessionKey=" + sessionKey + "]";
	}
	
	
}
