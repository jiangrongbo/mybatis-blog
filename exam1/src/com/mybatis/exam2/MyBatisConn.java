package com.mybatis.exam2;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.mybatis.domain.User;

public class MyBatisConn{
	@Test
	public void testMybatisConn()
	{	
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//创建一个数据库会话
			session = sessionFactory.openSession();
			User user = (User)session.selectOne("User.queryUserInfoByName","小王");
			//此处会调用user的toString方法
			System.out.println(user);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(null != session)
			{
				session.close();
			}
			e.printStackTrace();
		}
		//关闭会话
		if(null != session)
		{
			session.close();
		}
	}
}
