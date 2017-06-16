<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/14
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>

    $(function(){
        //构建子页面元素的操作
        $("#inputForm").form('load','${pageContext.request.contextPath}/province/queryOne?id=${param.id}');


    });
</script>


<div style="text-align: center;">
    <form id="inputForm" method="post">
        <div style="margin-top: 70px;">
            省编号:<input readonly="readonly" name="id" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            省名称：<input name="name" class="easyui-textbox" data-options="required:true"/><br/>
        </div>

    </form>
</div>
