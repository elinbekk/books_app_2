<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main page</title>
</head>
<body>

<div>
    <h1>Это главная страница</h1>
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
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>
</div>
</body>
</html>