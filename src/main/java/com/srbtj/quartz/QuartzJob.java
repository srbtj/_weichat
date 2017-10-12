package com.srbtj.quartz;

import org.apache.log4j.Logger;

import com.srbtj.common.WechatTask;

public class QuartzJob {

	private static Logger logger = Logger.getLogger(QuartzJob.class);
	
	public void workForToken() {
		
		try {
			WechatTask timer = new WechatTask();
			timer.getToken();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e, e);
		}
	}
}
