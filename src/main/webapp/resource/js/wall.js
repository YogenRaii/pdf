$(function () {

    var userId = $("#user_id").val();
    var username = $("#username").val();

    $('.add-todo').on('keypress', function (e) {
        //e.preventDefault
        if (e.which == 13) {
            if ($(this).val() != '') {
                var todo = $(this).val();
                var act = 'addTodoTask';
                $.ajax({ url: baseUrl + "controller/todo.php",
                    data: {action: act, text: todo, uid: userId},
                    type: 'post',
                    dataType: "json",
                    success: function (output) {
                        var itemId = output;
                        createTodo(todo, userId, username, itemId);
                    }
                });
            } else {
                alert("Please write something in todo box");
            }
        }
    });

    $(document).on('click','.comment-btn',function(){
        var itemId = this.id;

        if ($("#comment-textarea-"+itemId+" textarea").val() != '') {
            var comment = $("#comment-textarea-"+itemId+" textarea").val();

            $.ajax({ url: baseUrl + 'controller/todo.php',
                data: {action: 'addComment', text: comment, userid: userId, itemid: itemId},
                type: 'post',
                dataType: "json",
                success: function (output) {
                    createComment(comment, itemId, output);
                }
            });
        } else {
            // some validation
        }
    });

    $(document).on('click','.deleteimage',function(){
        var delId = this.id;
        $( "#dialog-confirm" ).dialog({
            resizable: false,
            height:200,
            modal: true,
            buttons: {
                "Delete": function() {
                    $.ajax({ url: baseUrl + 'controller/todo.php',
                        data: {action: 'deleteTodoTask', itemid: delId},
                        type: 'post',
                        dataType: "json",
                        success: function (output) {
                            if(output == 1){
                                $("#dialog-confirm").dialog( "close" );
                                $("#main-todo-content-"+delId).parent().remove();
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

    $(document).on('click','.comment-delete-img',function(){
        var commentId = this.id;
        $( "#dialog-confirm-comment" ).dialog({
            resizable: false,
            height:200,
            modal: true,
            buttons: {
                "Delete": function() {
                    $.ajax({ url: baseUrl + 'controller/todo.php',
                        data: {action: 'deleteComment', commentid: commentId},
                        type: 'post',
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


    $(document).on('click','.update-task',function(){
        var itemId = this.id;
            $('#task').val($("#todo-"+itemId).text().trim());

        $( "#dialog-update-task" ).dialog({
            autoOpen: false,
            height: 300,
            width: 350,
            modal: true,
            buttons: {
                OK: function() {
                    var taskText = $('#task').val();
                    $.ajax({ url: baseUrl + 'controller/todo.php',
                        data: {action: 'updateTask', itemid: itemId, text:taskText},
                        type: 'post',
                        dataType: "json",
                        success: function (output) {
                            if(output == 1){
                                $("#dialog-update-task").dialog( "close" );
                                $("#todo-"+itemId).text(taskText);
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

        $(document).on('click','.update-comment',function(){
            var commentId = this.id;
            $('#comment').val($("#comment-text-"+commentId).text().trim());

            $( "#dialog-update-comment" ).dialog({
                autoOpen: false,
                height: 300,
                width: 350,
                modal: true,
                buttons: {
                    OK: function() {
                        var commentText = $('#comment').val();
                        $.ajax({ url: baseUrl + 'controller/todo.php',
                            data: {action: 'updateComment', commentid: commentId, comment:commentText},
                            type: 'post',
                            dataType: "json",
                            success: function (output) {
                                if(output == 1){
                                    $("#dialog-update-comment").dialog( "close" );
                                    $("#comment-text-"+commentId).text(commentText);
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

    $(document).on('click','.done-or-not',function(){
        var itemid = $(this).find('input')[0].id;

        if($(this).find('input').prop('checked') == true){
        $( "#dialog-confirm-done" ).dialog({
            resizable: false,
            height:200,
            modal: true,
            buttons: {
                "Done": function() {
                    $.ajax({ url: baseUrl + 'controller/todo.php',
                        data: {action: 'doneTask', itemid: itemid},
                        type: 'post',
                        dataType: "json",
                        success: function (output) {
                            if(output == 1){
                                $("#dialog-confirm-done").dialog( "close" );

                                $("#main-todo-content-"+itemid).hide("slow");
                            }
                        }
                    });
                },
                Cancel: function() {
                    $( this ).dialog( "close" );
                    $('.done-or-not').find('input').attr('checked', false);
                }
            }
        });
        }
    });

    function createTodo(text, uid, uname, itemid) {
        var markup = '<li class="list-todo">' +
            '<div id="main-todo-content-'+itemid+'">' +
            '<div class="todoheader">'+
            '<div class="deleteimage" id="'+itemid+'">'+
                '<img src="images/delete.png">'+
               '</div>'+
            '<div class="update-task" id="'+itemid+'"><img src="images/edit.png"></div>'+
                '<div class="done-or-not"><label><input type="checkbox" value="0" id="'+itemid+'">Done</label></div>'+
                '<div class="todoimg" ><img src="images/todo.png" /></div>'+
            '<div class="userinfo"> Task added by: '+uname+'</div><div>'+
                '<div id="todo-'+itemid+'">' +
                        text +
            '</div></div>'+
            '<div id="comment-textarea-'+itemid+'"><textarea rows="5" cols="50"></textarea></div>' +
            '<div><button class="comment-btn btn-sm btn-success" id="'+itemid+'">Comment</button></div>'+
            '<div id="comments-'+itemid+'"></div>'+
        '</div></li>';

        $(".no-task").css("display","none");

        $('#sortable').append(markup);
        $('.add-todo').val('');
    }

    function createComment(text, itemid, commentid) {
        var comment = '<div class="delete-comment-container" id="delete-comment-'+commentid+'">' +
            '<div class="comment-image">'+
            '<img src="images/user.png">' +
            '</div>'+
            '<div class="comment-text-main">'+
            '<div class="userinfo"> Commented by: '+username+'</div>'+
            '<div class="comment-text">' + text + '</div>' +
            '</div>'+
            '<div class="comment-delete-img" id="'+commentid+'">' +
            '<img src="images/delete.png">' +
            '</div>' +
            '<div class="update-comment" id="'+commentid+'"><img src="images/edit.png"></div>'+
            '</div>';
        $("#comments-"+itemid).append(comment);
        $("#comment-textarea-"+itemid+" textarea").val('');
    }

    function getRandomInt(min, max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

});