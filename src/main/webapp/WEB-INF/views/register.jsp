<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<form method="post" action="/register">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required>
    <br>
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName">
    <br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <button type="submit">Register</button>
</form>
<c:if test="${not empty success}">
    <p style="color: green;">${success}</p>
    <p><a href="/login">Click here to login</a></p>
</c:if>

<c:if test="${not empty error}">
    <div style="color: red;">${error}</div>
</c:if>

</body>
</html>
