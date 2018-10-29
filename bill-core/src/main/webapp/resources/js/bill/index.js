//常量
var errmsg_form = "表单未填写完整，请重新填写";
var errmsg_getCagegory = "请求ajax出错了!";
var requestMethod = "";

//初始化方法入口
$(function () {
    init();
})

//页面初始化
function init() {
    eventBind();
    getHighCategory();
    $("#category").chosen({
        no_results_text: "没有找到结果！",//搜索无结果时显示的提示
        search_contains:true,   //关键字模糊搜索，设置为false，则只从开头开始匹配
        allow_single_deselect:true, //是否允许取消选择
        display_selected_options:false
    });
    initDate();
}

//初始化输入框日期
function initDate(){
    //初始化事项时间
    var myDate  = new Date();
    var fullYear = myDate.getFullYear(); //获取完整的年份(4位,1970-????)
    var month = myDate.getMonth() + 1; //获取当前月份(0-11,0代表1月)
    var date = myDate.getDate(); //获取当前日(1-31)
    var time = fullYear+"-"+month+"-"+date;
    $("#happenTime").val(time);

    //初始化提交按钮
    $("#submitButton").html('<button type="button" style="margin-left: 90px" class="btn btn-default text-center"\n' +
        '                                onclick="submitBillForm()">提交\n' +
        '                        </button>')
}

//获取高频分类标签
function getHighCategory() {
    $.ajax({
        url: "/category/highFrequencyCategory.do",
        type: 'GET',
        success: function (result) {
            $.each(result,function(i,j){
                $("#category").append("<option value='"+j+"'>"+j+"</option>");
            })

        },
        error: function (jqXHR) {
            $("#errmsg").html(errmsg_getCagegory)
            $("#errmsg").show(300)
            console.log(JSON.stringify(jqXHR));
        },
        async:false,//必须要有，不能丢
        dataType: "json"
    });
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
    if(category != "" || exCategory != ""){
        return true;
    }else{
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
function eventBind(){
    $(".mainInput").click(function () {
        $("#errmsg").hide(300)
    })
    $('#category').on('chosen:showing_dropdown', function(e, params) {
        $("#errmsg").hide(300)
    });
    $('#category').on('chosen:no_results', function(e, params) {
    });
    $("#addNewCategory").click(function(){
        var oldCategory = $("#exCategory").val();
        if(oldCategory != ""){
            $("#exCategory").val(oldCategory + "；"+$(".chosen-search-input").val() == "选择分类标签"?"":$(".chosen-search-input").val());
        }else{
            $("#exCategory").val($(".chosen-search-input").val() == "选择分类标签"?"":$(".chosen-search-input").val());
        }
        $("#newCategory").show();

    })
}

//恢复添加模式
function displaynone(){
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
