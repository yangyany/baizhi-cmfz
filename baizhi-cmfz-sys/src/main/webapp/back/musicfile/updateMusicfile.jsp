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
            $("#musicfileUpdateForm").form('load','${pageContext.request.contextPath}/musicfile/queryOneMusicfile?id=${param.id}');
            $('#musicfile_sel').combobox({
                width:175,
                required:true,
                multiple:false,
                url:'${pageContext.request.contextPath}/music/queryAllMusic',
                valueField:'id',
                textField:'title',
                value:'请选择'
            })


        });
    </script>


<div style="text-align: center;">
    <form id="musicfileUpdateForm" method="post">
        <div style="margin-top: 70px;">
            专辑编号:<input readonly="readonly" name="id" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            标题：<input name="title" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            名称：<input name="name" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            专辑：<select id="musicfile_sel" name="music.id"></select>
        </div>
    </form>
</div>

