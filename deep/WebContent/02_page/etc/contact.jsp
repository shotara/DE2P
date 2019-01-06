<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />

</head>
<body>

	<jsp:include page="/02_page/commonNav.jsp" flush="false" />

	<div class="container contact-us">
		<div class="row">
			<div class="contact-title">
				<input />
			</div>
			<div class="contact-content">
				<textarea rows="" cols=""></textarea>
			</div>
		
		</div>
	</div>
	
	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />


</body>
</html>