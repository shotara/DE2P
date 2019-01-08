<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Admin</title>
	</head>

	<body>
		<iframe src="/02_page/Admin/leftNav.jsp"  style="width:10%; height:500px; border:0px; float:left">	</iframe>
		<iframe src="/admin?action=getChannelList&page=1&size=30" name="right"  style="width:89%;height:900px" id="rightframe"></iframe>
	
	</body>
</html>
