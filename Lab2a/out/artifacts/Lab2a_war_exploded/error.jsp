<%@ page import="app.exception.WebException" %><%--
  Created by IntelliJ IDEA.
  User: piros
  Date: 11/14/2020
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<jsp:useBean id="except" class="app.entities.Except" scope="session">
    <jsp:setProperty name="except" property="message" value= "<%= exception.getMessage() %>"/>
</jsp:useBean>
<html>
<head>
    <link rel="stylesheet" href = "style_2.css">
    <title>Error</title>
</head>
<body align="center">
<% try {
    if (exception.getMessage() != null) {
        except.setMessage(exception.getMessage());
    }
} catch (NullPointerException e){
    System.out.println("NULL");
    except.setMessage(WebException.WRONG_NUMBER_OF_ARGUMENTS);
}%>
<div id="message" class="block">Error message: <span>${except.message}</span></div>
<p class="block"><button id="button" onclick="redirect()">Main page</button></p>
<section id="gif">
    <img src="злой_пингвинчик.gif" alt="тут был пингвинчик">
</section>

<script>
    function redirect(){
        window.location = "index.jsp";
    }
</script>

</body>
</html>