package com.bill.ssm.mapper;

import com.bill.ssm.entity.User;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月19日下午1:33:34<br/>
 * 类说明：UserMapper
 */
public interface UserMapper
{
	/**
	 * 根据Id查找用户
	 * @param id
	 * @return
	 */
	public User queryById(String id);
}
