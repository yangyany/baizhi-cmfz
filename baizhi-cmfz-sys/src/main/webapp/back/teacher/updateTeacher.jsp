<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/12
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

    <script>

        $(function(){
            //构建子页面元素的操作
            $("#inputForm").form('load','${pageContext.request.contextPath}/teacher/queryById?id=${param.id}');


        });
    </script>


<div style="text-align: center;">
    <form id="inputForm" method="post">
        <div style="margin-top: 70px;">
            上师编号:<input readonly="readonly" name="id" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            上师名称：<input name="name" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            头像：<input name="picpath" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
    </form>
</div>

