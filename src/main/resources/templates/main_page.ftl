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
        <input class="query" id="query" placeholder="Введите название книги" oninput="searchBooks() "/>
        <div id="result-block"></div>
    </div>

    <h2>Hello, ${user.getUserEntity().firstName}</h2>
    <a href="adm"> adm</a>
    <a href="/add_book">добавить книгу</a>
    <a href="/my_books">Посмотреть мои книги для обмена</a>
    <a href="/favourite">Избранное</a>

     <#if books??>
         <#list books as item>
             <div>
                 <p>${item.author} "${item.title}"</p>
                 <button class="button-like" value="${item.bookId}">
                     <i class="heart"></i>
                 </button>
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
        let query = $("#query").val();
        $.ajax({
            url: "/main-search",
            type: "POST",
            data: {query: query},
            dataType: "json",
            success: function (books) {
                updateBooks(books);
            },
        });
    }

    function updateBooks(books) {
        let resultBlock = $("#result-block");
        resultBlock.empty();

        books.forEach(function (book) {
            resultBlock.append('<div class=book__card">'
                + '<p>' + book.title + ' ' + book.author + '<p>' + '</div>');

        });
    }
    $(".button-like").on('click', function () {
        let bookId = $(this).val();
        console.log(bookId)
        $.ajax({
            type: "POST",
            url: "/main",
            data: {"bookId": bookId},
            success: function (result) {
                console.log(result);
            },
            dataType: "text/plain"
        });
        $(this).style.backgroundColor = '#ff0000';
    });
</script>

</body>
</html>
