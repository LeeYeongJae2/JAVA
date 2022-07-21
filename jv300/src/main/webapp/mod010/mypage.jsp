<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<jsp:include page="/incl/banner.jsp">
			<jsp:param value="<%=URLEncoder.encode(\"My 페이지\", \"UTF-8\")%>" name="subtitle" />
		</jsp:include>
	</div>
	<h3>My Page</h3>
	<label>Last Access Time : </label> ${lastAccessTime}
	<a href='<c:url value="/mod010/logout" />'>로그아웃</a>
</body>
</html>