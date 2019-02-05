<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Contact Us start -->
<div class="contact-us-modal" id="con-Us-Modal">

	<!-- Modal content -->
	<div class="contact-us-modal-content" id="con-Us-Modal-Content">
		<span class="contact-us-modal-close" onclick="Common.contactUs(2)">&times;</span>

		<div class="contact-us-input-area">
			<span class="contact-us-modal-title">문의하기</span>
			<hr style="margin-top: 5px; border-color: #f11834;">

			<div>

				<span class="display-block ">랭크리에 궁금한점이 있나요?</span> <span
					class="display-block">건의 혹은 문의주실 내용이 있다면 아래에 입력해주세요!</span>
			</div>

			<div class="pTop">

				<span>이메일 </span><span class="primary-color">*</span> <input
					class="ipt-contact-us-email" id="ipt-con-Us-Email"
					placeholder="답변 받으실 이메일을 입력해주세요." type="email" />
			</div>

			<div class="pTop">

				<span>문의내용 </span><span class="primary-color">*</span>

				<textarea class="w100 ipt-contact-us-text" col="1" row="1"
					id="Input-Contact-Text" placeholder="가능한 빨리 답변해드리겠습니다!"></textarea>

			</div>

			<div class="text-center pTop3">
				<button class="common-wide-Reverse-Btn"
					onclick="Common.contactUs(3)">문의하기</button>
			</div>
		</div>
	</div>

</div>

<!-- contact Us finished -->