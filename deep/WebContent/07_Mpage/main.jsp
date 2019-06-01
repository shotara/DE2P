<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, mininum-scale=1.0, maximun-scale=1.0, user-scalable=no">
<title>Rancre : 유튜브 채널 정보 플랫폼</title>
<jsp:include page="/07_Mpage/commonMobileHeader.jsp" flush="true" />

<script>
	function mobileAddList() {

		var startNo = $("#rac_m_startNo").val();

		CommonM.addList(startNo, 0);

		$("#rac_m_startNo").val(startNo * 1 + 10);
		if (startNo >= 90)
			$(".rac_m_bottom").hide();
	}
	
	$(document).ready(function() { 
		
		$("#rac_m_startNo").val(10);
		var url="/main?action=getMRankingMain";  
	    var params = {
	    	startNo : 0
	    };
	    
	    $.ajax({      
	        type:"POST",  
	        url:url,      
	        data:params,  
	        dataType:'json',
	        success:function(args){   
	        	for(var i=0; i<args.rankingList.length; i++) {
	        		$('.rac_m_Top100_Contents').append("		<div class='content' onclick='CommonM.m_chn_Detail_Go()'>\n" + 
	        				"		<div class='img'>\n" + 
	        				"			<img style='width: 100%;'\n" + 
	        				"				src='"+args.rankingList[i].outputChannelThumbnail + "'>\n" + 
	        				"		</div>\n" + 
	        				"		<div class='diff'>\n" + 
	        				"			<div class='count'>\n" + 
	        				"				<span>"+args.rankingList[i].outputRankTopNo + "</span>\n" + 
	        				"			</div>\n" + 
	        				"			<div class='mark'>\n" + args.rankingList[i].outputRankUpDown + 
	        				"			</div>\n" + 
	        				"		</div>\n" + 
	        				"		<div class='title_sub'>\n" + 
	        				"			<div class='title'>\n" + 
	        				"				<span>"+args.rankingList[i].outputChannelTitle+"</span>\n" + 
	        				"			</div>\n" + 
	        				"			<div class='view'>\n" + 
	        				"				<span>구독자</span><span>"+args.rankingList[i].outputChannelFollowers+"</span>\n" + 
	        				"			</div>\n" + 
	        				"		</div>\n" + 
	        				"		<div class='icon'>\n" + 
	        				"			<i class='icon-right-open-mini'></i>\n" + 
	        				"		</div>\n" + 
	        				"	</div>");
	        	}

	        },   
	        error:function(e){  
	            alert(e.responseText);  
	        }  
	    });  
		
	});
</script>
</head>
<body class="mbody">

	<jsp:include page="/07_Mpage/commonMHead.jsp" flush="true" />

	<section id="m-Main-Channel-List">

	<div class="rac_m_Top100">
		<div class="rac_m_Top100_Top">
			<p class="title">채널 100</p>
			<span class="content">채널 종합 순위입니다.</span>
		</div>

		<div class="rac_m_Top100_Contents"></div>


	</div>

	<div class="rac_m_bottom">
		<div class="rac_m_more_channel">
			<button class="commonMobileBtn" onclick="mobileAddList()">
				more</button>
			<input type="hidden" id="rac_m_startNo">
		</div>
	</div>


	</section>

	<jsp:include page="/07_Mpage/commonMFooter.jsp" flush="true" />

</body>
</html>