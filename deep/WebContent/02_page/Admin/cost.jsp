<%@ page import="com.rancre.config.GlobalValue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />
</head>
<body>
<script type="text/javascript">
	function addCost(no, price, category) {
		
		var action, form_data;
		
		action = "/admin?action=addChannelCost";

		//encryption

		form_data = {
				inputChannelNo : no,
				inputChannelCostPrice : price,
				inputChannelCostCategory : category
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
					location.href = "/admin?action=getChannelList&page=${result.pageNo}&size=30";
				}else{
					alert("실패");
				}
			}, error(xhr, status, error){
				alert("알 수 없는 문제가 발생하였습니다. \n 문제가 지속된다면 전 혼이 나겠네요. \n 고객센터로 조용히 문의바랍니다.");
			}
		});
		
	}
</script>

<section class="rancre-admin-cost">
	<div class="content">
		<h1>채널 단가 등록</h1>
		<div class="cost-channel-title">
			<div class="left">채널명</div>
			<div class="right">${result.outputChannelTitle}</div>
		</div>
		<div class="cost-channel-url">
			<div class="left">채널아이디</div>
			<div class="right">${result.outputChannelUrl}</div>
		</div>
		<div class="cost-channel-price">
			<div class="left">광고 단가</div>
			<input type="text" id="costPrice"/>
			<div class="right">원</div>
		</div>
		<div class="cost-channel-category">
			<div class="left">광고 종류</div>
			<input type="text" id="costCategory"/>
		</div>
	</div>
	
	<div class="btn">
		<button onclick="addCost(${result.outputChannelNo},$('#costPrice').val(),$('#costCategory').val())">단가입력</button>
		<button>취소</button>
	</div>
</section>
</body>
</html>