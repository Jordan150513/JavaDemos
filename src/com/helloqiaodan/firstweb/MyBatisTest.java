package com.helloqiaodan.firstweb;

import java.io.InputStream;
import java.io.IOException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

public class MyBatisTest {

	public static void main(String[] args) throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User("zhangsan","male",26);
		session.insert("com.qiaodan.mapper.UserMapper.save", user);
		session.commit();
		session.close();
	}

}
