package com.helloqiaodan.firstweb;

import java.io.InputStream;
import java.io.IOException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import com.helloqiaodan.firstweb.Department;

public class MyBatisTest {

	public static void main(String[] args) throws IOException {
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		// 1
//		User user = new User("LiSi","female",20);
//		session.insert("com.qiaodan.mapper.UserMapper.save", user);
		
		// 2 insert department
//		Department depart = new Department("depart2");
//		session.insert("com.qiaodan.mapper.DepartmentMapper.save", depart);
		
		// 3 delete department
//		session.delete("com.qiaodan.mapper.DepartmentMapper.deleteDepartment", 7);
		
		// 4 update department
		Department depart = new Department("department100");
		depart.setId(6);
		session.update("com.qiaodan.mapper.DepartmentMapper.updateDepartment", depart);
		
		// find department
//		findDepartment
//		session.
		session.commit();
		session.close();
	}

}
