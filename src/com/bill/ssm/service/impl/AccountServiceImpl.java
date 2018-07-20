package com.bill.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bill.ssm.mapper.AccountMapper;
import com.bill.ssm.service.AccountService;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月19日下午2:43:40<br/>
 * 类说明：
 */
@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountMapper accountMapper;
	
	/**
	 * readOnly = true:表示无需事务，针对Select
	 * readOnly = false:会启动事务，针对Insert，Update，Delete
	 */
	@Transactional(readOnly = false)
	@Override
	public int zhuanMoney(String bankNo1,String bankNo2,Integer money)
	{
		//给张三 bankNo 110 减200
		int result1 = accountMapper.upadteMoney(bankNo1, -money);
		
		//模拟转账失败
		int i = 10/0;
		
		//给李四bankNo 111加200
		if(result1 > 0)
		{
			return accountMapper.upadteMoney(bankNo2, money);
		}
		
		return 0;
	}

}
