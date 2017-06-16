<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/12
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../util.jsp"%>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${prc}/back/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${prc}/back/css/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${prc}/back/css/IconExtension.css">
    <script type="text/javascript" src="${prc}/back/js/jquery.min.js"></script>
    <script type="text/javascript" src="${prc}/back/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${prc}/back/js/form.validator.rules.js"></script>
    <script type="text/javascript" src="${prc}/back/js/easyui-lang-zh_CN.js"></script>


    <script>

            //用来提交表单
            function subForm(){
                $("#ff").form('submit',{
                    url:'${prc}/admin/login',
                    success:function(data){
                        console.log(data);
                        console.log($.parseJSON(data));
                    }
                });
            }


    </script>
    <style type="text/css">
        .setbg{
            background: url("spring.jpg");
            height: 500px;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="setbg">
    <form style="margin: 0 auto;" method="post"  id="ff" class="easyui-form" data-options="iframe:false,novalidate:false">
        用户名:<input class="easyui-textbox" name="username" data-options="required:true"/><br/>
        密码:<input class="easyui-passwordbox" name="password" data-options="required:true"/><br/>

        <a href="javascript:subForm();" class="easyui-linkbutton" data-options="">提交</a>
    </form>

</div>

</body>
</html>
