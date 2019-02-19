/**
 * 
 */
var Common ={};

Common.addList = function (mode, startNo, categoryNo) {

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
					$('.chnContents').append(
							"							<div id='chnContent' class='w-auto ml-auto'>\r\n" + 
							"							<div class='rankMainRowCnt'>\r\n" + 
							"							<div class='d-inline-block rankMainCnt'>"+args.rankingList[i].outputRankTopNo + "위</div>\r\n" + 
							"							<div class='d-inline-block rankMainDif'>"+args.rankingList[i].outputRankUpDown + "</div>\r\n" + 
							"							</div>\r\n" + 
							"							<div class='rankMainRowImg'>\r\n" + 
							"							<img id='chnListThumbNail'\r\n" + 
							"							style='width: 48px; border-radius: 48px;'\r\n" + 
							"							src='"+args.rankingList[i].outputChannelThumbnail +"'>\r\n" + 
							"							</div>\r\n" + 
							"							<div class='ranc-Main-Row'>"+args.rankingList[i].outputChannelTitle+"</div>\r\n" + 
							"							<div class='ranc-Main-Row2'>"+args.rankingList[i].outputCategoryNo+"</div>\r\n" + 
							"							<div class='ranc-Main-Row'>"+args.rankingList[i].outputChannelFollowers+"</div>\r\n" + 
							"							<div class='ranc-Main-Row'>"+args.rankingList[i].outputChannelViews+"</div>\r\n" + 
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
					var content = 
						"						<div id='chnContent' class='w-auto ml-auto'>\r\n" + 
						"						<div class='rankRowImg'>\r\n" + 
						"						<img id='chnListThumbNail'\r\n" + 
						"						style='width: 48px; border-radius: 48px;'\r\n" + 
						"						src='"+args.rankingList[i].outputChannelThumbnail +"'>\r\n" + 
						"						</div>\r\n" + 
						"						<div class='ranc-Row3'>"+args.rankingList[i].outputChannelTitle+"</div>\r\n" + 
						"						<div class='ranc-Row2'>"+args.rankingList[i].outputCategoryNo+"</div>\r\n" + 
						"						<div class='ranc-Row'>"+args.rankingList[i].outputChannelFollowers+"</div>\r\n" + 
						"						<div class='ranc-Row'>"+args.rankingList[i].outputChannelViews+"</div>\r\n" + 
						"						<div class='rankRowBtn'>\r\n" + 
						"						<a class='chnDtlGo' href='/channel?action=getChannelDetail&inputChannelNo="+args.rankingList[i].outputChannelNo+"'>\r\n"+
	        				"									<button class='btnChnGo'>채널정보\r\n" + 
	        				"										보기</button>\r\n" + 
	        				"								</a>\r\n" +
						"						</div>\r\n" + 
						"						</div>\r\n" + 
						"						<hr\r\n" + 
						"						style='margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;'>\r\n"
						;
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
						$("#asmr .chnContents").append(content);
						break;
					case 16:
						$("#habbit .chnContents").append(content);
						break;
					}
				}

				if(args.rankingList.length < 20) {
					switch(categoryNo) {
					case 2:
						$("#studio .btnListGo").hide();
						break;
					case 3:
						$("#entertain .btnListGo").hide();
						break;
					case 4:
						$("#travel .btnListGo").hide();
						break;
					case 5:
						$("#singdance .btnListGo").hide();
						break;
					case 6:
						$("#tech .btnListGo").hide();
						break;
					case 7:
						$("#education .btnListGo").hide();
						break;
					case 8:
						$("#beauty .btnListGo").hide();
						break;
					case 9:
						$("#daylife .btnListGo").hide();
						break;
					case 10:
						$("#game .btnListGo").hide();
						break;
					case 11:
						$("#sports .btnListGo").hide();
						break;
					case 12:
						$("#food .btnListGo").hide();
						break;
					case 13:
						$("#kids .btnListGo").hide();
						break;
					case 14:
						$("#pet .btnListGo").hide();
						break;
					case 15:
						$("#asmr .btnListGo").hide();
						break;
					case 16:
						$("#habbit .btnListGo").hide();
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
					$('.chnContents').append(
							"							<div id='chnContent' class='w-auto ml-auto'>\r\n" + 
							"							<div class='rankRowImg'>\r\n" + 
							"							<img id='chnListThumbNail'\r\n" + 
							"							style='width: 48px; border-radius: 48px;'\r\n" + 
							"							src='"+args.rankingList[i].outputChannelThumbnail +"'>\r\n" + 
							"							</div>\r\n" + 
							"							<div class='ranc-Row3'>"+args.rankingList[i].outputChannelTitle+"</div>\r\n" + 
							"							<div class='ranc-Row2'>"+args.rankingList[i].outputCategoryNo+"</div>\r\n" + 
							"							<div class='ranc-Row'>"+args.rankingList[i].outputChannelFollowers+"</div>\r\n" + 
							"							<div class='ranc-Row'>"+args.rankingList[i].outputChannelViews+"</div>\r\n" + 
							"							<div class='rankRowBtn'>\r\n" + 
							"							<a class='chnDtlGo' href='/channel?action=getChannelDetail&inputChannelNo="+args.rankingList[i].outputChannelNo+"'>\r\n"+
	        				"									<button class='btnChnGo'>채널정보\r\n" + 
	        				"										보기</button>\r\n" + 
	        				"								</a>\r\n" + 
							"							</div>\r\n" + 
							"							</div>\r\n" + 
							"							<hr\r\n" + 
							"							style='margin-top: 1rem; margin-bottom: 1rem; border: 0; border-top: 1px solid #fafafa; box-shadow: 0 0px 2px 0px #fafafa;'>\r\n"
					);

				}

				if(args.rankingList.length < 20) {
					switch(categoryNo) {
					case 2:
						$("#studio .btnListGo").hide();
						break;
					case 3:
						$("#entertain .btnListGo").hide();
						break;
					case 4:
						$("#travel .btnListGo").hide();
						break;
					case 5:
						$("#singdance .btnListGo").hide();
						break;
					case 6:
						$("#tech .btnListGo").hide();
						break;
					case 7:
						$("#education .btnListGo").hide();
						break;
					case 8:
						$("#beauty .btnListGo").hide();
						break;
					case 9:
						$("#daylife .btnListGo").hide();
						break;
					case 10:
						$("#game .btnListGo").hide();
						break;
					case 11:
						$("#sports .btnListGo").hide();
						break;
					case 12:
						$("#food .btnListGo").hide();
						break;
					case 13:
						$("#kids .btnListGo").hide();
						break;
					case 14:
						$("#pet .btnListGo").hide();
						break;
					case 15:
						$("#asmr .btnListGo").hide();
						break;
					case 16:
						$("#habbit .btnListGo").hide();
						break;
					}
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

/******************************/
/** Go channel Detail page   **/
/******************************/




/******************************/
/** Review page using         */
/******************************/

Common.review = function (mode){

	if(mode==1){
		var channelName = $("#Input-Channel-Name").val();
		if (channelName=="") {
			alert("채널명을 입력해주세요.");
			return;
		}

		var channelPrice = $("#Input-Commercial-Price").val();
		if (channelPrice=="") {
			alert("광고 집행비용을 입력해주세요.");
			return;
		}
		if(isNaN(channelPrice) == true) {
			alert("숫자만 입력해주세요.");
			return;
		} 

		var channelText = $("#Input-Commercial-Text").val();
		if (channelText=="") {
			alert("리뷰 내용을 입력해주세요.");
			return;
		}

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
	else if(mode==3){ //confirm the review

		var publicKeyModulus = "";
		var publicKeyExponent = "";

		$.ajax({
			type : "POST",
			url : "/main?action=getRSAPublicKey",
			dataType : "json",
			async: false,
			success: function(response) {
				publicKeyModulus = response.deepPublicKeyModulus;
				publicKeyExponent = response.deepPublicKeyExponent;
			}, error: function(xhr,status,error) {
				alert(error);
			}
		});

		var rsa = new RSAKey();
		rsa.setPublic(publicKeyModulus, publicKeyExponent);

		var channelName = $("#Input-Channel-Name").val();
		var channelSatisfy = $('input[name="commercial-satisfy"]:checked').val();
		var commercialDate1 = $("#commercial-Date1").val();
		var commercialDate2 = $("#commercial-Date2").val();
		var commercialType = $("#commercial-Type").val();
		var commercialPrice = $("#Input-Commercial-Price").val();
		var commercialUrl = $("#Input-Commercial-Url").val();
		var channelText = $("#Input-Commercial-Text").val();

		var targetReach = $("#success-reach").val();
		var targetConvert = $("#success-convert").val();
		var targetType = $("#success-itemType").val();
		var targetAge = $("#success-age").val();
		var targetSex = $("#success-sex").val();
		var channelRecomand = $('input[name="channel-recommand"]:checked').val();
		var channelReuse = $('input[name="channel-Reuse"]:checked').val();

		var encryptChannelName = rsa.encrypt(channelName);
		var encryptCommercialUrl = rsa.encrypt(commercialUrl);
		var encryptChannelText = rsa.encrypt(channelText);

		var form_data = {
				inputChannelName : encryptChannelName,
				inputReviewSatisfy : channelSatisfy,
				inputReviewDate1 : commercialDate1,
				inputReviewDate2 : commercialDate2,
				inputChannelAdType : commercialType,
				inputChannelCostPrice : commercialPrice,
				inputChannelAdUrl : encryptCommercialUrl,
				inputReviewDetail : encryptChannelText,
				inputReviewTargetReach : targetReach,
				inputReviewTargetConvert : targetConvert,
				inputChannelAdCategory : targetType,
				inputReviewTargetAge : targetAge,
				inputReviewTargetSex : targetSex,
				inputReviewRecomand : channelRecomand,
				inputReviewAdAgain : channelReuse
		};

		$.ajax({
			type:"POST",
			url: "/channel?action=addReview",
			data:form_data,
			dataType: "json",
			async : false,
			success: function(response) {

				if(response.outputResult == "1") {
					alert("리뷰가 등록되었습니다.");
					location.href = "/";
				} else {
					alert("알수없는 문제가 발생했습니다.");
				}
			}
		});
		return;
	}
	else if(mode==4){
		var check_cancel = confirm("리뷰는 다른 마케터에게 큰 도움이 됩니다. 리뷰 등록을 취소하겠습니까?");

		if(check_cancel){//don't want to write review, go index page
			location.href="/index.jsp";
			check_cancel = true;
		}else{//leave review page
			check_cancel = false;
		}
	}
	else if(mode==5){ //채널명 자동완성

		var channelName = protectXSS($("#Input-Channel-Name").val());

		$("#Input-Channel-Name").autocomplete({
			source : function(request, response) {
				$.ajax({
					type : 'post',
					url : "/channel?action=autoCompleteChannel",
					dataType : "json",
					async : true,
					data : {
						inputChannelTitle : channelName
					},
					success : function(data) {
						//서버에서 json 데이터 response 후 목록에 뿌려주기 위함, 한글 데이터가 지금 깨지고 있는 것 같은데 확인 필
						response($.map(data.outputResult, function(item) {
							return {
								label : item.outputChannelTitle,
								value : item.outputChannelTitle,
							}
						}));
					}
				});
			},
			//조회를 위한 최소글자수 1로 해야함 한글자짜리 활성화 된 채널 2개 존재함 유튜브 채널 타이틀 정책 쓰레기임 한글자가 뭐냐 ex, '벨'이라는 유튜버 있음 
			minLength : 1
		});
	} else if(mode==6) {
		alert("epgpt");
	}
};

/******************************/
/** channel Detail page using */
/*****************************/


$(function() {
	$('div.detail-tab a').click(function() {
		var activeTab = $(this).attr('data-tab');
		$('div.detail-tab a').removeClass('active');
		$('div.sub-tabcontent').removeClass('active');
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
/** search page using         */
/******************************/

Common.search = function (mode){

	if(mode == 1){ /** clear input value and remove x button **/
		const elem = document.getElementById('clear-btn');
		const ipt_clear = document.getElementById('ipt-Search');
		elem.style.display = 'none';
		ipt_clear.style.width = 'auto';
		ipt_clear.value = '';
	}
	else if (mode == 2) {
		var keyPressed = (event.keyCode ? event.keyCode : event.which);
		var channelName = protectXSS($("#ipt-Search").val());
		$("#inputChannelName").val(channelName);
		 var ua = navigator.userAgent;
//		 alert(ua.indexOf("windows"));
//		 alert(ua.indexOf("Mac"));
//		if(keyPressed==13 || keyPressed==10) {
//			document.getElementById('searchChannelForm').submit();
//		}
//			var publicKeyModulus = "";
//			var publicKeyExponent = "";
//			$.ajax({
//				type : "POST",
//				url : "/main?action=getRSAPublicKey",
//				dataType : "json",
//				async: false,
//				success: function(response) {
//					publicKeyModulus = response.deepPublicKeyModulus;
//					publicKeyExponent = response.deepPublicKeyExponent;
//					
//					var rsa = new RSAKey();
//					rsa.setPublic(publicKeyModulus, publicKeyExponent);
//
//					var encryptChannelName = rsa.encrypt(channelName);
//					$("#inputChannelName").val(encryptChannelName);
//					document.getElementById('searchChannelForm').submit();
//					return; 
//				}, error: function(xhr,status,error) {
//					alert(error);
//				}
//			});
//		}
	}
	else if (mode == 3) { /** modal popup Open **/
		const modal = document.getElementById('req-Search-Modal');
		const modal_content = document.getElementById('req-Search-Modal-Content');
		modal.style.display = 'block';
		modal_content.style.display = 'block';

		/** window.onclick = function(event) {
			if (event.target == modal) {
				modal_content.style.display = 'none';
				modal.style.display = 'none';
			}
		} **/
	}
	else if (mode == 4) { /** modal popup Close **/
		const modal = document.getElementById('req-Search-Modal');
		const modal_content = document.getElementById('req-Search-Modal-Content');
		modal.style.display = 'none';
		modal_content.style.display = 'none';
		// When the user clicks on <span> (x), close the modal
	}
	else if (mode == 5) { /**request channel search **/
		var req_Channel_Url = $("#ipt-Req-Search-Channel").val();
		var check_Channel_Url1 = "www.youtube.com/user/";
		var check_Channel_Url2 = "www.youtube.com/channel/";

		if (req_Channel_Url=="") {
			alert("채널 URL을 입력해주세요.");
			return;
		}
		else if (req_Channel_Url.length < 22){ /** Url 형식 검사  **/
			//url이 지나치게 짧은 경우
			alert("채널 URL을 정확히 입력해주세요.")
			return;
		}else if (req_Channel_Url.indexOf(check_Channel_Url1) == -1 && req_Channel_Url.indexOf(check_Channel_Url2) == -1){
			//url 내 www.youtube.com/user/가 들어갔는지 검사
			//또는 url 내 www.youtube.com/channel/가 들어갔는지 검사
			alert("채널 URL을 정확히 입력해주세요.");
			return;
		}
		else {  //채널 URL이 기본적으로 유요한 경우 진입

			var publicKeyModulus = "";
			var publicKeyExponent = "";

			$.ajax({
				type : "POST",
				url : "/main?action=getRSAPublicKey",
				dataType : "json",
				async: false,
				success: function(response) {
					publicKeyModulus = response.deepPublicKeyModulus;
					publicKeyExponent = response.deepPublicKeyExponent;
				}, error: function(xhr,status,error) {
					alert(error);
				}
			});

			var rsa = new RSAKey();
			rsa.setPublic(publicKeyModulus, publicKeyExponent);

			var encryptChannelUrl = rsa.encrypt(req_Channel_Url);

			var form_data = {
					inputChannelUrl : encryptChannelUrl
			};

			$.ajax({
				type:"POST",
				url: "/channel?action=searchChannelUrl",
				data:form_data,
				dataType: "json",
				async : false,
				success: function(response) {

					if(response.outputResult == "1") { /** 정상적으로 채널이 수집되었을 경우 **/ 
						alert("채널 수집이 정상적으로 요청되었습니다.랭크리에서 채널 정보가 노출되기까지 최대 24시간이 걸릴 수 있습니다.");
						location.href = "/";
					} else if(response.outputResult == "-1"){
						alert("이미 존재하는 채널입니다. 검색을 통해서 채널을 확인해보세요!");
					}else {
						alert("알수없는 문제가 발생했습니다.");
					}
				}
			});
			return; 
		}

	}
}

/**************************************/
/** contact us(footer) page using     */
/**************************************/

Common.contactUs = function (mode){

	if(mode == 1){//open contact us modal
		const modal = document.getElementById('con-Us-Modal');
		const modal_content = document.getElementById('con-Us-Modal-Content');
		modal.style.display = 'block';
		modal_content.style.display = 'block';

		/** window.onclick = function(event) {
			if (event.target == modal) {
				modal_content.style.display = 'none';
				modal.style.display = 'none';
			}
		} **/
	}else if(mode == 2){//close contact us modal
		const modal = document.getElementById('con-Us-Modal');
		const modal_content = document.getElementById('con-Us-Modal-Content');
		modal.style.display = 'none';
		modal_content.style.display = 'none';
		// When the user clicks on <span> (x), close the modal
	}else if(mode == 3){

		var publicKeyModulus = "";
		var publicKeyExponent = "";

		$.ajax({
			type : "POST",
			url : "/main?action=getRSAPublicKey",
			dataType : "json",
			async: false,
			success: function(response) {
				publicKeyModulus = response.deepPublicKeyModulus;
				publicKeyExponent = response.deepPublicKeyExponent;
			}, error: function(xhr,status,error) {
				alert(error);
			}
		});

		var rsa = new RSAKey();
		rsa.setPublic(publicKeyModulus, publicKeyExponent);

		var inputEmail = $("#ipt-con-Us-Email").val();
		var inputContent = $("#Input-Contact-Text").val();

		var encryptEmail = rsa.encrypt(inputEmail);
		var encryptContent = rsa.encrypt(inputContent);

		var form_data = {
				inputEmail : encryptEmail,
				inputContent : encryptContent
		};

		$.ajax({
			type:"POST",
			url: "/main?action=contactUs",
			data:form_data,
			dataType: "json",
			async : false,
			success: function(response) {
				if(response.outputResult == "1") { /** 정상적으로 채널이 수집되었을 경우 **/ 
					alert("문의가 접수되었습니다! 빠른 시일 안에 연락드리겠습니다.");
					location.href = "/";
				}else {
					alert("알수없는 문제가 발생했습니다.");
				}
			}
		});
	}
}

/**************************************/
/** Like channel     */
/**************************************/

Common.Like = function (mode, no){

	if(mode == 1){
		// 좋아요 
		var form_data = {
				inputChannelNo : no
		};

		$.ajax({
			type:"POST",
			url: "/channel?action=addChannelLike",
			data:form_data,
			dataType: "json",
			async : false,
			success: function(response) {

				if(response.outputResult == "1") { 
					location.reload();
				} else if(response.outputResult == "-3"){
					alert("이미 관심채널이 설정 되어있습니다.");
				}else {
					alert("알수없는 문제가 발생했습니다.");
				}
			}
		});
	}

	else if(mode == 2){
		// 취소 
		var form_data = {
				inputChannelNo : no
		};

		$.ajax({
			type:"POST",
			url: "/channel?action=deleteChannelLike",
			data:form_data,
			dataType: "json",
			async : false,
			success: function(response) {

				if(response.outputResult == "1") { 
					location.reload();
				} else if(response.outputResult == "-3"){
					alert("관심채널이 아닙니다.");
				}else {
					alert("알수없는 문제가 발생했습니다.");
				}
			}
		});		
	}
}


/******************************/
/** Common utility            */
/******************************/


