package com.bill.ssm.controller.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月19日下午1:29:01<br/>
 * 类说明：Controller全局异常
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
	private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex)
	{
		System.out.println("GlobalExceptionHandler...哈哈，恭喜您出错啦");
		//ex.printStackTrace();
		//将异常信息单独保存到一个文件中(MySSM.log)--->log4j(日志文件中会有很多Tomcat启动日志)
		logger.debug(ex.getMessage());
		return "error/error.jsp";
	}
	
	
	/**
	 * 自定义全局异常日志文件存储
	 * @param ex
	 * @return
	 */
	/*@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex)
	{
		try
		{
			System.out.println("GlobalExceptionHandler...哈哈，恭喜您出错啦");
			//将异常信息单独保存到一个文件中(MySSM.log)--->纯异常日志
			FileOutputStream fos = new FileOutputStream("F:\\MySSM_error.log",true);
			PrintStream ps = new PrintStream(fos);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(new Date());
			ps.write(time.getBytes("utf-8"));
			ps.write("\r\n".getBytes("utf-8"));
			ex.printStackTrace(ps);
			//关闭流
			ps.close();
			fos.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return "error/error.jsp";
	}*/

}
