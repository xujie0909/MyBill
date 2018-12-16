<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="alert alert-success" id="warnmsg" role="alert" style="display:none;" ondblclick="displaynone()">
            正在修改历史账单！(双击返回)
        </div>
        <form class="form-inline" id="billForm" style="margin-left: 20px;margin-top: 25px" action="/item/item.do"
              method="post">
            <div>
                <%--隐藏域--%>
                <%--<div class="form-group" style="">
                    <input type="text" style="margin-left: 10px" class="" id="createTime"
                           name="createTime" autocomplete="off">
                    <input type="text" style="margin-left: 10px" class="" id="id"
                           name="id" autocomplete="off">
                    &lt;%&ndash;0-新增；1=更新&ndash;%&gt;
                    <input type="text" style="margin-left: 10px" class="" id="flag"
                           name="flag" autocomplete="off" value="0">
                    &lt;%&ndash;<input type="text" style="margin-left: 10px" class="" id="happenTime"
                           name="happenTime" autocomplete="off">&ndash;%&gt;
                </div>--%>
                <%--展示域--%>
                <div class="form-group">
                    <label for="ictime">时&nbsp;&nbsp;&nbsp;&nbsp;间</label>
                    <input type="text" style="margin-left: 10px" class="form-control mainInput" id="ictime"
                           name="ictime" placeholder="时间" autocomplete="off">
                </div>
                <div class="form-group" style="margin-top: 10px">
                    <label for="iname">事&nbsp;&nbsp;&nbsp;&nbsp;项</label>
                    <input type="text" style="margin-left: 10px" class="form-control mainInput" id="iname"
                           name="iname" placeholder="事项" autocomplete="off">
                </div>
                <div class="form-group" style="margin-top: 10px">
                    <label for="imoney">金&nbsp;&nbsp;&nbsp;&nbsp;额</label>
                    <input type="text" style="margin-left: 10px" class="form-control mainInput" id="imoney" name="imoney"
                           placeholder="金额" autocomplete="off">
                </div>
                <div class="form-group" style="margin-top: 10px">
                    <label for="itype">支&nbsp;&nbsp;&nbsp;&nbsp;付</label>
                    <select class="form-control mainInput" id="itype" name="itype"
                            style="width: 182px;margin-left: 10px" data-placeholder="选择支付方式">
                        <option value="1" selected="selected">微信</option>
                        <option value="2">支付宝</option>
                        <option value="3">现金</option>
                    </select>
                </div>
                <div class="form-group" id="categoryDiv" style="margin-top: 10px">
                    <label>标&nbsp;&nbsp;&nbsp;&nbsp;签</label>
                    <input type="text" style="margin-left: 10px" class="form-control mainInput" id="tags" name="tags"
                           placeholder="标签" autocomplete="off">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary btn-md" style="margin-left: 10px" data-toggle="modal"
                            data-target="#myModal">
                        选择标签
                    </button>
                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">关闭</span></button>--%>
                                    <h4 class="modal-title" id="myModalLabel">选择标签</h4>
                                </div>
                                <div class="modal-body">
                                    <div>
                                        <div>
                                            已选择：
                                            <input type="text" style="color:red;" id="selectedTag">
                                        </div>
                                        <div style="margin-top: 10px">
                                            <c:forEach items="${hotTags}" var="tag">
                                                <input class="btn btn-warning" type="button" value="${tag}"
                                                       ondblclick="selectTag(value)">
                                            </c:forEach>
                                        </div>

                                        <div style="margin-top: 10px;margin-left: 50px">
                                            其&nbsp;&nbsp;他：
                                            <input type="text" id="newTag" value="">
                                            <input class="btn btn-success btn-sm" style="margin-left: 10px"
                                                   type="button" onclick="saveNewTag()" value="添加">
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" onclick="cloeseModel()">关闭</button>
                                    <button type="button" class="btn btn-primary" aria-hidden="true" onclick="saveTags()">保存</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group radio text-center" style="width: 100%; margin-top: 10px;margin-left: 70px">
                    <label>
                        <input type="radio" name="inOut" id="inOut1" value="1">收
                    </label>
                    <label>
                        <input type="radio" name="inOut" style="margin-left: 40px" id="inOrout2" value="0" checked>支
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
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <div class="container">
            <table id="myTable" class="table table-striped table-bordered" cellspacing="0">
                <thead>
                <tr>
                    <%--<td>id</td>--%>
                    <td>事件</td>
                    <td>收/支</td>
                    <td>名称</td>
                    <td>标签</td>
                    <td>金额</td>
                    <td>支付方式</td>
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
