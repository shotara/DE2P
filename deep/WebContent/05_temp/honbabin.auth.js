var Auth = {};

Auth.init = function(mode) {
	
	if(mode == 1) {
		// 공통 초기화
		slider = $("#auth-join .slides, #auth-join-m").unslider({
			autoplay : false,
			keys : false,
			nav : false,
			arrows: false,
			speed : 300
		});
		
		// 데스크탑
		$("#auth-law .content").css("height", $("html").height() - 190);	
	}
}

Auth.checkValue = function(no) {
	
	switch(no) {
		// 이름 체크
		case 1:	
			var name = $("#inputMemberName").val();
			
			// 이름이 2글자 미만인 경우
			if(name.length < 2 || name.length > 9) {
				alert("이름을 확인해주세요.");
				$("#inputMemberName").focus();
				$("li[data-step='2'] div.msgRow").text("이름은 2글자 이상 8글자 이하인 경우만 사용할 수 있습니다."); // 데스크탑
				$("#auth-join-m .message").html("이름은 2글자 이상 8글자 이하인 경우만<br />사용할 수 있습니다."); // 모바일
				return false;
			}
			
			// 이름이 한글, 영문, 숫자가 아닌 경우
			var chk = /[0-9]|[a-z]|[A-Z]|[가-힣]/
			for(i=0; i<name.length; i++) {
				if(!chk.test(name.charAt(i))) {
					alert("이름을 확인해주세요.");
					$("#inputMemberName").focus();
					$("li[data-step='2'] .content div.msgRow:first").html("이름은 한글, 영문, 숫자만 사용할 수 있습니다.");
					$("#auth-join-m .message").html("이름은 한글, 영문, 숫자만 사용할 수 있습니다.");
					return false;
				}
			}
			
			break;

		// 비밀번호 체크
		case 2:
			var password1 = $("#inputMemberPasswordPre").val();
			var password2 = $("#inputMemberPassword").val();
			
			// 비멀번호가 6자 미만인 경우
			if(password1.length < 6) {
				$("li[data-step='3'] div.msgRow").text("비밀번호는 6글자 이상 가능합니다."); // 데스크탑
				$("#auth-join-m .message").html("비밀번호는 6글자 이상 가능합니다."); // 모바일
				return false;
			}

			// 비밀번호가 서로 일치하지 않는 경우
			if(password1 != password2) {
				if(password2 == "") {
					$("li[data-step='3'] div.msgRow").text("비밀번호 확인이 필요합니다."); // 데스크탑
					$("#auth-join-m .message").html("비밀번호 확인이 필요합니다."); // 모바일				
				} else {
					$("li[data-step='3'] div.msgRow").text("일치하지 않습니다."); // 데스크탑
					$("#auth-join-m .message").html("일치하지 않습니다."); // 모바일
				}

				return false;				
			}
			
			// 비밀번호가 서로 일치하는 경우	
			$("li[data-step='3'] div.msgRow").html("<span style='color:#f5ee27;'>사용가능한 비밀번호입니다.</span>"); // 데스크탑
			$("#auth-join-m .message").html("사용가능한 비밀번호입니다.<br />연령대를 선택해주세요."); // 모바일
			
			break;
			
		// 연령대, 지역 체크
		case 3:			
			var selector1 = $("#inputMemberAgeGroup > option:selected").val();
			var selector2 = $("#inputMemberHomePlace1 > option:selected").val();
			var selector3 = $("#inputMemberHomePlace2 > option:selected").val();
			
			if(!(selector1 > 0)) {
				alert("연령대를 선택해주세요.");
				return false;
			}
			
			if(!(selector2 > 0)) {
				alert("지역을 선택해주세요.");
				return false;
			}
			
			if(!(selector3 > 0)) {
				alert("상세 지역을 선택해주세요.");
				return false;
			}
			
			break;
			
		// 이메일 체크
		case 4:			
			if(!validateEmail($("#inputMemberEmail").val())) {
				alert("잘못된 이메일 주소입니다.");
				$("li[data-step='5'] .content div.msgRow:first").text("올바른 이메일이 아닙니다.");
				$("#auth-join-m li[data-step='3'] .result .message").text("올바른 이메일이 아닙니다."); // 모바일
				return false;
			}
			
			break;
			
		// 전화번호 체크
		case 5:			
			if($("#inputMemberPhone1").val().length < 3) {
				alert("휴대폰 번호 첫번째 자리를 잘못 입력하였습니다.");
				$("#inputMemberPhone1").focus();
				return false;
			}
				
			if($("#inputMemberPhone2").val().length < 3) {
				alert("휴대폰 번호 두번째 자리를 잘못 입력하였습니다.");
				$("#inputMemberPhone2").focus();
				return false;
			}
				
			if($("#inputMemberPhone3").val().length < 4) {
				alert("휴대폰 번호 세번째 자리를 잘못 입력하였습니다.");
				$("#inputMemberPhone3").focus();
				return false;
			}
			
			break;
			
		// 인증번호 체크
		case 6:
			if($("#inputMemberAuthPhoneCode").val().length < 6) {
				alert("인증번호를 입력해주세요.");
				$("#inputMemberAuthPhoneCode").focus();
				return false;
			}
			
			break;
			
		// 비밀번호 체크 (로그인용)
		case 7:
			var password = $("#inputMemberPassword").val();
			
			// 비밀번호가 6자 미만인 경우
			if(password.length < 6) {
				alert("등록되지 않은 이메일이거나,\n이메일 또는 비밀번호를 잘못 입력하셨습니다.");
				return false;
			}
			
			break;
			
		default:
			return false;	
	}
	
	return true;
}

Auth.joinCheck = function(mode) {
	
	var check;
	var paramType;
	var param;

	// 0. 약관 체크
	if(mode == 0) {
		return true;
	
	// 1. 이름 체크 (서버 확인 필요)
	} else if(mode == 1) { 
		paramType = "Name";
		param = $("#inputMemberName").val();
		
		// 입력값 체크
		if(!Auth.checkValue(1)) {
			return false;
		}
	
	// 2. 비밀번호 체크
	} else if(mode == 2) {
		
		// 입력값 체크
		if(!Auth.checkValue(2)) {
			return false;
		} else {
			return true;
		}
	
	// 3. 연령대, 지역 체크
	} else if(mode == 3) {
		
		// 입력값 체크
		if(!Auth.checkValue(3)) {
			return false;
		} else {
			return true;
		}
		
	// 4. 이메일 체크 (서버 확인 필요)
	} else if(mode == 4) {
	
		paramType = "Email";
		param = checkWhitespace($("#inputMemberEmail").val()); // 모든 공백을 제거
		param = param.toLowerCase(); // 대문자를 소문자로 변경
		$("#inputMemberEmail").val(param);
			
		// 입력값 체크
		if(!Auth.checkValue(4)) {
			return false;
		}
	
	// 5. 휴대폰 번호 체크 (서버 확인 필요)
	} else if(mode == 5) {
	
		paramType = "Phone";
		param = $("#inputMemberPhone1").val() + $("#inputMemberPhone2").val() + $("#inputMemberPhone3").val();
		
		// 입력값 체크
		if(!Auth.checkValue(5)) {
			return false;
		}
	
	// 6. 인증번호 체크	
	} else if(mode == 6) {
		
		// 입력값 체크
		if(!Auth.checkValue(6)) {
			return false;
		} else {
			return true;
		}
		
	} else {
		return false;
	}
	
	// 6. 공개키 요청
	var publicKeyModulus = "";
	var publicKeyExponent = "";

	$.ajax({
		type : "POST",
		url : "/main?action=getRSAPublicKey",
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.hbiPublicKeyModulus;
			publicKeyExponent = response.hbiPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
		
	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);

	// 7. 서버로부터 받은 공개키로 비밀번호 암호화
	var encryptParam = rsa.encrypt(param);
	
	// 8. 암호화된 이메일과 비밀번호를 서버로 전송	
	var form_data = {
		inputParamType : paramType,
		inputEncryptParam : encryptParam
	};
	
	$.ajax({
		type : "POST",
		url : "/member?action=checkMember",
		data : form_data,
		dataType : "text",
		async : false,
		success: function(response) {
			// 가입 불가능
			if(response == "-3") {
				// 이름 체크
				if(mode == 1) {
					alert("이미 중복된 이름이거나 잘못된 이름입니다.");
					
					if(Honbabin.checkMobile()) { // 모바일	
						$("#auth-join-m .message").text("이미 사용중인 이름이거나 잘못된 이름입니다.");
					} else { // 데스크탑
						$("li[data-step='2'] div.msgRow").text("이미 사용중인 이름이거나 잘못된 이름입니다.");						
					}
					check = false;
				
				// 이메일 체크
				} else if(mode == 4) {
					alert("이미 가입된 이메일 주소입니다.");

					if(Honbabin.checkMobile()) { // 모바일
						$("#auth-join-m .message").text("이미 가입된 이메일 주소입니다.");				
					} else { // 데스크탑
						$("li[data-step='5'] div.msgRow:first").text("이미 가입된 이메일 주소입니다.");						
					}
					check = false;
			
				// 휴대폰 번호 체크
				} else if(mode == 5) {
					alert("이미 가입된 휴대폰 번호입니다.");
					
					if(Honbabin.checkMobile()) { // 모바일
						$("#auth-join-m .message").text("이미 가입된 휴대폰 번호입니다.");				
					} else { // 데스크탑
						$("li[data-step='5'] div.msgRow:first").text("이미 가입된 휴대폰 번호입니다.");						
					}
					check = false;
				}

			// 가입 가능
			} else if(response == "1") {
				// 이름 체크
				if(mode == 1) {
					if(Honbabin.checkMobile()) { // 모바일
						$("#auth-join-m .message").html("사용 가능한 이름입니다.");			
					} else { // 데스크탑
						$("li[data-step='2'] div.msgRow").html("<span style='color:#f5ee27;'>사용 가능한 이름입니다.</span>");				
					}
					check = true;
					
				// 이메일 체크
				} else if(mode == 4) {
					if(Honbabin.checkMobile()) { // 모바일
						$("#auth-join-m .message").html("사용 가능한 이메일입니다.");
					} else { // 데스크탑
						$("li[data-step='5'] div.msgRow:first").html("<span style='color:#f5ee27;'>사용 가능한 이메일입니다.</span>");
					}
					check = true;
					
				// 휴대폰 번호 체크
				} else if(mode == 5) {
					if(Honbabin.checkMobile()) { // 모바일
						$("#auth-join-m .message").html("사용 가능한 휴대폰 번호입니다.");
					} else { // 데스크탑
						$("li[data-step='5'] div.msgRow:first").html("<span style='color:#f5ee27;'>사용 가능한 휴대폰 번호입니다.</span>");
					}
					check = true;					
				}
			}
		}
	});
		
	return check;
}

// 가입하기
Auth.join = function() {
	
	// 1. 입력값 체크	
	if(!(selectedAuthMode == "email" || selectedAuthMode == "phone")) { // 가입 방식 체크
		selectedAuthMode = "email"; // 데스크탑 대비
	}
	
	if(!Auth.joinCheck(0)) { // 약관 체크
		if(!Honbabin.checkMobile()) {
			sliderTarget(1);
		}		
		return false;
	}
	
	if(!Auth.joinCheck(1)) { // 이름 체크
		if(!Honbabin.checkMobile()) {
			sliderTarget(2);			
		}
		return false;
	}
	
	// 이메일로 가입하는 경우
	if(selectedAuthMode == "email") {
		
		if(!Auth.joinCheck(4)) { // 이메일 체크
			return false;
		}
		
		if(!Auth.joinCheck(2)) { // 비밀번호 체크
			if(!Honbabin.checkMobile()) {
				sliderTarget(3);
			}
			return false;
		}
	
	// 휴대폰 번호로 가입하는 경우
	} else if(selectedAuthMode == "phone") {
		
		if(!Auth.joinCheck(5)) { // 휴대폰 번호 체크
			return false;
		}

		if(!Auth.joinCheck(6)) { // 인증번호 체크
			return false;
		}
	}

	if(!Auth.joinCheck(3)) { // 연령대/지역 체크
		if(!Honbabin.checkMobile()) {
			sliderTarget(4);
		}
		return false;
	}

	Honbabin.waiting(true);

	// 2. 공개키 요청
	var publicKeyModulus = "";
	var publicKeyExponent = "";

	$.ajax({
		type : "POST",
		url : "/main?action=getRSAPublicKey",
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.hbiPublicKeyModulus;
			publicKeyExponent = response.hbiPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
	
	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);
	
	// 3. 서버로부터 받은 공개키로 데이터 암호화
	var memberAgeGroup, memberHomePlace, memberName, memberEmail, memberPhone, memberPassword, memberAuthPhoneCode;
	var action, form_data;
	
	if(selectedAuthMode == "email") { // 이메일로 가입하는 경우
		action = "/member?action=joinMemberByEmail";
		
		memberName = protectXSS($("#inputMemberName").val().trim());
		memberEmail = protectXSS($("#inputMemberEmail").val().trim());
		memberPassword = protectXSS($("#inputMemberPassword").val().trim());
		memberAgeGroup = $("#inputMemberAgeGroup > option:selected").val();
		memberHomePlace = ($("#inputMemberHomePlace2 > option:selected").val() > 0 ? $("#inputMemberHomePlace2 > option:selected").val() : $("#inputMemberHomePlace1 > option:selected").val());
				
		// 암호화
		var encryptMemberName = rsa.encrypt(memberName);
		var encryptMemberEmail = rsa.encrypt(memberEmail);
		var encryptMemberPassword = rsa.encrypt(memberPassword);
		
		form_data = {
			inputMemberName : encryptMemberName,
			inputMemberEmail : encryptMemberEmail,
			inputMemberPassword : encryptMemberPassword,
			inputMemberAgeGroup : memberAgeGroup,
			inputMemberHomePlace : memberHomePlace
		};
		
	} else if(selectedAuthMode == "phone") { // 휴대폰 번호로 가입하는 경우
		action = "/member?action=joinMemberByPhone";
		
		memberName = protectXSS($("#inputMemberName").val().trim());
		memberPhone = $("#inputMemberPhone1").val() + $("#inputMemberPhone2").val() + $("#inputMemberPhone3").val();
		memberAuthPhoneCode = protectXSS($("#inputMemberAuthPhoneCode").val().trim());
		memberAgeGroup = $("#inputMemberAgeGroup > option:selected").val();
		memberHomePlace = ($("#inputMemberHomePlace2 > option:selected").val() > 0 ? $("#inputMemberHomePlace2 > option:selected").val() : $("#inputMemberHomePlace1 > option:selected").val());
		
		// 암호화
		var encryptMemberName = rsa.encrypt(memberName);
		var encryptMemberPhone = rsa.encrypt(memberPhone);

		form_data = {
			inputMemberName : encryptMemberName,
			inputMemberPhone : encryptMemberPhone,
			inputMemberAuthPhoneCode : memberAuthPhoneCode,
			inputMemberAgeGroup : memberAgeGroup,
			inputMemberHomePlace : memberHomePlace
		};
	}
			
	// 4. 암호화된 데이터를 서버로 전송	
	$.ajax({
		type : "POST",
		url : action,
		data : form_data,
		dataType : "text",
		success: function(response) {
			// 이메일로 가입하는 경우
			if(selectedAuthMode == "email") {
				if(response == "1") {
					// 데스크탑
					$("li[data-step='5'] div.msgRow:first").html("사용할 수 있는 이메일입니다.");
					$("li[data-step='5'] div.content:last").slideDown();
					
					// 모바일
					$("#auth-join-m .message").html("인증 메일을 확인하시면<br />가입이 완료됩니다."); 
					$("#auth-join-m li[data-step='3'] .bottom button").attr("onclick", "Auth.permit()");
					$("#auth-join-m li[data-step='3'] .bottom button").text("가입 완료");
					
					alert("입력하신 이메일로 인증 메일이 발송되었습니다.\n이메일 계정 확인 버튼을 클릭하시면 회원가입이 완료됩니다.");
				} else if(response == "-3" || response == "-4") {
					$("li[data-step='5'] div.msgRow:first").html("이미 가입된 이메일 주소입니다.");
				} else if(response == "-5") {
					alert("인증메일 전송에 문제가 발생하였습니다.\n문제가 지속된다면 고객센터로 문의해주시기 바랍니다.");
				} else {
					alert("알 수 없는 문제가 발생하였습니다.\n문제가 지속된다면 고객센터로 문의해주시기 바랍니다.");
				}
				
			// 휴대폰번호로 가입하는 경우
			} else if(selectedAuthMode == "phone") {
				if(response == "1") {
					alert("회원가입이 완료되었습니다.");
					location.href = "/";
					
				} else if(response == "-3") {
					alert("이미 가입된 휴대폰 번호입니다.");
				} else if(response == "-4") {
					alert("이미 사용중인 이름이거나 잘못된 이름입니다.");
				} else if(response == "-5") {
					alert("인증번호가 잘못되었습니다.");
				} else {
					alert("알 수 없는 문제가 발생하였습니다.\n문제가 지속된다면 고객센터로 문의해주시기 바랍니다.");
				}
			}
			
			Honbabin.waiting(false);
		}
	});
}

Auth.getPlaceList = function(mode) {
	
	$.ajax({
		type : "POST",
		url : "/main?action=getGlobalPlaceList",
		data : "inputPlaceNo=" + $("#inputMemberHomePlace1 option:selected").val(),
		dataType : "json",
		async : false,
		success: function(response) {
			var places = "<select name='inputPlaceNo' id='inputMemberHomePlace2' title='상세 지역 선택' data-width='100%' data-size='4' data-mobile='true' onchange='clickPlace()'>";
		
			for(i=0; i<response.outputPlaceList.length; i++) {
				places += "<option value='" + response.outputPlaceList[i].outputPlaceNo + "'>" + response.outputPlaceList[i].outputPlaceName + "</option>";
			}
			
			places += "</select>";
			
			// 모바일
			$("#auth-join-m .form .select[data-output='placeList']").html(places);
			$("#auth-join-m .form .message").html("상세 지역을 선택해주세요.");	
			$("#auth-join-m .slides .slide[data-step='3'] .middle .form select#inputMemberHomePlace2").selectpicker();
		}
	});
}

Auth.code = function() {
	
	if(phoneCodeCount == 5) {
		alert("인증번호 요청 횟수를 초과하였습니다. (5회)");
		return false;
	}
	
	if(!Auth.checkValue(5)) {
		return false;
	}
	
	// 2. 공개키 요청
	var publicKeyModulus = "";
	var publicKeyExponent = "";

	$.ajax({
		type : "POST",
		url : "/main?action=getRSAPublicKey",
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.hbiPublicKeyModulus;
			publicKeyExponent = response.hbiPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
	
	var memberPhone = $("#inputMemberPhone1").val() + $("#inputMemberPhone2").val() + $("#inputMemberPhone3").val();

	// 3. XSS 체크
	var filterMemberPhone = protectXSS(memberPhone);
	
	// 2. 서버로부터 받은 공개키로 이메일과 비밀번호, 이름(별명) 암호화
	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);

	var encryptMemberPhone = rsa.encrypt(filterMemberPhone);
		
	// 4. 암호화된 이메일과 비밀번호, 이름(별명)을 서버로 전송	
	var action = "/member?action=addMemberAuthPhoneCode";
	var form_data = {
		inputAuthMode : selectedAuth,
		inputMemberPhone : encryptMemberPhone
	};
	
	$.ajax({
		type : "POST",
		url : action,
		data : form_data,
		dataType : "text",
		async : false,
		success: function(response) {
			if(response == "-3") {
				alert("이미 등록된 번호입니다.");
			} else if(response == "-4") {
				alert("잘못된 번호이거나\n인증번호 발송에 실패하였습니다.")	
			} else if(response == "-5") {
				alert("잘못된 번호이거나\n인증번호 발송에 실패하였습니다.");
			} else if(response == "1") {
				if(phoneCodeCount == 0) {
					alert("인증번호가 발송되었습니다.");
				} else {
					alert("인증번호가 발송되었습니다. (" + phoneCodeCount + ")");
				}

				phoneCodeCount++;
				$("#inputMemberAuthPhoneCode").attr("disabled", false);
				$("#inputMemberAuthPhoneCode").focus();
				$("#auth-join-m .slides .slide[data-step='3'] .middle .form .button button").text("재요청");
				$("#auth-join-m .slides .slide[data-step='3'] .middle .form .code .text").text("인증번호를 입력해주세요.")
			} else {
				alert("알 수 없는 문제가 발생하였습니다.\n문제가 지속된다면 고객센터로 문의해주시기 바랍니다.");
			}
		}
	});
}

Auth.permit = function() {
	
	var check = confirm("인증 메일을 확인하셨습니까?\n인증 메일을 확인하셔야 가입이 완료됩니다.");
	
	if(!check) {
		return false;
	} else {
		location.href = "/";
	}
}

Auth.login = function() {

	// 1. 입력값 체크
	if(!(selectedAuthMode == "email" || selectedAuthMode == "phone")) { // 로그인 방식 체크
		selectedAuthMode = "email"; // 데스크탑 대비
	}
	
	// 이메일로 로그인하는 경우
	if(selectedAuthMode == "email") {
		
		if(!Auth.checkValue(4)) { // 이메일 주소 체크
			return false;
		}
		
		if(!Auth.checkValue(7)) { // 비밀번호 체크
			return false;
		}
		
	// 휴대폰 번호로 로그인하는 경우
	} else if(selectedAuthMode == "phone") {
		
		if(!Auth.checkValue(5)) { // 휴대폰 번호 체크
			return false;
		}
		
		if(!Auth.checkValue(6)) { // 인증번호 체크
			return false;
		}
	}
	
	Honbabin.waiting(true);
	
	// 2. 공개키 요청
	var publicKeyModulus = "";
	var publicKeyExponent = "";
	var action = "/main?action=getRSAPublicKey";
		
	$.ajax({
		type : "POST",
		url : action,
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.hbiPublicKeyModulus;
			publicKeyExponent = response.hbiPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
	
	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);

	// 3. 서버로부터 받은 공개키로 데이터 암호화
	var memberEmail, memberPhone, memberPassword, memberAuthPhoneCode;
	var action, form_data;

	if(selectedAuthMode == "email") { // 이메일로 로그인하는 경우
		action = "/member?action=loginMemberByEmail";

		memberEmail = $("#inputMemberEmail").val();
		memberPassword = $("#inputMemberPassword").val();
		
		// 암호화
		var encryptMemberEmail = rsa.encrypt(memberEmail);
		var encryptMemberPassword = rsa.encrypt(memberPassword);
	
		form_data = {
			inputMemberEmail : encryptMemberEmail,
			inputMemberPassword : encryptMemberPassword
		};
		
	} else if(selectedAuthMode == "phone") { // 휴대폰 번호로 로그인하는 경우
		action = "/member?action=loginMemberByPhone";
		
		memberPhone = $("#inputMemberPhone1").val() + $("#inputMemberPhone2").val() + $("#inputMemberPhone3").val();
		memberAuthPhoneCode = protectXSS($("#inputMemberAuthPhoneCode").val().trim());
		
		// 암호화
		var encryptMemberPhone = rsa.encrypt(memberPhone);

		form_data = {
			inputMemberPhone : encryptMemberPhone,
			inputMemberAuthPhoneCode : memberAuthPhoneCode
		};
	}
	
	// 4. 암호화된 데이터를 서버로 전송	
	$.ajax({
		type : "POST",
		url : action,
		data : form_data,
		dataType : "json",
		async: false,
		success: function(response) {
			// 이메일로 가입하는 경우
			if(selectedAuthMode == "email") {
				if(response.outputResult == "1") {
					if(Honbabin.checkMobile()) {
						location.href = "/";
						
					} else {
						location.reload(true);
					}
					
				} else if(response.outputResult == "-5") {
					alert("비밀번호 오류 초과로 사용이 정지되었습니다.\n'비밀번호를 잊으셨나요?' 버튼을 클릭하시거나\n고객센터로 문의해주시기 바랍니다.");
					Honbabin.waiting(false);
				} else if(response.outputResult == "-6") {
					alert("허가되지 않은 회원입니다.\n이용을 원하실 경우 고객센터로 문의해주시기 바랍니다.");
					Honbabin.waiting(false);
				} else if(response.outputResult == "-8") {
					alert("비밀번호 오류 초과로 사용이 정지되었습니다. (5회 틀림)\n비밀번호를 초기화해주세요.");
					Honbabin.waiting(false);
				} else if(response.outputResult == "-9") {
					alert("등록되지 않은 이메일이거나,\n이메일 또는 비밀번호를 잘못 입력하셨습니다.\n\n5회 이상 틀릴 경우 이용이 정지됩니다.");
					Honbabin.waiting(false);
				} else if(response.outputResult == "-10") {
					alert("등록되지 않은 이메일이거나,\n이메일 또는 비밀번호를 잘못 입력하셨습니다.");
					Honbabin.waiting(false);
				} else {
					alert("등록되지 않은 이메일이거나,\n이메일 또는 비밀번호를 잘못 입력하셨습니다.");
					Honbabin.waiting(false);
				}
				
			// 휴대폰 번호로 로그인하는 경우
			} else if(selectedAuthMode == "phone") {
				if(response.outputResult == "1") {
					location.href = "/";
				} else if(response.outputResult == "-5") {
					alert("비밀번호 오류 초과로 사용이 정지되었습니다.\n'비밀번호를 잊으셨나요?' 버튼을 클릭하시거나\n고객센터로 문의해주시기 바랍니다.");
					Honbabin.waiting(false);
				} else if(response.outputResult == "-6") {
					alert("허가되지 않은 회원입니다.\n이용을 원하실 경우 고객센터로 문의해주시기 바랍니다.");
					Honbabin.waiting(false);
				} else if(response.outputResult == "-7") {
					alert("인증번호가 잘못되었습니다.");
					Honbabin.waiting(false);
				} else {
					alert("등록되지 않은 이메일이거나,\n이메일 또는 비밀번호를 잘못 입력하셨습니다.");
					Honbabin.waiting(false);
				}
			}
			
		}, error: function(xhr,status,error) {
			Honbabin.waiting(false);
		}
	});

	return false;
}

Auth.setDeviceToken = function(device, token, uid) {
	
	var form_data = {
		inputMemberDeviceType : device,
		inputMemberDeviceToken : token,
		inputMemberUid : uid
	}

	$.ajax({
		type : "POST",
		url : "/member?action=setMemberDeviceToken",
		data : form_data,
		dataType : "text",
		async: false,
		success: function(response) {
			if(response == "1") {
				console.log("디바이스 토큰 수정 완료");
			}
		}
	});	
}

Auth.loginCheck = function(mode) {
	
	var check1 = false;
	
	$.ajax({
		type : "POST",
		url : "/member?action=loginCheck",
		dataType : "text",
		async : false,
		success: function(response) {
			if(response == "1") {
				check1 = true;
				
			} else if(response == "-1") {
				if(mode == 1) {
					var check2 = confirm("로그인이 필요합니다.\n로그인 하시겠습니까?");
					
					if(!check2) {
						check1 = false;
					} else {
						Auth.open();
						check1 = false;
					}
					
				} else {
					check1 = false;
				}
			}
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
	
	return check1;
}

Auth.logout = function() {
	
	var action = "/member?action=logoutMember";
	
	$.ajax({
		type : "POST",
		url : action,
		dataType : "text",
		async: false,
		success: function(response) {
			if(response == "1") {
				alert("정상적으로 로그아웃 되었습니다.");
				Facebook.logout();
				location.reload(true);
			} else if(response == "-1") {
				alert("이미 로그아웃 되었거나 로그인된 상태가 아닙니다.");
			} else {
				alert("알 수 없는 에러가 발생하였습니다.");
			}
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
}

Auth.issue = function() {

	// 1 입력폼 체크
	var emailForm = $("#inputMemberEmail").val();
	
	if(!validateEmail(emailForm)) {
		alert("올바른 이메일 주소가 아닙니다.");
		return false;
	}
	
	// 2. 공개키 요청
	var publicKeyModulus = "";
	var publicKeyExponent = "";

	var action = "/main?action=getRSAPublicKey";
	
	Honbabin.waiting(true);
	
	$.ajax({
		type : "POST",
		url : action,
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.hbiPublicKeyModulus;
			publicKeyExponent = response.hbiPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
	
	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);

	// 3. 서버로부터 받은 공개키로 이메일과 비밀번호 암호화
	var memberEmail = $("#inputMemberEmail").val();
	var encryptMemberEmail = rsa.encrypt(memberEmail);
	
	// 4. 암호화된 이메일을 서버로 전송	
	var action = "/member?action=setMemberTempPassword";
	var form_data = {
		inputMemberEmail : encryptMemberEmail
	};
	
	$.ajax({
		type : "POST",
		url : action,
		data : form_data,
		dataType : "text",
		success: function(response) {
			if(response == "1") {
				alert("입력하신 이메일 주소로 임시 비밀번호가 발급되었습니다.\n로그인 후 마이페이지에서 수정하시기 바랍니다.");
			} else if(response ="-3") {
				alert("존재하지 않는 회원입니다.");
			} else {
				alert("알 수 없는 문제가 발생하였습니다.\n고객센터로 문의주시기 바랍니다.");
			}
			Honbabin.waiting(false);
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
		
	return false;
}

Auth.open = function() {
	
	if(Honbabin.checkMobile()) {
		Auth.goLogin();
	} else {
		$("#loginNav, #loginBackground").fadeIn(250);
		$("#loginTxt").text("취소");
		$("#loginTxt").attr("onclick", "Auth.close()");
		$("#loginNav .middle div[data-form='email'] input").focus();
	}
}

Auth.close = function() {
	$("#loginNav, #loginBackground").fadeOut(250);
	$("#loginTxt").text("로그인");	
	$("#loginTxt").attr("onclick", "Auth.open()");
	Auth.temp(false);
}

Auth.temp = function(mode) {
	if(mode) {
		$("#loginNav div.form-group[data-form='password'], #auth-login-m .middle .form .password").slideUp();
		$("#loginNav div.form-group[data-form='tempMsg'], #auth-login-m .middle .form .temp").slideDown();
		$("#loginNav div.form-group[data-form='loginBtn'] button, #auth-login-m .middle .form > .button button").text("임시 비밀번호 발급받기");
		$("#loginNav div.form-group[data-form='loginBtn'] button, #auth-login-m .middle .form > .button button").attr("onclick", "Auth.issue()");
		$("#loginNav div.help-block, #auth-login-m .middle .form .find").html("<span onclick='Auth.temp(false)'>취소</span>");
	} else {
		$("#loginNav div.form-group[data-form='password'], #auth-login-m .middle .form .password").slideDown();
		$("#loginNav div.form-group[data-form='tempMsg'], #auth-login-m .middle .form .temp").slideUp();
		$("#loginNav div.form-group[data-form='loginBtn'] button, #auth-login-m .middle .form > .button button").text("로그인");
		$("#loginNav div.form-group[data-form='loginBtn'] button, #auth-login-m .middle .form > .button button").attr("onclick", "Auth.login()");		
		$("#loginNav div.help-block, #auth-login-m .middle .form .find").html("비밀번호를 잊으셨나요?&nbsp;&nbsp;<span class='text' onclick='Auth.temp(true)'>비밀번호 찾기</span>");
	}
}

Auth.goLogin = function() {
	location.href = "/main?action=goPage&page=login";
}

Auth.goJoin = function(step) {
	if(step == 0) {
		location.href = "/main?action=goPage&page=join";
	} else {
		location.href = "/main?action=goPage&page=joining"
	}
}

Auth.cancel = function() {
	location.href = "/";
}

Auth.checkPass = function() {
	
	// 1 입력폼 체크
	if(checkMemberIsSocialUser == 1) {
		$("#inputMemberCurrentPassword").val("");
	} else {
		if($("#inputMemberCurrentPassword").val().length < 6) {
			alert("기존 비밀번호를 입력하지 않았거나 잘못 입력하였습니다.");
			return false;
		}
	}
	
	// 2. 공개키 요청
	var publicKeyModulus = "";
	var publicKeyExponent = "";

	var action = "/main?action=getRSAPublicKey";
		
	$.ajax({
		type : "POST",
		url : action,
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.hbiPublicKeyModulus;
			publicKeyExponent = response.hbiPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
	
	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);

	var form_data = {
		inputMemberCurrentPassword : rsa.encrypt($("#inputMemberCurrentPassword").val())
	};
	
	$.ajax({
		type : "POST",
		url : "/member?action=checkMemberByPassword",
		data : form_data,
		dataType : "text",
		success: function(response) {
			if(response == "1") {
				MyPage.modify(true);
			} else {
				alert("비밀번호가 일치하지 않습니다.");
			}
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
		
	return false;
}

Auth.modify = function() {
	
	// 1. 입력폼 체크
	if(checkMemberIsSocialUser == 1) {
		if($("#inputMemberNewPassword").val().length == 0) {
			alert("비밀번호가 설정되지 않았습니다.\n새 비밀번호를 입력하셔야 합니다.");
			$("#inputMemberNewPassword").focus();
			return false;
		}
		
		if($("#inputMemberNewPassword").val().length < 6) {
			alert("새 비밀번호를 잘못 입력하셨습니다.\n6자 이상 입력해야 합니다.");
			return false;
		}
		
	} else {
		if($("#inputMemberCurrentPassword").val().length < 6) {
			alert("기존 비밀번호를 입력하지 않았거나 잘못 입력하였습니다.");
			return false;
		}
		
		if($("#inputMemberNewPassword").val().length > 0 && $("#inputMemberNewPassword").val().length < 6) {
			alert("새 비밀번호를 잘못 입력하셨습니다.\n6자 이상 입력해야 합니다.");
			return false;
		}
	}
	
	if($("#inputMemberPhone1").val() != "" || $("#inputMemberPhone2").val() != "" || $("#inputMemberPhone3").val() != "") {
		if($("#inputMemberPhone1").val().length < 3) {
			alert("휴대폰 번호 첫번째 자리를 잘못 입력하였습니다.");
			$("#inputMemberPhone1").focus();
			return false;
		}
		
		if($("#inputMemberPhone2").val().length < 3) {
			alert("휴대폰 번호 두번째 자리를 잘못 입력하였습니다.");
			$("#inputMemberPhone2").focus();
			return false;
		}
		
		if($("#inputMemberPhone3").val().length < 4) {
			alert("휴대폰 번호 세번째 자리를 잘못 입력하였습니다.");
			$("#inputMemberPhone3").focus();
			return false;
		}		
	}
	
	if($("#inputMemberBankAccountName").val() != "" || $("#inputMemberBankAccountNo").val() != "") {
		if($("#inputMemberBankAccountName").val() == "") {
			alert("예금주명을 입력하지 않았거나 잘못 입력하였습니다.");
			return false;
		}
		
		if($("#inputMemberBankAccountNo").val() == "") {
			alert("계좌번호를 입력하지 않았거나 잘못 입력하였습니다.");
			return false;			
		}
		
		if($("#inputPaymentBankNo > option:selected").val() == "-1") {
			alert("은행을 선택하지 않았거나 미등록 상태입니다.");
			return false;			
		}		
	}
	
	// 2. 공개키 요청
	var publicKeyModulus = "";
	var publicKeyExponent = "";

	var action = "/main?action=getRSAPublicKey";
		
	$.ajax({
		type : "POST",
		url : action,
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.hbiPublicKeyModulus;
			publicKeyExponent = response.hbiPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
		
	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);

	var memberName = $("#inputMemberName").val();
	var memberAgeGroup = $("#inputMemberAgeGroup > option:selected").val();
	var memberHomePlace = $("#inputMemberHomePlace2 > option:selected").val();
	var memberPhone = $("#inputMemberPhone1").val() + $("#inputMemberPhone2").val() + $("#inputMemberPhone3").val();
	var memberAuthPhoneCode = protectXSS($("#inputMemberAuthPhoneCode").val().trim());
	var memberCurrentPassword = $("#inputMemberCurrentPassword").val();
	var memberNewPassword = $("#inputMemberNewPassword").val();
	var paymentBankNo = $("#inputPaymentBankNo > option:selected").val();
	var memberBankAccountName = $("#inputMemberBankAccountName").val();
	var memberBankAccountNo = $("#inputMemberBankAccountNo").val();
	var memberProfileText = $("#inputMemberProfileText").val();
	var memberModifyAccessToken = $("#inputMemberModifyAccessToken").val();

	// 입력값 XSS 방어
	var filterMemberName = protectXSS(memberName);
	var filterMemberBankAccountName = protectXSS(memberBankAccountName);
	var filterMemberBankAccountNo = protectXSS(memberBankAccountNo);
	var filterMemberProfileText = protectXSS(memberProfileText);
	
	// 3. 데이터 암호화
	var encryptMemberName = rsa.encrypt(filterMemberName);
	var encryptMemberPhone = rsa.encrypt(memberPhone);
	var encryptMemberCurrentPassword = rsa.encrypt(memberCurrentPassword);
	var encryptMemberNewPassword = rsa.encrypt(memberNewPassword);
	var encryptMemberBankAccountName = rsa.encrypt(filterMemberBankAccountName);
	var encryptMemberBankAccountNo = rsa.encrypt(filterMemberBankAccountNo);
	var encryptMemberModifyAccessToken = rsa.encrypt(memberModifyAccessToken);

	// 4. 암호화된 데이터를 서버로 전송	
	var action = "/member?action=modifyMember";
	var form_data = {
		inputMemberName : encryptMemberName,
		inputMemberAgeGroup : memberAgeGroup,
		inputMemberHomePlace : memberHomePlace,
		inputMemberPhone : encryptMemberPhone,
		inputMemberAuthPhoneCode : memberAuthPhoneCode,
		inputMemberCurrentPassword : encryptMemberCurrentPassword,
		inputMemberNewPassword : encryptMemberNewPassword,
		inputPaymentBankNo : paymentBankNo,
		inputMemberBankAccountName : encryptMemberBankAccountName,
		inputMemberBankAccountNo : encryptMemberBankAccountNo,
		inputMemberProfileText : filterMemberProfileText,
		inputMemberModifyAccessToken : encryptMemberModifyAccessToken
	};

	$.ajax({
		type : "POST",
		url : action,
		data : form_data,
		dataType : "text",
		success: function(response) {
			if(response == "1") {
				alert("회원님의 정보가 정상적으로 수정되었습니다.");
				location.reload(true);
			} else if(response == "-2") {
				alert("기존 비밀번호를 입력하지 않았거나\n필수 입력 정보가 누락되었습니다.");
			} else if(response == "-6") {
				alert("잘못된 이름을 입력하셨습니다.\n이름은 한글, 영문, 숫자만 가능합니다.");
			} else if(response == "-7") {
				alert("인증번호를 잘못 입력하셨습니다.");
				$("#inputMemberAuthPhoneCode").focus();
			} else {
				alert("잘못된 입력이거나 문제가 발생하였습니다.\n문제가 지속된다면 고객센터로 문의주시기 바랍니다.");
			}
			
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});
	
	return false;
}