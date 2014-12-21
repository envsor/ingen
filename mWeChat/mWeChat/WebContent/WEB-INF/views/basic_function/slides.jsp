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
$(function() {
	$('#slideLabelBtn').button();
	$('#slideLabelBtn').attr('disabled',"true");
	$('#addSlideBtn').button().on('click',function(){
		$.get('basic_function/slide/add', function(result){
		    $('#slideShowDiv').append(result);
		    
		});
	});
	$( "#slideShowDiv" ).sortable();
	$( "#slideShowDiv" ).disableSelection();
});
function addSlidesDia(diaId){
	var selector = '#' + diaId; 
	$(selector).dialog({
		  appendTo: '#slideShowDiv',
	      autoOpen: false,
	      draggable: false,
	      resizable: false
	});
	$(selector).dialog('open');
	$('.ui-dialog', $('#slideShowDiv')).css('float','left');
	$('.ui-dialog', $('#slideShowDiv')).css('position','relative');
	$('.ui-dialog', $('#slideShowDiv')).css('top','0');
	$('.ui-dialog', $('#slideShowDiv')).css('left','0');
	$('.ui-dialog', $('#slideShowDiv')).css('margin-left','5px');
	$('.ui-dialog', $('#slideShowDiv')).css('margin-top','5px');
}
</script>
<div id="slidesWorkbench" style="width: 100%;height: auto;margin 0px;">
<div id="slidesToolbar" class="ui-widget-header ui-corner-all" style="width: 99%;">
  <input type="button" id="slideLabelBtn" value="幻灯片宣传页:">
  <input type="button" id="addSlideBtn" value="创建一页">
</div>
<div id="slideShowDiv">
</div>
</div>
<!-- ============================================================================================ -->
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>