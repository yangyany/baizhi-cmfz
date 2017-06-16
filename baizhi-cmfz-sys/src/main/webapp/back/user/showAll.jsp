<%--
  Created by IntelliJ IDEA.
  User: yanyan
  Date: 2017/6/11
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    var $UserDa;
    $(function(){
        $UserDa = $('#UserDa');
        $UserDa.datagrid({
            url:'${pageContext.request.contextPath}/user/queryAllUser',
            fit:true,
            fitColumns:true,
            toolbar: [{
                text:'添加',
                plan: true,
                iconCls: 'icon-add',
                handler: addUser
            }],
            columns:[[
                {field:'id',title:'编号', width:100},
                {field:'name',title:'昵称',width:100},
                {field:'legalname',title:'法名',width:100},
                {field:'tel',title:'电话号码',width:100},
                {field:'sex',title:'性别',width:100},
                {field:'signature',title:'签名',width:100},
                {field:'picpath',title:'图像名',width:100,
                    formatter:function(value,row,index){
                        return "<a target='_black' href='${pageContext.request.contextPath}/back/image/"+row.picpath+"'><img src='${pageContext.request.contextPath}/back/image/"+row.picpath+"' width='100px',height='100px'></a>"

                    }
                },
                {field:'province',title:'所在省',width:100,
                    formatter:function (value,row,index) {
                        return value.name;
                    }
                },
                {field:'city',title:'所在市',width:100,
                    formatter:function (value,row,index) {
                        return value.name;
                    }
                },
                {field:'teacher',title:'上师',width:100,
                    formatter:function (value,row,index) {
                        return value.name;
                    }
                },

                {field:'options',title:'操作',width:100,
                    formatter:function (value,row,index) {
                        return  "<a class='del' onClick=\"delUser('"+ row.id +"')\" href='javascript:;'>删除</a>&nbsp;" +
                                "<a class='edt' onClick=\"editRowUser('"+ row.id +"')\"  href='javascript:;'>修改</a>";
                    }
                }
            ]],
            onLoadSuccess:function () {
                $('.del').linkbutton({
                    plain:true,
                    iconCls:'icon-remove'
                });
                $('.edt').linkbutton({
                    plain:true,
                    iconCls:'icon-edit'
                });
            },
            pagination:true,
            pageNumber:1,
            pageSize:10,
            pageList:[10,20,30,40],
        });

    });
    function delUser(id) {
        $.messager.confirm("删除提示","您确认删除吗?",function (r) {
            if(r){

                $.post('${pageContext.request.contextPath}/user/deleteUser',{"id":id},function (result) {

                    $.messager.show({
                        title:'我的消息',
                        msg:result,
                        timeout:300,
                        showType:'slide'
                    });
                    $UserDa.datagrid('reload');
                },'JSON')
            }
        });
    }
    function editRowUser(id) {
        $('#dgEditUser').dialog({
            width:300,
            height:300,
            title:'用戶信息展示',
            href:'${pageContext.request.contextPath}/back/user/updateUser.jsp?id='+id,
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:sbmitUser,
            },{
                text:'取消',
                iconCls:'icon-cancle',
                handler:cleUser,
            }]
        });
    }
    function sbmitUser() {
        $('#ffUser').form('submit',{
            url:'${pageContext.request.contextPath}/user/updateUser' ,
            success:function () {
                $('#dgEditUser').dialog('close',true);
                $UserDa.datagrid('reload');
            }
        });
    }
    function sbmit1User() {
        $('#fUser').form('submit',{
            url:'${pageContext.request.contextPath}/user/saveUser' ,
            success:function () {
                $('#addUser').dialog('close',true);
                $UserDa.datagrid('reload');
            }
        });
    }
    function cleUser() {
        $('#dgEditUser').dialog('close',true);
    }
    function cle1User() {
        $('#addUser').dialog('close',true);
    }
    function addUser() {
        $('#addUser').dialog({
            width:300,
            height:300,
            title:'添加省',
            href:'${pageContext.request.contextPath}/back/user/saveUser.jsp',
            buttons:[{
                text:'提交',
                iconCls:'icon-save',
                handler:sbmit1User,
            },{
                text:'取消',
                iconCls:'icon-cancle',
                handler:cle1User,
            }]
        });
    }

</script>


<div  id="UserDa" >
</div>

<div id="dgEditUser"></div>
<div id="addUser"></div>



<%--
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ include file="../util.jsp"%>
<html>
<head>
    <title>Title</title>
    <script>
        var $dg,$da;
        $(function () {
            $dg = $("#userDa");
            $da = $("#userDa");
            $dg.datagrid({
                url: '/baizhi-cmfz-sys/user/splitUser',
                //fit:true,
                width:'100%',
                height:'100%',
                sortName:'id',
                remoteSort:false,
                fitColumns:true,
                method:'get',
                columns: [[
                    {title: "编号", field: "id", width: 200, align: 'center'},
                    {title: "姓名", field: "name", width: 200, align: 'center'},
                    {title: "法名", field: "legalname", width: 200, align: 'center'},
                    {title: "手机号", field: "tel", width: 200, align: 'center'},
                    {title: "性别", field: "sex", width: 200, align: 'center'},
                    {title: "签名", field: "signature", width: 200, align: 'center'},
                    {title: "头像", field: "picpath", width: 200, align: 'center',
                        formatter:function(value,row,index){
                            return "<a target='_black' href='${pageContext.request.contextPath}"+row.picpath+"'><img src='${pageContext.request.contextPath}"+row.picpath+"' width='100px',height='100px'></a>"

                        }
                    },
                    {
                        title: "所在地", field: "provinceName", width: 200, align: 'center',
                        formatter: function (value, row, index) {
                            return row.province.name;
                        }
                    },
                    {title: "上师", field: "teacherName", width: 200, align: 'center',
                        formatter:function(value,row,index){
                            return row.teacher.name;
                        }
                    },
                    {
                        title: "操作", field: "options", width: 300, align: 'center',
                        formatter: function (value, row, index) {
                            return "<a class='del' onClick=\"delUser('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                    "<a class='edit' onClick=\"editUser('" + row.id + "')\"  href='javascript:;'>修改</a>";
                        }
                    }
                ]],
                onLoadSuccess: function (data) {
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
                toolbar:'#userTb',
            });
        });

        //删除的操作
        function delUser(id){
            $.messager.confirm("提示","您确定要删除吗?",function(r){
                if(r){
                    //发送异步请求删除数据
                    $.get('${pageContext.request.contextPath}/user/delete',{'id':id},function () {
                        $dg.datagrid('reload');
                    })
                }
            });
        }


        //修改的操作
        function editUser(id){
            $da.dialog({
                width:600,
                height:300,
                title:"用户详细信息",
                iconCls:"icon-man",
                href:'${pageContext.request.contextPath}/back/user/updateUser.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveUser,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }],

            });

        }


        //保存修改用户
        function saveUser(){
            $("#inputForm").form('submit',{
                url:'${pageContext.request.contextPath}/user/updateUser',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            });
        }
        //添加操作
        function add() {
            $da.dialog({
                width:600,
                height:300,
                title:"添加用户",
                iconCls:"icon-user_female",
                href:'${pageContext.request.contextPath}/back/user/saveUser.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveUserAdd,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }],
            });
        }
        //保存添加
       function saveUserAdd() {
            $("#inputForm1").form('submit',{
                url:'${pageContext.request.contextPath}/user/saveUser',
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
</head>
<body>

<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north'," style="height: 50px;">
        <div style="text-align: center;margin: 10px 0px 10px 0px;">
            <input id="ss" class="easyui-searchbox" style="width: 300px"
            data-options="searcher:search,prompt:'Please Input Value',menu:'#mm'"/>
            <div id="mm" style="width: 120px">
                <div data-options="name:'name',iconCls:'icon-ok'">名称</div>
            </div>
        </div>
    </div>
    <div date-options="regin:'center',">
        <table id="userDg"></table>
        <div id="userDa"></div>
        <div id="userTb">
&lt;%&ndash;
            <a href="javascript:;" onClick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
&ndash;%&gt;
        </div>
    </div>
</div>
</body>
</html>
--%>
