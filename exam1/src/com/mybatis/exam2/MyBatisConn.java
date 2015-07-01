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
			//����һ�����ݿ�Ự
			session = sessionFactory.openSession();
			User user = (User)session.selectOne("User.queryUserInfoByName","С��");
			//�˴������user��toString����
			System.out.println(user);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(null != session)
			{
				session.close();
			}
			e.printStackTrace();
		}
		//�رջỰ
		if(null != session)
		{
			session.close();
		}
	}
}
