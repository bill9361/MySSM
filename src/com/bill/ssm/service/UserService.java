package com.bill.ssm.service;

import com.bill.ssm.entity.User;

public interface UserService
{

	/**
	 * 根据Id查找用户
	 * @param id
	 * @return
	 */
	User queryById(String id);

}