package srbtj.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.srbtj.common.WechatTask;
import com.srbtj.entity.UserInfo;
import com.srbtj.util.HttpUtil;

public class TTest {

	@Test
	public void test() {
		System.out.println("success");
	}

//	@Test
//	public void sendGet() {
//		String appId = "wxdf4ac816c369227c";
//		String appSecret = "8cedb96b43b920548fb047e1a19804f8";
//
//		Map<String, String> maps = new HashMap<String, String>();
//		maps.put("grant_type", "client_credential");
//		maps.put("appid", appId);
//		maps.put("secret", appSecret);
//		String val;
//		try {
//			val = HttpUtil.sendGet("https://api.weixin.qq.com/cgi-bin/token", maps);
//			System.out.println(val);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Test
	public void access_token() {
		try {
			// 977047fd-eccb-4001-bdcb-ff698741b517
			System.out.println(UUID.randomUUID().toString());
			
			UserInfo userInfo = new UserInfo();
			Timestamp timestamp = new Timestamp(new Date().getTime());
			
			userInfo.setCreateTime(timestamp);
			
			System.out.println(userInfo.toString());
//			new WechatTask().getToken();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
