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
				<div class="w-auto ml-auto">
					<h3>모든 채널</h3>
				</div>
				<div>
					<span>랭크리에서 수집한 전체 채널입니다.</span>
				</div>
				<div class="pt-4"></div>

				<!-- 랭킹페이지 서브 네비 영역  -->

				<div class="subNav-tabs w-auto ml-auto">
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link active" data-tab="studio" href="#studio" onclick="initList(1)">스튜디오</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="entertain" href="#entertain" onclick="initList(2)">엔터</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="travel" href="#travel" onclick="initList(3)">여행</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="singdance" href="#singdance" onclick="initList(4)">노래
							댄스</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="tech" href="#tech" onclick="initList(5)">테크</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="education" href="#education" onclick="initList(6)">교육(어학)</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="beauty" href="#beauty" onclick="initList(7)">뷰티</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="daylife" href="#daylife" onclick="initList(8)">일상</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="game" href="#game" onclick="initList(9)">게임</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="sports" href="#sports" onclick="initList(10)">스포츠</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="food" href="#food" onclick="initList(11)">먹방</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="kids" href="#kids" onclick="initList(12)">키즈</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="pet" href="#pet" onclick="initList(13)">반려동물</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="exercise" href="#exercise" onclick="initList(14)">운동</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="habbit" href="#habbit" onclick="initList(15)">취미</a>
					</div>
				</div>

				<!-- 랭킹페이지 서브네비 끝  -->

				<div class="pt-4"></div>

				<!-- 로우 시작 -->

				<div class="topRow">
					<div class="rankRowImg"></div>
					<div class="rankRow">채널명</div>
					<div class="rankRow">카테고리</div>
					<div class="rankRow">총구독자수</div>
					<div class="rankRow">총조회수</div>
					<div class="rankRow2">영상수</div>
					<div class="rankRowBtn"></div>
				</div>
				<hr>

				<!-- 로우 끝  -->

				<!-- 스튜디오 영역 시작 -->

				<div class="subNav-content active" id="studio">

					<div class="chnContents">
						<div class="pt-2"></div>
					
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(1)">더보기</button>
					</div>
				</div>
				<!--  스튜디오 콘텐츠 영역 끝  -->


				<!-- 엔터영역 시작  -->


				<div class="subNav-content" id="entertain">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>
					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(2)">더보기</button>
					</div>

				</div>


				<!-- 엔터영역 끝  -->



				<!-- 여행영역 시작  -->


				<div class="subNav-content" id="travel">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(3)">더보기</button>
					</div>

				</div>


				<!-- 여행영역 끝  -->



				<!-- 노래댄스 영역 시작  -->


				<div class="subNav-content" id="singdance">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>
					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(4)">더보기</button>
					</div>

				</div>



				<!-- 노래댄스 끝  -->



				<!-- 테크 영역 시작  -->


				<div class="subNav-content" id="tech">
					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(5)">더보기</button>
					</div>

				</div>

				<!-- 테크 영역 끝  -->



				<!-- 교육(어학) 시작  -->


				<div class="subNav-content" id="education">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(6)">더보기</button>
					</div>

				</div>

				<!-- 교육(어학) 끝   -->


				<!-- 뷰티  시작  -->


				<div class="subNav-content" id="beauty">
					<div class="chnContents">

						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(7)">더보기</button>
					</div>

				</div>

				<!-- 뷰티  끝   -->

				<!-- 일상  시작  -->


				<div class="subNav-content" id="daylife">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(8)">더보기</button>
					</div>
				</div>

				<!-- 일상  끝   -->

				<!-- 게임  시작  -->


				<div class="subNav-content" id="game">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(9)">더보기</button>
					</div>

				</div>

				<!-- 게임  끝   -->

				<!-- 스포츠  시작  -->


				<div class="subNav-content" id="sports">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(10)">더보기</button>
					</div>

				</div>

				<!-- 스포츠  끝   -->

				<!-- 먹방   시작  -->


				<div class="subNav-content" id="food">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(11)">더보기</button>
					</div>

				</div>

				<!-- 먹방   끝   -->

				<!-- 키즈   시작  -->


				<div class="subNav-content" id="kids">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>
					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(12)">더보기</button>
					</div>


				</div>

				<!-- 키즈   끝   -->

				<!-- 반려동물   시작  -->


				<div class="subNav-content" id="pet">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(13)">더보기</button>
					</div>

				</div>

				<!-- 반려동물   끝   -->

				<!-- 운동   시작  -->


				<div class="subNav-content" id="exercise">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(14)">더보기</button>
					</div>

				</div>

				<!-- 운동   끝   -->

				<!-- 취미  시작  -->


				<div class="subNav-content" id="habbit">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(15)">더보기</button>
					</div>

				</div>

				<!-- 취미  끝   -->

			</div>
		</div>
	</div>

	</section>

	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />

</body>
<script>
	var categoryArray = [0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

	function initList(i) {
		
		var startNo = categoryArray[i];
		if(startNo != 0) return; 
		Common.addList(2,startNo,i);
		categoryArray[i] = categoryArray[i] + 20;
	}
	
	function addList(i) {
			var startNo = categoryArray[i];
			Common.addList(2,startNo,i);
			categoryArray[i] = categoryArray[i] + 20;
			if(categoryArray[i] >= 890) 
				switch(i) {
				case 1:
					$("#studio .btnListGo").hide();
					break;
				case 2:
					$("#entertain .btnListGo").hide();
					break;
				case 3:
					$("#travel .btnListGo").hide();
					break;
				case 4:
					$("#singdance .btnListGo").hide();
					break;
				case 5:
					$("#tech .btnListGo").hide();
					break;
				case 6:
					$("#education .btnListGo").hide();
					break;
				case 7:
					$("#beauty .btnListGo").hide();
					break;
				case 8:
					$("#daylife .btnListGo").hide();
					break;
				case 9:
					$("#game .btnListGo").hide();
					break;
				case 10:
					$("#sports .btnListGo").hide();
					break;
				case 11:
					$("#food .btnListGo").hide();
					break;
				case 12:
					$("#kids .btnListGo").hide();
					break;
				case 13:
					$("#pet .btnListGo").hide();
					break;
				case 14:
					$("#exercise .btnListGo").hide();
					break;
				case 15:
					$("#habbit .btnListGo").hide();
					break;
				}
	}
	
	$(document).ready(function() { 
		
		var url="/main?action=getRankingList";  
	    var params = {
	    	startNo : 0,
	    	mode : 2,
	    	categoryNo : 1,
	    };
	    
	    $.ajax({      
	        type:"POST",  
	        url:url,      
	        data:params,  
	        dataType:'json',
	        success:function(args){   
	        	for(var i=0; i<args.rankingList.length; i++) {
					$('#studio .chnContents').append(`
							<div id="chnContent" class="w-auto ml-auto">
							<div class="rankRowImg">
								<img id="chnListThumbNail"
									style="width: 48px; border-radius: 48px;"
									src="`+args.rankingList[i].outputChannelThumbnail +`">
							</div>
							<div class="rankRow">`+args.rankingList[i].outputChannelTitle+`</div>
							<div class="rankRow">#`+args.rankingList[i].outputCategoryNo+`</div>
							<div class="rankRow">`+args.rankingList[i].outputChannelFollowers+`</div>
							<div class="rankRow">`+args.rankingList[i].outputChannelViews+`</div>
							<div class="rankRow2">`+args.rankingList[i].outputChannelVideoCount+`</div>
							<div class="rankRowBtn">
								<button class="btnChnGo">
									<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
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