<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="scheme" value="${pageContext.request.scheme}"/>
<c:set var="serverName" value="${pageContext.request.serverName}"/>
<c:set var="port" value="${pageContext.request.serverPort}"/>
<c:set var="imgctx" value="${sessionScope.img_ctx}"/>
<%
	response.setHeader("Pragma", "No-cache");
	response.setDateHeader("Expires", 0); 
	response.setHeader("Cache-Control", "no-cache"); 
%>
<script type="text/javascript">
var ctx = "${ctx}";
var imgctx = "${imgctx}";
var scheme = "${scheme}";
var serverName = "${serverName}";
var port = "${port}";
</script>