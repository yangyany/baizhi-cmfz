
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../util.jsp"%>

<html>
<head>
    <title>Title</title>
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
    <script>
        var $aa,$tt
        $(function () {
            $aa=$("#menus");
            $tt=$("#tt");

            //初始化系统菜单
            $.post("${prc}/accordion/queryAllAccordion",function (menus) {
                $.each(menus,function (i,menu) {
                    var content="<div style='text-align: center'>";
                    $.each(menu.children,function (j,child) {

                        content +="<div onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" class='easyui-linkbutton' style='text-align: center;width: 150px;' data-options=\"iconCls:'"+child.iconCls+"'\">"+child.name+"</div>"+"<br/>"
                    })
                    content+="</div>";
                    $aa.accordion('add',{
                        title:menu.name,
                        iconCls:menu.iconCls,
                        content:content,
                    });
                });
            },"JSON");
        })

        //添加选项卡
        function  addTabs(title,iconCls,href){
            if(!$tt.tabs('exists',title)){
                $tt.tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    href:"${prc}/"+href,
                    closable:true,
                });
            }else{
                $tt.tabs('select',title)
            }

        }
    </script>
</head>
<body class="easyui-layout">

<div data-options="region:'north',split:false" style="height:70px;">
    <div style="text-align: center;font-size: 37px;color: #1f637b">持明法洲系统管理页面</div>
</div>
<div data-options="region:'south',split:false" style="height:50px;"></div>

<div data-options="region:'west',split:false,title:'系统菜单'," style="width:200px;text-align: center">
    <div style="text-align: center" id="menus" class="easyui-accordion" data-options="fit:true"></div>
</div>
<div data-options="region:'center',title:'主页',iconCls:'icon-house'"  style="height: 100%;padding:5px;background:#eee;">
    <div id="tt" class="easyui-tabs" style="height: 100%;"></div>
</div>

</body>
</html>