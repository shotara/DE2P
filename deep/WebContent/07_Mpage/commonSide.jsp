<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rancre : 유튜브 채널 정보 플랫폼</title>
<jsp:include page="/07_Mpage/commonMobileHeader.jsp" flush="true" />
</head>
<body id="mbody">

	<section id="mSideMenu">
	<div class="rac_m_side_top">
		<a href="/07_Mpage/main.jsp" class="rac_m_top_exit"> <i
			class="icon-cancel"></i>
		</a>
	</div>
	<div class="rac_m_side_profile">

		<!-- non-login-session -->

		<div class="rac_m_non_login">
			<a href="/07_Mpage/Auth/MLogin.jsp" class="rac_m_side_user"> <i
				class="icon-user"></i> <span>로그인하기</span> <i class="icon-right-open-mini"></i>
			</a>
		</div>

		<!-- non-login-session-end -->

		<!-- login-session exist -->

		<!-- login-session exist-end -->

	</div>
	
	<div class="rac_m_side_menu">
		<ul class="side_menu">
			<li>채널 100</li>
			<li>모든 채널</li>
			<li>새로운 채널</li>
			<li>검색</li>
		</ul>
	</div>


	</section>


</body>
</html>