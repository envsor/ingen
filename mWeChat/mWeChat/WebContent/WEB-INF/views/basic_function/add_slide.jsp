<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String diaId = java.util.UUID.randomUUID().toString(); %>
<c:url var="actionUrl" value="basic_function/slide/upload?${_csrf.parameterName}=${_csrf.token}"/>
<div id="<%=diaId %>" title="Basic dialog">
  <form id="fileuploadForm" action="${actionUrl}" method="POST" enctype="multipart/form-data" class="cleanform">
			<label for="file">File</label>
			<input id="file" type="file" name="file" />
			<p><button type="submit">Upload</button></p>		
  </form>
</div>
<script type="text/javascript">
addSlidesDia('<%=diaId %>');
$("#fileuploadForm").ajaxForm({ success: function(html) {
	alert(html);
}
});
</script>