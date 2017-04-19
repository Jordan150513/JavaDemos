package com.helloqiaodan.firstweb;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.fang.home.model.Customer;


public class DepartmentTestTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp()throws Exception{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		DepartmentTest customerDAO = new DepartmentTest(sqlSessionFactory);
		Customer customer = customerDAO.selectByPrimaryKey(1);
		System.out.println(customer);
	}

}
