<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<form method="post" action="/register">
    <label>First Name:</label>
    <input type="text" name="firstName" required>
    <br>
    <label>Last Name:</label>
    <input type="text" name="lastName" required>
    <br>
    <label>Email:</label>
    <input type="email" name="email" required>
    <br>
    <label>Password:</label>
    <input type="password" name="password" required>
    <br>
    <button type="submit">Register</button>
</form>
</body>
</html>
