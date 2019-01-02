$(function () {
  
    $(document).on('click','.questionType-delete-img',function(){
        var questionTypeId = this.id;
        $( "#dialog-confirm" ).dialog({
            resizable: false,
            height:200,
            modal: true,
            buttons: {
                "Delete": function() {
                    $.ajax({ url: 'delete/'+questionTypeId,
                        type: 'get',
                        dataType: "json",
                        success: function (output) {
                            if(output == 1){
                                $("#dialog-confirm").dialog( "close" );
                                $("#delete-questionType-"+questionTypeId).remove();
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

        $(document).on('click','.update-questionType',function(){
            var questionTypeId = this.id;
            $('#questionType').val($("#questionType-text-"+questionTypeId).text().trim());

            $( "#dialog-update-questionType" ).dialog({
//                autoOpen: false,
                height: 300,
                width: 350,
                modal: true,
                buttons: {
                    OK: function() {
                        var questionTypeText = $('#questionType').val();
                        $.ajax({ url: "edit/"+questionTypeId,
                            data: JSON.stringify({'description':questionTypeText}),
                            type: 'patch',
                            dataType: "json",
                            contentType: "application/json;charset=utf-8",
                            success: function (output) {
                                if(output == 1){
                                    $("#dialog-update-questionType").dialog( "close" );
                                    $("#questionType-text-"+questionTypeId).text(questionTypeText);
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

});