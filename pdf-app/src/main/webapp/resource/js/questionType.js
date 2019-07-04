$(function () {
  
    $(document).on('click','.questionType-delete-img',function(){
        var questionTypeId = this.id;
        $("#dialog-delete-confirm" ).dialog({
            resizable: false,
            height:200,
            modal: true,
            buttons: {
                "Delete": function() {
                    console.log("making delete requests....");
                    $.ajax({
                        url: '/questionTypes/' + questionTypeId,
                        type: 'DELETE',
                        contentType: "application/json;charset=utf-8",
                        success: function (output) {
                            $("#dialog-delete-confirm").dialog( "close" );
                            $("#delete-questionType-" + questionTypeId).remove();
                        },
                        error: function (response) {
                            console.log('Error while deleting question type ', response);
                            $("#dialog-delete-confirm-message").val('Error while deleting the question type!');
                        }
                    });

                },
                Cancel: function() {
                    $( this ).dialog( "close" );
                }
            }
        });
    });

        $(document).on('click','.update-questionType',function(){
            var questionTypeId = this.id;
            $('#questionType-heading').val($("#questionType-heading-" + questionTypeId).text().trim());
            $('#questionType-content').val($("#questionType-text-" + questionTypeId).text().trim());

            $( "#dialog-update-questionType" ).dialog({
//                autoOpen: false,
                height: 300,
                width: 350,
                modal: true,
                buttons: {
                    OK: function() {
                        var questionTypeHeading = $('#questionType-heading').val();
                        var questionTypeText = $('#questionType-content').val();
                        $.ajax({ url: "/questionTypes/" + questionTypeId,
                            data: JSON.stringify({'description' : questionTypeText, 'name': questionTypeHeading}),
                            type: 'PUT',
                            dataType: "json",
                            contentType: "application/json;charset=utf-8",
                            success: function (response) {
                                $("#dialog-update-questionType").dialog( "close" );
                                $("#questionType-heading-" + questionTypeId).text(response.name);
                                $("#questionType-text-" + questionTypeId).text(response.description);
                            },
                            error: function (response) {
                                console.log('Error while updating question type ', response);
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

});
