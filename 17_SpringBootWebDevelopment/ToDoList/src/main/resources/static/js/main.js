$(function(){

    const appendToDo = function(data){
        var todoCode2 = '<li style=" "><a href="#" class="todo-link" data-id="' +
        data.id + '">' + data.name + '</a><br>' +
        '<span class="close">×</span>' +
        '</li>';

        $('#myUL')
                    .append(todoCode2);
    };
    var dataId;
    $('#show-add-todo-form').click(function(){
        $('#todo-form').css('display', 'flex');
    });

    $('#todo-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    $('#todo-form-edit').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    $(document).on('click', '.todo-link', function(){
        var link = $(this);
        var todoId = link.data('id');

        $.ajax({
            method: "GET",
            url: '/list/' + todoId,
            success: function(response)

            {
               $('#todo-form-edit').css('display', 'flex');
               $('#todo-form-edit').find("input[name=name]").val(response.name);
               $('#todo-form-edit').find("input[name=description]").val(response.description);
               dataId = response.id;
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Описание отсутствует');
                }
            }
        });
        return false;
    });

    $('#save-todo-edit').click(function()
    {
        var data = $('#todo-form-edit form').serialize();
        data = data + '&id=' + dataId;

        $.ajax({
            method: "PUT",
            url: '/list/',
            data: data,
            success: function(response)
            {
                $('#todo-form-edit').css('display', 'none');
                console.log('. display = ' + response.id + ' ' + response.name);

                $('a[data-id="' + response.id + '"]').text(response.name);
            }
        });
        return false;
    });

    $('#save-todo').click(function()
    {
        var data = $('#todo-form form').serialize();
        if(data.name = null){
        return false;
        }
        $.ajax({
            method: "POST",
            url: '/list/',
            data: data,
            success: function(response)
            {
                $('#todo-form').css('display', 'none');
                var todo = {};
                todo.id = response;
                var dataArray = $('#todo-form form').serializeArray();
                for(i in dataArray) {
                    todo[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendToDo(todo);
            }
        });
        return false;
    });

    var myNodelist = document.getElementsByTagName("LI");
    var i;
    for (i = 0; i < myNodelist.length; i++) {
      var span = document.createElement("SPAN");
      var txt = document.createTextNode("\u00D7");
      span.className = "close";
      span.appendChild(txt);
      myNodelist[i].appendChild(span);
    }

    $(document).on('click', '.close', function(){
    var link = $(this);
    var todoId = link.siblings('.todo-link').data('id');

        $.ajax({
            method: "DELETE",
            url: '/list/' + todoId,
            success: function(response)
            {
                link.parent().remove();
            }
        });
    return false;
    });
});