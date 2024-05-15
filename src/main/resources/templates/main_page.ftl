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
        var query = document.getElementById("query").value;

        // AJAX request
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/main-search", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    var books = JSON.parse(xhr.responseText);
                    updateBooks(books);
                } else {
                    console.error("Error:", xhr.status);
                }
            }
        };
        xhr.send("query=" + encodeURIComponent(query));
    }

    function updateBooks(books) {
        var resultBlock = document.getElementById("result-block");
        resultBlock.innerHTML = ""; // Clear previous results

        // Append new results
        books.forEach(function (book) {
            var div = document.createElement("div");
            var p1 = document.createElement("p");
            p1.textContent = book.author + ' "' + book.title + '"';
            var p2 = document.createElement("p");
            p2.textContent = book.bookId;
            div.appendChild(p1);
            div.appendChild(p2);
            resultBlock.appendChild(div);
        });
    }
</script>

</body>
</html>
