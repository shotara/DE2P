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
		
		if(!validateEmail(email)){  //valid email check
			$("div.msgRow.malfunMsg").text("올바른  이메일이 아닙니다");
			return false;
		}
		break;
		
	case 2: //pw check - join
		var password1 = $("#inputMemberPasswordPre").val();
		var password2 = $("#inputMemberPassword").val();
		
		if(password1.length < 6){
			alert("패스워드는 6글자 이상으로 해주세요");
			$("div.msgRow.malfunMsg").text("비밀번호는 6글자 이상 가능합니다");
			return false;
		}
		
		if(password1 != password2){
			
			if(passwoord2 == ""){
					alert("패스워드를 확인해주세요.");
					$("div.msgRow.malfunMsg").text("비밀번호를 입력해주세요");
					return false;
			}else{
				alert("패스워드가 일치하지 않습니다.");
				$("div.msgRow.malfunMsg").text("비밀번호가 일치하지 않습니다.");
				return false;
			}		
			return false;
		}
		
		break;
		
	case 3://check Name;
		var name = $("#inputMemberName").val();
		//less than 2 letters 
		if(name.length < 2 || name.length > 9){
			alert("이름을 확인해주세요");
			$("div.msgRow.malfunMsg").text("닉네임은 2글자 이상 8글자 이하입니다");
			return false;
		}
		
		// 이름이 한글, 영문, 숫자가 아닌 경우
		var chk = /[0-9]|[a-z]|[A-Z]|[가-힣]/
		for(i=0; i<name.length; i++) {
			if(!chk.test(name.charAt(i))) {
				alert("이름을 확인해주세요.");
				$("div.msgRow.malfunMsg").text("이름은 한글, 영문, 숫자만 사용할 수 있습니다.");
				return false;
			}
		}
		break;
		
	case 4:
		var password = $("#inputMemberPassword").val();
		
		//less than 6 letters
		if(password.length < 6){
			alert("비밀번호는 6글자 이상이어야합니다.");
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
		}else {
			return true;
		}
	} else if(mode == 3){//name check
		param = $("#inputMemberName").val();		
		
		if(!Auth.checkValue(3))
			return false;
	}
	
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

	var encryptParam = rsa.encrypt(param);

	var form_data = {
			mode : mode,
			inputMemberParam : encryptParam
	};
	
	$.ajax({
		type:"POST",
		url: "/member?action=checkMember",
		data:form_data,
		dataType: "json",
		async : false,
		success: function(response) {
			
			if(response.outputResult == "1") {
				check = true;
			} else if(response.outputResult == "-3") {
				alert("이미 사용중인 메일/이름입니다.");
				
				check = false;
			} else {
				alert(response.outputResult);
				alert("알수없는 문제가 발생했습니다.");
				check = false;
			}
		}
	});
	
	return check;
		
}

Auth.join = function(){
	
	if(!Auth.joinCheck(1)){
		return false;
	}// email check
	if(!Auth.joinCheck(2)){
		return false;
	} // password check
	if(!Auth.joinCheck(3)){
		return false;
	}//name check
	//deep.waiting(true);
	
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
	
	var memberEmail, memberPassword, memberName;
	
	action = "/member?action=joinMember";
	
	memberEmail = protectXSS($("#inputMemberEmail").val().trim());
	memberPassword = protectXSS($("#inputMemberPassword").val().trim());
	memberPasswordConfirm = protectXSS($("#inputMemberPasswordPre").val().trim());
	memberName = protectXSS($("#inputMemberName").val().trim());

	//암호화
	var encryptMemberEmail = rsa.encrypt(memberEmail);
	var encryptMemberPassword = rsa.encrypt(memberPassword);
	var encryptMemberPasswordConfirm = rsa.encrypt(memberPasswordConfirm);
	var encryptMemberName = rsa.encrypt(memberName);
	
	form_data = {
			inputMemberName : encryptMemberName,
			inputMemberPassword : encryptMemberPassword,
			inputMemberPasswordConfirm : encryptMemberPasswordConfirm,
			inputMemberEmail : encryptMemberEmail
	};
	
	
	$.ajax({
		type : "POST",
		url : action,
		data : form_data,
		dataType : "json",
		success: function(response){
			
			if(response.outputResult == "1"){
				alert("회원가입 완료");
				location.href = "/joinPermit";
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
	
	//pw check more than 6 letters
	
	if(!Auth.checkValue(4)){
		return false;
	}
	
	var publicKeyModulus = "";
	var publicKeyExponent = "";
	var action = "/main?action=getRSAPublicKey";
	
	$ajax({
		type : "POST",
		url : action,
		dataType : "json",
		aysnc : false,
		success : function(response){
			publicKeyModulus = response.deepPublicKeyModulus;
			publicKeyExponent = response.deepPublicKeyExponent;
		}, error : function(xhr, status, error){
			alert(error);
		}
		
	});
	
	var rsa = new RSAKey();
	rsa.setPublic(publicKeyModulus, publicKeyExponent);
	
	var memberEmail, memberPassword;
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
			}else{
				alert("등록되지 않은 이메일이거나, \n 이메일 또는 비밀번호가 잘못되었습니다.");
			}
		}, error(xhr, status, error){
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
		dataType : "text",
		async : false,
		success : function(response){
			if(resonese.outputResult == "1"){
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
		dataType : "text",
		async : false,
		success : function(response){
			if(response.outputResult == "1"){
				alert("정상적으로 로그아웃 되었습니다.");
				location.reload(true);
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