<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="/03_include/js/jquery-2.1.4.min.js"></script>

<script>
	var Member = {}
	
	$(function() {
	
		Member.login = function() {
			var inputMemberEmail = $("input[name='inputMemberEmail']").val();
			var inputMemberPassword = $("input[name='inputMemberPassword']").val();
	
			var action = "/member?action=loginMember";
			
			form_data = {
					inputMemberEmail : inputMemberEmail,
					inputMemberPassword : inputMemberPassword
				};
			
		    $.ajax({
		        url: action,
		        type: "POST",
		        data: form_data,
		        dataType: "json",
		        success: function(response) {
		        	alert(inputMemberEmail);
		        	if(response.outputResult == 1) {
						alert("로그인");
						location.href = "/";
		        	}
				}, error: function(xhr,status,error) {
					alert(error);
				}
		    });
		}
	});	
	

</script>
</head>
<body>
<h2>Hello World!</h2>
<h3>I'm staying in San Jose, CA now! </h3>

	<div class="login">
		<input type="text" name="inputMemberEmail" />
		<input type="password" name="inputMemberPassword" />
		<input type="submit"  onclick="Member.login()"/>
	</div>

	<form action="member?action=changeMemberImg" method="post" enctype="multipart/form-data">
		<input type="file" name="inputMemberImage">
		<input type="submit" value="changeProfile" />
	</form>
		<br/>
	<form action="member?action=resetMemberProfileImg" method="post">
		<input type="submit" value="resetProfileImg" />
	</form>
</body>
</html>
