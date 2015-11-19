$(function () {
    $(document).on('click','.user-details',function(){
        var userId = this.id;
            $.ajax({ url: "user/"+userId,
                type: 'GET',
                dataType : 'json',
                contentType: "application/json;charset=utf-8",
                success: function (profile) {
                	console.log(profile);
                	$("#user-detail").empty();
                	var info ="<div><p>Name: "+profile.firstName+" "+profile.lastName+"</p>"+
                	"<p>Occupation: "+profile.occupation+"</p>"+
                	"<p>Address: "+profile.address+"</p>"+
                	"<p>Date Of birth: "+profile.dateOfBirth+"</p>"+
                	"</div>"
                	$("#user-detail").append(info);
                	$("#user-detail").dialog({
                		
                		buttons:{
                			"OK":function() {
                                $( this ).dialog( "close" );
                            }
                		}
                	})
//                    createInfo();
                },
            error: function(error,xhr) {
				alert(error+" "+xhr.status);
				console.log(error);
			}
            
            });
    });
});