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
			<div class="col pt-3">
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
						<a class="subnav-link active" data-tab="studio" href="#studio">스튜디오</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="entertain" href="#entertain">엔터</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="travel" href="#travel">여행</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="singdance" href="#singdance">노래
							댄스</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="tech" href="#tech">테크</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="education" href="#education">교육(어학)</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="beauty" href="#beauty">뷰티</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="daylife" href="#daylife">일상</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="game" href="#game">게임</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="sports" href="#sports">스포츠</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="food" href="#food">먹방</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="kids" href="#kids">키즈</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="pet" href="#pet">반려동물</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="exercise" href="#exercise">운동</a>
					</div>
					<div class="subNav-tab col w-auto ml-auto d-inline-block">
						<a class="subnav-link" data-tab="habbit" href="#habbit">취미</a>
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

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">WassupMan</div>
						<div class="rankRow">#스튜디오</div>
						<div class="rankRow">1,232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">20</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">WassupMan</div>
						<div class="rankRow">#스튜디오</div>
						<div class="rankRow">1,232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">20</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">WassupMan</div>
						<div class="rankRow">#스튜디오</div>
						<div class="rankRow">1,232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">20</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">WassupMan</div>
						<div class="rankRow">#스튜디오</div>
						<div class="rankRow">1,232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">20</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">WassupMan</div>
						<div class="rankRow">#스튜디오</div>
						<div class="rankRow">1,232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">20</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">WassupMan</div>
						<div class="rankRow">#스튜디오</div>
						<div class="rankRow">1,232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">20</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">WassupMan</div>
						<div class="rankRow">#스튜디오</div>
						<div class="rankRow">1,232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">20</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">WassupMan</div>
						<div class="rankRow">#스튜디오</div>
						<div class="rankRow">1,232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">20</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">WassupMan</div>
						<div class="rankRow">#스튜디오</div>
						<div class="rankRow">1,232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">20</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzpOoL9VM1ytSDLaMuCoEV4Gr3U4XaXFbAtew=s176-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">WassupMan</div>
						<div class="rankRow">#스튜디오</div>
						<div class="rankRow">1,232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">20</div>
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



				<!--  스튜디오 콘텐츠 영역 끝  -->


				<!-- 엔터영역 시작  -->


				<div class="subNav-content active" id="entertain">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzl5zlOedULGISAO-Mqluanu5FMbdVX3JV-qg=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">와우엔터테인먼트</div>
						<div class="rankRow">#엔터</div>
						<div class="rankRow">332,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">15</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzl5zlOedULGISAO-Mqluanu5FMbdVX3JV-qg=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">와우엔터테인먼트</div>
						<div class="rankRow">#엔터</div>
						<div class="rankRow">332,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">15</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzl5zlOedULGISAO-Mqluanu5FMbdVX3JV-qg=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">와우엔터테인먼트</div>
						<div class="rankRow">#엔터</div>
						<div class="rankRow">332,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">15</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzl5zlOedULGISAO-Mqluanu5FMbdVX3JV-qg=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">와우엔터테인먼트</div>
						<div class="rankRow">#엔터</div>
						<div class="rankRow">332,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">15</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzl5zlOedULGISAO-Mqluanu5FMbdVX3JV-qg=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">와우엔터테인먼트</div>
						<div class="rankRow">#엔터</div>
						<div class="rankRow">332,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">15</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzl5zlOedULGISAO-Mqluanu5FMbdVX3JV-qg=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">와우엔터테인먼트</div>
						<div class="rankRow">#엔터</div>
						<div class="rankRow">332,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">15</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzl5zlOedULGISAO-Mqluanu5FMbdVX3JV-qg=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">와우엔터테인먼트</div>
						<div class="rankRow">#엔터</div>
						<div class="rankRow">332,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">15</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzl5zlOedULGISAO-Mqluanu5FMbdVX3JV-qg=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">와우엔터테인먼트</div>
						<div class="rankRow">#엔터</div>
						<div class="rankRow">332,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">15</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzl5zlOedULGISAO-Mqluanu5FMbdVX3JV-qg=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">와우엔터테인먼트</div>
						<div class="rankRow">#엔터</div>
						<div class="rankRow">332,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">15</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzl5zlOedULGISAO-Mqluanu5FMbdVX3JV-qg=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">와우엔터테인먼트</div>
						<div class="rankRow">#엔터</div>
						<div class="rankRow">332,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">15</div>
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


				<!-- 엔터영역 끝  -->



				<!-- 여행영역 시작  -->


				<div class="subNav-content active" id="travel">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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


				<!-- 여행영역 끝  -->



				<!-- 노래댄스 영역 시작  -->


				<div class="subNav-content active" id="singdance">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAybqQh4LMsA0mS2cOhLyW5PR3lQh62zUgmXWw=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">JFlaMusic</div>
						<div class="rankRow">#노래 댄스</div>
						<div class="rankRow">10,232,232</div>
						<div class="rankRow">1,232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAybqQh4LMsA0mS2cOhLyW5PR3lQh62zUgmXWw=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">JFlaMusic</div>
						<div class="rankRow">#노래 댄스</div>
						<div class="rankRow">10,232,232</div>
						<div class="rankRow">1,232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAybqQh4LMsA0mS2cOhLyW5PR3lQh62zUgmXWw=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">JFlaMusic</div>
						<div class="rankRow">#노래 댄스</div>
						<div class="rankRow">10,232,232</div>
						<div class="rankRow">1,232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAybqQh4LMsA0mS2cOhLyW5PR3lQh62zUgmXWw=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">JFlaMusic</div>
						<div class="rankRow">#노래 댄스</div>
						<div class="rankRow">10,232,232</div>
						<div class="rankRow">1,232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAybqQh4LMsA0mS2cOhLyW5PR3lQh62zUgmXWw=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">JFlaMusic</div>
						<div class="rankRow">#노래 댄스</div>
						<div class="rankRow">10,232,232</div>
						<div class="rankRow">1,232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAybqQh4LMsA0mS2cOhLyW5PR3lQh62zUgmXWw=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">JFlaMusic</div>
						<div class="rankRow">#노래 댄스</div>
						<div class="rankRow">10,232,232</div>
						<div class="rankRow">1,232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>

					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAybqQh4LMsA0mS2cOhLyW5PR3lQh62zUgmXWw=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">JFlaMusic</div>
						<div class="rankRow">#노래 댄스</div>
						<div class="rankRow">10,232,232</div>
						<div class="rankRow">1,232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAybqQh4LMsA0mS2cOhLyW5PR3lQh62zUgmXWw=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">JFlaMusic</div>
						<div class="rankRow">#노래 댄스</div>
						<div class="rankRow">10,232,232</div>
						<div class="rankRow">1,232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAybqQh4LMsA0mS2cOhLyW5PR3lQh62zUgmXWw=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">JFlaMusic</div>
						<div class="rankRow">#노래 댄스</div>
						<div class="rankRow">10,232,232</div>
						<div class="rankRow">1,232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAybqQh4LMsA0mS2cOhLyW5PR3lQh62zUgmXWw=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">JFlaMusic</div>
						<div class="rankRow">#노래 댄스</div>
						<div class="rankRow">10,232,232</div>
						<div class="rankRow">1,232,232,213</div>
						<div class="rankRow2">120</div>
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



				<!-- 노래댄스 끝  -->



				<!-- 테크 영역 시작  -->


				<div class="subNav-content active" id="tech">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 테크 영역 끝  -->



				<!-- 교육(어학) 시작  -->


				<div class="subNav-content active" id="education">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 교육(어학) 끝   -->


				<!-- 뷰티  시작  -->


				<div class="subNav-content active" id="beauty">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 뷰티  끝   -->

				<!-- 일상  시작  -->


				<div class="subNav-content active" id="daylife">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 일상  끝   -->

				<!-- 게임  시작  -->


				<div class="subNav-content active" id="game">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 게임  끝   -->

				<!-- 스포츠  시작  -->


				<div class="subNav-content active" id="sports">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 스포츠  끝   -->

				<!-- 먹방   시작  -->


				<div class="subNav-content active" id="food">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 먹방   끝   -->

				<!-- 키즈   시작  -->


				<div class="subNav-content active" id="kids">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 키즈   끝   -->

				<!-- 반려동물   시작  -->


				<div class="subNav-content active" id="pet">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 반려동물   끝   -->

				<!-- 운동   시작  -->


				<div class="subNav-content active" id="exercise">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 운동   끝   -->

				<!-- 취미  시작  -->


				<div class="subNav-content active" id="habbit">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
					<div class="pt-2"></div>
					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
						<div class="rankRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">

					<div class="pt-2"></div>

					<div id="newChnContent" class="w-auto ml-auto">
						<div class="rankRowImg">
							<img style="width: 48px; border-radius: 48px;"
								src="https://yt3.ggpht.com/a-/AN66SAzagU8o4275kfOeL5mYnU0TJfIRvKz2po3JpQ=s288-mo-c-c0xffffffff-rj-k-no">
						</div>
						<div class="rankRow">여행에미치다-Travelholic</div>
						<div class="rankRow">#여행</div>
						<div class="rankRow">232,232</div>
						<div class="rankRow">232,232,213</div>
						<div class="rankRow2">120</div>
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

				<!-- 취미  끝   -->

				<div class="pt-4"></div>

				<div class="rankBottom text-center">
					<button class="btnListGo">더보기</button>
				</div>
			</div>
		</div>
	</div>

	</section>

	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />


	<section class="indexRecommend"> </section>
	<c:forEach var="i" items="${requestScope.outputFeedList}">
		<div class="row<c:if test="${i.outputPostType == 1}"> notice</c:if>"
			onclick="Feed.goView('${i.outputFeedNo}')"></div>
	</c:forEach>
</body>
</html>