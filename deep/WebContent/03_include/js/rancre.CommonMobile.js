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


CommonM.m_clk_s_menu = function(mode){
	if(mode == 1){ //open side menu
		const side_open = document.getElementById('rac_m_Side_menu');
		side_open.style.display = 'block';
	}else if(mode == 2){ //close side menu
		const side_close = document.getElementById('rac_m_Side_menu');
		side_close.style.display = 'none';
	} 
}

CommonM.move_m_List = function(mode){
	if(mode==1){//move mainList, channel 100
		location.href = "/main";
	}else if(mode==2){//move all channel list
		location.href = "/07_Mpage/Channel/allMChannel.jsp";
	}else if(mode==3){//move new channel list
		location.href = "/07_Mpage/Channel/newMChannel.jsp";
	}else if(mode==4){//move search page
		location.href = "/07_Mpage/Search/commonSearch.jsp";
	}
}

CommonM.addCategory = function(startNo, categoryNo){

	if(startNo>=200) return -1;

	var url="/channel?action=getMCategoryList";  
	var params = {
			startNo : startNo,
			categoryNo : categoryNo
	};

	$.ajax({      
		type:"POST",  
		url:url,      
		data:params,  
		dataType:'json',
		success:function(args){   
			for(var i=0; i<args.rankingList.length; i++) {
				$('.rac_m_AllChannel_Contents').append("		<div class='content' onclick='CommonM.m_chn_Detail_Go("+args.rankingList[i].outputChannelNo+")'>\n" + 
        				"		<div class='img'>\n" + 
        				"			<img style='width: 100%;'\n" + 
        				"				src='"+args.rankingList[i].outputChannelThumbnail + "'>\n" + 
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

	if(startNo>=190) 		
		$(".rac_m_bottom").hide();
}

CommonM.addNew = function(startNo, categoryNo){

	if(startNo>=200) return -1;

	var url="/channel?action=getMNewList";  
	var params = {
			startNo : startNo,
			categoryNo : categoryNo
	};

	$.ajax({      
		type:"POST",  
		url:url,      
		data:params,  
		dataType:'json',
		success:function(args){   
			for(var i=0; i<args.rankingList.length; i++) {
				$('.rac_m_NewChannel_Contents').append("		<div class='content' onclick='CommonM.m_chn_Detail_Go("+args.rankingList[i].outputChannelNo+")'>\n" + 
        				"		<div class='img'>\n" + 
        				"			<img style='width: 100%;'\n" + 
        				"				src='"+args.rankingList[i].outputChannelThumbnail + "'>\n" + 
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

	if(startNo>=190) 		
		$(".rac_m_bottom").hide();
}

