<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Admin</title>		
	<script>
	var permitCheck = "${requestScope.adminToken}";
	if (permitCheck != "129") {
		location.href = "/error.jsp"
	}
	
	var sessionCheck = "${sessionScope.racMemberNo}";
	if (sessionCheck<1 || sessionCheck>10) {
		location.href = "/error.jsp"
	}
</script>
	</head>
	
	<body>
		<iframe src="/02_page/Admin/leftNav.jsp"  style="width:10%; height:500px; border:0px; float:left">	</iframe>
		<iframe src="/admin?action=getChannelList&page=1&size=30" name="right"  style="width:89%;height:900px" id="rightframe"></iframe>
	
	</body>
</html>
