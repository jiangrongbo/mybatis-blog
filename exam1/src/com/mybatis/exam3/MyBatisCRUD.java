package com.mybatis.exam3;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.domain.User;

public class MyBatisCRUD{
	private Reader reader = null;
	private SqlSessionFactory sessionFactory  = null;
	private SqlSession session = null;
	@Before
	public void before()
	{
		try {
			reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//����һ�����ݿ�Ự
			 session = sessionFactory.openSession();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMybatisSelect()
	{			
			User user = (User)session.selectOne("User.queryUserInfoByName","С��");			
			//�˴������user��toString����
			System.out.println(user);	
	}
	
	@Test
	public void testMybatisInsert()
	{	
			User user = new User();
			user.setPassword("aaaa");
			user.setPhone("18909568934");
			user.setUsername("Jane");
			session.insert("User.saveUser", user);
			//mybatis����Ĭ�ϲ��Զ��ύ
			session.commit();	
	}
	
	@Test
	public void testMybatisUpdate()
	{	
			User user = new User();
			user.setPassword("bbbbb");
			user.setPhone("18909568934");
			user.setUsername("Jane");
			session.update("User.updateUser",user);
			//mybatis����Ĭ�ϲ��Զ��ύ
			session.commit();	
			
	}
	
	@Test
	public void testMybatisDelete()
	{	
			User user = new User();
			user.setPassword("bbbbb");
			user.setPhone("18909568934");
			user.setUsername("Jane");
			session.delete("User.deleteUser", user);
			//mybatis����Ĭ�ϲ��Զ��ύ
			session.commit();
			
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
