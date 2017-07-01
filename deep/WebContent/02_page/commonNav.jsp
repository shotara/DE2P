<%@ page import="com.deep.config.GlobalValue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="navbar navbar-default" id="navtop">
	<div class="container-fluid">
	
		<!-- Brand and toggle get grouped for better mobile display -->
		
		<div class="col-xs-2 col-md-3">
			<div class="logo">
				<ul class="title">
					<li><span><font class="deep">DE2P 깊은 블로그의 시작</font></span></li>
				</ul> 
			</div>		
		</div>
		
		
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="col-xs-8 col-md-6">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="/page/index.jsp"><i class="fa fa-home fa-2x"
						aria-hidden="true"></i></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
						<button class="icon">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</form>
			</ul>
		</div>
		
		
		<div class="col-xs-2 col-md-3">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${not empty sessionScope.deepMemberNo}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-hidden="true"
							aria-haspopup="true" aria-expanded="false"><i
								class="fa fa-user-o fa-2x"></i> </a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Log-In</a></li>
								<li><a href="#">Join</a></li>
							</ul></li>

						<li class="dropdown" onclick="Member.getMyNotificationList()"><a
							href="#" class="dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false"> <i
								class="fa fa-envelope-o fa-2x"></i></a>
							<ul class="dropdown-menu" role="menu" data-output="notifications"></ul>
						</li>

						<li><a href="/page/index.jsp"><i
								class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i></a></li>

					</c:if>
					<c:if test="${empty sessionScope.deepMemberNo}">

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-hidden="true"
							aria-haspopup="true" aria-expanded="false"><i
								class="fa fa-user-circle-o fa-2x"></i> </a>
							<ul class="dropdown-menu">
								<li><a href="/02_page/Auth/login.jsp">LOG-IN</a></li>
								<li><a href="/02_page/Auth/join.jsp">JOIN</a></li>
							</ul></li>

					</c:if>
				</ul>
			</div>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
