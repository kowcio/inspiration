 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 
 
            
            <div id="greeting" class="brand">

 <button class="btn btn-large btn-primary" type="button" onclick="testMotiv('yt')">Test YT</button> 
 <button class="btn btn-large btn-primary" type="button" onclick="testMotiv('img')">Test Img</button>
 <button class="btn btn-large btn-primary" type="button" onclick="testMotiv('quote')">Test Img</button>



    <!-- Button to trigger modal -->
    <a href="#myModal" class="btn" data-toggle="modal">Launch demo modal</a>
     
    <!-- Modal -->
    <div id="myModal" class="modal hide fade" tabindex="-1">
	    <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">X</button>
	    </div>
	    <div class="modal-body">
	       Add image url, YT link or quote.
           <input type="text" Name="url" id="addUrlInput"/>
        </div>
	    <div class="modal-footer">
	     <button class="btn btn-large btn-primary addMotiv" 
	     id="addMotiv" type="button">Add Motiv</button>
	    </div>
    </div>
    
            
            
            
            
            
            
            
            
             <button class="btn btn-large btn-primary" type="button" id="changeBgBtn">Change BG</button>
            <script>
            
            var bgCount = 1;
            
            $("#changeBgBtn").click(
			    function(){
			    	bgCount++;
			    	
			    	if      (bgCount%4){     $('body').css('background-image',"url('../grow/resources/img/bg1.jpg')");    }
			    	else if (bgCount%3){     $('body').css('background-image',"url('../grow/resources/img/bg2.jpg')");    }
			    	else if (bgCount%2){     $('body').css('background-image',"url('../grow/resources/img/bg3.jpg')");    }
			    	else if (bgCount%1){     $('body').css('background-image',"url('../grow/resources/img/bg4.jpg')");    }
			    	else               {     $('body').css('background-image',"url('../grow/resources/img/bg5.jpg')");    }
			    });
             
            </script> 
            
            
            
            
            
            
            
            
            
         
            
          </div>  
      