package com.yuanqi.packinglines.mybatis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	@SuppressWarnings("unused")
	private static Reader reader;

	static {
		InputStream is;
		try {
			is = new FileInputStream(System.getProperty("user.dir")
					+ "\\configuration\\database_configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static SqlSession getSqlSession() {
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
}
