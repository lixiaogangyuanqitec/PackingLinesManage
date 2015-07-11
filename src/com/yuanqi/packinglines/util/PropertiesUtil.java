package com.yuanqi.packinglines.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.yuanqi.packinglines.mainwindow.LoginWindow;

/***
 * properties文件的读写工具类
 * 
 * @author lixiaogang
 *
 */
public class PropertiesUtil {
	private static  Properties prop = new Properties();
	private static Logger logger=null;
	
	
	/**
	 * 读取properties文件
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	public static  String readPropertiesFile(String key,String filePath){
		InputStream ins;
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		logger = Logger.getLogger(LoginWindow.class);
		try {
			ins = new FileInputStream(filePath);
			prop.load(ins);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		
		return prop.getProperty(key);
	}

	/**
	 * 写入properties文件
	 * @throws Exception 
	 * 
	 */
	public static void writePropertiesFile(String key,String value,String filePath){
		OutputStream outputStream;
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		logger = Logger.getLogger(LoginWindow.class);
		try {
			outputStream = new FileOutputStream(filePath);
			prop.setProperty(key,value);
			prop.store(outputStream, "");
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		
	}


	
}
