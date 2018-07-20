package com.bill.ssm.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill.ssm.service.AccountService;

/**
 * 
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月19日下午3:02:29<br/>
 * 类说明：
 */
@RequestMapping("/account")
@Controller
public class AccountController
{
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/zhuanMoney")
	@ResponseBody
	public int zhuanMoney(String bankNo1,String bankNo2,Integer money)
	{
		System.out.println("AccountController....zhuanMoney():"+"bankNo1="+bankNo1+" bankNo2="+bankNo2+" money="+money);
		return accountService.zhuanMoney(bankNo1, bankNo2, money);
	}

}
