<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ include file="../util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $("#counDg");
        $da = $("#counDa");
        $dg.datagrid({
            url:'${prc}/counter/queryCountByPage',
            //fit:true,
            width:'100%',
            height:'100%',
            sortName:'id',
            remoteSort:false,
            fitColumns:true,
            method:'get',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "名称", field: "name", width: 200, align: 'center'},
                {title: "创建日期", field: "creatdate", width: 200, align: 'center'},
                {title: "数量", field: "count", width: 200, align: 'center'},
                {title: "记录名称", field: "record", width: 200, align: 'center',
                    formatter:function(value,row,index){
                        return value.name;
                    }
                },
                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"delCounter('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editCounter('" + row.id + "')\"  href='javascript:;'>修改</a>";
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
            toolbar:'#counterTb',
        });
    });


    //删除的操作
    function delCounter(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('${pageContext.request.contextPath}/counter/deleteCounter',{'id':id},function () {
                    $dg.datagrid('reload');
                })
            }
        });
    }


    //修改的操作
    function editCounter(id){
        $da.dialog({
            width:600,
            height:300,
            title:"计数器详细信息",
            iconCls:"icon-man",
            href:'${pageContext.request.contextPath}/back/counter/updateCounter.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveCont,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }


    //保存修改记录
    function saveCont(){
        $("#inputForm").form('submit',{
            url:'${pageContext.request.contextPath}/counter/updateCounter',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //添加操作
    function addCounter() {
        $da.dialog({
            width:600,
            height:300,
            title:"添加计数器",
            iconCls:"icon-user_female",
            href:'${pageContext.request.contextPath}/back/counter/saveCounter.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveCounterAdd,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //保存添加
    function saveCounterAdd() {
        $("#inputForm").form('submit',{
            url:'${pageContext.request.contextPath}/counter/saveCounter',
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
        <table id="counDg" ></table>


        <div id="counDa" style="height: 1%;"></div>

        <div id="counterTb">
            <a href="javascript:;" onClick="addCounter()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        </div>

    </div>
</div>




