<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>book adding page</title>
</head>
<body>
<h1> твои книги</h1>
<#if message??>
    <p>${message}</p>
</#if>
<#if books??>
    <#list books as item>
        <div>
            <p>${item.author} "${item.title}"</p>
        </div>
    </#list>
    <#else>
    <p>Вы пока не добавли книги для обмена</p>
</#if>
<a href="add_book">Добавить книгу</a>
</body>
</html>