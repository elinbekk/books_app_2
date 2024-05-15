<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main page</title>
    <link rel="stylesheet" href="/css/main.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div>
    <h1>Boooooks</h1>
    <div>
        <label for="query"></label>
        <input type="text" id="query" placeholder="Введите название книги">
        <button onclick="searchBooks()">Искать</button>
        <div id="result-block"></div>
    </div>

    <h2>Hello, ${user.getUserEntity().firstName}</h2>
    <a href="adm"> adm</a>
    <a href="/add_book">добавить книгу</a>
    <a href="/my_books">Посмотреть мои книги для обмена</a>

    <#if books??>
        <#list books as item>
            <div>
                <p>${item.author} "${item.title}"</p>
                <p>${item.bookId}</p>
            </div>
        </#list>
    </#if>
</div>
<div>
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>
</div>

<script>
    function searchBooks() {
        var query = $("#query").val();

        // AJAX request using jQuery
        $.ajax({
            url: "/main-search",
            type: "POST",
            data: { query: query },
            dataType: "json",
            success: function (books) {
                updateBooks(books);
            },
            error: function (xhr, status, error) {
                console.error("Error:", status, error);
            }
        });
    }

    function updateBooks(books) {
        var resultBlock = $("#result-block");
        resultBlock.empty(); // Clear previous results

        // Append new results
        books.forEach(function (book) {
            var div = $("<div>");
            var p1 = $("<p>").text(book.author + ' "' + book.title + '"');
            var p2 = $("<p>").text(book.bookId);
            div.append(p1).append(p2);
            resultBlock.append(div);
        });
    }
</script>

</body>
</html>
