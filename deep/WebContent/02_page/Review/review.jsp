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
						<div class="float-left review-commonTxt inline-block">
							채널 이름<span class="primary-color">*</span>
						</div>
						<input class="ipt-channel-name" type="txt" id="Input-Channel-Name"
							placeholder="광고한 채널의 이름을 입력해주세요!" required />
					</div>

					<div class="ipt-channel-review pTop2">
						<div class="float-left review-commonTxt2 inline-block">
							종합 만족도<span class="primary-color">*</span>
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

					</div>

					<div class="ipt-joinPermit pTop2">

						<div class="float-left joinPermit-commonTxt inline-block">
							상품의 타깃 성별은 어떻게 되나요?<span class="primary-color pRight10">*</span>
						</div>
						<div class="float-left joinPermit-commonSubTxt inline-block">광고하고자
							하는 상품의 타깃 성별을 선택해주세요.</div>
						<div class="inline-block">
							<select class="ipt-Select-Join" id="commercial-target-sex">
								<option value="0">성별무관</option>
								<option value="1">남성</option>
								<option value="2">여성</option>
							</select>
						</div>

					</div>

					<div class="ipt-joinPermit pTop2">

						<div class="float-left joinPermit-commonTxt inline-block">
							동영상 채널을 통해 광고를 하신적이 있나요?<span class="primary-color pRight10">*</span>
						</div>
					</div>
					<div class="float-right">
						<div class="radio-item">
							<input type="radio" id="commercial-exYes" name="commercial-ex"
								value="1" checked> <label for="commercial-exYes">예</label>
						</div>

						<div class="radio-item">
							<input type="radio" id="commercial-exNo" name="commercial-ex"
								value="0"> <label for="commercial-exNo">아니오</label>
						</div>
					</div>

					<div class="pTop3"></div>

					<div class="pTop3">
						<a href="#" onclick="Auth.join()"><button
								class="common-wide-Btn" type="button">회원가입 완료</button></a>
					</div>

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