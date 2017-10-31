package com.srbtj.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.aspectj.weaver.WeaverStateInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/upload")
public class UploadPictureController {

	private static Logger logger = Logger.getLogger(UploadPictureController.class);

	@RequestMapping(value = "/picture")
	public void uploadPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取上传文件路径
		String path = request.getRealPath("/upload") + "/";
		File dir = new File(path);

		if (null == dir) {
			dir.mkdir();
		}

		logger.debug("path=" + path);

		// 设置编码
		request.setCharacterEncoding("utf-8");

		// 获取磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		/***
		 * 原理: 它是先存到暂时存储室，然后再真正写到对应目录的硬盘上， 按理来说当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
		 * 然后再将其真正写到对应目录的硬盘上
		 */
		factory.setRepository(dir);
		// 设置缓存大小， 当上传文件的容量超过缓存时 直接入到暂时存储室
		factory.setSizeThreshold(1024 * 1024);
		// 文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {

			List<FileItem> fileItem = upload.parseRequest(request);
			FileItem picture = null;

			for (FileItem item : fileItem) {
				// 获取属性名
				String name = item.getFieldName();
				// 获取的是变通文本信息
				if (item.isFormField()) {
					String value = item.getString();
					request.setAttribute(name, value);
					logger.debug("name=" + name + ", value=" + value);
				} else {
					picture = item;
				}
			}
			
			// 自定义上传图片的名字
			String fileName = request.getAttribute("userId") + ".jpg";
			String destPath = path + fileName;
			logger.debug("destPath=" + destPath);
			
			// 真正写在磁盘上
			File file = new File(destPath);
			
			OutputStream stream = new FileOutputStream(file);
			InputStream is = picture.getInputStream();
			
			int lenght = 0;
			
			byte[] b = new byte[1024];
			// is.read(b) 每次读到的数据存放在b 数组中
			while( (lenght = is.read(b)) != -1) {
				//在b数组中取出数据写到（输出流）磁盘上
				stream.write(b, 0, lenght);
			}
			
			is.close();
			stream.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e,e);
		}
		
		PrintWriter writer = response.getWriter();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("success", true);
		
		writer.write(JSON.toJSONString(maps));
		writer.flush();

	}
}
