<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>记账小本本</title>

    <%--bootstrap--%>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.min.css"/>
    <%--chosen--%>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/jqueryChosen/chosen.css"/>
    <%--queryDataTablejs--%>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/dataTable/dataTables.bootstrap4.css"/>
    <%--calender css--%>
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/calender/calendar.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/calender/myCalender.css"/>
    <%--公共js--%>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js" type="text/javascript"
            charset="utf-8"></script>
    <%--bootstrap--%>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js" type="text/javascript"
            charset="utf-8"></script>
    <%--chosenJS--%>
    <script src="${pageContext.request.contextPath}/resources/js/jqueryChosen/chosen.jquery.min.js"
            type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bill/index.js" type="text/javascript"
            charset="utf-8"></script>
    <%--queryDataTablejs--%>
    <script src="${pageContext.request.contextPath}/resources/js/dataTable/jquery.dataTables.min.js"
            type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dataTable/dataTables.bootstrap4.js"
            type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dataTable/myTable.js" type="text/javascript"
            charset="utf-8"></script>
    <style>
        .chosen-container {
            margin-left: 10px;
        }
        /*调试专用*/
       /*div {
            border: #0c0c0c solid 1px;
        }*/
    </style>
</head>
<body scroll="no" style="overflow-x:hidden">
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <div id="demo">
            <div id="ca"></div>
            <div id="dd"></div>
        </div>
    </div>
    <%--<div class="col-md-4" align="center" style="margin-top: 200px;margin-left: 22px">--%>
    <div class="col-md-5" align="center" style="margin-top: 200px;">
        <div class="alert alert-danger" align="center" id="errmsg" role="alert" style="display: none"></div>
        <div class="alert alert-success" id="warnmsg" role="alert" style="display:none;" ondblclick="displaynone()">正在修改历史账单！(双击返回)</div>
        <form class="form-inline" id="billForm" style="margin-left: 20px;margin-top: 25px" action="/bill/bill.do" method="post">
            <div>
                <%--隐藏域--%>
                <div class="form-group" style="display: none">
                    <input type="text" style="margin-left: 10px" class="" id="createTime"
                           name="createTime" autocomplete="off">
                    <input type="text" style="margin-left: 10px" class="" id="id"
                           name="id" autocomplete="off">
                    <%--0-新增；1=更新--%>
                    <input type="text" style="margin-left: 10px" class="" id="flag"
                           name="flag" autocomplete="off" value="0">
                    <%--<input type="text" style="margin-left: 10px" class="" id="happenTime"
                           name="happenTime" autocomplete="off">--%>
                </div>
                <%--展示域--%>
                    <div class="form-group">
                        <label for="somethingDo">时&nbsp;&nbsp;&nbsp;&nbsp;间</label>
                        <input type="text" style="margin-left: 10px" class="form-control mainInput" id="happenTime"
                               name="happenTime" placeholder="时间" autocomplete="off">
                    </div>
                <div class="form-group" style="margin-top: 10px">
                    <label for="somethingDo">事&nbsp;&nbsp;&nbsp;&nbsp;项</label>
                    <input type="text" style="margin-left: 10px" class="form-control mainInput" id="somethingDo"
                           name="somethingDo" placeholder="事项" autocomplete="off">
                </div>
                <div class="form-group" style="margin-top: 10px">
                    <label for="money">金&nbsp;&nbsp;&nbsp;&nbsp;额</label>
                    <input type="text" style="margin-left: 10px" class="form-control mainInput" id="money" name="money"
                           placeholder="金额" autocomplete="off">
                </div>
                <div class="form-group" style="margin-top: 10px">
                    <label for="payType">支&nbsp;&nbsp;&nbsp;&nbsp;付</label>
                    <select class="form-control mainInput" id="payType" name="payType"
                            style="width: 182px;margin-left: 10px" data-placeholder="选择支付方式">
                        <option value="1" selected="selected">微信</option>
                        <option value="2">支付宝</option>
                        <option value="3">现金</option>
                    </select>
                </div>
                <div class="form-group" id="categoryDiv" style="margin-top: 10px">
                    <label for="category">分&nbsp;&nbsp;&nbsp;&nbsp;类</label>
                    <select class="chosen-select mainInput" id="category" name="category"
                            style="width: 182px;margin-left: 10px" data-placeholder="选择分类标签" multiple>
                    </select>
                    <button class="btn btn-default" type="button" id="addNewCategory" style="margin-left: 10px">添加
                    </button>
                </div>
                <div class="form-group" id="newCategory" style="margin-top: 10px ; display: none">
                    <label for="somethingDo">新分类</label>
                    <input type="text" style="margin-left: 10px" class="form-control mainInput" id="exCategory"
                           name="exCategory" autocomplete="off">
                </div>
                <div class="form-group radio text-center" style="width: 100%; margin-top: 10px;margin-left: 70px">
                    <label>
                        <input type="radio" name="inOutFlag" id="inOrout1" value="1">收
                    </label>
                    <label>
                        <input type="radio" name="inOutFlag" style="margin-left: 40px" id="inOrout2" value="0" checked>支
                    </label>
                </div>

                <div class="form-group text-center" style="margin-top: 10px">
                    <label id="submitButton">
                        <button type="button" style="margin-left: 90px" class="btn btn-default text-center"
                                onclick="submitBillForm()">提交
                        </button>
                    </label>
                </div>
            </div>
        </form>

    </div>
    <div class="col-md-1" style="margin-top: 30px">
        <div>
        </div>
    </div>
</div>
</div>
<div class="row" >
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="container" >
            <table id="myTable" class="table table-striped table-bordered" cellspacing="0">
                <thead>
                <tr>
                    <%--<td>id</td>--%>
                    <td>happenTime</td>
                    <td>inOutFlag</td>
                    <td>somethingDo</td>
                    <td>category</td>
                    <td>money</td>
                    <td>payType</td>
                    <td>createTime</td>
                    <td>updateTime</td>
                </tr>
                </thead>
            </table>
        </div>
    </div>
    <div class="col-md-1"></div>
</div>
<%--calender js--%>
<script src="${pageContext.request.contextPath}/resources/js/calender/calendar.js" type="text/javascript"
        charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/calender/myCalender.js" type="text/javascript"
        charset="utf-8"></script>
</body>
</html>
