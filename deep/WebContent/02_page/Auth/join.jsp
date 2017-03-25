<%@ page import="com.deep.config.GlobalValue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />

</head>
<body>

<jsp:include page="/02_page/commonNav.jsp" flush="false" />

<section class="joinDeep">
<div class="row">
	<div class="col-xs-3"></div>
	<div class="col-xs-6">
		<div class="deepInfo"></div>
		<div class="col-xs-3"></div>
			<div class="col-xs-6">

				<div class="joinBox">
					<input class="inputJoin" type="email" id="inputMemberEmail"
						placeholder="이메일" required />
				</div>
				<div class="joinBox">
					<input class="inputJoin" type="password" id="inputMemberPassword"
						placeholder="패스워드" required />
				</div>
				<div class="joinBox">
					<input class="inputJoin" type="password"
						id="inputMemberPasswordPre" placeholder="패스워드" required />
				</div>
				<div class="joinBox">
					<input class="inputJoin" type="text" id="inputMemberName"
						placeholder="닉네임" required />
				</div>
				<div class="joinBox">
					<button class="inputJoinBtn" type="button"
						onclick="Auth.join()">회원가입</button>
				</div>
				<div class="msgRow">
					<span class="malfunMsg"></span>
				</div>

			</div>
			<div class="col-xs-3"></div>
	</div>
	<div class="col-xs-3"></div>
</div>

</section>


</body>
</html>