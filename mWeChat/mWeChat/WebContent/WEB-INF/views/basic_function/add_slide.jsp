<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String diaId = java.util.UUID.randomUUID().toString(); %>
<div id="<%=diaId %>" title="Basic dialog" style="position: relative;">
  <p>This is an animated dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
</div>
<script type="text/javascript">
addSlidesDia('<%=diaId %>');
</script>