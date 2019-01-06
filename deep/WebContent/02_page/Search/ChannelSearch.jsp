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

	<div class="container rec-search">
		<div class="row">

			<!-- search input area -->

			<div class="txt-center search-Keyword pTop4">
				<div class="ipt-search-box">
					<input class="ipt-search" id="ipt-Search" type="text"
						placeholder="다음으로 Rancre 검색" onkeyup="Common.search(2)"/>
				</div>
				<button id="clear-btn" class="clear-Btn" onclick="Common.search(1)">
					<img style="width: 20px;" src="/01_image/commonImg/cancel.png">
				</button>
			</div>


			<!-- search input area finish -->

			<div class="pTop3 w-100 display-block"></div>


			<!-- search result area -->


			<div class="col search-Result">

				<!-- before result area start -->
				<div class="before-result">
					<div class="txt-center">
						<span>이런 채널은 어떤가요?</span>
					</div>

					<div class="search-reco-channel-list">
						<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>

						<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>

						<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>
						
						<div class="search-reco-channel-right">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>
							<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>

						<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>

						<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>
						
						<div class="search-reco-channel-right">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>
							<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>

						<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>

						<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>
						
						<div class="search-reco-channel-right">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>
							<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>

						<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>

						<div class="search-reco-channel">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>
						
						<div class="search-reco-channel-right">
							<div class="search-reco-chnImg txt-left">
								<img id="search-reco-thumbNail"
									style="width: 50px; border-radius: 50px;"
									src="https://yt3.ggpht.com/-mUDER2p8AVo/AAAAAAAAAAI/AAAAAAAAAAA/qQod6ZFouBo/s240-c-k-no-mo-rj-c0xffffff/photo.jpg" />
							</div>
							<div class="search-reco-chnInfo">
								<div class="name">Wassup-Man</div>
								<div class="category inline-block txt-left">#스튜디오, 게임, 엔터</div>
							</div>
							<div class="txt-center pTop">
								<button class="common-wide85Reverse-Btn">채널정보 보기</button>
							</div>
						</div>
					</div>

				</div>

				<!-- before result area finished -->

				<!-- none result area start -->
				<div class="non-result txt-center">
					<span>검색 결과가 없습니다. 다른 검색어를 입력해보세요!</span>
				</div>

				<!-- none result area finished -->

				<!-- channel result area start -->

				<div class="videoResult">
					<div class=""></div>
				</div>



				<!-- channel result area finished -->


			</div>

		</div>
	</div>


	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />
</body>
</html>