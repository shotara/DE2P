<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />
<jsp:include page="/02_page/commonContactUs.jsp" flush="true" />

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col txt-center">
				<div class="txt-center login">

					<div class="v20"></div>

					<div class="float-right login-Redirect">
						<a href="/index.jsp">홈으로</a>
					</div>
					<div class="login-brand">Rancre</div>

					<div class="pTop"></div>

					<div class="float-left login-type-corp">기업</div>
					<hr
						style="margin-top: 1.5rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa;">

					<div class="pTop2">
						<span>더 많은 채널의 광고 리뷰가 궁금하신가요? </br> 지금 랭크리에서 2,342개 채널의 광고 효과를
							확인해보세요!
						</span>
					</div>

					<div class="pTop3"></div>

					<div class="ipt-login">
						<div class="float-left login-commonTxt">아이디</div>
						<input class="ipt-Member-Email" type="email" id="inputMemberEmail"
							placeholder="이메일을 입력해주세요." required />
					</div>

					<div class="ipt-login pTop3">
						<div class="float-left login-commonTxt">비밀번호</div>
						<input class="ipt-Member-Password" type="password"
							id="inputMemberPassword" placeholder="비밀번호를 입력해주세요." required />
					</div>

					<div class="pTop5"></div>

					<div>
						<a href="#" onclick="Auth.login()"><button
								class="common-wide-Btn" type="button">로그인</button></a>
					</div>

					<div class="pTop5"></div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa;">

					<div class="pTop3"></div>

					<div class="row">
						<div class="col login-Redirect">
							<a href="/index.jsp">아이디 찾기</a>
						</div>
						<div class="col login-Redirect">
							<a href="/index.jsp">비밀번호 찾기</a>
						</div>
						<div class="col login-Redirect">
							<a href="../Auth/join.jsp">회원가입</a>
						</div>
					</div>
					
					<div class="pTop5"></div>

					<div class="float-left"><span class="brand-color">Rancre</span><span class="gray-color"> all right reserved.</span></div>
					<div class="float-right login-Redirect"><a href="#" onclick="Common.contactUs(1)">Contact Us</a></div>
					
					<div class="pTop5"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>