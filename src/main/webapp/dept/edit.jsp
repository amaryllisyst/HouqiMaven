<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        $("#editUserInputForm").form('load','${pageContext.request.contextPath}/menu/queryBan?b_id=${param.b_id}');
    })
</script>
<div style="text-align: center;">
    <form id="editUserInputForm" class="easyui-form" method="post">
        <input type="hidden" name="b_id" value="${param.b_id}">
        <div style="margin-top: 20px;">
            图片标题: <input type="text" name="b_title"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            图片路径: <input type="text" name="b_imgPath" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            图片描述: <input type="text" name="b_desc"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            图片状态: <input type="text" name="b_status"  class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            成立时间: <input type="text" name="b_date"  class="easyui-datebox">
        </div>
    </form>
</div>