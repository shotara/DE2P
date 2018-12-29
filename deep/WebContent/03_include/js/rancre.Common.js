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
							<div class="rankMainRow">`+args.rankingList[i].outputCategoryNo+`</div>
							<div class="rankMainRow">`+args.rankingList[i].outputChannelFollowers+`</div>
							<div class="rankMainRow">`+args.rankingList[i].outputChannelViews+`</div>
							<div class="rankMainRow2">`+args.rankingList[i].outputChannelVideoCount+`</div>
							<div class="rankMainRowBtn">
							<button class="btnChnGo">
							<a class="chnDtlGo" href="/channel?action=getChannelDetail&inputChannelNo=`+args.rankingList[i].outputChannelNo+`">채널정보
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
						<div class="rankRowImg">
						<img id="chnListThumbNail"
						style="width: 48px; border-radius: 48px;"
						src="`+args.rankingList[i].outputChannelThumbnail +`">
						</div>
						<div class="rankRow">`+args.rankingList[i].outputChannelTitle+`</div>
						<div class="rankRow">`+args.rankingList[i].outputCategoryNo+`</div>
						<div class="rankRow">`+args.rankingList[i].outputChannelFollowers+`</div>
						<div class="rankRow">`+args.rankingList[i].outputChannelViews+`</div>
						<div class="rankRow2">`+args.rankingList[i].outputChannelVideoCount+`</div>
						<div class="rankRowBtn">
						<button class="btnChnGo">
						<a class="chnDtlGo" href="/channel?action=getChannelDetail&inputChannelNo=`+args.rankingList[i].outputChannelNo+`">채널정보
						보기</a>
						</button>
						</div>
						</div>
						<hr
						style="margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;">
						</div>
						`;
					switch(categoryNo) {
					case 2:
						$("#studio .chnContents").append(content);
						break;
					case 3:
						$("#entertain .chnContents").append(content);
						break;
					case 4:
						$("#travel .chnContents").append(content);
						break;
					case 5:
						$("#singdance .chnContents").append(content);
						break;
					case 6:
						$("#tech .chnContents").append(content);
						break;
					case 7:
						$("#education .chnContents").append(content);
						break;
					case 8:
						$("#beauty .chnContents").append(content);
						break;
					case 9:
						$("#daylife .chnContents").append(content);
						break;
					case 10:
						$("#game .chnContents").append(content);
						break;
					case 11:
						$("#sports .chnContents").append(content);
						break;
					case 12:
						$("#food .chnContents").append(content);
						break;
					case 13:
						$("#kids .chnContents").append(content);
						break;
					case 14:
						$("#pet .chnContents").append(content);
						break;
					case 15:
						$("#exercise .chnContents").append(content);
						break;
					case 16:
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
							<div class="rankRowImg">
							<img id="chnListThumbNail"
							style="width: 48px; border-radius: 48px;"
							src="`+args.rankingList[i].outputChannelThumbnail +`">
							</div>
							<div class="rankRow">`+args.rankingList[i].outputChannelTitle+`</div>
							<div class="rankRow">`+args.rankingList[i].outputCategoryNo+`</div>
							<div class="rankRow">`+args.rankingList[i].outputChannelFollowers+`</div>
							<div class="rankRow">`+args.rankingList[i].outputChannelViews+`</div>
							<div class="rankRow2">`+args.rankingList[i].outputChannelVideoCount+`</div>
							<div class="rankRowBtn">
							<button class="btnChnGo">
							<a class="chnDtlGo" href="/channel?action=getChannelDetail&inputChannelNo=`+args.rankingList[i].outputChannelNo+`">채널정보
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

Common.review = function (mode){
	
	if(mode==1){
		/**move next-page **/
		var review_step1 = document.getElementById('review-Step1');
		var review_step2 = document.getElementById('review-Step2');
	    review_step1.style.display = 'none';
		review_step2.style.display = 'block';
	}
	else if(mode==2){
		/**move pre-page **/
		var review_step1 = document.getElementById('review-Step1');
		var review_step2 = document.getElementById('review-Step2');
	    review_step1.style.display = 'block';
		review_step2.style.display = 'none';
	}
	else if(mode==3){
		return;
	}
	
}

/******************************/
/** channel Detail page using */
/*****************************/


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


/******************************/
/** search page using */
/*****************************/

jQuery(function($) {


	// /////
	// CLEARABLE INPUT
	function tog(v){return v?'addClass':'removeClass';} 
	$(document).on('input', '.clearable', function(){
		$(this)[tog(this.value)]('x');
	}).on('mousemove', '.x', function( e ){
		$(this)[tog(this.offsetWidth-18 < e.clientX-this.getBoundingClientRect().left)]('onX');   
	}).on('touchstart click', '.onX', function( ev ){
		ev.preventDefault();
		$(this).removeClass('x onX').val('').change();
	});


});