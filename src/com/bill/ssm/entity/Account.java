package com.bill.ssm.entity;

import java.io.Serializable;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月19日下午2:36:17<br/>
 * 类说明：账户
 */
@SuppressWarnings("serial")
public class Account implements Serializable
{
	private String id;
	private String bankNo;
	private String username;
	private Integer money;
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getBankNo()
	{
		return bankNo;
	}
	public void setBankNo(String bankNo)
	{
		this.bankNo = bankNo;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public Integer getMoney()
	{
		return money;
	}
	public void setMoney(Integer money)
	{
		this.money = money;
	}
	@Override
	public String toString()
	{
		return "Account [id=" + id + ", bankNo=" + bankNo + ", username=" + username + ", money=" + money + "]";
	}

}
