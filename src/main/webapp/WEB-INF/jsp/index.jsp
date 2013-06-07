<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--  broken tag validation depends on the doctype, above works like a charm... -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="host" value="${pageContext.request.serverName}"/>


<head>

<title> Inspiration ! Daily ! </title>
    <!--  CSS  -->

<link href="<c:url value="/resources/css/all.css"/>" rel="stylesheet" type="text/css" />

    <!--  JS  -->
    
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jqueryui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/skrypty.js"/>"></script>



  </head>
  <body id="body">





<div id="header">
    <jsp:include page="/WEB-INF/jsp/header/header4all.jsp" />
</div>  




<div id="main ">

main

<!--  main frame for displaying the motivator -->

<div id="mainFrame">

mainFrame

            <iframe title="YouTube video player" 
            class="youtube-player" 
            type="text/html" 
            height="500"
            width="600" 
            src="http://www.youtube.com/embed/U0lsNP8vAXU" frameborder="0">
            </iframe>                  

</div>


<!--  Button for getting the new motivator -->

<div id="getNextMotivator" class="text-center">


 <button 
 id="getNextMotivatorBtn"
 class="btn btn-large btn-primary" 
 type="button">
 Inspire !</button>
</div>




</div>







   <div id="footer">
        <jsp:include page="/WEB-INF/jsp/footer/footer4all.jsp" />
   </div>
    



  </body>   
  </html>
  
  
  