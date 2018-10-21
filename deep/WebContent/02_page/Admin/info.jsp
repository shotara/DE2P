<%@ page import="com.rancre.config.GlobalValue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />

</head>
<script type="text/javascript">
	function addInfo(no, mcn, category) {
		
		var action, form_data;
		
		action = "/admin?action=addChannelInfo";

		//encryption

		form_data = {
				inputChannelNo : no,
				inputMcnNo : mcn,
				inputCategoryNo : category
		};
		
		$.ajax({
			type:"POST",
			url : action,
			data : form_data,
			dataType : "json",
			async : false,
			success :  function(response){
				if(response.outputResult == "1"){
					alert("등록성공")
					location.href = "/";
				}else{
					alert("실패");
				}
			}, error(xhr, status, error){
				alert("알 수 없는 문제가 발생하였습니다. \n 문제가 지속된다면 전 혼이 나겠네요. \n 고객센터로 조용히 문의바랍니다.");
			}
		});
		
	}
</script>

<body>

<section class="rancre-admin-info">
	<div class="content">
		<h1>채널 정보 등록</h1>
		<div class="info-channel-title">
			<div class="left">채널명</div>
			<div class="right">${result.outputChannelTitle}</div>
		</div>
		<div class="info-channel-url">
			<div class="left">채널아이디</div>
			<div class="right">${result.outputChannelUrl}</div>
		</div>
		<div class="info-channel-mcn">
			<div class="left">소속</div>
			<input type="text" id="mcnNo"/>
		</div>
		<div class="info-channel-category">
			<select name="category" id="category">
			    <option value="1">카테고리 선택</option>
			    <option value="2">뷰티</option>
			    <option value="3">먹방</option>
			    <option value="4">BJ</option>
			</select>
		</div>
	</div>
	
	<div class="btn">
		<button onclick="addInfo(${result.outputChannelNo},$('#mcnNo').val(),$('#category').val())">정보입력</button>
		<button>취소</button>
	</div>
</section>


</body>
</html>