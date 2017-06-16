<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/13
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>

    $(function(){
        //构建子页面元素的操作
        $("#inputForm").form('load','${pageContext.request.contextPath}/picture/queryOne?id=${param.id}');

    });
</script>


<div style="text-align: center;">
    <form id="inputForm" method="post">
        <div style="margin-top: 70px;">
            图片编号:<input readonly="readonly" name="id" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            图片描述：<input name="title" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            图片名称：<input name="name" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            图片是否轮播：<select name="type">
                            <option value="0" > 不轮播</option>
                            <option value="1">轮播</option>
                        </select>
        </div>
    </form>
</div>
