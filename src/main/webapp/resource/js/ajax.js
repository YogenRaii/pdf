$(document).ready(function() {
	$(".update").click(function() {
		userSubmit();
	})
})

function userSubmit() {
	var dataToSend = JSON.stringify(serializeObject($('#userForm')));
  	 $.ajax({
		url: 'update',
		type: 'POST',
		dataType: "json",           // Accepts
		data:dataToSend,
		contentType: 'application/json',   // Sends
		success: function(){
			$('#errors').html("");
			$("#result").append( '<H3 align="center"> OKAY!! <H3>');                
			make_visible('result');
		},

		error: function(errorObject ){	
//			error: function(jqXHR,  textStatus,  HTTPStatus ){	
//			error: function(jQuery XMLHttpRequest,  "error",  "Bad Request" ){	
						
			if (errorObject.responseJSON.errorType == "ValidationError") {
	 			$('#success').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    $("#result").append( '<p>');
	  	
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#errors").append( error.message + '<br>');
			    	});
	 	 	        $("#errors").append( '</p>');
	 	 	      make_visible('result');
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
		}
	});
}

toggle_visibility = function(id) {
    var element = document.getElementById(id);
    if(element.style.display == 'block')
    	element.style.display = 'none';
    else
    	element.style.display = 'block';
 }	 

resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  
	


make_hidden = function(id) {
    var e = document.getElementById(id);
        e.style.display = 'none';
        }	   

make_visible = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
 }	   

// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};




/*function bookSubmit(){
   	var dataToSend = JSON.stringify(serializeObject($('#bookForm')));
	$.ajax({
		url: '/Book5Rest/addBook',
		type: 'POST',
		dataType: "application/json",           // Accepts
 		data:dataToSend,
 		contentType: 'application/json',   // Sends
		success: function(category){
			$('#result').html("");
 			$("#result").append( '<H3 align="center"> OKAY!! <H3>');                
 			make_visible('result');
		},
		error: function(exception){						
//			alert( exception.responseText );
			alert( "HOO-HA");
		}
	});
}
*/


 