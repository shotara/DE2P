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
	<jsp:include page="/02_page/commonSubNav.jsp" flush="false" />

	<section id="indexFeed" class="section" data-type="feed">
	<div class="container-fluid">
		<div class="col-xs-2 col-md-3"></div>
		<div class="col-xs-8 col-md-6">
			<div class="list" data-type="feed">
				<div class="feed">
					<div class="left col-xs-5 col-md-5">
					 <div class="coverPic">
						 <div class="title">
							 <span class="char">여기가 타이틀 입니다.</span>
						 </div>
					  </div>
					 </div>
					 <div class="right col-xs-7 col-md-7">
						<div class="content">
							<span class="title-black">여기에 바로 이렇게 본문이 들어가는 부분입니다 여러분!</span>
						</div>
						<div class="name">
							BY 누구누구누구
						</div> 
						<div class="like fa fa-heart-o">&nbsp좋아요</div>
						<div class="comment fa fa-comment-o">&nbsp댓글</div>
						<div class="share fa fa-share-alt">&nbsp공유</div>						
					 </div>
				 </div>
			</div>
			
			
		</div>
		<div class="col-xs-2 col-md-3"></div>
	</div>

	</section>

	<section class="indexRecommend"> </section>
   <c:forEach var="i" items="${requestScope.outputFeedList}">
			        <div class="row<c:if test="${i.outputPostType == 1}"> notice</c:if>" onclick="Feed.goView('${i.outputFeedNo}')">
			         </div>
	</c:forEach>
</body>
</html>