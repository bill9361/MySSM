package com.bill.ssm.controller.front;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill.ssm.entity.User;
import com.bill.ssm.service.UserService;
import com.bill.ssm.util.Validator;

@RequestMapping("/user")
@Controller
public class UserController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryById")
	@ResponseBody
	public User queryById(String id)
	{
		System.out.println("UserController....queryById():id:"+id);
		return userService.queryById(id);
	}
	
	@RequestMapping("/test1")
	public void test1()
	{
		System.out.println("test1()");
		String a = null;
		a.toString();
	}
	

	@RequestMapping("/test2")
	public void test2()
	{
		System.out.println("test2()");
		int i = 10 / 0;
	}
	
	/**
	 * 用户注册(数据校验和数据回显)
	 */
	@RequestMapping("/register")
	public String register(HttpServletRequest request,HttpServletResponse response,@Valid User user,BindingResult errorResult,Model model)
	{
		System.out.println("UserController....register()");
		System.out.println(user);
		
		Map<String, String> errorMap = Validator.fieldValidate(errorResult);
		if(errorMap != null)
		{
			model.addAttribute("errorMap", errorMap);
			model.addAttribute("user", user);
			return "/front/register.jsp";
		}
		
		return "/front/register_success.jsp";
	}
	
	/**
	 * 使用@RequestBody Map<String, Object> userFiledMap接收传过来的Json
	 * 用户注册(ajax与@RequestBody方式，返回Json数据)
	 * 使用@ResponseBody将结果返回ajax
	 */
	@RequestMapping("/register1")
	@ResponseBody
	public boolean register1(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String, Object> userFiledMap,Model model)
	{
		System.out.println("UserController....register1()");
		System.out.println(userFiledMap);
		return true;
	}
	
	/**
	 * 使用@RequestBody User user接收传过来的Json(以及数据校验)
	 * 用户注册(ajax与@RequestBody方式，返回Json数据)
	 * 使用@ResponseBody将结果返回ajax
	 */
	@RequestMapping("/register2")
	@ResponseBody
	public boolean register2(HttpServletRequest request,HttpServletResponse response,@RequestBody @Valid User user,BindingResult errorResult,Model model)
	{
		System.out.println("UserController....register2()");
		System.out.println(user);
		
		Map<String, String> errorMap = Validator.fieldValidate(errorResult);
		
		System.out.println(errorMap);
		
		if(errorMap != null)
		{
			return false;
		}
		
		return true;
	}
}
