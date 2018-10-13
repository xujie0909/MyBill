<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>记账小本本</title>
    <%--bootstrap--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-grid.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-grid.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-reboot.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.min.css"/>
    <%--message 组件--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/messenger/messenger.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/messenger/messenger-theme-future.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/messenger/messenger-spinner.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/messenger/messenger-theme-ice.css"/>
    <%--公共--%>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <%--bootstrap--%>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.bundle.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <%--message 组件--%>
    <script src="${pageContext.request.contextPath}/resources/js/messenger/messenger.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/resources/js/messenger/messenger-theme-future.js" type="text/javascript" charset="utf-8"></script>
    <%--自定义js--%>
    <script src="${pageContext.request.contextPath}/resources/js/bill/index.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-2">
        <form class="form-inline" style="margin-top: 200px;margin-left: 22px" id="billForm" action="/bill/bill.do" method="post">
            <div style="" >
            <div class="form-group">
                <label for="money">事项</label>
                <input type="text" style="margin-left: 10px" class="form-control" id="somethingDo" name="somethingDo" placeholder="事项" autocomplete="off">
            </div>
            <div class="form-group" style="margin-top: 10px">
                <label for="money">金额</label>
                <input type="text" style="margin-left: 10px" class="form-control" id="money" name="money" placeholder="金额" autocomplete="off">
            </div>
            <div class="form-group" style="margin-top: 10px">
                <label for="money">分类</label>
                <input type="text" style="margin-left: 10px" class="form-control" id="category" name="category" placeholder="分类" autocomplete="off">
            </div>
            <div class="form-group radio text-center" style="width: 100%; margin-top: 10px">
                <label>
                    <input type="radio" name="inOutFlag" id="inOrout1" value="1">收
                </label>
                <label>
                    <input type="radio" name="inOutFlag" id="inOrout2" value="0" checked>支
                </label>
            </div>

            <div class="form-group text-center" style="margin-top: 10px">
                <label>
                    <button type="button" class="btn btn-default text-center" onclick="submitBillForm()">提交</button>
                </label>
            </div>
            </div>
        </form>
    </div>
    <div class="col-md-2" style="margin-top: 30px;margin-left: 10px" >
    </div>
    <div class="col-md-3"></div>
</div>
</div>
</body>
</html>
