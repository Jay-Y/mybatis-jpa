package com.svili.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.svili.mapper.UserMapper;
import com.svili.model.User;

public class SelectTest extends AbstractTest {
	
	@Resource
	protected UserMapper userMapper;

	@Test
	public void selectByPrimaryKey() {
		User user = userMapper.selectById(1);
		if (user != null)
			System.out.println(user.toString());
	}

	// @Test
	public void select() {
		List<User> list = userMapper.select();
		System.out.println(list);
	}

	// @Test
	public void selectByUserName() {
		List<User> list = userMapper.selectByUserName("svili");
		System.out.println(list);
	}

	// @Test
	public void selectByUserNameLike() {
		List<User> list = userMapper.selectByUserNameLike("%svili%");
		System.out.println(list);
	}

	// @Test
	public void selectByUserIdLessThan() {
		List<User> list = userMapper.selectByUserIdLessThan(5);
		System.out.println(list);
	}

	// @Test
	public void selectByUserIdIsNull() {
		List<User> list = userMapper.selectByUserIdIsNull();
		System.out.println(list);
	}

//	@Test
	public void selectComplex() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("userName", "svili first one");
		args.put("deptId", 1);
		List<User> list = userMapper.selectComplex(args);
		System.out.println(list);
	}

	//@Test
	public void selectComplex2() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("userName", "svili first one");
		args.put("deptId", 1);
		List<User> list = userMapper.selectComplex2(args);
		System.out.println(list);
	}
}
