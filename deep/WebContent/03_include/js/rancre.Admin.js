/**
 * 
 */
var Admin ={};

/******************************/
/** search page using         */
/******************************/

Admin.search = function (mode){

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

		if(keyPressed==13 || keyPressed==10) {
			$("#inputChannelName").val(channelName);
			document.getElementById('searchChannelForm').submit();
			return; 

		}
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
					publicKeyModulus = response.racPublicKeyModulus;
					publicKeyExponent = response.racPublicKeyExponent;
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


Admin.review = function(mode, reviewNo) {

	var form_data = {
			inputReviewNo : reviewNo,
			inputReviewStatus : mode
	};

	$.ajax({
		type:"POST",
		url: "/admin?action=setReviewStatus",
		data:form_data,
		dataType: "json",
		async : false,
		success: function(response) {

			if(response.outputResult == "1") { 
				alert("상태 변경완료.");
				location.href = "/admin?action=getAdminMain";
			} else {
				alert("알수없는 문제가 발생했습니다.");
			}
		}
	});
	return; 
}

