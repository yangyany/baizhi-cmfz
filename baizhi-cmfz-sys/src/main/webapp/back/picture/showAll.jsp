<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ include file="../util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $("#picDg");
        $da = $("#picDa");

        $dg.datagrid({
            url: '${prc}/picture/splitPicture',
            //fit:true,
            width:'100%',
            height:'100%',
            sortName:'id',
            remoteSort:false,
            fitColumns:true,
            method:'get',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "名称", field: "name", width: 200, align: 'center',
                    formatter:function(value){
                        return "<a target='_black' href='${prc}/picture/download?name="+value+"'>"+value+"</a>";
                    }

                },
                {title: "图片描述", field: "title", width: 200, align: 'center'},
                {
                    title: "是否轮播", field: "type", width: 200, align: 'center',

                    formatter:function(value,row){
                        if (value=="0"){
                            return "不轮播";
                        }else{
                            return "轮播";
                        }

                    }
                },
                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"delPicture('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editPicture('" + row.id + "')\"  href='javascript:;'>修改</a>&nbsp;&nbsp;";
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
            toolbar:'#pictureTb',
        });
    });


    //删除的操作
    function delPicture(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('${pageContext.request.contextPath}/picture/delete',{'id':id},function () {
                    $dg.datagrid('reload');
                })
            }
        });
    }


    //修改的操作
    function editPicture(id){
        $da.dialog({
            width:600,
            height:300,
            title:"图片详细信息",
            iconCls:"icon-man",
            href:'${pageContext.request.contextPath}/back/picture/updatePicture.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:savepicture,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],

        });

    }



    //保存修改图片
    function savepicture(){
        $("#inputForm").form('submit',{
            url:'${pageContext.request.contextPath}/picture/updatePicture',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //添加操作
    /*function add() {
        $da.dialog({
            width:600,
            height:300,
            title:"添加上师",
            iconCls:"icon-user_female",
            href:'/back/teacher/saveMusicfile.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveTeacherAdd,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //保存添加
    function saveTeacherAdd() {
        $("#inputForm").form('submit',{
            url:'/teacher/insertTeacher',
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
        <table id="picDg" ></table>


        <div id="picDa" style="height: 1%;"></div>

        <div id="pictureTb">
        </div>

    </div>
</div>




