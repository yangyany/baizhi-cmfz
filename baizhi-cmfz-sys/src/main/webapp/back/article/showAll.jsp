<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ include file="../util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $("#musDg");
        $da = $("#musDa");
        $dg.datagrid({
            url: '${prc}/article/queryArtByPage',
            //fit:true,
            width:'100%',
            height:'100%',
            sortName:'id',
            remoteSort:false,
            fitColumns:true,
            method:'get',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "标题", field: "title", width: 200, align: 'center'},
                {title: "作者", field: "author", width: 200, align: 'center'},
                {title: "創建日期", field: "creatdate", width: 200, align: 'center'},
/*
                {title: "内容", field: "content", width: 200, align: 'center'},
*/
                {title: "類型", field: "type", width: 200, align: 'center',
                    formatter:function (value,row,index) {
                        if(value=='0'){
                            return "上师言教";
                        } else {
                           return "显密法要";

                        }
                    }
                },

                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"delArticle('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit'   href='${prc}/back/article/updateArticle.jsp?id="+row.id+"'>修改</a>";
                    }
                }
            ]],
            onLoadSuccess: function (data) {
               // console.log(data);
                $(".del").linkbutton({
                    plain: true,
                    iconCls: 'icon-remove',

                });
                $(".edit").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });
            },
            pagination:true,
            pageNumber:2,
            pageSize:2,
            pageList:[2,4,6,8,10],
            toolbar:'#articleTb',
        });
    });


    //删除的操作
    function delArticle(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('${pageContext.request.contextPath}/article/deleteArticle',{'id':id},function () {
                    $dg.datagrid('reload');
                })
            }
        });
    }


    //修改的操作
/*    function editArticle(id){
        $da.dialog({
            width:600,
            height:300,
            title:"专辑详细信息",
            iconCls:"icon-man",
            href:'/back/article/updateArticle.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveArticles,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }


    //保存修改上师
    function saveArticles(){
        $("#musicUpdateForm").form('submit',{
            url:'article/updateArticle',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }*/
    //添加操作
   /* function addArticle() {
        $da.dialog({
            width:600,
            height:300,
            title:"添加专辑",
            iconCls:"icon-user_female",
            href:'/back/article/saveArticle.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveArticleAdd,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //保存添加
    function saveArticleAdd() {
        $("#musicSaveForm").form('submit',{
            url:'/article/saveArticle',
            success:function () {
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        })
    }*/
    //关闭对话框
    function closeDa(){
        $da.dialog('close',true);
    }

    //搜索的处理程序
    function search(value,name){

        $dg.datagrid('load',{
            name:value
        });
    }

</script>


<div  class="easyui-layout" data-options="fit:true" >
    <div data-options="region:'north'," style="height:50px;">
        <div style="text-align: center;margin: 10px 0px 10px 0px;">
            <input id="ss" class="easyui-searchbox" style="width:300px"
                   data-options="searcher:search,prompt:'Please Input Value',menu:'#mm'"/>
            <div id="mm" style="width:120px">
                <div data-options="name:'name',iconCls:'icon-ok'">名字</div>
            </div>
        </div>
    </div>
    <div data-options="region:'center'," style="height: 30%;">
        <table id="musDg" ></table>


        <div id="musDa" style="height: 1%;"></div>

        <div id="articleTb">
            <a href="${prc}/back/article/saveArticle.jsp"  class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        </div>

    </div>
</div>




