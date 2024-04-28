<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main page</title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<div>
    <h1>Boooooks</h1>
    <h2>Hello, ${user.getUserEntity().firstName}</h2>
    <a href="adm"> adm</a>
    <a href="/add_book">добавить книгу</a>
    <a href="/my_books">Посмотреть мои книги для обмена</a>
    <#if books??>
        <#list books as item>
            <div>
                <p>${item.author} "${item.title}"</p>
            </div>
        </#list>
    </#if>
</div>
<div>
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>
</div>
</body>
</html>