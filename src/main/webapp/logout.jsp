
<%
session=request.getSession(false);
if(session!=null)
{
session.invalidate();	
}
%>
<jsp:include page="index.jsp"></jsp:include>
<script>
document.getElementById("logoutmsg").innerHTML="<br><b>successfully logedout...</b>";
</script>
