
$(document).ready(function(){
	
	//make a random grow appear on load
	loadRandomMotivator();

	
	});	


$(document).on("click", ".getNextMotivatorBtn", loadRandomMotivator ); 


 function loadRandomMotivator() {
	 //  $(".displayusers").load("${path}/users/part/"+postNo);
		var timeout = 1000;

	  var url = $("#pageContext").text()+"/getMotivator";
	$.getJSON(  url , function(data) {
        //console.log("data.url = "+data.url+" \n pageContext in div is = "+$("#pageContext").text());
		//$.each(data, function(key, val) {
		////console.log("key = "+key+" value= "+val);
	    //load values to the divs
		//});
		//console.log("linkType = "+data.linkType);
		var type = data.linkType;
        $(".mainFrame").fadeOut( timeout , function() {
        
        //console.log("nie skonczylo sie fejdowac");
		 if ( type == "yt"){
	            var media = 
	            '<iframe title="YouTube video player" class="youtube-player" type="text/html" width="640"'+
	            'height="390" src="http://www.youtube.com/embed/'+data.url+'" frameborder="0">'+
	            '</iframe>';
	             $(".mainFrame").html(  media  );
	            //console.log("YT setting");
		 }
	        else if ( type=="img"){    
var media = 
'<a href="'+ data.url +'"><img src="'+ data.url +'" alt="Smiley face" height="390" width="640" /></a>';
	            console.log(media);
	            $(".mainFrame").html(  media  );
                //console.log("IMG setting");
	        }
	        else if ( type=="quote"){
	        	   var media = 
	        		   '<div id="qouteBackground" style="max-height:640px; max-width:390px">'
	        		   +data.url+
	        		   '</div>';
	        	   $(".mainFrame").html(  media  );
	        	   //console.log("QUOTE setting");
	        }
	        else {
	                $(".mainFrame").replaceWith( "That should have not happened, admin will go crazy");
	        }
		 //end fade out function        
        });		 
		 
		 
         $(".mainFrame").fadeIn(  timeout  );
        
	});
}

/////////////////////////////////////
/////////////////////////////////////
//		TEST						
/////////////////////////////////////
/////////////////////////////////////



 function testMotiv(type) {
     $(".mainFrame").fadeOut( 2000 , function() {

		if ( type == "yt"){
	            var media = 
	            '<iframe title="YouTube video player" class="youtube-player" type="text/html" width="640"'+
	            'height="390" src="http://www.youtube.com/embed/EuJak7Do-rk" frameborder="0">'+
	            '</iframe>';
	             $(".mainFrame").html(  media  );
	            //console.log("YT setting");
		 }
	        else if ( type=="img"){    
	            var media = '<img src="http://uniquelifeguide.com/wp-content/uploads/inspire.jpg" alt="Smiley face" height="390" width="640">';
	            $(".mainFrame").html(  media  );
             //console.log("IMG setting");
	        }
	        else if ( type=="quote"){
	        	   var media = '<div id="qouteBackground"' + 
	        		   'style="max-height:640px; max-width:390px">123456789</div>';
	        	   $(".mainFrame").html(  media  );
	        	   //console.log("QUOTE setting");
	        }
	        else {
	                $(".mainFrame").replaceWith( "That should have not happened, admin will go crazy");
	        }
		 //end fade out function        
     });		 
		 		 
      $(".mainFrame").fadeIn(  2000  );
	        
}



/////////////////////////////////////
/////////////////////////////////////
//			Add motiv
/////////////////////////////////////
/////////////////////////////////////
 
 //add motiv modal popup button
 $(document).on('click', '#showAddMotivModal', function(){
	 	$("#addedErrorAlert").hide('slow');
		$("#addedSuccesAlert").hide('slow');
		$('#myModal').modal('toggle'); 
 });
 //add motiv on the modal buton
 $(document).on('click', '#addMotiv', function(){
	 	$("#addedErrorAlert").hide('slow');
		$("#addedSuccesAlert").hide('slow');

		
		var url = $('#addUrlInput').val();
		console.log(url);
		urlWithNoSlashes = url.replace( /\//g , 'hereIsSlash');
		console.log(urlWithNoSlashes);
		
		//validation
		if (url.length<5) {
			console.log("Url to short");
			 $("#addedErrorAlert").fadeIn('slow', function(){
		       });
			 return false;
			}

		//OK
		
		var jsonfile={json:JSON.stringify(urlWithNoSlashes)};
		
 $.ajax({
 	type: "POST",
 	data: jsonfile,
    dataType : "json",
 	url: $("#pageContext").text()+"/addUrl/11",
 	success: function(){	//if i won`t return true boolean response body in spring it always will fail ... wtf ? 
 		console.log("success");
       $("#addedSuccesAlert").fadeIn('slow', function(){
    	   $('#myModal').modal('hide');
   	 		$('#addUrlInput').val("");

       });
 		//add a green mark
 	},
 	error: function(){ console.log("erroe sennding ajax ? "); }
 	});
 
 
 
 
 
 }); //end #addMotiv
 
 
 



