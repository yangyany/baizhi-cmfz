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
            $("#musicUpdateForm").form('load','${pageContext.request.contextPath}/music/queryById?id=${param.id}');


        });
    </script>


<div style="text-align: center;">
    <form id="musicUpdateForm" method="post">
        <div style="margin-top: 70px;">
            专辑编号:<input readonly="readonly" name="id" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 70px;">
            标题：<input name="title" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            集数：<input name="count" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            作者：<input name="author" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            播音：<input name="broadcast" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            图片：<input name="picpath" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
    </form>
</div>

