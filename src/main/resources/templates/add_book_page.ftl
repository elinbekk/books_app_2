<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>book adding page</title>
<#--    <link rel="stylesheet" href="/css/add_book.css">-->
</head>
<body>
<h1>добавление книги</h1>
<#if message??>
    <p>${message}</p>
</#if>
<form action="/add_book" method="POST" enctype="multipart/form-data">
    <label for="title">Название:</label><br>
    <input type="text" id="title" name="title" required><br><br>

    <label for="author">Автор:</label><br>
    <input type="text" id="author" name="author" required><br><br>

    <label for="description">Описание:</label><br>
    <input type="text" id="description" name="description" required><br><br>

    <input type="hidden" name="ownerId" value="${user.getUserId()}">

    <input type="file" accept="image/*" name="file">
    <input type="submit" value="Добавить книгу">
</form>
<a href="/my_books">Посмотреть мои книги для обмена</a>
</body>
</html>