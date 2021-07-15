//function callAjax
function callAjax(url, method, data) {
    return $.ajax({
        type: method,
        url: url,
        contentType:'application/json; charset=utf-8',
        data: data,
        cache: false
    });
}


function showMessage(message,action){
	(action == true) ? alertify.notify(message, 'success', 3) : alertify.notify(message, 'error', 3);
}



//function upload single file
			function uploadFile(idOfForm,nameOfFolderUpload){
				$.ajax({
			        url: '/sample/admin/user/uploadFile/' + nameOfFolderUpload, //đằng sau uploadFile cần thêm biến folder để chèn ảnh theo class
			        type: "POST",
			        data: new FormData($("#" + idOfForm)[0]),
			        enctype: 'multipart/form-data',
			        processData: false,
			        contentType: false,
			        cache: false,
			        success: function (res) {
			        	console.log(res);
			        },
			        error: function (xhr) {
			        	console.log(xhr);
			        	alert('fail UploadFile');
			        }
			      });
			}


