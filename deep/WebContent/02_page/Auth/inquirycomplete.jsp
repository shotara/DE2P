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
						<span>안전한 회원정보 관리를 위해 비밀번호를 재설정해주세요!	<br /> 비밀번호 재설정 페이지는 일회성 페이지이며 재설정을 원하시는 경우 <br/> 아이디/비밀번호 찾기를 다시 진행해주시기 바랍니다.
						</span>
					</div>

					<div class="pTop3"></div>

					<div class="ipt-user-inquiry pTop2">
						<div class="float-left inquiry-commonTxt">
							비밀번호<span class="primary-color">*</span>
						</div>
						<input class="ipt-Inquiry" type="password"
							id="inputMemberPassword" placeholder="비밀번호를 입력해주세요." required />
					</div>

					<div class="ipt-user-inquiry pTop2">
						<div class="float-left inquiry-commonTxt">
							비밀번호 확인<span class="primary-color">*</span>
						</div>
						<input class="ipt-Inquiry" type="password"
							id="inputMemberPassword2" placeholder="비밀번호를 한번 더 입력해주세요."
							required />
					</div>

					<div class="pTop5"></div>

					<div>
						<a href="#" onclick="Auth.inquiryComplete()"><button
								class="common-wide-Btn" type="button">변경 완료</button></a>
					</div>

					<div class="pTop5"></div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa;">

					
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