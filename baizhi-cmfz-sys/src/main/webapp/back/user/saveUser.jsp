<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/11
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $('#fbUser').filebox({
            buttonText: '选择图片',
            buttonAlign: 'left',

            width:170
        });
        $('#UserAddProvince').combobox({
            width:175,
            required:true,
            multiple:false,
            url:'${pageContext.request.contextPath}/province/queryAllProvince',
            valueField:'id',
            textField:'name',
            value:'请选择'
        })
        $('#UserAddCity').combobox({
            width:175,
            required:true,
            multiple:false,
            url:'${pageContext.request.contextPath}/city/queryAllCity',
            valueField:'id',
            textField:'name',
            value:'请选择'
        })
        $('#UserAddTeacher').combobox({
            width:175,
            required:true,
            multiple:false,
            url:'${pageContext.request.contextPath}/teacher/queryAll',
            valueField:'id',
            textField:'name',
            value:'请选择'
        })
    })

</script>
<div style="text-align: center">
    <form method="post" class="easyui-form" id="fUser" enctype="multipart/form-data">
        <div style="margin-top: 10px">昵称：<input class="easyui-textbox" data-options="required:true" name="name"></div>
        <div style="margin-top: 10px">密码：<input class="easyui-textbox" data-options="required:true" name="password"></div>
        <div style="margin-top: 10px">法名：<input class="easyui-textbox" data-options="required:true" name="legalname"></div>
        <div style="margin-top: 10px">电话：<input class="easyui-textbox" data-options="required:true" name="tel"></div>
        <div style="margin-top: 10px">性别：<input type="radio" name="sex" value="男" checked="checked"/>男&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女"/>女</div>
        <div style="margin-top: 10px">签名：<input class="easyui-textbox" data-options="required:true" name="signature"></div>
        <div style="margin-top: 10px">头像：<input id="fbUser" type="text" style="width:150px" name="aaafile"></div>
        <div style="margin-top: 10px">所在省：<select id="UserAddProvince" name="province.id"/></div>
        <div style="margin-top: 10px">所在市：<select id="UserAddCity" name="city.id"/></div>
        <div style="margin-top: 10px">上师：<select id="UserAddTeacher" name="teacher.id"/></div>
    </form>
</div>

<%--
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ include file="../util.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${prc}/user/saveUser" method="post" >
    请输入手机号：<input name="tel" type="text"/><br/><br/>

    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="注册"/>
</form>
</body>
</html>
--%>
