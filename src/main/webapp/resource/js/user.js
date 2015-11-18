$(function () {
    $(document).on('click','.user-details',function(){
        var userId = this.id;
            $.ajax({ url: "user/"+userId,
                type: 'GET',
                dataType : 'json',
                contentType: "application/json;charset=utf-8",
                success: function (output) {
                	alert(output);
                	$("#user-detail").dialog({
//                		$("#user-detail").append();
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
			}
            
            });
    });

    /*function createComment(text, itemid, commentid) {
        var comment = '<div class="delete-comment-container" id="delete-comment-'+commentid+'">' +
            '<div class="comment-image">'+
            '<img src="resource/images/user.png">' +
            '</div>'+
            '<div class="comment-text-main">'+
            
            '<div class="comment-text">' + text + '</div>' +
            '<div class="userinfo"> Answered by: '+username+'</div>'+
            '</div>'+
            '<div class="comment-delete-img" id="'+commentid+'">' +
            '<img src="resource/images/delete.png">' +
            '</div>' +
            '<div class="update-question" id="'+commentid+'"><img src="resource/images/edit.png"></div>'+
            '</div>';
        $("#comments-"+itemid).append(comment);
        $("#comment-textarea-"+itemid+" textarea").val('');
    }*/
});