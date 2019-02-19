/**
 * 
 */


var Auth = {};

Auth.init = function(){}


Auth.checkValue = function(mode){

	//mode 1 = email check
	//mode 2 = pw check

	switch(mode){

	case 1: //email check
		var email = $("#inputMemberEmail").val();
		if(email == ""){
			alert("이메일을 입력해주세요.");
			return false;
		}else if(!validateEmail(email)){  //valid email check
			alert("올바른 이메일이 아닙니다");
			return false;
		}
		break;

	case 2: //pw check - join
		var password1 = $("#inputMemberPassword").val();
		var password2 = $("#inputMemberPassword2").val();

		if(password1.length < 6){
			alert("패스워드는 6글자 이상으로 해주세요.");
			return false;
		}

		if(password1 != password2){

			if(passwoord2 == ""){
				alert("패스워드를 한번 더 입력해주세요.");
				return false;
			}else{
				alert("패스워드가 일치하지 않습니다.");
				return false;
			}		
			return false;
		}

		break;

	case 3://check company Name;
		var companyname = $("#inputCompanyName").val();
		//less than 2 letters 
		if(companyname == ""){
			alert("회사명을 입력해주세요.");
			return false;
		}
		break;

	default :
		return false;
	}

	return true;
}


Auth.joinCheck = function(mode){

	var check;
	var paramtype;
	var param;

	if(mode == 1){ //eamil check
		param = checkWhitespace($("#inputMemberEmail").val());
		param = param.toLowerCase();
		$("#inputMemberEmail").val(param);

		if(!Auth.checkValue(1)){
		
			return false;
		}
	} else if(mode == 2){//password check

		if(!Auth.checkValue(2)){

			return false;
		}else{
			return true;
		}
	} else if(mode == 3){//name check

		if(!Auth.checkValue(3)){
			
			return false;
		}
	}
	
	return true;

}

Auth.checkNumber =function(mode){
	
	var check_ipt1 = $("#inputCompany-Number1").val();
	var check_ipt2 = $("#inputCompany-Number2").val();
	var check_ipt3 = $("#inputCompany-Number3").val();
	
	if(mode == 1){
		if(check_ipt1.length < 3 || check_ipt2.length < 2 || check_ipt3.length < 5){
			var check_company = document.getElementById('company-Check-Btn');
			check_company.style.background = '#fd8090';
			check_company.style.border = '1px solid #fd8090';
			check_company.disabled = true;
		}else {
			var check_company = document.getElementById('company-Check-Btn');
			check_company.style.background = '#f11834';
			check_company.style.border = '1px solid #f11834';
			check_company.disabled = false;
		}
	}
}

Auth.businessCheck = function () {

	var check_ipt1 = $("#inputCompany-Number1").val();
	var check_ipt2 = $("#inputCompany-Number2").val();
	var check_ipt3 = $("#inputCompany-Number3").val();

	if(check_ipt1.length == 3 && check_ipt2.length == 2 && check_ipt3.length == 5){
		
		var businessNo = $("#inputCompany-Number1").val() + $("#inputCompany-Number2").val() + $("#inputCompany-Number3").val();  

		var publicKeyModulus = "";
		var publicKeyExponent = "";

		$.ajax({
			type : "POST",
			url : "/main?action=getRSAPublicKey",
			dataType : "json",
			async: false,
			success: function(response) {
				publicKeyModulus = response.deepPublicKeyModulus;
				publicKeyExponent = response.deepPublicKeyExponent;
			}, error: function(xhr,status,error) {
				alert(error);
			}
		});

		var rsa = new RSAKey();
		rsa.setPublic(publicKeyModulus, publicKeyExponent);

		var form_data = {
				inputCompany : businessNo
		};

		$.ajax({
			type:"POST",
			url: "/member?action=checkCompany",
			data:form_data,
			dataType: "json",
			async : false,
			success: function(response) {

				if(response.outputResult == "1") {
					alert("확인되었습니다.");
					var btn = document.getElementById('joinButton');
					btn.style.background = '#f11834';
					btn.style.border = '1px solid #f11834';
					btn.disabled = false;
					return true;
				} else if(response.outputResult == "-2") {
					alert("잘못된 사업자 번호입니다.");
					var btn = document.getElementById('joinButton');
					btn.disabled = 'disabled';
					return false;
				} else if(response.outputResult == "-1") {
					alert("이미 사용중인 사업자 번호입니다.");
					var btn = document.getElementById('joinButton');
					btn.disabled = 'disabled';
					return false;
				} else {
					alert(response.outputResult);
					alert("알수없는 문제가 발생했습니다.");
				}
			}
		});
	}else {
		
	}
}

Auth.join = function(){

	if(!Auth.joinCheck(1)){
		return false;
	}// email check
	if(!Auth.joinCheck(2)){
		return false;
	}//password check
	
	if(!Auth.joinCheck(3)){
		return false;
	}// company name check

	//2. 공개키 요청
	var publicKeyModulus = "";
	var publicKeyExponent = "";

	$.ajax({
		type : "POST",
		url : "/main?action=getRSAPublicKey",
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.deepPublicKeyModulus;
			publicKeyExponent = response.deepPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});

	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);

	var memberEmail, memberPassword, businessNumber;

	action = "/member?action=joinMember";

	memberEmail = protectXSS($("#inputMemberEmail").val().trim());
	memberPassword = protectXSS($("#inputMemberPassword").val().trim());
	memberPasswordConfirm = protectXSS($("#inputMemberPassword2").val().trim());
	businessNumber =  protectXSS($("#inputCompany-Number1").val() + $("#inputCompany-Number2").val() + $("#inputCompany-Number3").val());
	companyName =  protectXSS($("#inputCompanyName").val());

	//암호화
	var encryptMemberEmail = rsa.encrypt(memberEmail);
	var encryptMemberPassword = rsa.encrypt(memberPassword);
	var encryptMemberPasswordConfirm = rsa.encrypt(memberPasswordConfirm);
	var encryptBusinessNumber = rsa.encrypt(businessNumber);
	var encryptCompanyName = rsa.encrypt(companyName);

	form_data = {
			inputBusinessNumber : encryptBusinessNumber,
			inputMemberPassword : encryptMemberPassword,
			inputMemberPasswordConfirm : encryptMemberPasswordConfirm,
			inputMemberEmail : encryptMemberEmail,
			inputCompanyName : encryptCompanyName
	};


	$.ajax({
		type : "POST",
		url : action,
		data : form_data,
		dataType : "json",
		success: function(response){

			if(response.outputResult == "1"){
				alert("인증메일이 발송되었습니다. 회원가입에 사용한 이메일에서 회원가입을 완료해주세요!");
				location.href = "/";
			}else if(response.outputResult == "-3" ||response.outputResult == "-4"){
				$("div.msgRow.malfunMsg").text("이미 가입된 이메일 또는 사용중인 닉네임입니다.");
			}else {
				alert("알 수 없는 문제가 발생하였습니다. \n 문제가 지속된다면 전 혼이 나겠네요. \n 고객센터로 조용히 문의바랍니다.");
			}
		}	
	});

}

Auth.login = function(){

	//email check regular expression
	if(!Auth.checkValue(1)){
		return false;
	}

//	//pw check more than 6 letters
//	if(!Auth.checkValue(4)){
//		return false;
//	}

	var publicKeyModulus = "";
	var publicKeyExponent = "";
	var action = "/main?action=getRSAPublicKey";

	$.ajax({
		type : "POST",
		url : "/main?action=getRSAPublicKey",
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.deepPublicKeyModulus;
			publicKeyExponent = response.deepPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});

	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);

	var memberEmail = "";
	var memberPassword = "";
	var action, form_data;

	action = "/member?action=loginMember";
	memberEmail = $("#inputMemberEmail").val();
	memberPassword = $("#inputMemberPassword").val();

	//encryption
	var encryptMemberEmail  = rsa.encrypt(memberEmail);
	var encryptMemberPassword = rsa.encrypt(memberPassword);

	form_data = {
			inputMemberEmail : encryptMemberEmail,
			inputMemberPassword : encryptMemberPassword
	};

	$.ajax({
		type:"POST",
		url : action,
		data : form_data,
		dataType : "json",
		async : false,
		success :  function(response){
			if(response.outputResult == "1"){
				location.href = "/";
			} else if(response.outputResult == "-5"){
				alert("인증 메일이 발송되었습니다. 인증메일을 확인해주세요.");
			}else{
				alert("등록되지 않은 이메일이거나, \n이메일 또는 비밀번호가 잘못되었습니다.");
			}
		}, error: function(xhr, status, error){
			alert("알 수 없는 문제가 발생하였습니다. \n 문제가 지속된다면 전 혼이 나겠네요. \n 고객센터로 조용히 문의바랍니다.");
		}
	});

	return false;
}

Auth.loginCheck = function(mode){

	var check1 = false;

	$.ajax({
		type :  "POST",
		url : "/member?action=loginCheck",
		dataType : "json",
		async : false,
		success : function(response){
			if(response.outputResult == "1"){
				check1 = true; //Status - login
			}else if(response.outputResult == "-1"){
				//login needed
				if(mode == 1){
					var check2 = confirm("로그인이 필요합니다.\n로그인하시겠습니까?");

					if(!check2){//don't want to login
						check1 = false;
					}else{//Move to login page
						location.href="/main?action=goPage&page=login";
						check1 = false;
					}
				}else {
					check1 = false;
				}
			}
		}, error : function(xhr, status, error){
			alert(error);
		}	
	});

	return check1;
}

Auth.logout = function(){

	var action = "/member?action=logoutMember";

	$.ajax({
		type : "POST",
		url : action,
		dataType : "json",
		async : false,
		success : function(response){
			if(response.outputResult == "1"){
				alert("정상적으로 로그아웃 되었습니다.");
				location.href = "/";
			}else if(response.outputResult == "-1"){
				alert("이미 로그아웃 되었거나 로그인된 상태가 아닙니다.");
			}else {
				alert("알 수 없는 에러가 발생했습니다");
			}

		}, error: function(xhr, status, error){
			alert(error);
		}

	});
}

Auth.userInquiry = function(){

	//email check regular expression
	if(!Auth.checkValue(1)){
		return false;
	}
	
	var publicKeyModulus = "";
	var publicKeyExponent = "";
	var action = "/main?action=getRSAPublicKey";

	$.ajax({
		type : "POST",
		url : "/main?action=getRSAPublicKey",
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.deepPublicKeyModulus;
			publicKeyExponent = response.deepPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});

	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);
	
	var memberEmail = "";
	var action, form_data;

	action = "/member?action=checkValidMember"; // 이곳 수정 필요
	memberEmail = $("#inputMemberEmail").val();
	
	//encryption
	var encryptMemberEmail  = rsa.encrypt(memberEmail);

	form_data = {
			inputMemberEmail : encryptMemberEmail
	};
	
	$.ajax({
		type:"POST",
		url : action,
		data : form_data,
		dataType : "json",
		async : false,
		success :  function(response){
			if(response.outputResult == "1"){ //valid email information 
				alert("인증 메일이 발송되었습니다. 인증메일을 확인해주세요.");
				location.href = "/";
			}else{ //invalid email or wrong context  
				alert("등록되지 않은 이메일이거나 이메일이 양식이 정확하지 않습니다.");
			}
		}, error: function(xhr, status, error){
			alert("알 수 없는 문제가 발생하였습니다. \n 문제가 지속된다면 전 혼이 나겠네요. \n 고객센터로 조용히 문의바랍니다.");
		}
	});

	return false;

}

Auth.inquiryComplete = function(){
	
	if(!Auth.checkValue(2)){
		return false;
	}//password check
	
	//2. 공개키 요청
	var publicKeyModulus = "";
	var publicKeyExponent = "";

	$.ajax({
		type : "POST",
		url : "/main?action=getRSAPublicKey",
		dataType : "json",
		async: false,
		success: function(response) {
			publicKeyModulus = response.deepPublicKeyModulus;
			publicKeyExponent = response.deepPublicKeyExponent;
		}, error: function(xhr,status,error) {
			alert(error);
		}
	});

	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);

	var memberEmail, memberPassword;

	action = "/member?action=changeMemberPassword";  //재설정 필요

	memberEmail = protectXSS($("#inputMemberEmail").val().trim());
	memberPassword = protectXSS($("#inputMemberPassword").val().trim());
	memberPasswordConfirm = protectXSS($("#inputMemberPassword2").val().trim());

	//암호화
	var encryptMemberEmail = rsa.encrypt(memberEmail);
	var encryptMemberPassword = rsa.encrypt(memberPassword);
	var encryptMemberPasswordConfirm = rsa.encrypt(memberPasswordConfirm);

	form_data = {
			inputMemberPassword : encryptMemberPassword,
			inputMemberPasswordConfirm : encryptMemberPasswordConfirm,
			inputMemberEmail : encryptMemberEmail,
	};


	$.ajax({
		type : "POST",
		url : action,
		data : form_data,
		dataType : "json",
		success: function(response){

			if(response.outputResult == "1"){
				alert("비밀번호가 재설정되었습니다. 다시 로그인해주시기 바랍니다.");
				location.href = "/";
			}else {
				alert("알 수 없는 문제가 발생하였습니다. \n 문제가 지속된다면 전 혼이 나겠네요. \n 고객센터로 조용히 문의바랍니다.");
			}
		}	
	});

}

