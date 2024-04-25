<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>адм page</title>
</head>
<body>
<h1>адм editor</h1>
<form action="/adm" method="post">
    <input type="text" name="username" value="${user.username}">
    <input type="hidden" value="${user.userId}" name="userId">
    <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
        </div>
    </#list>
    <label for="block">
    <#if user.state == "ACTIVE">
        <input type="checkbox" name="state" value="block">
        <#else>
            <input type="checkbox" name="state" value="block" checked>
    </#if>
    Block this user</label>
    <button type="submit">Save</button>
</form>
</body>
</html>