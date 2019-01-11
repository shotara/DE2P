<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />
<script>
	$('#inputMemberEmail').focusout(function() {
		if(!Auth.joinCheck(1)) {
			buttonDisable();
		};
	});

	$('#inputMemberPassword2').focusout(function() {
		if(!Auth.joinCheck(2)) {
			buttonDisable();

		};	});
	
	function buttonDisable() {
		var btn = document.getElementById('joinButton');
		btn.disabled = 'disabled';
	}
	
	function checkNumber(temp) {
				
		if(isNaN(temp) == true) {
			alert("숫자만 입력해주세요.");
			buttonDisable();
		} 
	};

	$('#inputCompany-Number1').focusout(function() {
		Auth.checkNumber($('#inputCompany-Number1').val());
	});
	$('#inputCompany-Number2').focusout(function() {
		Auth.checkNumber($('#inputCompany-Number2').val());
	});
	$('#inputCompany-Number3').focusout(function() {
		Auth.checkNumber($('#inputCompany-Number3').val());
	});
		
	
</script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col txt-center">
				<div class="txt-center join">

					<div class="v20"></div>

					<div class="float-right login-Redirect">
						<a href="/index.jsp">홈으로</a>
					</div>
					<div class="login-brand">Rancre</div>

					<div class="pTop"></div>

					<div>
						<span>더 많은 채널의 광고 리뷰가 궁금하신가요? </br> 지금 랭크리에서 2,342개 채널의 광고 효과를
							확인해보세요!
						</span>
					</div>

					<div class="pTop3"></div>

					<div class="ipt-login">
						<div class="float-left join-commonTxt">
							아이디<span class="primary-color">*</span>
						</div>
						<input class="ipt-Member-Join" type="email" id="inputMemberEmail"
							placeholder="이메일을 입력해주세요." required />
					</div>

					<div class="ipt-login pTop2">
						<div class="float-left join-commonTxt">
							비밀번호<span class="primary-color">*</span>
						</div>
						<input class="ipt-Member-Join" type="password"
							id="inputMemberPassword" placeholder="비밀번호를 입력해주세요." required />
					</div>

					<div class="ipt-login pTop2">
						<div class="float-left join-commonTxt">
							비밀번호 확인<span class="primary-color">*</span>
						</div>
						<input class="ipt-Member-Join" type="password"
							id="inputMemberPassword2" placeholder="비밀번호를 한번 더 입력해주세요." required />
					</div>

					<div class="ipt-login pTop2">
						<div class="float-left join-commonTxt">
							회사명<span class="primary-color">*</span>
						</div>
						<input class="ipt-Member-Join" type="text" id="inputCompanyName"
							placeholder="회사명을 입력해주세요." required  oncahnge="buttonDisable();" />
					</div>

					<div class="ipt-login pTop2">
						<div class="float-left join-commonTxt">
							사업자번호<span class="primary-color">*</span>
						</div>
					</div>
					<div class="inline-flex">
						<input class="ipt-Company-Number display-initial" type="text"
							id="inputCompany-Number1" maxlength="3" oncahnge="buttonDisable();"  required /> <span
							class="pRight pLeft pTop-half">-</span> <input
							class="ipt-Company-Number display-initial" type="text"
							id="inputCompany-Number2" maxlength="2" oncahnge="buttonDisable();"  required /> <span
							class="pRight pLeft pTop-half">-</span> <input
							class="ipt-Company-Number display-initial mRight" type="text"
							id="inputCompany-Number3" maxlength="5" oncahnge="buttonDisable();"  required />
						<div class="ipt-Company-Check display-initial">
							<button class="companyCheckBtn" onclick="Auth.businessCheck()">조회</button>
						</div>
					</div>

					<div class="pTop3"></div>

					<div>
						<a onclick="Auth.join()"><button
								id="joinButton" class="common-wide-Btn" type="button" disabled="disabled">회원가입</button></a>
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

					<div class="pTop4"></div>


				</div>
			</div>
		</div>
	</div>

</body>
</html>
