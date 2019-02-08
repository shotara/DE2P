<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />

</head>
<body>

	<jsp:include page="/02_page/commonNav.jsp" flush="false" />

	<section class="section" data-type="feed">
	<div class="container pTop2">
		<div class="row">
			<div class="col">
				<div class="w-auto ml-auto">
					<h3>새로운 채널</h3>
				</div>
				<div>
					<span>랭크리에서 새롭게 수집한 채널입니다.</span>
				</div>


				<div class="pt-4"></div>

				<!-- 로우 시작 -->

				<div class="topRow">
					<div class="rankRowImg"></div>
					<div class="ranc-Row">채널명</div>
					<div class="ranc-Row2">카테고리</div>
					<div class="ranc-Row">총구독자수</div>
					<div class="ranc-Row">총조회수</div>
					<div class="rankRowBtn"></div>
				</div>
				<hr>

				<!-- 로우 끝  -->


				<div class="chnContents">

					<div class="pt-2"></div>

				</div>

				<div class="pt-4"></div>

				<div class="rankBottom txt-center">
					<button class="btnListGo" onclick="addList()">더보기</button>
				</div>
			</div>
		</div>
	</div>
	</section>

	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />

</body>
<script>
	var startNo = 20;
	
	function addList() {
				
			Common.addList(3,startNo,0);
		    
			startNo = startNo + 20;

	}
	
	$(document).ready(function() { 
		
		var url="/main?action=getRankingList";  
	    var params = {
	    	startNo : 0,
	    	mode : 3
	    };
	    
	    $.ajax({      
	        type:"POST",  
	        url:url,      
	        data:params,  
	        dataType:'json',
	        success:function(args){   
	        	for(var i=0; i<args.rankingList.length; i++) {
					$('.chnContents').append(
							"							<div id='chnContent' class='w-auto ml-auto'>\r\n" + 
							"							<div class='rankRowImg'>\r\n" + 
							"								<img id='chnListThumbNail'\r\n" + 
							"									style='width: 48px; border-radius: 48px;'\r\n" + 
							"									src='"+args.rankingList[i].outputChannelThumbnail +"'>\r\n" + 
							"							</div>\r\n" + 
							"							<div class='ranc-Row'>"+args.rankingList[i].outputChannelTitle+"</div>\r\n" + 
							"							<div class='ranc-Row2'>"+args.rankingList[i].outputCategoryNo+"</div>\r\n" + 
							"							<div class='ranc-Row'>"+args.rankingList[i].outputChannelFollowers+"</div>\r\n" + 
							"							<div class='ranc-Row'>"+args.rankingList[i].outputChannelViews+"</div>\r\n" + 
							"							<div class='rankRowBtn'>\r\n" + 
							"								<button class='btnChnGo'>\r\n" + 
							"									<a class='chnDtlGo' href='/channel?action=getChannelDetail&inputChannelNo="+args.rankingList[i].outputChannelNo+"'>채널정보\r\n" + 
							"										보기</a>\r\n" + 
							"								</button>\r\n" + 
							"							</div>\r\n" + 
							"						</div>\r\n" + 
							"						<hr\r\n" + 
							"							style='margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;'>\r\n" + 
							"					</div>"
							);
					
	        	}

	        },   
	        error:function(e){  
	            alert(e.responseText);  
	        }  
	    });  
		
	});
</script>
</html>