package com.mybatis.exam4;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResultMap {
	private Reader reader = null;
	private SqlSessionFactory sessionFactory  = null;
	private SqlSession session = null;
	@Before
	public void before()
	{
		try {
			reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//创建一个数据库会话
			 session = sessionFactory.openSession();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testResultMap()
	{
		
		HashMap map = new HashMap();
		map.put("username", "小王");
		HashMap userInfoMap = (HashMap)session.selectOne("User.queryUserInfoByNameV1",map);
		System.out.println("username: " + userInfoMap.get("username"));
		System.out.println("password: " + userInfoMap.get("password"));
		System.out.println("phone: " + userInfoMap.get("phone"));
	}
	
	@After
	public void after()
	{
		if(null != session)
		{
			session.close();
		}
	}
}
