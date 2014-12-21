<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<link href="<c:url value="/resources/jqueryui/jquery-ui.min.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/jqueryui/jquery-ui.theme.min.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/layout/layout-default-latest.css" />"
	rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	font-family: "Trebuchet MS", "Helvetica", "Arial",  "Verdana", "sans-serif";
	font-size: 80%;
}
#container {
	background: #999;
	height: 100%;
	margin: 0 auto;
	width: 100%;
	min-width: 1024px;
}
.ui-menu { width: 99%; }
.ui-accordion .ui-accordion-content {padding: 2px;}
</style>

<script type="text/javascript"
	src="<c:url value="/resources/jquery/jquery-1.11.1.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/jquery/jquery.form.js"/>"></script>	
<script type="text/javascript"
	src="<c:url value="/resources/jqueryui/jquery-ui.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/layout/jquery.layout-latest.js"/>"></script>
<script type="text/javascript">
	var wLayout;
	$(document).ready(function() {
		wLayout = $('#container').layout({

			//	reference only - these options are NOT required because 'true' is the default
			closable : false, // pane can open & close
			
			resizable : true, // when open, pane can be resized 
			slidable : true, // when closed, pane can 'slide' open over other panes - closes on mouse-out			
			livePaneResizing : true,

			//	some resizing/toggling settings
			north__slidable : false, // OVERRIDE the pane-default of 'slidable=true'
			north__resizable : false,

			//	some pane-size settings
			north__size : 60,
			west__minSize : 220,
			west__maxSize : 400, // 50% of layout width
			center__minWidth : 800,

			//	some pane animation settings
			west__animatePaneSizing : false,
			west__fxSpeed_size : "fast", // 'fast' animation when resizing west-pane
			west__fxSpeed_open : 1000, // 1-second animation when opening west-pane
			west__fxSettings_open : {
				easing : "easeOutBounce"
			}, // 'bounce' effect when opening
			
			west__fxName_close : "none" // NO animation when closing west-pane
		});

		$("#accordion").accordion({
			heightStyle : "fill"
		});
		
		$( "#menu01" ).menu({
			select: function(event, ui) {
				//alert(ui.item.context.id);
				window.location.hash = ui.item.context.id;
				$('#mainWorkbench').html('加载中...');
				$('#mainWorkbench').load('basic_function/slides');
            }

		});
	});
</script>
<title>我的工作台</title>
</head>
<body>
	<div id="container">
		<div class="ui-layout-north">This is the north pane, closable,
			slidable and resizable</div>
		<div class="ui-layout-west" style="overflow: hidden;">
			<div id="accordion">
				<h3>基本功能</h3>
				<div>
					<ul id="menu01">
						<li id="menu0101">幻灯片宣传页</li>
					</ul>
				</div>
				<h3>Section 2</h3>
				<div>
					<p>Sed non urna.</p>
				</div>
				<h3>Section 3</h3>
				<div>
					<p>Nam enim risus,</p>
					<ul>
						<li>List item one</li>
						<li>List item two</li>
						<li>List item three</li>
					</ul>
				</div>
				<h3>Section 4</h3>
				<div>
					<p>Cras deos.</p>
				</div>
			</div>
		</div>
		<div id="mainWorkbench" class="ui-layout-center">
			This CENTER pane auto-sizes to fit the space <i>between</i> the
			'border-panes'
		</div>
	</div>
</body>
</html>