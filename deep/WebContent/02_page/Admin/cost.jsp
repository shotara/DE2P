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
	function addCost(no, price, type) {
		
		var action, form_data;
		
		action = "/admin?action=addChannelCost";

		//encryption

		form_data = {
				inputChannelNo : no,
				inputChannelCostPrice : price,
				inputChannelAdType : type
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
			<div class="right"><a href="/channel?action=getChannelDetail&inputChannelNo=${result.outputChannelNo}"  target="_blank">${result.outputChannelTitle}</a></div>
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
	<select class="ipt-Select-CommercialType" id="commercial-Type" name="inputChannelAdType" >
		<option value="0" selected >없음</option>
		<option value="2">영상 콘텐츠</option>
		<option value="3">배너 광고</option>
		<option value="4">물품협찬</option>
		<option value="5">섭외</option>
		<option value="6">True View</option>
		<option value="1">기타</option>
	</select>
	</div>
	
	<div class="btn">
		<button onclick="addCost(${result.outputChannelNo},$('#costPrice').val(),$('#commercial-Type').val())">단가입력</button>
		<button>취소</button>
	</div>
</section>
</body>
</html>