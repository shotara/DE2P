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
	<div class="container">
		<div class="row">
			<div class="col v20">

				<!-- 채널 100 페이지 상단 설명영역 -->
				<div class="w-auto ml-auto">
					<h3>채널 100</h3>
				</div>
				<div>
					<span>채널 종합 순위입니다.</span>
				</div>

				<!--컬럼 구분 영 -->

				<div class="w-auto pt-4"></div>

				<div class="rankMainRowCnt">순위</div>
				<div class="rankMainRowImg"></div>
				<div class="ranc-Main-Row">채널명</div>
				<div class="ranc-Main-Row2">카테고리</div>
				<div class="ranc-Main-Row">총구독자수</div>
				<div class="ranc-Main-Row">총조회수</div>
				<div class="rankMainRowBtn"></div>

				<hr>

				<div class="pt-2"></div>

				<!-- 채널별 스탯 영역1 -->
				<div class="chnContents">
				</div>
				<div class="pt-4"></div>
				
				<div class="rankBottom txt-center">
					<button class="btnListGo" onclick="addList()">더보기</button>
					<input type="hidden" id="startNo">
				</div>

			</div>
		</div>

	</div>

	</section>

	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />
</body>
<script>
	
	function addList() {
			
			var startNo = $("#startNo").val();
	
			Common.addList(1,startNo,0);
		    
			$("#startNo").val(startNo*1+10);
		    if(startNo>=90) 
				$(".btnListGo").hide();
	}
	
	$(document).ready(function() { 
		
		$("#startNo").val(10);
		var url="/main?action=getRankingList";  
	    var params = {
	    	startNo : 0,
	    	mode : 1
	    };
	    
	    $.ajax({      
	        type:"POST",  
	        url:url,      
	        data:params,  
	        dataType:'json',
	        success:function(args){   
	        	for(var i=0; i<args.rankingList.length; i++) {
					$('.chnContents').append(`
							<div id="chnContent" class="w-auto ml-auto">
							<div class="rankMainRowCnt">
								<div class="d-inline-block rankMainCnt">`+args.rankingList[i].outputRankTopNo + `위</div>
								<div class="d-inline-block rankMainDif">-</div>
							</div>
							<div class="rankMainRowImg">
								<img id="chnListThumbNail"
									style="width: 48px; border-radius: 48px;"
									src="`+args.rankingList[i].outputChannelThumbnail +`">
							</div>
							<div class="ranc-Main-Row">`+args.rankingList[i].outputChannelTitle+`</div>
							<div class="ranc-Main-Row2">`+args.rankingList[i].outputCategoryNo+`</div>
							<div class="ranc-Main-Row">`+args.rankingList[i].outputChannelFollowers+`</div>
							<div class="ranc-Main-Row">`+args.rankingList[i].outputChannelViews+`</div>
							<div class="rankMainRowBtn">
								<button class="btnChnGo">
								<a class="chnDtlGo" href="/channel?action=getChannelDetail&inputChannelNo=`+args.rankingList[i].outputChannelNo+`">채널정보
										보기</a>
								</button>
							</div>
						</div>
						<hr
							style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					</div>
							`);
					
	        	}

	        },   
	        error:function(e){  
	            alert(e.responseText);  
	        }  
	    });  
		
	});
</script>
</html>