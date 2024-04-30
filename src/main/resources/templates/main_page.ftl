<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main page</title>
    <link rel="stylesheet" href="/css/main.css">
<#--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
</head>
<body>
<div>
    <h1>Boooooks</h1>
    <h2>Hello, ${user.getUserEntity().firstName}</h2>
    <a href="adm"> adm</a>
    <a href="/add_book">добавить книгу</a>
    <a href="/my_books">Посмотреть мои книги для обмена</a>

    <label for="keyword"></label>
    <input type="text" id="keyword" placeholder="Введите название книги">
    <button onclick="searchProducts()">Искать</button>
    <#if books??>
        <#list books as item>
            <div>
                <p>${item.author} "${item.title}"</p>
                <p>${item.bookId}</p>
                <p>${item.photoUrl}"</p>
                <img src="${item.photoUrl}" alt="book">
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