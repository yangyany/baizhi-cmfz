<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/14
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $("#cityDg");
        $da = $("#cityDa");
        $dg.datagrid({
            url: '${prc}/city/queryCiytByPage',
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
                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"delCity('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editCity('" + row.id + "')\"  href='javascript:;'>修改</a>";
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
            toolbar:'#cityTb',
        });
    });


    //删除的操作
    function delCity(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('${prc}/city/deleteCity',{'id':id},function () {
                    $dg.datagrid('reload');
                })
            }
        });
    }


    //修改的操作
    function editCity(id){
        $da.dialog({
            width:600,
            height:300,
            title:"省详细信息",
            iconCls:"icon-man",
            href:'${prc}/back/city/updateCity.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:savecity,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }


    //保存修改上师
    function savecity(){
        $("#inputForm").form('submit',{
            url:'${prc}/city/updateCity',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //添加操作
    function addCity() {
        $da.dialog({
            width:600,
            height:300,
            title:"添加省",
            iconCls:"icon-user_female",
            href:'${prc}/back/city/saveCity.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveCityAdd,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //保存添加
    function saveCityAdd() {
        $("#cityForm").form('submit',{
            url:'${prc}/city/saveCity',
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
        <table id="cityDg" ></table>


        <div id="cityDa" style="height: 1%;"></div>

        <div id="cityTb">
            <a href="javascript:;" onClick="addCity()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
        </div>

    </div>
</div>





