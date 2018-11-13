<%@page pageEncoding="UTF-8" isELIgnored="false" %>
    <script>
        $(function () {

            $("#deptDg").datagrid({
               url:"${pageContext.request.contextPath}/menu/queryBanner",
                fit:true,
                pagination:true,
                pageSize:2,
                pageList:[2,4,6,10],
               toolbar:[
                   {
                       text:'添加轮播图',
                       iconCls:'icon-add',
                       handler:openDeptDialog,
                   },
                   {
                       text:'批量删除',
                       iconCls:'icon-remove',
                       handler:deleteMoreBumen,
                   }
               ],
               columns:[[
                   {title:"id",field:'check',width:120,checkbox:true},
                   {title:"图片id",field:'b_id',width:220,},
                   {title:"图片标题",field:'b_title',width:120,},
                   {title:"图片路径",field:'b_imgPath',width:180,},
                   {title:"图片状态",field:'b_status',width:120,},
                   {title:"图片描述",field:'b_desc',width:120,},
                   {title:"插入时间",field:'b_date',width:120,},
                   {title:"操作",field:'options',width:220,
                     formatter:function(value,row,index){
                       return "<a href='javascript:;' class='options' onclick=\"del('"+row.b_id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;&nbsp;" +
                              "<a href='javascript:;' class='options' onclick=\"updd('"+row.b_id+"')\" data-options=\"iconCls:'icon-edit',plain:true\">修改</a>"
                     }
                   }

               ]],
                onLoadSuccess:function () {
                    $(".options").linkbutton();
                },
                view: detailview,
                detailFormatter: function(index, row){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + row.b_imgPath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>date: ' + row.b_date + '</p>' +
                        '<p>title: ' + row.b_title + '</p>' +
                        '<p>path: ' + row.b_imgPath + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });

        });

        //删除多行的方法
        function deleteMoreBumen() {
            var rows=$("#deptDg").datagrid('getSelections');
            if(rows<=null){
                $.messager.show({title:'提示',msg:"至少选中一行！！！"});
            }else{
                //设置一个空的id数组
                var ids=[];
                for(var i=0;i<rows.length;i++){
                    //把接收到的id填充到rows里
                    ids.push(rows[i].b_id);
                }
                console.log(ids);
                //发送ajax请求传递数组
                $.ajax({
                    url:'${pageContext.request.contextPath}/menu/delMore',
                    type:"POST",
                    //传递数据类型的数据时必须设置这个属性为true
                    traditional:true,
                    data:{b_id:ids},
                    success:function(result){
                        //刷新datagrid
                        $("#deptDg").datagrid('reload');//刷新当前datagrid
                    },
                    error:function(){
                        //刷新datagrid
                        $("#deptDg").datagrid('reload');//刷新当前datagrid
                    }
                })
            }
        }
        //修改一行的方法
        function updd(b_id){
            $("#update").dialog({
                href:'${pageContext.request.contextPath}/dept/edit.jsp?b_id='+b_id,
                draggable:false,
                buttons:[
                    {
                        iconCls:'icon-save',
                        text:"修改",
                        handler:function(){
                            //关闭dialog
                            $("#update").dialog('close');
                            $("#editUserInputForm").form('submit',{
                                url:"${pageContext.request.contextPath}/menu/update",
                                success:function (result) {//注意一定是json字符串  使用需要转为js对象
                                    var parseJson=$.parseJSON(result);
                                    if(parseJson.success){
                                        $.messager.show({title:'提示',msg:"轮播图修改成功!!!"});
                                    }else{
                                        $.messager.show({title:'提示',msg:parseJson.message});
                                    }
                                    //关闭dialog
                                    $("#update").dialog('close');
                                    //刷新datagrid
                                    $("#deptDg").datagrid('reload');//刷新当前datagrid

                                }
                            })
                        }
                    },
                    {
                        iconCls:'icon-no',
                        text:"取消",
                        handler:function(){
                            $("#update").dialog('close');
                        }
                    },
                ]
            });
        }

        //删除一行的方法
        function del(b_id){
            //获取当前点击id发送ajax请求删除id这个人的信息
            $.post("${pageContext.request.contextPath}/menu/del",{"b_id":b_id},function (result) {//响应成功之后回调
                //刷新datagrid数据
                $("#deptDg").datagrid('reload');//刷新当前datagrid
            });
        }

        //添加一行的方法
        function openDeptDialog(){
            $("#saveDeptDialog").dialog({
                href:'${pageContext.request.contextPath}/dept/save.jsp',
                buttons:[
                    {
                        text:'保存',
                        iconCls:'icon-save',
                        handler:function(){
                            $("#userForm").form('submit',{
                                url:"${pageContext.request.contextPath}/menu/save",
                                success:function (data) {//获取的数据为json格式字符串使用时需要转为js对象
                                    //关闭对话框
                                    $("#saveDeptDialog").dialog('close');
                                    //刷新datagrid
                                    $("#deptDg").datagrid('reload');
                                }
                            })
                        }
                    },
                    {
                        text:'关闭',
                        iconCls:"icon-cancel",
                        handler:function(){
                            $('#saveDeptDialog').dialog('close');
                        }
                    },
                ]
            });
        }
    </script>
<table id="deptDg" class="easyui-datagrid" data-options="fit:true">


</table>

<div id="saveDeptDialog" data-options="width:600,height:400,iconCls:'icon-add',title:'添加轮播图'"></div>
<div id="update" data-options="iconCls:'icon-save',width:600,height:400,title:'修改轮播图'"></div>

