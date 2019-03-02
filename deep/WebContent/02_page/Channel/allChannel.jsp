<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>랭크리 : 모든 채널</title>

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />
<script>
	var categoryArray = [ 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];

	function initList(i) {
		
		event.preventDefault ? event.preventDefault() : (event.returnValue = false);

		var startNo = categoryArray[i];
		if (startNo != 0)
			return;
		Common.addList(2, startNo, i);
		categoryArray[i] = categoryArray[i] + 20;

		

	}

	function addList2(i) {
		var startNo = categoryArray[i];
		Common.addList(2, startNo, i);
		categoryArray[i] = categoryArray[i] + 20;
		if (categoryArray[i] >= 890)
			switch (i) {
			case 2:
				$("#studio .btnListGo").hide();
				break;
			case 3:
				$("#entertain .btnListGo").hide();
				break;
			case 4:
				$("#travel .btnListGo").hide();
				break;
			case 5:
				$("#singdance .btnListGo").hide();
				break;
			case 6:
				$("#tech .btnListGo").hide();
				break;
			case 7:
				$("#education .btnListGo").hide();
				break;
			case 8:
				$("#beauty .btnListGo").hide();
				break;
			case 9:
				$("#daylife .btnListGo").hide();
				break;
			case 10:
				$("#game .btnListGo").hide();
				break;
			case 11:
				$("#sports .btnListGo").hide();
				break;
			case 12:
				$("#food .btnListGo").hide();
				break;
			case 13:
				$("#kids .btnListGo").hide();
				break;
			case 14:
				$("#pet .btnListGo").hide();
				break;
			case 15:
				$("#asmr .btnListGo").hide();
				break;
			case 16:
				$("#habbit .btnListGo").hide();
				break;
			}
	}

	$(document)
			.ready(
					function() {

						var url = "/main?action=getRankingList";
						var params = {
							startNo : 0,
							mode : 2,
							categoryNo : 2,
						};

						$
								.ajax({
									type : "POST",
									url : url,
									data : params,
									dataType : 'json',
									success : function(args) {
										for (var i = 0; i < args.rankingList.length; i++) {
											$('#studio .chnContents')
													.append(
															"<div id='chnContent' class='w-auto ml-auto'>\r\n"
																	+ "							<div class='rankRowImg'>\r\n"
																	+ "								<img id='chnListThumbNail'\r\n" + 
							"									style='width: 48px; border-radius: 48px;'\r\n" + 
							"									src='"+args.rankingList[i].outputChannelThumbnail +"'>\r\n"
																	+ "							</div>\r\n"
																	+ "							<div class='ranc-Row3'>"
																	+ args.rankingList[i].outputChannelTitle
																	+ "</div>\r\n"
																	+ "							<div class='ranc-Row2'>"
																	+ args.rankingList[i].outputCategoryNo
																	+ "</div>\r\n"
																	+ "							<div class='ranc-Row'>"
																	+ args.rankingList[i].outputChannelFollowers
																	+ "</div>\r\n"
																	+ "							<div class='ranc-Row'>"
																	+ args.rankingList[i].outputChannelViews
																	+ "</div>\r\n"
																	+ "							<div class='rankRowBtn'>\r\n"
																	+ "								<a class='chnDtlGo' href='/channel?action=getChannelDetail&inputChannelNo="
																	+ args.rankingList[i].outputChannelNo + "'>\r\n"
																	+ "								<button class='btnChnGo'>\r\n"
																	+ "채널정보\r\n"
																	+ "										보기</button>\r\n"
																	+ "								</a>\r\n"
																	+ "							</div>\r\n"
																	+ "						</div>\r\n"
																	+ "						<hr\r\n" + 
							"							style='margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;'>\r\n"
																	+ "					</div>");
										}

										if (args.rankingList.length < 20)
											$("#studio .btnListGo").hide();
									},
									error : function(e) {
										alert(e.responseText);
									}
								});

					});
</script>
</head>
<body>

	<jsp:include page="/02_page/commonNav.jsp" flush="false" />


	<div class="container pTop2 all-channel">
		<div class="row">
			<div class="col">
				<div class="w-auto ml-auto">
					<h3>모든 채널</h3>
				</div>
				<div>
					<span>랭크리에서 수집한 전체 채널입니다.</span>
				</div>
				<div class="pt-4"></div>

				<!-- 랭킹페이지 서브 네비 영역  -->

				<div class="subNav-tabs w-auto ml-auto" id="subNav-Tabs">
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link active" data-tab="studio" href="#studio"
							onclick="initList(2)">스튜디오</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="entertain" href="#entertain"
							onclick="initList(3)">엔터</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="travel" href="#travel"
							onclick="initList(4)">여행</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="singdance" href="#singdance"
							onclick="initList(5)">노래 댄스</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="tech" href="#tech"
							onclick="initList(6)">테크</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="education" href="#education"
							onclick="initList(7)">교육(어학)</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="beauty" href="#beauty"
							onclick="initList(8)">뷰티</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="daylife" href="#daylife"
							onclick="initList(9)">일상</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="game" href="#game"
							onclick="initList(10)">게임</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="sports" href="#sports"
							onclick="initList(11)">운동</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="food" href="#food"
							onclick="initList(12)">먹방</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="kids" href="#kids"
							onclick="initList(13)">키즈</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="pet" href="#pet"
							onclick="initList(14)">반려동물</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="asmr" href="#asmr"
							onclick="initList(15)">ASMR</a>
					</div>
					<div
						class="subNav-tab all-channel-tab w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="habbit" href="#habbit"
							onclick="initList(16)">취미</a>
					</div>
				</div>

				<!-- 랭킹페이지 서브네비 끝  -->

				<div class="pt-4"></div>

				<!-- 로우 시작 -->

				<div class="topRow">
					<div class="rankRowImg"></div>
					<div class="ranc-Row3">채널명</div>
					<div class="ranc-Row2">카테고리</div>
					<div class="ranc-Row">총구독자수</div>
					<div class="ranc-Row">총조회수</div>
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
						<button class="btnListGo" onclick="addList2(2)">더보기</button>
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
						<button class="btnListGo" onclick="addList2(3)">더보기</button>
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
						<button class="btnListGo" onclick="addList2(4)">더보기</button>
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
						<button class="btnListGo" onclick="addList2(5);">더보기</button>
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
						<button class="btnListGo" onclick="addList2(6)">더보기</button>
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
						<button class="btnListGo" onclick="addList2(7)">더보기</button>
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
						<button class="btnListGo" onclick="addList2(8)">더보기</button>
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
						<button class="btnListGo" onclick="addList2(9)">더보기</button>
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
						<button class="btnListGo" onclick="addList2(10)">더보기</button>
					</div>

				</div>

				<!-- 게임  끝   -->

				<!-- 운동  시작  -->


				<div class="subNav-content" id="sports">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList2(11)">더보기</button>
					</div>

				</div>

				<!-- 운동  끝   -->

				<!-- 먹방   시작  -->


				<div class="subNav-content" id="food">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList2(12)">더보기</button>
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
						<button class="btnListGo" onclick="addList2(13)">더보기</button>
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
						<button class="btnListGo" onclick="addList(14)">더보기</button>
					</div>

				</div>

				<!-- 반려동물   끝   -->

				<!-- ASMR   시작  -->


				<div class="subNav-content" id="asmr">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(15)">더보기</button>
					</div>

				</div>

				<!-- ASMR   끝   -->

				<!-- 취미  시작  -->


				<div class="subNav-content" id="habbit">

					<div class="chnContents">
						<div class="pt-2"></div>
					</div>

					<div class="pt-4"></div>

					<div class="rankBottom txt-center">
						<button class="btnListGo" onclick="addList(16)">더보기</button>
					</div>

				</div>

				<!-- 취미  끝   -->

			</div>
		</div>
	</div>


	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />

</body>
</html>