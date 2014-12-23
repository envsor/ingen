<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String diaId = java.util.UUID.randomUUID().toString(); %>
<c:url var="actionUrl" value="basic_function/slide/upload?${_csrf.parameterName}=${_csrf.token}"/>
<div id="<%=diaId %>" title="Basic dialog">
  <form id="fileuploadForm<%=diaId %>" action="${actionUrl}" method="POST" enctype="multipart/form-data" class="cleanform">
		<input id="file<%=diaId %>" type="file" name="file" accept=".jpg,.png,.gif" style="width: 290px;border: 1px solid #aaa;"/>
		<img id="img<%=diaId %>" src="" alt="请选择图片" style="width: 290px;height: 457px;"/>
  </form>
</div>
<script type="text/javascript">
addSlidesDia('<%=diaId %>');
$('#fileuploadForm<%=diaId %>').ajaxForm({ success: function(result) {
		if(!result.successful)
			return;
		$('#img<%=diaId%>').attr('src', result.imgUri);
	}
});
$('#file<%=diaId %>').change(function(){
	$('#fileuploadForm<%=diaId %>').submit();	
});
</script>