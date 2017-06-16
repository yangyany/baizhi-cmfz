<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/13
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function () {
        $('#PictureType').combobox({
            required:true,
            value:'请选择',
            width:170
        })
        $('#subPicture').linkbutton({
            text:'提交',
            width:60,
            height:30,
            onClick:function(){
                $('#savePictureForm').form('submit', {
                    url:'${pageContext.request.contextPath}/picture/upload' ,
                    success:function () {
                        $.messager.show({
                            title:'我的消息',
                            msg:'保存成功',
                            timeout:300,
                            showType:'slide'
                        });
                    }
                })
            }
        })

    })
</script>
<div style="text-align: center;">
    <form id="savePictureForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            选择图片: <input class="easyui-filebox" data-options="required:true" name="file"/><br/>
        </div>
        <div style="margin-top: 10px;">
            图片描述：<input class="easyui-textbox" type="text"  name="title"/><br/>
        </div>
        <div style="margin-top: 10px;">
            图片是否轮播：<select name="type" id="PictureType">
                <option value="0" > 不轮播</option>
                <option value="1">轮播</option>
            </select>
        </div>

            <a id="subPicture"></a>

    </form>
</div>


</form>

