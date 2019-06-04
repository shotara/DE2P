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

	function mobileCategoryList(categoryNo) {

		var startNo = 0;
		$('.rac_m_AllChannel_Contents').empty();
		CommonM.addCategory(startNo, categoryNo);
		
		$("#rac_m_startNo").val(startNo * 1 + 20);
		$("#rac_m_categoryNo").val(categoryNo);
		if (startNo >= 90)
			$(".rac_m_bottom").hide();
	}

	function moreCategory() {

		var startNo = $("#rac_m_startNo").val();
		var categoryNo = $("#rac_m_categoryNo").val();

		CommonM.addCategory(startNo, categoryNo);

		$("#rac_m_startNo").val(startNo * 1 + 20);
		if (startNo >= 190)
			$(".rac_m_bottom").hide();
	}

	$(document)
			.ready(
					function() {

						$("#rac_m_startNo").val(20);
						$("#rac_m_categoryNo").val(2);

						var url = "/channel?action=getMCategoryList";
						var params = {
							startNo : 0,
							categoryNo : 2
						};

						$
								.ajax({
									type : "POST",
									url : url,
									data : params,
									dataType : 'json',
									success : function(args) {
										for (var i = 0; i < args.rankingList.length; i++) {
											$('.rac_m_AllChannel_Contents')
													.append(
															"		<div class='content' onclick='CommonM.m_chn_Detail_Go()'>\n"
																	+ "		<div class='img'>\n"
																	+ "			<img style='width: 100%;'\n"
																	+ "				src='"
																	+ args.rankingList[i].outputChannelThumbnail
																	+ "'>\n"
																	+ "		</div>\n"
																	+ "		<div class='title_sub'>\n"
																	+ "			<div class='title'>\n"
																	+ "				<span>"
																	+ args.rankingList[i].outputChannelTitle
																	+ "</span>\n"
																	+ "			</div>\n"
																	+ "			<div class='view'>\n"
																	+ "				<span>구독자</span><span>"
																	+ args.rankingList[i].outputChannelFollowers
																	+ "</span>\n"
																	+ "			</div>\n"
																	+ "		</div>\n"
																	+ "		<div class='icon'>\n"
																	+ "			<i class='icon-right-open-mini'></i>\n"
																	+ "		</div>\n"
																	+ "	</div>");
										}

									},
									error : function(e) {
										alert(e.responseText);
									}
								});

					});
</script>
</head>
<body class="mbody">

	<jsp:include page="/07_Mpage/commonMHead.jsp" flush="true" />

	<section id="m-Main-Channel-List">

	<div class="rac_m_AllChannel">
		<div class="rac_m_AllChannel_Top">
			<p class="title">모든 채널</p>
			<span class="content">랭크리에서 수집한 모든 채널입니다</span>
		</div>

		<ul class="rac_m_AllChannel_Mid">
			<li class="list"><input id="0" type="radio" name="list"
				class="ipt_radio_list" checked onclick="mobileCategoryList(2)" /> <label for="0" class="list_label">스튜디오/엔터</label></li>
			<li class="list"><input id="1" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(3)"/><label for="1" class="list_label">예능/토크</label></li>
			<li class="list"><input id="2" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(9)"/><label for="2" class="list_label">여행/일상</label></li>
			<li class="list"><input id="3" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(5)"/><label for="3" class="list_label">노래/댄스</label></li>
			<li class="list"><input id="4" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(6)"/><label for="4" class="list_label">테크/교육</label></li>
			<li class="list"><input id="5" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(7)"/><label for="5" class="list_label">시사/이슈</label></li>
			<li class="list"><input id="6" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(8)"/><label for="6" class="list_label">뷰티</label></li>
			<li class="list"><input id="7" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(10)"/><label for="7" class="list_label">게임</label></li>
			<li class="list"><input id="8" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(11)"/><label for="8" class="list_label">운동/피트니스</label></li>
			<li class="list"><input id="9" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(12)"/><label for="9" class="list_label">먹방/쿡방</label></li>
			<li class="list"><input id="10" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(13)"/><label for="10" class="list_label">키즈</label></li>
			<li class="list"><input id="11" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(14)"/><label for="11" class="list_label">반려동물</label></li>
			<li class="list"><input id="12" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(15)"/><label for="12" class="list_label">ASMR</label></li>
			<li class="list"><input id="13" type="radio" name="list"
				class="ipt_radio_list" onclick="mobileCategoryList(16)"/><label for="13" class="list_label">취미/예술</label></li>
		</ul>


		<div class="rac_m_AllChannel_Contents">

		</div>

	</div>

	<div class="rac_m_bottom">
		<div class="rac_m_more_channel">
			<button class="commonMobileBtn" onclick="moreCategory()">
				more</button>
			<input type="hidden" id="rac_m_startNo">
			<input type="hidden" id="rac_m_categoryNo">
		</div>
	</div>

	</section>

	<jsp:include page="/07_Mpage/commonMFooter.jsp" flush="true" />

</body>
</html>