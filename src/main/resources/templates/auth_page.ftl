<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>auth</title>
    <link rel="stylesheet" href="/css/auth_page_style.css">
</head>
<body>
<div>
    <#if message??>
        <p>${message}</p>
    </#if>
    <form method="POST" action="login">
        <label for="username">Email:</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Sign in">
    </form>
    <a href="./sign-up"> I don't have profile yet</a>
</div>
</body>
</html>