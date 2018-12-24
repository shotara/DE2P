<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="/02_page/commonHeader.jsp" flush="true" />
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col txt-center">
				<div class="txt-center channel-review">

					<div class="v20"></div>

					<div class="common-brand">Rancre</div>

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
						<input class="ipt-Common-Review" type="text"
							id="Input-Channel-Name" placeholder="와썹맨Wassup-man" required />
					</div>

					<div class="ipt-channel-review pTop2">
						<div class="float-left review-commonTxt inline-block">
							종합 만족도<span class="primary-color">*</span>
						</div>
					</div>


					<div class="float-right">
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

					<div class="pTop2"></div>

					<div class="ipt-channel-review pTop2">

						<div class="txt-left review-commonTxt2 inline-block">
							광고 집행 일자<span class="primary-color">*</span>
						</div>
						<div class="txt-left review-commonSubTxt">입력한 일자는 년도만 노출되며,
							1~3년 이내 3년 ~ 5년 이내 등으로 표기됩니다.</div>
						<div class="inline-flex w100">
							<select class="ipt-Select-Date" id="commercial-Date1">
								<option value="0">2018년</option>
								<option value="1">2017년</option>
								<option value="2">2016년</option>
							</select>
							<div class="pRight"></div>
							<select class="ipt-Select-Date" id="commercial-Date2">
								<option value="0">12월</option>
								<option value="1">11월</option>
								<option value="2">10월</option>
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
						<div class="txt-left review-commonSubTxt">모든 리뷰는 익명처리되며, 심사를
							거쳐 수정될 수 있습니다.</div>
						<textarea class="w100 review-TextArea" col="1" row="1"
							id="Input-Commercial-Text"
							placeholder="광고 리뷰를 등록하고, 다른 채널의 광고 이용 리뷰를 확인해보세요!"></textarea>
					</div>

					<div class="pTop3">
						<button class="float-left common-wide20Reverse-Btn pRight"
							type="button">이전</button>
						<button class="float-right common-wide80-Btn" type="button">다음</button>

					</div>

					<div class="pTop4"></div>
					<div class="pTop4"></div>

					<div class="float-left">
						<span class="brand-color">Rancre</span><span class="gray-color">
							all right reserved.</span>
					</div>
					<div class="float-right login-Redirect">
						<a href="#">Contact Us</a>
					</div>

					<div class="pTop4"></div>

				</div>
			</div>
		</div>
	</div>


</body>
</html>