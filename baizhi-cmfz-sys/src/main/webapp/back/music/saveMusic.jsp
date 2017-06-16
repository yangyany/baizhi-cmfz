<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/12
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<div style="text-align: center;">
    <form id="musicSaveForm" method="post" enctype="multipart/form-data">
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
            图片：<input name="aaa" class="easyui-filebox" data-options="required:true"/><br/>
        </div>
    </form>
</div>

