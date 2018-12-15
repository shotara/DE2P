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

	<div class="container">
		<div class="row">
			<div class="col txt-center">
				<div class="txt-center login">

					<div class="pTop"></div>

					<div class="float-right login-Redirect">
						<a href="/index.jsp">홈으로</a>
					</div>
					<div class="login-brand">Rancre</div>

					<div class="pTop3"></div>

					<div>
						<span>더 많은 채널의 광고 리뷰가 궁금하신가요? </br> 지금 랭크리에서 2,342개 채널의 광고 효과를
							확인해보세요!
						</span>
					</div>

					<div class="pTop3"></div>

					<div class="ipt-login">
						<div class="float-left login-commonTxt">
							아이디<span class="primary-color">*</span>
						</div>
						<input class="ipt-Member-Join" type="email" id="inputMemberEmail"
							placeholder="이메일을 입력해주세요." required />
					</div>

					<div class="ipt-login pTop2">
						<div class="float-left login-commonTxt">
							비밀번호<span class="primary-color">*</span>
						</div>
						<input class="ipt-Member-Join" type="password"
							id="inputMemberPassword" placeholder="비밀번호를 입력해주세요." required />
					</div>

					<div class="ipt-login pTop2">
						<div class="float-left login-commonTxt">
							회사명<span class="primary-color">*</span>
						</div>
						<input class="ipt-Member-Join" type="text" id="inputCompanyName"
							placeholder="회사명을 입력해주세요." required />
					</div>

					<div class="ipt-login pTop2">
						<div class="float-left login-commonTxt">
							사업자번호<span class="primary-color">*</span>
						</div>
					</div>
					<div class="inline-flex">
						<input class="ipt-Company-Number display-initial" type="text"
							id="inputCompany-Number1" required />
						<div class="ipt-Company-Slash display-initial">-</div>
						<input class="ipt-Company-Number display-initial" type="text"
							id="inputCompany-Number2" required />
						<div class="ipt-Company-Slash display-initial">-</div>
						<input class="ipt-Company-Number display-initial mRight" type="text"
							id="inputCompany-Number3" required />
						<div class="w20 display-initial">
							<button class="companyCheckBtn" onclick="">조회</button>
						</div>
					</div>


					<div class="pTop2"></div>

					<div class="">
						<span>동영상 채널을 이용하여 광고를 하신적이 있나요?</span> </br> <span>광고 후기를 입력하면
							다른 광고 후기를 바로 확인할 수 있어요!</span>

					</div>

					<div class="">
						<input type="radio" id="yes" name="commercialCheck" checked>
						<label for="yes">예</label> <input type="radio" id="no"
							name="commercialCheck"> <label for="no">아니오</label>
					</div>

					<div class="pTop3"></div>

					<div>
						<a href="#" onclick="Auth.join()"><button
								class="common-wide-Btn" type="button">회원가입</button></a>
					</div>

					<div class="pTop3"></div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa;">

					<div class="pTop2"></div>

					<div class="row">
						<div class="col login-Redirect">
							<a href="/index.jsp">아이디 찾기</a>
						</div>
						<div class="col login-Redirect">
							<a href="/index.jsp">비밀번호 찾기</a>
						</div>
						<div class="col login-Redirect">
							<a href="../Auth/login.jsp">로그인</a>
						</div>
					</div>

					<div class="pTop4"></div>

					<div class="float-left">
						<span class="brand-color">Rancre</span><span class="gray-color">
							all right reserved.</span>
					</div>
					<div class="float-right login-Redirect">
						<a href="#">Contact Us</a>
					</div>


				</div>
			</div>
		</div>
	</div>

</body>
</html>
