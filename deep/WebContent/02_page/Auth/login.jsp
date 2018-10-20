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



	<section class="login">
	<div class="container">
		<div class="row">
			<div class="col-xl-4"></div>

			<div class="col-xl-4 text-center login-Form">
				<div>
					<span class="brand">Rancre</span>
				</div>
				<input class="inputMemberEmail" type="email" id="inputMemberEmail"
					placeholder="이메일" required /> 
					
				<input class="inputMemberPassword"
					type="password" id="inputMemberPassword" placeholder="패스워드"
					required />
				<div class="msgRow">
					<span class="malfunMsg"></span>
				</div>

				<button class="inputLoginBtn" type="button" onclick="Auth.login()">로그인</button>
			</div>
			<div class="col-xl-4">
				<span><a href="/index.jsp">홈으로</a></span>
			</div>


		</div>
	</div>
	</section>



</body>
</html>