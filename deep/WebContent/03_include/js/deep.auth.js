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
		var email = $("inputMemberEmail").val();
		
		if(!validateEmail(email)){  //valid email check
			$("div.msgRow.malfunMsg").text("올바른  이메일이 아닙니다");
			alert("asdfasdf");
			return false;
		}
		break;
		
	case 2: //pw check
		var password1 = $("inputMemberPasswordPre").val();
		var password2 = $("inputMemberPassword").val();
		
		if(password1.length < 6){
			alret("패스워드는 6글자 이상으로 해주세요");
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
		
	default :
			return false;
	}
	
	return true;
}


Auth.joinCheck = function(mode){
	
	var check;
	var paramtype;
	var param;
	
	alert("1");
	
	if(mode == 1){ //eamil check
		paramType = "Email";
		param = checkWhitespace($("#inputMemberEmail").val());
		param = param.toLowerCase();
		$("#inputMemberEmail").val(param);
		
		if(!Auth.checkValue(1)){
			alert("임일병신");

			return false;
		}
	}else if(mode == 2){//password check
		
		if(!Auth.checkValue(2)){
			return false;
		}else {
			return true;
		}
	}else if(mode == 3){//name check
		if(!Auth.checkValue(3)){
			return false;
		}else{
			return true;
		}
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
			inputParamType : paramType,
			inputEncryptParam : encryptParam
	};
	
	$.ajax({
		type:"POST",
		url: "/member?action=checkMember",
		data:form_data,
		dataType: "text",
		async : false,
		success: function(response){
			if(response == "-3"){
				//가입 불가능
				if(mode == 1){
					alert("이미 가입된 이메일 주소입니다.");
					$("div.msgRow.malfunMsg").text("이미 가입된 이메일입니다.");
				
					check = false;
				}else if(mode == 3){
					alert("이미 사용중인 닉네임입니다.");
					$("div.msgRow.malfunMsg").text("이미 사용중인 이메일입니다.");
					
					check = false;
				}
				
			}else if(response == 1){
				alert("가입가능")
				
				check = true;
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
	
	action = "/member?action = joinMember";
	
	memberEmail = protectXSS($("inputMemberEmail").val().trim());
	memberPassword = protectXSS($("inputMemberPassword").val().trim());
	memberName = protectXSS($("inputMemberName").val().trim());
	
	
	//암호화
	var encryptMemberEmail = rsa.encrypt(memberEmail);
	var encryptMemberPassword = rsa.encrypt(memberPassword);
	var encryptMemberName = rsa.encrypt(memberName);
	
	form_data = {
			inputMemberName : encryptMemberName,
			inputMemberPassword : encryptMemberPassword,
			inputMemberEamil : encryptMemberEmail
	};
	
	
	$.ajax({
		type : "POST",
		url : action,
		data : form_data,
		dataType : "text",
		success: function(response){
			
			if(response == "1"){
				alert("회원가입 완료");
				location.href = "/joinPermit";
			}else if(response == "-3" ||response == "-4"){
				$("div.msgRow.malfunMsg").text("이미 가입된 이메일 또는 사용중인 닉네임입니다.");
			}else {
				alert("알 수 없는 문제가 발생하였습니다. \n 문제가 지속된다면 전 혼이 나겠네요. \n 고객센터로 조용히 문의바랍니다.");
			}
		}	
	});
	
}