<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="editUserInput" class="easyui-form" method="post">
        <input name="a_id" type="hidden" value="${sessionScope.admin.a_id}">
        <div style="margin-top: 20px;">
            管理员的昵称：<input name="a_username" readonly="readonly" value="${sessionScope.admin.a_username}">
        </div>
        <div style="margin-top: 20px;">
            管理员旧密码：<input name="a_pass" readonly="readonly" value="${sessionScope.admin.a_password}">
        </div>
        <div style="margin-top: 20px;">
            请输入新密码: <input type="text" name="a_password"  class="easyui-textbox">
        </div>
    </form>
</div>