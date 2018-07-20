package com.bill.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.ssm.entity.User;
import com.bill.ssm.mapper.UserMapper;
import com.bill.ssm.service.UserService;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月19日下午1:35:05<br/>
 * 类说明：用户业务层
 */
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryById(String id)
	{
		return userMapper.queryById(id);
	}

}
