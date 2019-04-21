/**
 * RANCRE MOBILE COMMON Js 
 */

var CommonM ={};

CommonM.addList = function(mode, startNo, categoryNo){

	if(mode==1 && startNo>=100) return -1;
	if((mode==2 || mode==3) && startNo>=200) return -1;

	if(mode == 1) {
		var url="/main?action=getRankingList";  
		var params = {
				startNo : startNo,
				mode : mode
		};

		$.ajax({      
			type:"POST",  
			url:url,      
			data:params,  
			dataType:'json',
			success:function(args){   
				for(var i=0; i<args.rankingList.length; i++) {
					$('.content').append(
							"							<div class='content'>\r\n" + 
							"							<div class='img'>\r\n" + 
							"							<img id='chnListThumbNail'\r\n" + 
							"							style='width: 48px; border-radius: 48px;'\r\n" + 
							"							src='"+args.rankingList[i].outputChannelThumbnail +"'>\r\n" + 
							"							</div>\r\n" + 
							"							<div class='rankMainRowCnt'>\r\n" + 
							"							<div class='d-inline-block txt-left rankMainCnt'>"+args.rankingList[i].outputRankTopNo + "위</div>\r\n" + 
							"							<div class='d-inline-block txt-left rankMainDif"+args.rankingList[i].outputRankUpDown + "</div>\r\n" + 
							"							</div>\r\n" + 
							"							<div class='rankMainRowImg'>\r\n" + 
							"							<img id='chnListThumbNail'\r\n" + 
							"							style='width: 48px; border-radius: 48px;'\r\n" + 
							"							src='"+args.rankingList[i].outputChannelThumbnail +"'>\r\n" + 
							"							</div>\r\n" + 
							"							<div class='ranc-Main-Row'>"+args.rankingList[i].outputChannelTitle+"</div>\r\n" + 
							"							<div class='ranc-Main-Row2'>"+args.rankingList[i].outputCategoryNo+"</div>\r\n" + 
							"							<div class='ranc-Main-Row3'>"+args.rankingList[i].outputChannelFollowers+"</div>\r\n" + 
							"							<div class='ranc-Main-Row3'>"+args.rankingList[i].outputChannelViews+"</div>\r\n" + 
							"							<div class='rankMainRowBtn'>\r\n" + 
							"							<a class='chnDtlGo' href='/channel?action=getChannelDetail&inputChannelNo="+args.rankingList[i].outputChannelNo+"'>\r\n"+
							"									<button class='btnChnGo'>채널정보\r\n" + 
							"										보기</button>\r\n" + 
							"								</a>\r\n" + 
							"							</button>\r\n" + 
							"							</div>\r\n" + 
							"							</div>\r\n" + 
							"							<hr\r\n" + 
							"							style='margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;'>\r\n"
					);

				}
			},   
			error:function(e){  
				alert(e.responseText);  
			}  
		});  

	}
	if(mode==1 && startNo>=90) 		
		$(".rac_m_bottom").hide();
}