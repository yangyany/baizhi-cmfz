
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        $.post('${pageContext.request.contextPath}/user/queryOneUser',{"id":"${param.id}"},function (user) {
            $('#idProvince').val(user.id);
            $('#UserName').textbox({
                value:user.name,
            });
            $('#picth').textbox({
                value:user.picpath,
            })
            $('#UserLegalname').textbox({
                value:user.legalname,
            });
            $('#UserTel').textbox({
                value:user.tel,
            });$('#UserSignature').textbox({
                value:user.signature,
            });

            $.post("${pageContext.request.contextPath}/province/queryAllProvince",function(province1){
                $.each(province1,function (i,province) {
                    var $option = $('<option></option>');
                    $option.prop("value",province.id).prop("text",province.name);
                    if(user.province.id==province.id){
                        $option.prop("selected",true) ;
                    }
                    $('#UserAddProvince_sel').append($option);
                });

                $('#UserAddProvince_sel').combobox({
                    width:175,
                    required:true,
                    multiple:false,
                })
            },"JSON");
            $.post("${pageContext.request.contextPath}/city/queryAllCity",function(city1){
                $.each(city1,function (i,city) {
                    var $option = $('<option></option>');
                    $option.prop("value",city.id).prop("text",city.name);
                    if(user.city.id==city.id){
                        $option.prop("selected",true) ;
                    }
                    $('#UserAddCity_sel').append($option);
                });

                $('#UserAddCity_sel').combobox({
                    width:175,
                    required:true,
                    multiple:false,
                })
            },"JSON");
            $.post("${pageContext.request.contextPath}/teacher/queryAll",function(teacher1){
                $.each(teacher1,function (i,teacher) {
                    var $option = $('<option></option>');
                    $option.prop("value",teacher.id).prop("text",teacher.name);
                    if(user.teacher.id==teacher.id){
                        $option.prop("selected",true) ;
                    }
                    $('#UserAddTeacher_sel').append($option);
                });

                $('#UserAddTeacher_sel').combobox({
                    width:175,
                    required:true,
                    multiple:false,
                })
            },"JSON");
        },'JSON');
    });
</script>
<div style="text-align: center">
    <form method="post" class="easyui-form" id="ffUser">
        <div style="margin-top: 30px"><input type="hidden" data-options="required:true" id="idUser" name="id"></div>
        <div style="margin-top: 10px">昵称：<input class="easyui-textbox" data-options="required:true" name="name" id="UserName"></div>
        <div style="margin-top: 10px">法名：<input class="easyui-textbox" data-options="required:true" name="legalname" id="UserLegalname"></div>
        <div style="margin-top: 10px">电话：<input class="easyui-textbox" data-options="required:true" name="tel" id="UserTel"></div>
        <div style="margin-top: 10px">性别：<input type="radio" name="sex" value="男" checked="checked"  />男&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女"/>女</div>
        <div style="margin-top: 10px">签名：<input class="easyui-textbox" data-options="required:true" name="signature" id="UserSignature"></div>
        <div style="margin-top: 10px">图像名<input class="easyui-textbox" data-options="required:true" name="picpath" id="picth"></div>
        <div style="margin-top: 10px">所在省：<select id="UserAddProvince_sel" name="province.id"/></div>
        <div style="margin-top: 10px">所在市：<select id="UserAddCity_sel" name="city.id"/></div>
        <div style="margin-top: 10px">上师：<select id="UserAddTeacher_sel" name="teacher.id"/></div>
    </form>
</div>
