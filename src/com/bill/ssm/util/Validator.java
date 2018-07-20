package com.bill.ssm.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月17日下午4:21:44<br/>
 * 类说明：数据校验
 */
public class Validator
{
	private Validator(){}
	
	/**
	 * 字段校验<br/>
	 * 如果返回结果为null，说明校验全部通过<br/>
	 * 如果返回结果不为空，说明有校验不通过的字段
	 * @param errorResult
	 * @return
	 */
	public static Map<String, String> fieldValidate(BindingResult errorResult)
	{
		Map<String, String> errorMap = null;
		if(errorResult != null && errorResult.hasErrors())
		{
			if(errorMap == null) errorMap = new HashMap<>();
			List<FieldError> fieldErrorList = errorResult.getFieldErrors();
			for (FieldError fieldError : fieldErrorList)
			{
				//获取不通过的字段名
				String fileName = fieldError.getField();
				//获取不通过的错误信息
				String fileErrorMessage = fieldError.getDefaultMessage();
				System.out.println(fileName + " = " + fileErrorMessage);
				errorMap.put(fileName, fileErrorMessage);
			}
		}
		
		return errorMap;
	}

}
