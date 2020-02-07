<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>码蚁商城后台管理系统</title>

<!-- 在服务器内部跳转时,里边的路径都是相对于WebContent -->
<!-- 而如果直接运行jsp(相当于直接在浏览器中输入地址,是浏览器的请求),里边的路径又是相对于当前jsp的 -->
<!-- 简而言之,服务器内部跳转时和浏览器请求时,里边路径的相对位置是不一样的 -->
<!-- 所以如果不使用绝对路径,读取这些文件会有问题 -->
<!-- 在JSP中, 凡是碰到action,src,href都要去写上绝对路径(也就是前面加上工程名称) -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/admin/css/style.css"
	type="text/css" />

</head>

<body>
	<div id="container">
		<c:if test="${!empty admin }">
			<jsp:forward
				page="/admin/admin_index.jsp"></jsp:forward>
		</c:if>
		<c:if test="${empty admin }">
			<form action="${pageContext.request.contextPath }/AdminServlet">
				<div class="login">
					码蚁商城后台管理系统 <span style="color: red">${errorMsg }</span>
				</div>
				<div class="username-text">用户名:</div>
				<div class="password-text">密码:</div>
				<div class="username-field">
					<input type="text" name="username" value="admin" />
				</div>
				<div class="password-field">
					<input type="password" name="password" value="123" />
				</div>
				<input type="checkbox" name="remember-me" id="remember-me" /><label
					for="remember-me">记住用户名</label>

				<div class="forgot-usr-pwd"></div>
				<input type="submit" name="submit" value="GO" />
			</form>
		</c:if>
	</div>

</body>
</html>
