function callAjax(url, method, data) {
    return $.ajax({
        type: method,
        url: url,
        contentType:'application/json; charset=utf-8',
        data: data,
        processData: false
    });
}

function showMessage(message,action){
	(action == true) ? alertify.notify(message, 'success', 3) : alertify.notify(message, 'error', 3);
}