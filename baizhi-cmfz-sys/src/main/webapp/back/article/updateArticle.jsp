<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/12
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="../util.jsp"%>
<link rel="stylesheet" type="text/css" href="${prc}/back/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${prc}/back/css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${prc}/back/css/IconExtension.css">
<script type="text/javascript" src="${prc}/back/js/jquery.min.js"></script>
<script type="text/javascript" src="${prc}/back/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${prc}/back/js/form.validator.rules.js"></script>
<script type="text/javascript" src="${prc}/back/js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="${prc}/back/editor/kindeditor-common.js"></script>
<script type="text/javascript" src="${prc}/back/editor/kindeditor.js"></script>
<script type="text/javascript" src="${prc}/back/editor/lang/zh_CN.js"></script>
<script type="text/javascript">
    $(function(){
        //构建子页面元素的操作
        $("#articleUpdateForm").form('load','${pageContext.request.contextPath}/article/queryOneArticle?id=${param.id}');


        //富文本編輯器
        KindEditor.ready(function(K) {
            editor = K.create("#editor", {
                themeType:"simple",//修改主题
                height: "600px",
                items: [
                    "source",  "preview","fullscreen","clearhtml","|",
                    "undo", "redo","|",
                    "copy", "paste","plainpaste", "wordpaste", "|",
                    "justifycenter", "justifyright",
                    "justifyfull", "insertorderedlist", "insertunorderedlist", "indent", "outdent",  "|",
                    "formatblock", "fontname", "fontsize",
                    "forecolor", "hilitecolor", "bold",
                    "italic", "underline", "strikethrough", "lineheight", "removeformat", "|", "image","table", "hr", "emoticons", "baidumap", "pagebreak",
                    "anchor", "link", "unlink"
                ],
                langType: 'zh_CN',
                syncType: "form",
                filterMode: false,
                pagebreakHtml: '<hr class="pageBreak" \/>',
                allowFileManager: true,
                filePostName: "image",
                fileManagerJson:"${pageContext.request.contextPath }/imgs/browser",
                uploadJson:  "${pageContext.request.contextPath }/imgs/uploadImg",
                extraFileUploadParams: {
                    token: getCookie("token")
                },
                afterChange: function() {
                    this.sync();
                }
            });
        });

        $('#ArticleType').combobox({
            required:true,
            value:'请选择',
            width:170
        })
        $('#subArticle').linkbutton({
            text:'提交',
            width:60,
            height:35,
            onClick:function(){
                $('#articleUpdateForm').form('submit',{
                    url:'${prc}/article/updateArticle',
                    success:function(){
                        $.messager.show({
                            title:'我的消息',
                            msg:'修改成功',
                            timeout:300,
                            showType:'slide'
                        });
                    }
                })
            }
        })
        $('#butt').linkbutton({
            text:'返回主页',
            width:70,
            height:35,
            onClick:function(){
                $('#butt').prop('href','${prc}/back/main/main.jsp')
            }

        })
    });
</script>

<div style="text-align: center;">
    <form id="articleUpdateForm" method="post" >
        <div style="margin-top: 70px;">
            编号：<input readonly="readonly" name="id" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            标题：<input name="title" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            作者：<input name="author" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            创建日期：<input name="creatdate" readonly="readonly" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px">
            类型：<select name="type" id="ArticleType">

            <option value="0">上师言教</option>
            <option value="1">显密法要</option>
        </select></div>

        <div style="margin-top: 10px;">
            <textarea id="editor" name="content" class="editor" style="width: 90%;display: none"></textarea>
        </div>
        <br/><br/>
        <a id="subArticle"></a>
        <a id="butt"></a>
    </form>
</div>
