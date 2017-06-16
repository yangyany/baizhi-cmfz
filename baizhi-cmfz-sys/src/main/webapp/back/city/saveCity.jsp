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
        $('#province_sel').combobox({
            width:175,
            required:true,
            multiple:false,
            url:'${pageContext.request.contextPath}/province/queryAllProvince',
            valueField:'id',
            textField:'name',
            value:'请选择'
        })

    });
</script>

<div style="text-align: center;">
    <form id="cityForm" method="post">
        <div style="margin-top: 70px;">
            市名称：<input name="name" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            所属省：<select id="province_sel" name="province.id"></select>
        </div>
    </form>
</div>
