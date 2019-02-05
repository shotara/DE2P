<%@ page import="com.rancre.config.GlobalValue"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<footer class="ranFooter">
	<div class="container">
		<div class="pt-3"></div>
		<div class="w-auto">
			<div class="float-left">
				<a class="footer-brand" href="/index.jsp">Rancre</a>
			</div>
			<div class="float-right mTop">
				<a class="common-white-A" href="#" onclick="Common.contactUs(1)">contact
					us</a>
			</div>
			<div class="txt-center pTop4">
				<span class="footer-detail">Rancre 는 채널 추천 서비스로 여러분에게 새로운 채널을
					추천해주고 싶어 만들었어요! </br> 더 많은 채널을 보여주도록 노력할게요!
				</span>
			</div>
		</div>
	</div>
</footer>

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

				<span>이메일 </span><span class="primary-color">*</span> 
				
				<input
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
