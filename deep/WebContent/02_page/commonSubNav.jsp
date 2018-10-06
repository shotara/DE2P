<%@ page import="com.rancre.config.GlobalValue" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="navbar subnav" role="navigation">
	<div class="navbar-inner">
		<div class="container-fluid">
		<div class="col-xs-2 col-md-3"></div>
		<div class="col-xs-8 col-md-6">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="#" onclick="feedList(1)"><span>All</span></a></li>
				<li><a href="#" onclick="feedList(2)"><span>Language</span></a></li>
				<li><a href="#" onclick="feedList(3)"><span>DataBase</span></a></li>
				<li><a href="#" onclick="feedList(4)"><span>Server</span></a></li>
				<li><a href="#" onclick="feedList(5)"><span>DataStructure</span></a></li>
			</ul>
		</div>
		<div class="col-xs-2 col-md-3"></div>
		</div>
	</div>
</div>