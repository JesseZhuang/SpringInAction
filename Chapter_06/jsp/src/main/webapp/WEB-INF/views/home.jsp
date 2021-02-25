<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1><s:message code="spitter.welcome" text="Welcome" /></h1>

    <s:url value="/spitter/register" var="registerUrl" />

    <a href="<s:url value="/spittles" />">Spittles</a> | 
    <a href="${registerUrl}">Register</a>


    <s:url href="/spittles" var="spittlesUrl">
      <s:param name="max" value="60" />
      <s:param name="count" value="20" />
    </s:url>

    <s:url href="/spitter/{username}" var="spitterUrl">
      <s:param name="username" value="jbauer" />
    </s:url>

    <!-- /spitter/spittles?max=60&amp;count=20 -->
    <s:url value="/spittles" htmlEscape="true">
      <s:param name="max" value="60" />
      <s:param name="count" value="20" />
    </s:url>

  </body>
</html>
