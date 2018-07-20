package com.bill.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月19日下午4:46:14<br/>
 * 类说明：拦截器（拦截器主要拦Controller,过滤器主要是过滤Jsp,js等）
 */
public class OneInterceptor implements HandlerInterceptor
{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception)
			throws Exception
	{
		System.out.println("OneInterceptor....afterCompletion()");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView)
			throws Exception
	{

		System.out.println("OneInterceptor....postHandle()");
	}

	/**
	 * 该方法每次执行符合拦截条件的Controller都执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception
	{
		System.out.println("OneInterceptor....preHandle()");
		
		/*HttpSession httpSession = request.getSession();
		//判断session中是否有登录的Id等，如果未登录则拦截
		String userId = (String) httpSession.getAttribute("userId");
		if(userId == null || userId != null && "".equals(userId))
		{
			//转发到首页
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			//重定向到首页
			response.sendRedirect(request.getServletContext().getContextPath()+"/index.jsp");
		}*/
		//return false 表示不放行,true 表示放行
		
		return true;
		//return false;
	}

}
