<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ include file="../util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $("#musDg");
        $da = $("#musDa");
        $dg.datagrid({
            url: '${prc}/music/queryMusicByPage',
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
                {title: "集数", field: "count", width: 200, align: 'center'},
                {title: "作者", field: "author", width: 200, align: 'center'},
                {title: "播音", field: "broadcast", width: 200, align: 'center'},
                {title: "图片", field: "picpath", width: 200, align: 'center',
                    formatter:function(value,row,index){
                        return "<a target='_black' href='${pageContext.request.contextPath}/back/image/"+row.picpath+"'><img src='${pageContext.request.contextPath}/back/image/"+row.picpath+"' width='100px',height='100px'></a>"

                    }
                },
                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"delMusic('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editMusic('" + row.id + "')\"  href='javascript:;'>修改</a>";
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
            toolbar:'#musicTb',
        });
    });


    //删除的操作
    function delMusic(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('${pageContext.request.contextPath}/music/delete',{'id':id},function () {
                    $dg.datagrid('reload');
                })
            }
        });
    }


    //修改的操作
    function editMusic(id){
        $da.dialog({
            width:600,
            height:300,
            title:"专辑详细信息",
            iconCls:"icon-man",
            href:'${pageContext.request.contextPath}/back/music/updateMusic.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:savemusic,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }


    //保存修改上师
    function savemusic(){
        $("#musicUpdateForm").form('submit',{
            url:'${pageContext.request.contextPath}/music/updateMusic',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //添加操作
    function addMusic() {
        $da.dialog({
            width:600,
            height:300,
            title:"添加专辑",
            iconCls:"icon-user_female",
            href:'${pageContext.request.contextPath}/back/music/saveMusic.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:savemusicAdd,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //保存添加
    function savemusicAdd() {
        $("#musicSaveForm").form('submit',{
            url:'${pageContext.request.contextPath}/music/saveMusic',
            success:function () {
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        })
    }
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

        <div id="musicTb">
            <a href="javascript:;" onClick="addMusic()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        </div>

    </div>
</div>




