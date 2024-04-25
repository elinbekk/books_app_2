<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>адм page</title>
</head>
<body>
<h1>адм</h1>
<#list users as user>
    <div>
        <p>${user.firstName} ${user.lastName} ${user.middleName}</p>
        <#list user.roles as role>${role}<#sep>, </#list>
        <p>user state: ${user.state}</p>
        <a href="adm/${user.userId}">edit user</a>
    </div>
</#list>
</body>
</html>