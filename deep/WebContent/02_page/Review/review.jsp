<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />
<jsp:include page="/02_page/commonContactUs.jsp" flush="true" />
<script>
	var sessionCheck = "${sessionScope.racMemberUid}";
	if (sessionCheck == "") {
		alert("로그인이 필요합니다.");
		location.href = "/02_page/Auth/login.jsp"
	}
</script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col txt-center">
				<div class="txt-center channel-review">

					<div class="common-brand">Rancre</div>

					<div class="review-step1" id="review-Step1">

						<div class="pTop">
							<span>광고 리뷰를 작성하시면 다른 채널의 리뷰를 바로 확인할 수 있습니다! </br> 외부에 노출되는 모든
								리뷰는 익명처리됩니다!
							</span>
						</div>

						<div class="ipt-channel-review pTop3">
							<div class="txt-left review-commonTxt2">
								채널 이름<span class="primary-color">*</span>
							</div>
							<div class="txt-left review-commonSubTxt">광고한 채널의 이름을
								입력해주세요!</div>
							<div class="channel-autocomplete">
								<input class="ipt-Common-Review" type="text"
									id="Input-Channel-Name" placeholder="Ex) 와썹맨, Dana " required
									onkeyup="Common.review(5)" />
							</div>
						</div>

						<div class="ipt-channel-review review-radio pTop2">
							<div class="float-left review-commonTxt inline-block">
								종합 만족도<span class="primary-color">*</span>
							</div>

							<div class="float-right flow-hidden">
								<div class="radio-item">
									<input type="radio" id="commercial-verySatisfy"
										name="commercial-satisfy" value="0" checked> <label
										for="commercial-verySatisfy">매우 만족</label>
								</div>

								<div class="radio-item">
									<input type="radio" id="commercial-Satisfy"
										name="commercial-satisfy" value="1"> <label
										for="commercial-Satisfy">만족</label>
								</div>
								<div class="radio-item">
									<input type="radio" id="commercial-normal"
										name="commercial-satisfy" value="2"> <label
										for="commercial-normal">보통</label>
								</div>
								<div class="radio-item">
									<input type="radio" id="commercial-unSatisfy"
										name="commercial-satisfy" value="3"> <label
										for="commercial-unSatisfy">불만족</label>
								</div>
								<div class="radio-item">
									<input type="radio" id="commercial-veryunSatisfy"
										name="commercial-satisfy" value="4"> <label
										for="commercial-veryunSatisfy">매우 불만족</label>
								</div>

							</div>
						</div>

						<div class="ipt-channel-review pTop">

							<div class="txt-left review-commonTxt2 inline-block">
								광고 집행 일자<span class="primary-color">*</span>
							</div>
							<div class="txt-left review-commonSubTxt">입력한 일자는 년도만 노출되며,
								1~3년 이내 3년 ~ 5년 이내 등으로 표기됩니다.</div>
							<div class="inline-flex w100">
								<select class="ipt-Select-Date" id="commercial-Date1">
									<option value="1">2019년</option>
									<option value="2">2018년</option>
									<option value="3">2017년</option>
									<option value="4">2016년</option>
									<option value="5">2015년</option>
									<option value="6">2014년</option>
									<option value="7">2013년</option>
									<option value="8">2012년</option>
									<option value="9">2011년</option>
									<option value="10">2010년</option>
								</select>
								<div class="pRight"></div>
								<select class="ipt-Select-Date" id="commercial-Date2">
									<option value="1">1월</option>
									<option value="2">2월</option>
									<option value="3">3월</option>
									<option value="4">4월</option>
									<option value="5">5월</option>
									<option value="6">6월</option>
									<option value="7">7월</option>
									<option value="8">8월</option>
									<option value="9">9월</option>
									<option value="10">10월</option>
									<option value="11">11월</option>
									<option value="12">12월</option>

								</select>
							</div>

						</div>

						<div class="ipt-channel-review pTop2">

							<div class="txt-left review-commonTxt2 inline-block">
								광고 집행 비용<span class="primary-color">*</span>
							</div>
							<div class="txt-left review-commonSubTxt">광고 비용을 입력한 리뷰를
								작성하면 다른 채널의 광고 비용을 확인 할 수 있습니다.</div>
							<div class="inline-flex w100">
								<select class="ipt-Select-CommercialType" id="commercial-Type">
									<option value="0">영상 콘텐츠</option>
									<option value="1">배너 광고</option>
									<option value="2">기타</option>
								</select>
								<div class="pRight"></div>
								<input class="ipt-Commercial-Price" type="text"
									id="Input-Commercial-Price" placeholder="10,000,000" required />

							</div>

						</div>

						<div class="ipt-channel-review pTop2">

							<div class="txt-left review-commonTxt2 inline-block">광고 영상
								URL</div>
							<div class="txt-left review-commonSubTxt">입력한 광고 URL은 리뷰
								검증에만 사용되며, 입력한 리뷰와 연동되지 않습니다.</div>
							<input class="ipt-Common-Review" type="text"
								id="Input-Commercial-Url"
								placeholder="http://youtube.com/example" required />
						</div>


						<div class="ipt-channel-review pTop2">

							<div class="txt-left review-commonTxt2 inline-block">
								채널 리뷰<span class="primary-color">*</span>
							</div>
							<div class="txt-left review-commonSubTxt">모든 리뷰는 익명처리되며,
								심사를 거쳐 수정될 수 있습니다.</div>
							<textarea class="w100 review-TextArea" col="1" row="1"
								id="Input-Commercial-Text"
								placeholder="광고 리뷰를 등록하고, 다른 채널의 광고 이용 리뷰를 확인해보세요!"></textarea>
						</div>

						<div class="pTop2 flow-hidden">
							<button class="float-left common-wide20Reverse-Btn pRight"
								type="button" onclick="Common.review(4)">취소</button>
							<button class="float-right common-wide75-Btn" type="button"
								onclick="Common.review(1)">다음</button>
						</div>
					</div>

					<div class="review-step2" id="review-Step2">

						<div class="pTop">
							<span>거의 다 작성하였습니다! </br> 작성한 리뷰는 다른 마케터들에게 큰 도움이 됩니다!
							</span>
						</div>

						<div class="ipt-channel-review pTop3">

							<div class="txt-left review-commonTxt2 inline-block">
								도달률(조회수)<span class="primary-color">*</span>
							</div>
							<div class="txt-left review-commonSubTxt">광고 영상은 목표한
								도달률(조회수)을 달성하였나요?</div>
							<div class="w100">
								<select class="ipt-Select-Reach" id="success-reach">
									<option value="0">달성함</option>
									<option value="1">달성하지 못함</option>
								</select>
							</div>

						</div>

						<div class="ipt-channel-review pTop2">

							<div class="txt-left review-commonTxt2 inline-block">
								전환률(인입 또는 매출)<span class="primary-color">*</span>
							</div>
							<div class="txt-left review-commonSubTxt">광고 영상은 목표한 전환률(인입
								또는 매출)을 달성하였나요?</div>
							<div class="w100">
								<select class="ipt-Select-Reach" id="success-convert">
									<option value="0">달성함</option>
									<option value="1">달성하지 못함</option>
								</select>
							</div>

						</div>

						<div class="ipt-channel-review pTop2">

							<div class="txt-left review-commonTxt2 inline-block">
								광고 상품 카테고리<span class="primary-color">*</span>
							</div>
							<div class="txt-left review-commonSubTxt">광고할 상품과 제일 근접한
								카테고리를 선택해주세요!</div>
							<div class="w100">
								<select class="ipt-Select-Reach" id="success-itemType">
									<option value="0">달성함</option>
									<option value="1">달성하지 못함</option>
								</select>
							</div>

						</div>

						<div class="ipt-channel-review pTop2">

							<div class="txt-left review-commonTxt2 inline-block">
								타깃 연령<span class="primary-color">*</span>
							</div>
							<div class="txt-left review-commonSubTxt">영상의 타깃 연령을
								선택해주세요!</div>
							<div class="w100">
								<select class="ipt-Select-Reach" id="success-age">
									<option value="0">연령무관</option>
									<option value="1">10대</option>
									<option value="2">10대 - 20대</option>
									<option value="3">20대</option>
									<option value="4">20대 - 30대</option>
									<option value="5">30대</option>
									<option value="6">30대 - 40대</option>
									<option value="7">40대</option>
									<option value="8">40대 - 50대</option>
									<option value="9">50대 이상</option>
								</select>
							</div>

						</div>

						<div class="ipt-channel-review pTop2">

							<div class="txt-left review-commonTxt2 inline-block">
								타깃 성별<span class="primary-color">*</span>
							</div>
							<div class="txt-left review-commonSubTxt">영상의 타깃 성별을
								선택해주세요!</div>
							<div class="w100">
								<select class="ipt-Select-Reach" id="success-sex">
									<option value="0">성별무관</option>
									<option value="1">남성</option>
									<option value="2">여성</option>
								</select>
							</div>

						</div>


						<div class="ipt-channel-review pTop2 flow-hidden">
							<div class="float-left review-commonTxt inline-block">
								이 채널을 다른 마케터에게도 추천하나요?<span class="primary-color">*</span>
							</div>

							<div class="float-right">
								<div class="radio-item">
									<input type="radio" id="channel-Recommand"
										name="channel-recommand" value="0" checked> <label
										for="channel-Recommand">예</label>
								</div>

								<div class="radio-item">
									<input type="radio" id="channel-Unrecommand"
										name="channel-recommand" value="1"> <label
										for="channel-Unrecommand">아니오</label>
								</div>

							</div>
						</div>

						<div class="ipt-channel-review flow-hidden pTop2">
							<div class="float-left review-commonTxt inline-block">
								다음에도 유튜브 채널을 통해 광고를 할 예정이신가요?<span class="primary-color">*</span>
							</div>

							<div class="float-right">
								<div class="radio-item">
									<input type="radio" id="channel-Reuse" name="channel-Reuse"
										value="0" checked> <label for="channel-Reuse">예</label>
								</div>

								<div class="radio-item">
									<input type="radio" id="channel-Unreuse" name="channel-Reuse"
										value="1"> <label for="channel-Unreuse">아니오</label>
								</div>

							</div>
						</div>

						<div class="pTop2 flow-hidden">
							<button class="float-left common-wide20Reverse-Btn pRight"
								type="button" onclick="Common.review(2)">이전</button>
							<button class="float-right common-wide75-Btn" type="button"
								onclick="Common.review(3)">리뷰 등록</button>
						</div>

					</div>

				</div>

				<div class="review-footer">

					<div class="pTop5"></div>

					<div class="float-left">
						<span class="brand-color">Rancre</span><span class="gray-color">
							all right reserved.</span>
					</div>
					<div class="float-right login-Redirect">
						<a href="#" onclick="Common.contactUs(1)">Contact Us</a>
					</div>

					<div class="pTop4"></div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>