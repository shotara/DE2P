<%@ page import="com.rancre.config.GlobalValue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />
<script type="text/javascript">

</script>

</head>
<body>

<section class="rancre-admin-adurl">
	<form method="post" action="/admin?action=addChannelAdUrl">
	<div class="content">
		<h1>광고 영상 등록(식별 광고 영상)</h1>
		<div class="adurl-channel-title">
			<div class="left">채널명</div>
			<div class="right">${result.outputChannelTitle}</div>
		</div>
		<div class="adurl-channel-url">
			<div class="left">채널아이디</div>
			<div class="right">${result.outputChannelUrl}</div>
		</div>
		<div class="adurl-channel-url">
			<div class="left">광고 url</div>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="text" name="inputChannelAdUrls"/>
			<input type="hidden" name="inputChannelNo" value="${result.outputChannelNo}"/>
		</div>
	</div>
	
		<div class="btn">
			<input type="submit" value="정보입력"/>
			<button>취소</button>
		</div>
	</form>
</section>


</body>
</html>