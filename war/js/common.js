/**
 * 
 */
$(document).ready(function(){
    $("#callAPIButtonId").click(function(){
        $.post("_ah/api/helloApi/v1/hello",
        {
          name: $("#fname").val()
        },
        function(data,status){
        	console.log(data);
			if(data.isError = "true"){
    			alert(data.errorMessage);
			}else{
				alert("Successfully stored.");  
				$( "#responseDivId" ).text("Hello " + data.name);  
    		}
        });
    });
});


/*$(document).ready(function(){
    $("#callAPIButtonId").click(function(){
        $.ajax({
    	   url : "_ah/api/helloApi/v1/hello",
    	   data :JSON.stringify({"name" : $("#fname").val()}),
    	   contentType : 'application/json',
    	   type : 'POST',
    	   dataType : 'json',
    	   contentType : 'application/json',
    	   crossDomain : true,
    	   success : function(data, status, xhr){
        		console.log(data);
    			if(data.isError = undefined || data.isError == true){
        			alert(data.errorMessage);
    			}else{
    				alert("Successfully stored.");  
    				$( "#responseDivId" ).text("Hello " + data.name);  
        		}
    	     },
    	   error : function(data, status, xhr){
    	    alert("internal server error");
    	   }
    	  });      
    });
});
*/

