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
	function addInfo(no, mcn, category, category2, category3, region, curatorNo, curator) {
		
		var action, form_data;
		
		action = "/admin?action=addChannelInfo";

		//encryption

		form_data = {
				inputChannelNo : no,
				inputMcnNo : mcn,
				inputCategoryNo : category,
				inputCategoryNo2 : category2,
				inputCategoryNo3 : category3,
				inputChannelRegion : region,
				inputCuratorNo : curatorNo,
				inputCuratorContent : curator
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
			<div class="right"><a onclick="window.open('https://www.youtube.com${result.outputChannelUrl}')">${result.outputChannelUrl}</a></div>
		</div>
		<div class="info-channel-mcn">
			<div class="left">소속</div>
			<input type="text" id="mcnNo"/>
		</div>
		<div class="info-channel-category">
			<select name="category" id="category">
			    <option value="1">카테고리 선택</option>
			    <option value="2">스튜디오/엔터</option>
			    <option value="3">예능/토크</option>
			    <option value="4">미사용</option>
  			    <option value="5">노래, 댄스</option>
			    <option value="6">테크/교육</option>
			    <option value="7">시사/이슈</option>
			    <option value="8">뷰티</option>
			    <option value="9">여행/일상</option>
   			    <option value="10">게임</option>
			    <option value="11">스포츠</option>
			    <option value="12">먹방/쿡방</option>
			    <option value="13">키즈</option>
   			    <option value="14">반려동물</option>
			    <option value="15">ASMR</option>
			    <option value="16">취미/예술</option>
			    <option value="17">리뷰어</option>
			    <option value="18">스트리머</option>
			    <option value="19">기타</option>
			</select>
			<select name="category2" id="category2">
			    <option value="1">카테고리 선택</option>
			    <option value="2">스튜디오/엔터</option>
			    <option value="3">예능/토크</option>
			    <option value="4">미사용</option>
  			    <option value="5">노래, 댄스</option>
			    <option value="6">테크/교육</option>
			    <option value="7">시사/이슈</option>
			    <option value="8">뷰티</option>
			    <option value="9">여행/일상</option>
   			    <option value="10">게임</option>
			    <option value="11">스포츠</option>
			    <option value="12">먹방/쿡방</option>
			    <option value="13">키즈</option>
   			    <option value="14">반려동물</option>
			    <option value="15">ASMR</option>
			    <option value="16">취미/예술</option>
			    <option value="17">리뷰어</option>
			    <option value="18">스트리머</option>
			    <option value="19">기타</option>
			</select>
			<select name="category3" id="category3">
			    <option value="1">카테고리 선택</option>
			    <option value="2">스튜디오/엔터</option>
			    <option value="3">예능/토크</option>
			    <option value="4">미사용</option>
  			    <option value="5">노래, 댄스</option>
			    <option value="6">테크/교육</option>
			    <option value="7">시사/이슈</option>
			    <option value="8">뷰티</option>
			    <option value="9">여행/일상</option>
   			    <option value="10">게임</option>
			    <option value="11">스포츠</option>
			    <option value="12">먹방/쿡방</option>
			    <option value="13">키즈</option>
   			    <option value="14">반려동물</option>
			    <option value="15">ASMR</option>
			    <option value="16">취미/예술</option>
			    <option value="17">리뷰어</option>
			    <option value="18">스트리머</option>
			    <option value="19">기타</option>
			</select>
		</div>
		<div class="info-channel-region">
			<div class="left">국가</div>
			<input type="text" id="region" value="${result.outputChannelRegion}"/>
		</div>
			<div class="info-channel-curator">
			<div class="left">큐레이션</div>
			<input type="hidden" id="curatorNo" value="${result.outputChannelCuratorNo}"/>
			현재 큐레이션 : ${result.outputChannelCurator}<br/>
			수정할 큐레이션 <input type="text" id="curator"/>
			
		</div>
	</div>
	
	<div class="btn">
		<button onclick="addInfo(${result.outputChannelNo},$('#mcnNo').val(),$('#category').val(),$('#category2').val(),$('#category3').val(),$('#region').val(), $('#curatorNo').val(), $('#curator').val())">정보입력</button>
		<button>취소</button>
	</div>
	<div class="btn">
		<button onclick="location.href='/admin?action=getChannelList&page=${result.pageNo}&size=30'">목록</button>
	</div>
</section>

<script>
	$(document).ready(function() { 
		
		$("#category").val(${result.outputCategoryNo}).prop("selected", true);
		$("#category2").val(${result.outputCategoryNo2}).prop("selected", true);
		$("#category3").val(${result.outputCategoryNo3}).prop("selected", true);

	});
</script>
</body>
</html>