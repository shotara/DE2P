<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Contact Us start -->
<div class="review-search-channelName-modal" id="get-ChannelName-Modal">

	<!-- Modal content -->
	<div class="review-search-channelName-modal-content"
		id="get-ChannelName-Modal-Content">
		<span class="contact-us-modal-close" onclick="Common.review(9)">&times;</span>

		<div class="review-channelName-search-area">
			<span class="contact-us-modal-title">채널 검색</span>
			<hr style="margin-top: 5px; border-color: #f11834;">

			<div>

				<span class="display-block ">채널 이름을 입력해주세요</span>
			</div>

			<div class="review-channel-input-area pTop">

				<span>채널명 </span><span class="primary-color">*</span>

				<div class="w100">
					<input class="ipt-Modal-channelName float-left"
						id="ipt-Modal-ChannelName" placeholder="채널 이름을 입력하고 검색을 눌러주세요."
						type="text" maxlength="30" />
					<button class="common-wide20Reverse-Btn float-right" onclick="Common.review(7)">검색</button>
				</div>
			</div>

			<div class="review-channel-output-area">

			</div>

			<div class="text-center pTop3">
				<button class="common-wide-Reverse-Btn"
					onclick="Common.review(8)">확인</button>
			</div>
		</div>
	</div>

</div>

<!-- contact Us finished -->