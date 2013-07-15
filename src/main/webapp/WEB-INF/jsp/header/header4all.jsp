 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 
 
            
            <div id="greeting" class="brand">
<!-- 
 <button class="btn btn-large btn-primary" type="button" onclick="testMotiv('yt')">Test YT</button> 
 <button class="btn btn-large btn-primary" type="button" onclick="testMotiv('img')">Test Img</button>
 <button class="btn btn-large btn-primary" type="button" onclick="testMotiv('quote')">Test Img</button>
 -->

      <button class="btn btn-info pull-right btn-header" type="button" id="changeBgBtn">Change BG</button>

    <!-- Button to trigger modal -->
    <a href="#" class="btn btn-info pull-right btn-header" id="showAddMotivModal">Add motiv</a>
     
    <!-- Modal -->
    <div id="myModal" class="modal hide fade" tabindex="-1">
	    <div class="modal-header"> 
	        <button type="button" class="close" data-dismiss="modal"><i class="icon-chevron-up"></i></button>
	        <br>
	    </div>
	    <div class="modal-body">
	       Add image url, YT link or quote.
           <input type="text" Name="url" id="addUrlInput"/>
        </div>
	    <div class="modal-footer">
		     <button class="btn btn-large btn-primary addMotiv" 
		     id="addMotiv" type="button">Add Motiv</button>
		     
	         <div id="addedSuccesAlert" class="alert alert-success text-center" style="display:none">
	                <button type="button" class="close" data-dismiss="alert">&times;</button>
	                Added Your motivator, thanks !
	         </div>
	         <div id="addedErrorAlert" class="alert alert-error text-center" style="display:none">
	                <button type="button" class="close" data-dismiss="alert">&times;</button>
	                Bad input, too short !
	         </div>
	         

        </div>    
        </div>    
 </div>       
            
            
            
            <script>
              var bgCount=0;	
       
              $("#changeBgBtn").click(
			    function(){
			    	console.log( bgCount++ ) ;
			    	
			    	if      (bgCount%4==0){console.log(bgCount);     $('body').css('background-image',"url('../grow/resources/img/bg1.jpg')");    }
			    	else if (bgCount%3==0){console.log(bgCount);     $('body').css('background-image',"url('../grow/resources/img/bg2.jpg')");    }
			    	else if (bgCount%2==0){console.log(bgCount);     $('body').css('background-image',"url('../grow/resources/img/bg3.jpg')");    }
			    	else if (bgCount%1==0){console.log(bgCount);     $('body').css('background-image',"url('../grow/resources/img/bg4.jpg')");    }
			    	else               {console.log(bgCount);     $('body').css('background-image',"url('../grow/resources/img/bg5.jpg')");    }
			    });
             
            </script> 
     
          
      