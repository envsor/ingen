<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<link href="<c:url value="/resources/jqueryui/jquery-ui.min.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/jquery-ui.structure.min.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/jquery-ui.theme.min.css" />" rel="stylesheet" type="text/css"/>
<title>mWeChat微信营销平台</title>
</head>
<body>
这里是首页，<a href="<c:url value="/workbench"/>">点击这里进入工作台</a>。
</body>
</html>