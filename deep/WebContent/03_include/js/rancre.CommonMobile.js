/**
 * RANCRE MOBILE COMMON Js 
 */

var CommonM ={};

CommonM.addList = function(startNo, categoryNo){

	if(startNo>=100) return -1;

	var url="/main?action=getMRankingMain";  
	var params = {
			startNo : startNo,
	};

	$.ajax({      
		type:"POST",  
		url:url,      
		data:params,  
		dataType:'json',
		success:function(args){   
			for(var i=0; i<args.rankingList.length; i++) {
        		$('.rac_m_Top100_Contents').append("		<div class='content' onclick='CommonM.m_chn_Detail_Go("+args.rankingList[i].outputChannelNo+")'>\n" + 
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

	if(startNo>=90) 		
		$(".rac_m_bottom").hide();
}

CommonM.m_chn_Detail_Go = function(no) {
	
}
