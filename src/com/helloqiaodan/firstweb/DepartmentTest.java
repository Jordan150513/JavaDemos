package com.helloqiaodan.firstweb;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fang.home.mapperDAO.CustomerMapper;
import com.fang.home.model.Customer;
import com.fang.home.model.CustomerExample;

public class DepartmentTest implements CustomerMapper{

	// 需要向dao实现类中注入sqlSessionFactory
	// 这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;
	public DepartmentTest(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public long countByExample(CustomerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(CustomerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Customer record) {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public int insertSelective(Customer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> selectByExample(CustomerExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectByPrimaryKey(Integer id) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Customer customer = sqlSession.selectOne("com.fang.home.mapperDAO.CustomerMapper.selectByPrimaryKey", id);
		sqlSession.close();
		
		return customer;
		
	}

	@Override
	public int updateByExampleSelective(Customer record, CustomerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Customer record, CustomerExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Customer record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Customer record) {
		// TODO Auto-generated method stub
		return 0;
	}


}
