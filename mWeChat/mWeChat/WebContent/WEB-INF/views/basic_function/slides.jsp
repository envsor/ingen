<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${!ajaxRequest}">    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>制作幻灯片</title>
</head>
<body>
</c:if>
<!-- ============================================================================================ -->
<style type="text/css">
<!--
  #slidesToolbar {
    padding: 4px;
    display: inline-block;
  }
  /* support: IE7 */
  *+html #slidesToolbar {
    display: inline;
  }
//-->  
</style>
<script type="text/javascript">
<!--
$(function() {
	$( '#shuffle' ).button();
});
//-->
</script>
<div id="slidesWorkbench">
<div id="slidesToolbar" class="ui-widget-header ui-corner-all">
  <input type="checkbox" id="shuffle"><label for="shuffle">Shuffle</label>
</div>
</div>
<!-- ============================================================================================ -->
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>