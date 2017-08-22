package com.svili.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.svili.mapper.UserMapper;
import com.svili.model.User;
import com.svili.type.DataStateEnum;

public class UpdateTest extends AbstractTest {
	
	@Resource
	protected UserMapper userMapper;

	// @Test
	public void updateSelectiveByPrimaryKey() {
		User user = new User();
		user.setUserId(1);
		user.setDeptId(1);
		user.setUserName("svili_1");
		user.setLoginName("updateSelectiveByPrimaryKey");
		user.setEmail("updateSelectiveByPrimaryKey");
		user.setJob("updateSelectiveByPrimaryKey");
		user.setPassword("updateSelectiveByPrimaryKey");
		user.setState(DataStateEnum.UNEFFECT);
		user.setCreateTime(new java.util.Date());
		userMapper.updateSelectiveById(user);
	}

	// @Test
	public void updateByPrimaryKey() {
		User user = new User();
		user.setUserId(1);
		user.setDeptId(11);
		user.setUserName("svili_1");
		userMapper.updateById(user);
	}

	//@Test
	public void updateByUserName() {
		User user = new User();
		user.setDeptId(1);
		user.setUserName("svili_1");
		user.setEmail("update by user name");
		user.setJob("update by user name");
		user.setLoginName("update by user name");
		user.setPassword("update by user name");
		user.setState(DataStateEnum.UNEFFECT);
		user.setCreateTime(new java.util.Date());
		userMapper.updateByUserName(user);
	}

	@Test
	public void updateSelectiveByUserName() {
		User user = new User();
		user.setDeptId(1);
		user.setUserName("svili_1");
		user.setEmail("updateSelectiveByUserName");
		user.setJob("updateSelectiveByUserName");
		user.setLoginName("updateSelectiveByUserName");
		user.setPassword("updateSelectiveByUserName");
		//user.setState(DataStateEnum.UNEFFECT);
		user.setCreateTime(new java.util.Date());
		userMapper.updateByUserName(user);
	}
}
