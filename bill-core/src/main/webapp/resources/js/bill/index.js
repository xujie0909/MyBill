//常量
var errmsg_form = "表单未填写完整，请重新填写";
// var errmsg_getCagegory = "请求ajax出错了!";
// var requestMethod = "";

//初始化方法入口
$(function () {
    init();
})

//页面初始化
function init() {

    //事件绑定
    eventBind();
    //初始化事件
    initDate();

}

//初始化输入框日期
function initDate() {
    //初始化事项时间
    var myDate = new Date();
    var fullYear = myDate.getFullYear(); //获取完整的年份(4位,1970-????)
    var month = myDate.getMonth() + 1; //获取当前月份(0-11,0代表1月)
    var date = myDate.getDate(); //获取当前日(1-31)
    var time = fullYear + "-" + month + "-" + date;
    $("#ictime").val(time);

    //初始化提交按钮
    $("#submitButton").html('<button type="button" style="margin-left: 90px" class="btn btn-default text-center"\n' +
        '                                onclick="submitBillForm()">提交\n' +
        '                        </button>')
}

//表单校验
function checkForm() {
    var somethingDo = $("#somethingDo").val();
    var money = $("#money").val();
    var category = $("#category").val();
    if (somethingDo == "") {
        console.log("事项未填写！")
        return false;
    } else if (money == "") {
        console.log("金额未填写！")
        return false;
    }
    //校验目录
    var category = $("#category").val();
    var exCategory = $("#exCategory").val();
    if (category != "" || exCategory != "") {
        return true;
    } else {
        return false;
    }
}

function submitBillForm() {
    var isPass = checkForm();

    if (isPass) {
        $("#billForm").submit();
    } else {
        $("#errmsg").html(errmsg_form)
        $("#errmsg").show(300)
    }
}

//事件绑定
function eventBind() {

    //主要输入框的错误提示
    $(".mainInput").click(function () {
        $("#errmsg").hide(300)
    })
}

//恢复添加模式
function displaynone() {
    $("#warnmsg").hide(300);
    $("#submitButton").html('<button type="button" style="margin-left: 90px" class="btn btn-default text-center"\n' +
        '                                onclick="submitBillForm()">提交\n' +
        '                        </button>')
    $("#somethingDo").val("");
    $("#money").val("");
    $("#payType").val("");
    $("#category").val("");
    $("#id").val("");
    $("#flag").val("0"); //改为新增模式
}

//选择标签
function selectTag(value) {
    var tag = $("#selectedTag").val();
    if(tag == ""){
        $("#selectedTag").val(value)
    }else{
        $("#selectedTag").val(tag + "，" + value)
    }
}

//记录新标签标签
function saveNewTag(){

    var newTag = $("#newTag").val();
    if(newTag != ""){
        selectTag(newTag)
    }
}

//记录所有标签
function saveTags(){

    var selectedTag = $("#selectedTag").val()
    $("#tags").val(selectedTag)
    $('#myModal').modal('hide')

    cloeseModel()
}

function cloeseModel(){
    //清理
    $("#selectedTag").val("");
    $("#newTag").val("");
    $('#myModal').modal('hide')
}
