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
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>
</div>
</body>
</html>