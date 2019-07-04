$(function () {

    var userId = $("#user_id").val();
    var username = $("#username").val();

    $(document).on('click', '.comment-btn', function () {
        var questionId = this.id;
        if ($("#comment-textarea-" + questionId + " textarea").val() != '') {
            var comment = $("#comment-textarea-" + questionId + " textarea").val();
            $.ajax({
                url: "answers/add/" + questionId + "/" + userId,
                data: JSON.stringify({'answerContent': comment}),
                type: 'POST',
                dataType: 'json',
                contentType: "application/json;charset=utf-8",
                success: function (output) {
                    createComment(comment, questionId, output);
                }
            });
        } else {
            // some validation
        }
    });

    $(document).on('click', '.deleteimage', function () {
        var questionId = this.id;
        $("#dialog-delete-question").dialog({
            resizable: false,
            height: 200,
            modal: true,
            buttons: {
                "Delete": function () {
                    console.log("making delete requests....");
                    $.ajax({
                        url: "questions/" + questionId,
                        type: 'DELETE',
                        contentType: "application/json;charset=utf-8",
                        success: function (output) {
                            $("#dialog-delete-question").dialog("close");
                            $("#main-todo-content-" + questionId).parent().remove();
                        },
                        error: function (response) {
                            console.log(response);
                            $("dialog-delete-question-message").text('Error while deleting the Question!');
                        }
                    });

                },
                Cancel: function () {
                    $(this).dialog("close");
                }
            }
        });
    });


    $(document).on('click', '.update-question', function () {
        var questionId = this.id;
        $('#question').val($("#question-" + questionId).text().trim());
        $('#heading').val($("#heading-" + questionId).text().trim());
        $("#dialog-update-question").dialog({
//            autoOpen: false,
            height: 300,
            width: 550,
            modal: true,
            buttons: {
                'OK': function () {
                    var questionText = $('#question').val();
                    var heading = $('#heading').val();
                    $.ajax({
                        url: "questions/" + questionId,
                        data: JSON.stringify({'questionContent': questionText,'id': questionId, 'heading': heading}),
                        type: 'PUT',
                        dataType: "json",
                        contentType: "application/json;charset=utf-8",
                        success: function (output) {
                            $("#dialog-update-question").dialog("close");
                            $("#question-" + questionId).text(output.questionContent);
                        }
                    });
                },
                Cancel: function () {
                    $(this).dialog("close");
                }
            }
        });

        $("#dialog-update-task").dialog("open");
    });

    $(document).on('click', '.comment-delete-img', function () {
        var commentId = this.id;
        $("#dialog-confirm-answer").dialog({
            resizable: false,
            height: 200,
            modal: true,
            buttons: {
                "Delete": function () {
                    $.ajax({
                        url: 'answers/delete/' + commentId,
                        type: 'get',
                        dataType: "json",
                        success: function (output) {
                            if (output == 1) {
                                $("#dialog-confirm-answer").dialog("close");
                                $("#delete-comment-" + commentId).remove();
                            }
                        }
                    });

                },
                Cancel: function () {
                    $(this).dialog("close");
                }
            }
        });
    });

    $(document).on('click', '.update-comment', function () {
        var commentId = this.id;
        $('#answer').val($("#comment-text-" + commentId).text().trim());

        $("#dialog-update-answer").dialog({
//                autoOpen: false,
            height: 300,
            width: 350,
            modal: true,
            buttons: {
                OK: function () {
                    var answerText = $('#answer').val();
                    $.ajax({
                        url: "answers/edit/" + commentId,
                        data: JSON.stringify({'answerContent': answerText}),
                        type: 'post',
                        dataType: "json",
                        contentType: "application/json;charset=utf-8",
                        success: function (output) {
                            console.log("..........");
                            console.log(output);
                            console.log(output.status);
                            if (output == 1) {
                                $("#dialog-update-answer").dialog("close");
                                $("#comment-text-" + commentId).text(answerText);
                            }
                        }
                    });
                },
                Cancel: function () {
                    $(this).dialog("close");
                }
            }
        });

        $("#dialog-update-answer").dialog("open");
    });

    function createComment(text, itemid, commentid) {
        var comment = '<div class="delete-comment-container" id="delete-comment-' + commentid + '">' +
            '<div class="comment-image">' +
            '<img src="resource/images/user.png">' +
            '</div>' +
            '<div class="comment-text-main">' +

            '<div class="comment-text">' + text + '</div>' +
            '<div class="userinfo"> Answered by: ' + username + '</div>' +
            '</div>' +
            '<div class="comment-delete-img" id="' + commentid + '">' +
            '<img src="resource/images/delete.png">' +
            '</div>' +
            '<div class="update-question" id="' + commentid + '"><img src="resource/images/edit.png"></div>' +
            '</div>';
        $("#comments-" + itemid).append(comment);
        $("#comment-textarea-" + itemid + " textarea").val('');
    }

    function getRandomInt(min, max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

});
