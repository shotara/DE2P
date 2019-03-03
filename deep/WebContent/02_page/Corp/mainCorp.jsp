<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>랭크리 : 기업회원 홈</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="subject" content="랭크리 : 유튜브 채널의 비즈니스 정보를 한곳에서">
<link rel="canonical" href="http://rancre.com">
<meta name="description" content="랭크리는 유튜브 채널의 비즈니스 정보를 제공합니다. 유튜브 채널 마케팅을 고민하고 있다면 랭크리에서 채널정보를 확인하세요" >
<jsp:include page="/02_page/commonHeader.jsp" flush="true" />
<script>
	function getChannelPage(mode, page) {
		switch(mode) {
		case 1:
			var url="/member?action=getReviewChannelList";  
		    var params = {
		    	startNo : (page-1)*5,
		    	pageNo : page
		    };
		    
		    $.ajax({      
		        type:"POST",  
		        url:url,      
		        data:params,  
		        dataType:'json',
		        success:function(args){   
		            $("#myReviewChild").empty();

		        	for(var i=0; i<args.outputReviewList.length; i++) {
						$('#myReviewChild').append(
								"			<div class='corp-MyReview row'>\r\n" + 
								"			<div class='col float-left corp-ChnName'>"+args.outputReviewList[i].outputChannelTitle+"</div>\r\n" + 
								"			<div class='col float-left corp-ChnSatisfy'>"+args.outputReviewList[i].outputReviewSatisfy+"</div>\r\n" + 
								"			<div class='col float-left corp-ChnReview-Date'>"+args.outputReviewList[i].outputReviewCreateDate+"</div>\r\n" + 
								"			<div class='col float-left corp-ChnReivew-Accept'>"+args.outputReviewList[i].outputReviewStatus+"</div>\r\n" + 
								"		</div>\r\n" + 
								"\r\n" + 
								"		<hr\r\n" + 
								"			style='margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;'>\r\n");
		        	}

		            $("#reviewPaging").empty();
		            
		    		var review_current = args.reviewCurrentPageNo;
		    		var review_total = parseInt((review_current) / 10) * 10 + 10;
		    		var review_start = parseInt((review_current) / 10) * 10;
		    		var review_finalPage = args.reviewFinalPageNo;
		    		
		    		if (review_start > 0) {
		    			if ((review_start - 10) == 0)
		    				$("#reviewPaging")
		    						.append(
		    								"<li class='common-page-pre display-none' onclick='getChannelPage(1,1)>이전</li> ");
		    			else
		    				$("#reviewPaging").append(
		    						"<li class='common-page-pre display-none' onclick='getChannelPage(1,"
		    								+ (review_start - 10)
		    								+ ");'>이전</li> ");
		    		}

		    		if (review_start == 0) {
		    			for (var i = review_start; i < review_total && i < review_finalPage; i++) {
		    				var input = ""
		    				if ((i + 1) != review_current) {
		    					input = "<li class='common-page-link' onclick='getChannelPage(1,"
		    							+ (i + 1)
		    							+ ");'>"
		    							+ (i + 1)
		    							+ "</li> ";
		    				} else {
		    					input = "<li class='common-page-link active'>"+(i + 1) + "</li> ";
		    				}
		    				$("#reviewPaging").append(input);
		    			}
		    		} else {
		    			for (var i = review_start; i < review_total + 1
		    					&& i + 1 < review_finalPage; i++) {
		    				var input = ""
		    				if ((i) != review_current) {
		    					input = "<li class='common-page-link' onclick='getChannelPage(1,"
		    							+ (i)
		    							+ ");'>"
		    							+ (i)
		    							+ "</li> ";
		    				} else {
		    					input ="<li class='common-page-link active'>"+ (i) + "</li> ";
		    				}
		    				$("#reviewPaging").append(input);
		    			}
		    		}

		    		if (review_total < review_finalPage)
		    			$("#reviewPaging").append(
		    					"<li class='common-page-next go-review-list'><a\r\n" + 
		    					"class='common-A' onclick='getChannelPage(2,"+review_total+")'>다음<img style='margin-bottom: 2px;'\r\n" + 
		    					"src='/01_image/commonImg/right-arrow.png'></a></li>");
		        },   
		        error:function(request,status,error){  
		            alert(error);  
		        }  
		    });  
			
			break;
		case 2:
			var url="/member?action=getRecentChannelList";  
		    var params = {
		    	startNo : (page-1)*5,
		    	pageNo : page
		    };
		    
		    $.ajax({      
		        type:"POST",  
		        url:url,      
		        data:params,  
		        dataType:'json',
		        success:function(args){   
		            $("#myViewChild").empty();

		        	for(var i=0; i<args.outputChannelList.length; i++) {
						var like='';
						if(args.outputChannelList[i].outputChannelLike==0) like = "<button class='commonBtn' onclick='Common.Like(1,"+args.outputChannelList[i].outputChannelNo+");'>관심채널 등록</button>";
						else like ="<button class='commonReverseBtn' onclick='Common.Like(2,"+args.outputChannelList[i].outputChannelNo+");'>관심채널 해제</button>";
						
						$('#myViewChild').append(
								"								<div class='corp-MyView w100'>\r\n" + 
								"								<div class='corp-View-Row-ChnImg'>\r\n" + 
								"									<img id='corp-View-Row-ThumbNail'\r\n" + 
								"										style='width: 48px; border-radius: 48px;'\r\n" + 
								"										src='"+ args.outputChannelList[i].outputChannelThumbnail +"' />\r\n" + 
								"								</div>\r\n" + 
								"								<div class='corp-View-Row-ChnName'>"+ args.outputChannelList[i].outputChannelName +"</div>\r\n" + 
								"								<div class='corp-View-Row-Category'>"+ args.outputChannelList[i].outputChannelCategory +"</div>\r\n" + 
								"								<div class='corp-View-Row-Subscribe'>"+ args.outputChannelList[i].outputChannelFollowers +"</div>\r\n" + 
								"								<div class='corp-View-Row-TotalView'>"+ args.outputChannelList[i].outputChannelViews +"</div>\r\n" + 
								"								<div class='corp-View-Row-Like'>\r\n" + 
								"								"+like+"\r\n" + 
								"								</div>\r\n" + 
								"								<div class='corp-View-Row-DetailGo'>\r\n" + 
								"									<a href='/channel?action=getChannelDetail&inputChannelNo="+ args.outputChannelList[i].outputChannelNo +"'>\r\n" +
								"										<button class='common-Small-Btn'>채널정보 보기\r\n" + 
								"									</button>\r\n" + 
								"									</a>r\n"+
								"								</div>\r\n" + 
								"\r\n" + 
								"							</div>\r\n" + 
								"\r\n" + 
								"							<hr\r\n" + 
								"								style='margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;'>\r\n"

					  );
		        	}

		            $("#recentPaging").empty();
		            
		    		var recent_current = args.recentCurrentPageNo;
		    		var recent_total = parseInt((recent_current) / 10) * 10 + 10;
		    		var recent_start = parseInt((recent_current) / 10) * 10;
		    		var recent_finalPage = args.recentFinalPageNo;

		    		if (recent_start > 0) {
		    			if ((recent_start - 10) == 0)
		    				$("#recentPaging")
		    						.append(
		    								"<li class='common-page-pre display-none' onclick='getChannelPage(2,1)>이전</li> ");
		    			else
		    				$("#recentPaging").append(
		    						"<li class='common-page-pre display-none' onclick='getChannelPage(2,"
		    								+ (recent_start - 10)
		    								+ ");'>이전</li> ");
		    		}

		    		if (recent_start == 0) {
		    			for (var i = recent_start; i < recent_total && i < recent_finalPage; i++) {
		    				var input = ""
		    				if ((i + 1) != recent_current) {
		    					input = "<li class='common-page-link' onclick='getChannelPage(2,"
		    							+ (i + 1)
		    							+ ");'>"
		    							+ (i + 1)
		    							+ "</li> ";
		    				} else {
		    					input = "<li class='common-page-link active'>"+(i + 1) + "</li> ";
		    				}
		    				$("#recentPaging").append(input);
		    			}
		    		} else {
		    			for (var i = recent_start; i < recent_total + 1
		    					&& i + 1 < recent_finalPage; i++) {
		    				var input = ""
		    				if ((i) != recent_current) {
		    					input = "<li class='common-page-link' onclick='getChannelPage(2,"
		    							+ (i)
		    							+ ");'>"
		    							+ (i)
		    							+ "</li> ";
		    				} else {
		    					input ="<li class='common-page-link active'>"+ (i) + "</li> ";
		    				}
		    				$("#recentPaging").append(input);
		    			}
		    		}

		    		if (recent_total < recent_finalPage)
		    			$("#recentPaging").append(
		    					"<li class='common-page-next go-review-list'><a\r\n" + 
		    					"class='common-A' onclick='getChannelPage(2,"+recent_total+")'>다음<img style='margin-bottom: 2px;'\r\n" + 
		    					"src='/01_image/commonImg/right-arrow.png'></a></li>");
		    	
		        },   
		        error:function(request,status,error){  
		            alert(error);  
		        }  
		    });  
			
			break;
		case 3:
			var url="/member?action=getLikeChannelList";  
		    var params = {
		    	startNo : (page-1)*5,
		    	pageNo : page
		    };
		    
		    $.ajax({      
		        type:"POST",  
		        url:url,      
		        data:params,  
		        dataType:'json',
		        success:function(args){   
		            $("#myLikeChild").empty();

		        	for(var i=0; i<args.outputChannelList.length; i++) {
						var like='';
						if(args.outputChannelList[i].outputChannelLike==0) like = "<button class='commonBtn' onclick='Common.Like(1,"+args.outputChannelList[i].outputChannelNo+");'>관심채널 등록</button>";
						else like ="<button class='commonReverseBtn' onclick='Common.Like(2,"+args.outputChannelList[i].outputChannelNo+");'>관심채널 해제</button>";
						
						$('#myLikeChild').append(
								"								<div class='corp-MyView w100'>\r\n" + 
								"								<div class='corp-View-Row-ChnImg'>\r\n" + 
								"									<img id='corp-View-Row-ThumbNail'\r\n" + 
								"										style='width: 48px; border-radius: 48px;'\r\n" + 
								"										src='"+ args.outputChannelList[i].outputChannelThumbnail +"' />\r\n" + 
								"								</div>\r\n" + 
								"								<div class='corp-View-Row-ChnName'>"+ args.outputChannelList[i].outputChannelName +"</div>\r\n" + 
								"								<div class='corp-View-Row-Category'>"+ args.outputChannelList[i].outputChannelCategory +"</div>\r\n" + 
								"								<div class='corp-View-Row-Subscribe'>"+ args.outputChannelList[i].outputChannelFollowers +"</div>\r\n" + 
								"								<div class='corp-View-Row-TotalView'>"+ args.outputChannelList[i].outputChannelViews +"</div>\r\n" + 
								"								<div class='corp-View-Row-Like'>\r\n" + 
								"									"+like+"\r\n" + 
								"								</div>\r\n" + 
								"								<div class='corp-View-Row-DetailGo'>\r\n" + 
								"									<a href='/channel?action=getChannelDetail&inputChannelNo="+ args.outputChannelList[i].outputChannelNo +"'>
								"										<button class='common-Small-Btn'>채널정보 보기\r\n" + 
								"										</button>\r\n" +
								"									</a>\r\n" + 
								"								</div>\r\n" + 
								"\r\n" + 
								"							</div>\r\n" + 
								"\r\n" + 
								"							<hr\r\n" + 
								"								style='margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;'>\r\n"
					  );
		        	}

		            $("#likePaging").empty();
		            
		    		var like_current = args.likeCurrentPageNo;
		    		var like_total = parseInt((like_current) / 10) * 10 + 10;
		    		var like_start = parseInt((like_current) / 10) * 10;
		    		var like_finalPage = args.likeFinalPageNo;
		    		
		    		if (like_start > 0) {
		    			if ((like_start - 10) == 0)
		    				$("#likePaging")
		    						.append(
		    								"<li class='common-page-pre display-none' onclick='getChannelPage(3,1)>이전</li> ");
		    			else
		    				$("#likePaging").append(
		    						"<li class='common-page-pre display-none' onclick='getChannelPage(3,"
		    								+ (like_start - 10)
		    								+ ");'>이전</li> ");
		    		}

		    		if (like_start == 0) {
		    			for (var i = like_start; i < like_total && i < like_finalPage; i++) {
		    				var input = ""
		    				if ((i + 1) != like_current) {
		    					input = "<li class='common-page-link' onclick='getChannelPage(3,"
		    							+ (i + 1)
		    							+ ");'>"
		    							+ (i + 1)
		    							+ "</li> ";
		    				} else {
		    					input = "<li class='common-page-link active'>"+(i + 1) + "</li> ";
		    				}
		    				$("#likePaging").append(input);
		    			}
		    		} else {
		    			for (var i = like_start; i < like_total + 1
		    					&& i + 1 < like_finalPage; i++) {
		    				var input = ""
		    				if ((i) != like_current) {
		    					input = "<li class='common-page-link' onclick='getChannelPage(3,"
		    							+ (i)
		    							+ ");'>"
		    							+ (i)
		    							+ "</li> ";
		    				} else {
		    					input ="<li class='common-page-link active'>"+ (i) + "</li> ";
		    				}
		    				$("#likePaging").append(input);
		    			}
		    		}

		    		if (like_total < like_finalPage)
		    			$("#likePaging").append(
						"<li class='common-page-next go-review-list'><a"+
						"class='common-A' onclick='getChannelPage(3,"+like_total+")'>다음<img style='margin-bottom: 2px;'"+
							"src='/01_image/commonImg/right-arrow.png'></a></li>");
			
		        },   
		        error:function(request,status,error){  
		            alert(error);  
		        }  
		    });  
			
			
			break;
		}
	}
	
</script>
</head>
<body>

	<jsp:include page="/02_page/commonNav.jsp" flush="false" />

	<div class="container pTop2">
		<div class="row">
			<div class="col">

				<div class="w100 display-block corp-Top-area">

					<div class="corp-Row inline-block float-left">기업명</div>
					<div class="corp-Row inline-block float-left">아이디</div>
					<div class="corp-Row inline-block float-left">리뷰 등록 수</div>

					<div class="pTop3"></div>

					<div class="corp-Name inline-block float-left">${outputCompanyName }</div>
					<div class="corp-Id inline-block float-left">${outputMemberName }</div>
					<div class="corp-ReviewCnt inline-block float-left">${outputReviewCount }개</div>

				</div>



				<div class="corp-Middle-area inline-block">
					<div class="corp-headerTitle">나의 리뷰 (${outputReviewCount }건)</div>

					<div class="pTop3 row">
						<div class="col float-left">채널명</div>
						<div class="col float-left">종합 만족도</div>
						<div class="col float-left">등록일자</div>
						<div class="col float-left">상태</div>
					</div>

					<hr>

					<!-- if non-channel review -->
					<c:if test="${outputReviewList.size() == 0}">
						<div class="none-MyReview txt-center">
							<div class="common-alert-txt">
								등록한 광고 리뷰가 없습니다. <br /> 지금 광고 리뷰를 등록하고 다른 채널의 리뷰를 확인해보세요!
							</div>
							<div class="go-write-review">
								<button class="common-wide20Reverse-Btn"
									onclick="location.href='/02_page/Review/review.jsp'">리뷰
									등록하기</button>
							</div>
						</div>
					</c:if>
					<!-- end non-channel review -->

					<!-- if channel review exist -->
					<c:if test="${outputReviewList.size() != 0}">
						<div class="corp-MyReview-Contents" id="myReviewContent">
							<div id="myReviewChild">
								<c:forEach var="item" items="${outputReviewList}">
									<div class="corp-MyReview row">
										<div class="col float-left corp-ChnName">${item.outputChannelTitle}</div>
										<div class="col float-left corp-ChnSatisfy">${item.outputReviewSatisfy}</div>
										<div class="col float-left corp-ChnReview-Date">${item.outputReviewCreateDate}</div>
										<div class="col float-left corp-ChnReivew-Accept">${item.outputReviewStatus}</div>
									</div>

									<hr
										style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
								</c:forEach>
							</div>
							<div class="pagination-area pTop3">
								<ul class="common-pagination" id="reviewPaging">
								</ul>
							</div>
						</div>
					</c:if>
					<!-- end channel review exist -->
				</div>



				<!-- start view channel & like channel area start -->
				<div class="pTop4 inline-block subNav-tabs">
					<div class="corp-headerTitle subNav-tab">
						<a class="subnav-link active" data-tab="myViewContent"
							href="#myViewContent" onclick="Common.dontMove()">최근 본 채널</a>
					</div>
					<div class="corp-headerTitle subNav-tab">
						<a class="subnav-link" data-tab="myLikeContent"
							href="#myLikeContent" onclick="Common.dontMove()">나의 관심 채널</a>
					</div>
				</div>
				<!-- end view channel & like channel area end -->


				<div class="pTop3 w100 inline-block">
					<div class="corp-View-Row">채널명</div>
					<div class="corp-View-Row">카테고리</div>
					<div class="corp-View-Row">총 구독자수</div>
					<div class="corp-View-Row-Right">총 조회수</div>
					<hr>
				</div>


				<!-- if exist view channel list -->
				<c:if test="${outputChannelViewList.size() != 0 }">
					<div class="subNav-content active corp-MyView-Contents"
						id="myViewContent">
						<div id="myViewChild">
							<c:forEach var="item" items="${outputChannelViewList}">
								<div class="corp-MyView w100">
									<div class="corp-View-Row-ChnImg">
										<img id="corp-View-Row-ThumbNail"
											style="width: 48px; border-radius: 48px;"
											src="${item.outputChannelThumbnail }" />
									</div>
									<div class="corp-View-Row-ChnName">${item.outputChannelName}</div>
									<div class="corp-View-Row-Category">${item.outputChannelCategory}</div>
									<div class="corp-View-Row-Subscribe">${item.outputChannelFollowers}</div>
									<div class="corp-View-Row-TotalView">${item.outputChannelViews}</div>
									<div class="corp-View-Row-Like">
										<c:if test="${item.outputChannelLike==0}">
											<button class="commonBtn"
												onclick="Common.Like(1,${item.outputChannelNo });">관심채널
												등록</button>
										</c:if>
										<c:if test="${item.outputChannelLike!=0}">
											<button class="commonReverseBtn"
												onclick="Common.Like(2,${item.outputChannelNo });">관심채널
												해제</button>
										</c:if>
									</div>
									<div class="corp-View-Row-DetailGo">
										<a
											href="/channel?action=getChannelDetail&inputChannelNo=${item.outputChannelNo }">
											<button class="commonBtn">채널정보 보기</button>
										</a>
									</div>

								</div>

								<hr
									style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
							</c:forEach>
						</div>
						<!-- pagination area -->

						<div class="pagination-area pTop3">
							<ul class="common-pagination" id="recentPaging">
							</ul>
						</div>

						<!-- end pagination area -->

					</div>
				</c:if>
				<!-- end exist view channel list -->

				<!-- none exist view channel list -->
				<c:if test="${outputChannelViewList.size() == 0 }">
					<div class="subNav-content active none-View-List"
						id="myViewContent">
						<div class="common-alert-txt txt-center">
							최근 15일 내 검색한 채널이 없습니다. </br> 이런 채널은 어떤가요?
						</div>
						<div class="recommend-channel-list">
							<c:forEach var="item" items="${outputChannelViewRandom}">
								<div class="recommend-channel">
									<div class="reco-chnImg txt-left">
										<img id="corp-View-Row-ThumbNail"
											style="width: 50px; border-radius: 50px;"
											src="${item.outputChannelThumbnail }" />
									</div>
									<div class="reco-chnInfo">
										<div class="name">${item.outputChannelTitle }</div>
										<div class="category inline-block txt-left">${item.outputChannelCategory }</div>
									</div>
									<div class="txt-center pTop">
										<button class="common-wide85Reverse-Btn"
											onclick="location.href='/channel?action=getChannelDetail&inputChannelNo=${item.outputChannelNo}';">채널정보
											보기</button>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>
				<!-- none exist view channel list -->


				<!-- if exist like channel list -->
				<c:if test="${outputChannelLikeList.size() != 0 }">
					<div class="subNav-content corp-MyLike-Contents" id="myLikeContent">
						<div id="myLikeChild">
							<c:forEach var="item" items="${outputChannelLikeList}">
								<div class="corp-MyView w100">
									<div class="corp-View-Row-ChnImg">
										<img id="corp-View-Row-ThumbNail"
											style="width: 48px; border-radius: 48px;"
											src="${item.outputChannelThumbnail }" />
									</div>
									<div class="corp-View-Row-ChnName">${item.outputChannelName}</div>
									<div class="corp-View-Row-Category">${item.outputChannelCategory}</div>
									<div class="corp-View-Row-Subscribe">${item.outputChannelFollowers}</div>
									<div class="corp-View-Row-TotalView">${item.outputChannelViews}</div>
									<div class="corp-View-Row-Like">
										<c:if test="${item.outputChannelLike==0}">
											<button class="commonBtn"
												onclick="Common.Like(1,${item.outputChannelNo });">관심채널
												등록</button>
										</c:if>
										<c:if test="${item.outputChannelLike!=0}">
											<button class="commonReverseBtn"
												onclick="Common.Like(2,${item.outputChannelNo });">관심채널
												해제</button>
										</c:if>
									</div>
									<div class="corp-View-Row-DetailGo">
										<a
											href="/channel?action=getChannelDetail&inputChannelNo=${item.outputChannelNo }">
											<button class="commonBtn">채널정보 보기</button>
										</a>
									</div>

								</div>

								<hr
									style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
							</c:forEach>
						</div>
						<!-- pagination area -->

						<div class="pagination-area pTop3">
							<ul class="common-pagination" id="likePaging">
							</ul>
						</div>

						<!-- end pagination area -->

					</div>
				</c:if>
				<!-- end exist like channel list -->


				<!-- none like channel list -->
				<c:if test="${outputChannelLikeList.size() == 0 }">
					<div class="subNav-content none-Like-List" id="myLikeContent">
						<div class="common-alert-txt txt-center">
							관심 채널로 등록한 채널이 없습니다. </br> 이런 채널은 어떤가요?
						</div>
						<div class="recommend-channel-list">
							<c:forEach var="item" items="${outputChannelLikeRandom}">
								<div class="recommend-channel">
									<div class="reco-chnImg txt-left">
										<img id="corp-View-Row-ThumbNail"
											style="width: 50px; border-radius: 50px;"
											src="${item.outputChannelThumbnail }" />
									</div>
									<div class="reco-chnInfo">
										<div class="name">${item.outputChannelTitle}</div>
										<div class="category inline-block txt-left">${item.outputChannelCategory }</div>
									</div>
									<div class="txt-center pTop">
										<button class="common-wide85Reverse-Btn"
											onclick="location.href='/channel?action=getChannelDetail&inputChannelNo=${item.outputChannelNo}';">채널정보
											보기</button>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:if>
				<!-- none like channel list -->


			</div>
		</div>
	</div>

	<jsp:include page="/02_page/commonFooter.jsp" flush="false" />
	<script>
	$(document).ready(function() {
		
		///////////// Review 
		var review_current = ${reviewCurrentPageNo};
		var review_total = parseInt((review_current) / 10) * 10 + 10;
		var review_start = parseInt((review_current) / 10) * 10;
		var review_finalPage = ${reviewPaging.finalPageNo};
		
		if (review_start > 0) {
			if ((review_start - 10) == 0)
				$("#reviewPaging")
							.append(
							"<li class='common-page-pre display-none' onclick='getChannelPage(1,1)>이전</li> ");
			else
			$("#reviewPaging").append(
					"<li class='common-page-pre display-none' onclick='getChannelPage(1,"
							+ (recent_start - 10)
							+ ");'>이전</li> ");
		}
		if (review_start == 0) {
			for (var i = review_start; i < review_total && i < review_finalPage; i++) {
				var input = ""
				if ((i + 1) != review_current) {
					input = "<li class='common-page-link'><a href='/admin?action=getChannelList&page="
							+ (i + 1)
							+ "&size=5'>"
							+ (i + 1)
							+ "</a></li> ";
				} else {
					input = "<li class='common-page-link active'>"+(i + 1) + "</li> ";
				}
				$("#reviewPaging").append(input);
			}
		} else {
			for (var i = review_start; i < review_total + 1
					&& i + 1 < review_finalPage; i++) {
				var input = ""
				if ((i) != review_current) {
					input = "<li class='common-page-link'><a href='/admin?action=getChannelList&page="
							+ (i)
							+ "&size=5'>"
							+ (i)
							+ "</a></li> ";
				} else {
					input ="<li class='common-page-link active'>"+ (i) + "</li> ";
				}
				$("#reviewPaging").append(input);
			}
		}

		if (review_total < review_finalPage)
			$("#reviewPaging").append(
					"<li class='common-page-next go-review-list'><a"+
					"class='common-A' onclick='getChannelPage(2,"+review_total+")'>다음<img style='margin-bottom: 2px;'"+
						"src='/01_image/commonImg/right-arrow.png'></a></li>");
	
		///////////// Recent 
		var recent_current = ${recentCurrentPageNo};
		var recent_total = parseInt((recent_current) / 10) * 10 + 10;
		var recent_start = parseInt((recent_current) / 10) * 10;
		var recent_finalPage = ${recentPaging.finalPageNo};
		
		if (recent_start > 0) {
			if ((recent_start - 10) == 0)
				$("#recentPaging")
						.append(
								"<li class='common-page-pre display-none' onclick='getChannelPage(2,1)>이전</li> ");
			else
				$("#recentPaging").append(
						"<li class='common-page-pre display-none' onclick='getChannelPage(2,"
								+ (recent_start - 10)
								+ ");'>이전</li> ");
		}
		if (recent_start == 0) {
			for (var i = recent_start; i < recent_total && i < recent_finalPage; i++) {
				var input = ""
				if ((i + 1) != recent_current) {
					input = "<li class='common-page-link' onclick='getChannelPage(2,"
							+ (i + 1)
							+ ");'>"
							+ (i + 1)
							+ "</a></li> ";
				} else {
					input = "<li class='common-page-link active'>"+(i + 1) + "</li> ";
				}
				$("#recentPaging").append(input);
			}
		} else {
			for (var i = recent_start; i < recent_total + 1
					&& i + 1 < recent_finalPage; i++) {
				var input = ""
				if ((i) != recent_current) {
					input = "<li class='common-page-link' onclick='getChannelPage(2,"
							+ (i)
							+ ");'>"
							+ (i)
							+ "</li> ";
				} else {
					input ="<li class='common-page-link active'>"+ (i) + "</li> ";
				}
				$("#recentPaging").append(input);
			}
		}

		if (recent_total < recent_finalPage)
			$("#recentPaging").append(
					"	<li class='common-page-next go-review-list'><a\r\n" + 
					"			class='common-A' onclick='getChannelPage(2,"+recent_total+")'>다음<img style='margin-bottom: 2px;'\r\n" + 
					"				src='/01_image/commonImg/right-arrow.png'></a></li>"
					);
	
		///////Like 
		var like_current = ${likeCurrentPageNo};
		var like_total = parseInt((like_current) / 10) * 10 + 10;
		var like_start = parseInt((like_current) / 10) * 10;
		var like_finalPage = ${likePaging.finalPageNo};
		
		if (like_start > 0) {
			if ((like_start - 10) == 0)
				$("#likePaging")
						.append(
						"<li class='common-page-pre display-none' onclick='getChannelPage(3,1)>이전</li> ");
			else
				$("#likePaging").append(
						"<li class='common-page-pre display-none' onclick='getChannelPage(3,"
						+ (recent_start - 10)
						+ ");'>이전</li> ");
		}
		if (like_start == 0) {
			for (var i = like_start; i < like_total && i < like_finalPage; i++) {
				var input = ""
				if ((i + 1) != like_current) {
					input = "<li class='common-page-link' onclick='getChannelPage(3,"
							+ (i + 1)
							+ ");'>"
							+ (i + 1)
							+ "</li> ";
				} else {
					input = "<li class='common-page-link active'>"+(i + 1) + "</li> ";
				}
				$("#likePaging").append(input);
			}
		} else {
			for (var i = like_start; i < like_total + 1
					&& i + 1 < like_finalPage; i++) {
				var input = ""
				if ((i) != like_current) {
					input = "<li class='common-page-link' onclick='getChannelPage(3,"
							+ (i)
							+ ");'>"
							+ (i)
							+ "</li> ";
				} else {
					input ="<li class='common-page-link active'>"+ (i) + "</li> ";
				}
				$("#likePaging").append(input);
			}
		}

		if (like_total < like_finalPage)
			$("#likePaging").append(
					"					<li class='common-page-next go-review-list'><a\r\n" + 
					"					class='common-A' onclick='getChannelPage(3,"+like_total+")'>다음<img style='margin-bottom: 2px;'\r\n" + 
					"						src='/01_image/commonImg/right-arrow.png'></a></li>");
		

	
	});
	</script>
</body>
</html>