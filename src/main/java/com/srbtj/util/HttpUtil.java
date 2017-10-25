package com.srbtj.util;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

@SuppressWarnings("deprecation")
public class HttpUtil {

	@SuppressWarnings("resource")
	public static String sendGet(String url, Map<String, String> params) throws Exception {
		InputStream is = null;
		CloseableHttpClient httpClient = null;
		try {
			String _url = buildUrl(url, params);
			System.out.println("请求 url ===="+_url);
			httpClient = HttpClients.createDefault();
			
			HttpGet httpGet = new HttpGet(_url);
			httpGet.setHeader("Accept-Encoding", "gzip");
			
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			System.out.println("getResponse:" + httpResponse.getStatusLine().getStatusCode());
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			String inputLine = null;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			
			reader.close();
			System.out.println(response);
			return response.toString();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return "";
		} finally {
			if (is != null) {
				is.close();
			}
			httpClient.close();
		}
	}

	/***
	 *  接接链接地址
	 * @param url 请求url地址
	 * @param params 查询参数
	 * @return 构建好的url
	 */
	private static String buildUrl(String url, Map<String, String> params) {
		// TODO Auto-generated method stub
		StringBuilder query = new StringBuilder();
		Set<String> set = params.keySet();
		
		for(String key : set) {
			query.append(String.format("%s=%s&", key, params.get(key)));
		}
		
		System.out.println(query);
		return url + "?" + query.toString();
	}
}
