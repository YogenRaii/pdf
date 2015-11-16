$(function () {

    var userId = $("#user_id").val();
    var username = $("#username").val();

    $(document).on('click','.comment-btn',function(){
        var questionId = this.id;
        if ($("#comment-textarea-"+questionId+" textarea").val() != '') {
            var comment = $("#comment-textarea-"+questionId+" textarea").val();
            $.ajax({ url: "answers/add/"+questionId+"/"+userId,
                data: JSON.stringify({'answerContent': comment}),
                type: 'POST',
                dataType : 'json',
                contentType: "application/json;charset=utf-8",
                success: function (output) {
                    createComment(comment, questionId, output);
                }
            });
        } else {
            // some validation
        }
    });

    $(document).on('click','.deleteimage',function(){
        var questionId = this.id;
        $( "#dialog-confirm" ).dialog({
            resizable: false,
            height:200,
            modal: true,
            buttons: {
                "Delete": function() {
                    $.ajax({ url: "questions/delete/"+questionId,
                        type: 'GET',
                        dataType: "json",
                        success: function (output) {
                            if(output == 1){
                                $("#dialog-confirm").dialog( "close" );
                                $("#main-todo-content-"+questionId).parent().remove();
                            }
                        }
                    });

                },
                Cancel: function() {
                    $( this ).dialog( "close" );
                }
            }
        });
    });


    $(document).on('click','.update-question',function(){
        var questionId = this.id;
            $('#question').val($("#question-"+questionId).text().trim());
//            alert(questionId);
        $("#dialog-update-question").dialog({
//            autoOpen: false,
            height: 300,
            width: 350,
            modal: true,
            buttons: {
                'OK': function() {
//                	alert(questionId);
                    var questionText = $('#question').val();
//                    alert(questionText);
                    $.ajax({ url: "questions/edit/"+questionId,
                        data: JSON.stringify({'questionContent':questionText/*,'id':questionId*/}),
                        type: 'post',
                        dataType: "json",
                        contentType: "application/json;charset=utf-8",
                        success: function (output) {
                            if(output == 1){
                                $("#dialog-update-question").dialog( "close" );
                                $("#question-"+questionId).text(questionText);
                            }
                        }
                    });
                },
                Cancel: function() {
                    $( this ).dialog( "close" );
                }
            }
        });

        $( "#dialog-update-task" ).dialog( "open" );
    });

    $(document).on('click','.comment-delete-img',function(){
        var commentId = this.id;
        $( "#dialog-confirm-comment" ).dialog({
            resizable: false,
            height:200,
            modal: true,
            buttons: {
                "Delete": function() {
                    $.ajax({ url: 'answers/delete/'+commentId,
                        type: 'get',
                        dataType: "json",
                        success: function (output) {
                            if(output == 1){
                                $("#dialog-confirm-comment").dialog( "close" );
                                $("#delete-comment-"+commentId).remove();
                            }
                        }
                    });

                },
                Cancel: function() {
                    $( this ).dialog( "close" );
                }
            }
        });
    });

        $(document).on('click','.update-comment',function(){
            var commentId = this.id;
            $('#answer').val($("#comment-text-"+commentId).text().trim());

            $( "#dialog-update-comment" ).dialog({
//                autoOpen: false,
                height: 300,
                width: 350,
                modal: true,
                buttons: {
                    OK: function() {
                        var answerText = $('#answer').val();
                        $.ajax({ url: "answers/edit/"+commentId,
                            data: JSON.stringify({'answerContent':answerText}),
                            type: 'post',
                            dataType: "json",
                            contentType: "application/json;charset=utf-8",
                            success: function (output) {
                                if(output == 1){
                                    $("#dialog-update-comment").dialog( "close" );
                                    $("#comment-text-"+commentId).text(answerText);
                                }
                            }
                        });
                    },
                    Cancel: function() {
                        $( this ).dialog( "close" );
                    }
                }
        });

        $( "#dialog-update-comment" ).dialog( "open" );
     });

    function createComment(text, itemid, commentid) {
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
    }

    function getRandomInt(min, max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

});