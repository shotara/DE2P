/**
 * 
 */
var Common ={};

Common.addList = function (mode, startNo, categoryNo) {
	
	if(mode==1 && startNo>=100) return;
	if((mode==2 || mode==3) && startNo>=200) return;
	
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
					$('.chnContents').append(`
							<div id="chnContent" class="w-auto ml-auto">
							<div class="rankMainRowCnt">
								<div class="d-inline-block rankMainCnt">`+args.rankingList[i].outputRankTopNo + `위</div>
								<div class="d-inline-block rankMainDif">-</div>
							</div>
							<div class="rankMainRowImg">
								<img id="chnListThumbNail"
									style="width: 48px; border-radius: 48px;"
									src="`+args.rankingList[i].outputChannelThumbnail +`">
							</div>
							<div class="rankMainRow">`+args.rankingList[i].outputChannelTitle+`</div>
							<div class="rankMainRow">#`+args.rankingList[i].outputCategoryNo+`</div>
							<div class="rankMainRow">`+args.rankingList[i].outputChannelFollowers+`</div>
							<div class="rankMainRow">`+args.rankingList[i].outputChannelViews+`</div>
							<div class="rankMainRow2">`+args.rankingList[i].outputChannelVideoCount+`</div>
							<div class="rankMainRowBtn">
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
	} else if(mode==2){
		var url="/main?action=getRankingList";  
	    var params = {
	    	startNo : startNo,
	    	mode : mode,
	    	categoryNo : categoryNo
	    };
	    
	    $.ajax({      
	        type:"POST",  
	        url:url,      
	        data:params,  
	        dataType:'json',
	        success:function(args){   
	        	for(var i=0; i<args.rankingList.length; i++) {
	        		var content = `
						<div id="chnContent" class="w-auto ml-auto">
						<div class="rankMainRowCnt">
							<div class="d-inline-block rankMainCnt">`+args.rankingList[i].outputRankTopNo + `위</div>
							<div class="d-inline-block rankMainDif">-</div>
						</div>
						<div class="rankMainRowImg">
							<img id="chnListThumbNail"
								style="width: 48px; border-radius: 48px;"
								src="`+args.rankingList[i].outputChannelThumbnail +`">
						</div>
						<div class="rankMainRow">`+args.rankingList[i].outputChannelTitle+`</div>
						<div class="rankMainRow">#`+args.rankingList[i].outputCategoryNo+`</div>
						<div class="rankMainRow">`+args.rankingList[i].outputChannelFollowers+`</div>
						<div class="rankMainRow">`+args.rankingList[i].outputChannelViews+`</div>
						<div class="rankMainRow2">`+args.rankingList[i].outputChannelVideoCount+`</div>
						<div class="rankMainRowBtn">
							<button class="btnChnGo">
								<a class="chnDtlGo" href="/02_page/Channel/channelDetail.jsp">채널정보
									보기</a>
							</button>
						</div>
					</div>
					<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
				</div>
						`;
					switch(categoryNo) {
					case 1:
						$("#studio .chnContents").append(content);
						break;
					case 2:
						$("#entertain .chnContents").append(content);
						break;
					case 3:
						$("#travel .chnContents").append(content);
						break;
					case 4:
						$("#singdance .chnContents").append(content);
						break;
					case 5:
						$("#tech .chnContents").append(content);
						break;
					case 6:
						$("#education .chnContents").append(content);
						break;
					case 7:
						$("#beauty .chnContents").append(content);
						break;
					case 8:
						$("#daylife .chnContents").append(content);
						break;
					case 9:
						$("#game .chnContents").append(content);
						break;
					case 10:
						$("#sports .chnContents").append(content);
						break;
					case 11:
						$("#food .chnContents").append(content);
						break;
					case 12:
						$("#kids .chnContents").append(content);
						break;
					case 13:
						$("#pet .chnContents").append(content);
						break;
					case 14:
						$("#exercise .chnContents").append(content);
						break;
					case 15:
						$("#habbit .chnContents").append(content);
						break;
					}
	        	}
	
	        },   
	        error:function(e){  
	            alert(e.responseText);  
	        }  
	    });  
	} else if(mode==3) {
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
					$('.chnContents').append(`
							<div id="chnContent" class="w-auto ml-auto">
							<div class="rankMainRowCnt">
								<div class="d-inline-block rankMainCnt">`+args.rankingList[i].outputRankTopNo + `위</div>
								<div class="d-inline-block rankMainDif">-</div>
							</div>
							<div class="rankMainRowImg">
								<img id="chnListThumbNail"
									style="width: 48px; border-radius: 48px;"
									src="`+args.rankingList[i].outputChannelThumbnail +`">
							</div>
							<div class="rankMainRow">`+args.rankingList[i].outputChannelTitle+`</div>
							<div class="rankMainRow">#`+args.rankingList[i].outputCategoryNo+`</div>
							<div class="rankMainRow">`+args.rankingList[i].outputChannelFollowers+`</div>
							<div class="rankMainRow">`+args.rankingList[i].outputChannelViews+`</div>
							<div class="rankMainRow2">`+args.rankingList[i].outputChannelVideoCount+`</div>
							<div class="rankMainRowBtn">
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
	}
	
	if(mode==1 && startNo>=90) 		
		$(".btnListGo").hide();
	if((mode==2 || mode==3) && startNo>=890)
		$(".btnListGo").hide();

}
/** channel Detail page using
 */

$(function() {
	$('ul.sub-tabs li a').click(function() {
		var activeTab = $(this).attr('data-tab');
		$('ul.sub-tabs li a').removeClass('active');
		$('.sub-tabcontent').removeClass('active');
		$(this).addClass('active');
		$('#' + activeTab).addClass('active');
	})
});

$(function() {
	$('div.subNav-tab a').click(function() {
		var activeTab = $(this).attr('data-tab');
		$('div.subNav-tab a').removeClass('active');
		$('.subNav-content').removeClass('active');
		$(this).addClass('active');
		$('#' + activeTab).addClass('active');
	})
});