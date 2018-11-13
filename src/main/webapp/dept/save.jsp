<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form class="easyui-form" id="userForm" method="post" enctype="multipart/form-data">

        <div style="margin-top: 20px;">
            图片标题:     <input name="b_title" type="text" class="easyui-textbox"  data-options="width:200,height:26"> <br>
        </div>
        <div style="margin-top: 20px;">
            图片路径:    <input name="multipartFile" type="text" class="easyui-filebox" data-options="width:200,height:26">
        </div>
        <div style="margin-top: 20px;">
            图片描述:    <input name="b_desc" type="text" class="easyui-textbox" data-options="width:200,height:26">
        </div>
        <div style="margin-top: 20px;">
            图片状态:     <input name="b_status" type="text" class="easyui-textbox"  data-options="width:200,height:26"> <br>
        </div>

    </form>
</div>