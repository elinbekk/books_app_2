<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>sign up</title>
</head>
<body>
<h2>User Registration Form</h2>
<div>
    <#if message??>
        <p>${message}</p>
    </#if>
    <form action="/sign-up" method="POST">
        <label for="firstName">First Name:</label><br>
        <input type="text" id="firstName" name="firstName" required><br><br>

        <label for="lastName">Last Name:</label><br>
        <input type="text" id="lastName" name="lastName" required><br><br>

        <label for="middleName">Middle Name:</label><br>
        <input type="text" id="middleName" name="middleName"><br><br>

<#--        <label for="birthday">Birthday:</label><br>-->
<#--        <input type="date" id="birthday" name="birthday" required><br><br>-->

        <label for="city">City:</label><br>
        <input type="text" id="city" name="city" required><br><br>

        <label for="username">Email:</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Register">
    </form>
    <a href="./auth"> I have profile</a>
</div>
</body>
</html>