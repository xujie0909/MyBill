/*message 组件初始化*/
$(function () {
    Messenger.options = {
        extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
        theme: 'ice'
    }
})


function checkForm() {
    var somethingDo = $("#somethingDo").val();
    var money = $("#money").val();
    var category = $("#category").val();
    if (somethingDo == null || somethingDo == "") {
        return false;
    } else if (money == null || money == "") {
        return false;
    } else if (category == null || category == "") {
        return false;
    }
    return true;
}

function submitBillForm() {
    //表单校验
    var isPass = checkForm();
    if(isPass){
        $("#billForm").submit();
    }else{
        Messenger().post({
            message: '表单不完整，请重新填!',
            type: 'error',
            showCloseButton: true
        });
    }
}