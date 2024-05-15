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
    <#if bookList??>
        <#list bookList as item>
            <div>
                <p>${item.author} "${item.title}"</p>
                <button class="button-delete" value="${item.bookId}">
                    <i class="trash"></i>
                </button>
            </div>
        </#list>
        <#else>
        <p>Тут пока нет книг(</p>
    </#if>
</div>

<script>
    $(".button-delete").on('click', function () {
        let bookId = $(this).val();
        console.log(bookId)
        $.ajax({
            type: "POST",
            url: "/favourite",
            data: {"bookId": bookId},
            success: function (result) {
                console.log(result);
            },
            dataType: "text/plain"
        });
    });
</script>

</body>
</html>
