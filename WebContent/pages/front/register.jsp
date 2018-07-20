<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户注册</title>
	<style type="text/css">
		span {
			color: red;
		}
	</style>
	<script type="text/javascript" src="<%=basePath %>resources/js/jquery.min.js"></script>
</head>
<body>
	<center>
		<!--  method="post"  action="user/register.do" -->
		<!-- return false:不会提交表单；return true会提交表单 -->
		<form onsubmit="return false" id="registerForm1">
			<table>
				<tr>
					<td>用户名</td>
					<td>
						<input style="width: 300px;" type="text" name="username" value="${requestScope.errorMap.username == null?requestScope.user.username:"" }" placeholder="请输入3-16位数字、字母、下划线组合">
						<span>${requestScope.errorMap.username }</span>
					</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td>
						<input style="width: 300px;" type="text" name="fullname" value="${requestScope.errorMap.username == null?requestScope.user.fullname:"" }" placeholder="请输入4-32位数字、字母、下划线汉字组合">
						<span>${requestScope.errorMap.fullname }</span>
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						<input style="width: 300px;" type="password" name="password" value="${requestScope.errorMap.password == null?requestScope.user.password:"" }" placeholder="请输入3-16位数字、字母、下划线组合">
						<span>${requestScope.errorMap.password }</span>
					</td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td>
						<input style="width: 300px;" type="text" name="tel" value="${requestScope.errorMap.tel == null?requestScope.user.tel:"" }" placeholder="请输入正确的手机格式">
						<span>${requestScope.errorMap.tel }</span>
					</td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td>
						<input style="width: 300px;" type="text" name="email" value="${requestScope.errorMap.email == null?requestScope.user.email:"" }" placeholder="请输入正确的邮箱格式">
						<span>${requestScope.errorMap.email }</span>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="width: 300px;">
					<input style="width: 100px;" type="submit" value="注册">
					<input style="width: 100px;" type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
		
		<script type="text/javascript">
			$.fn.serializeObject = function()    
			{    
			   var o = {};    
			   var a = this.serializeArray();    
			   $.each(a, function() {    
			       if (o[this.name]) {    
			           if (!o[this.name].push) {    
			               o[this.name] = [o[this.name]];    
			           }    
			           o[this.name].push(this.value || '');    
			       } else {    
			           o[this.name] = this.value || '';    
			       }    
			   });    
			   //return o;    
			   return JSON.stringify(o);
			};
		
			$("input[type=submit]").click(function(){
				var userJson = $("#registerForm1").serializeObject();
				//alert(userJson);
				$.ajax({
					url:"user/register2.do",
					type:"post",
					dataType:"json",
					data:userJson,
					contentType:"application/json",
					success:function(result){
						alert(result);
					}
				});
				
			});
		</script>
	</center>
</body>
</html>