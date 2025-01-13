<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <title>Contact Us</title>
</head>
<body>
<h1>Contact Us</h1>
<c:if test="${not empty successMessage}">
    <p style="color: green;">${successMessage}</p>
</c:if>
<form action="/contact" method="post">
    <label for="subject">Subject:</label><br>
    <input type="text" id="subject" name="subject" required><br><br>

    <label for="emailAddress">Email Address:</label><br>
    <input type="email" id="emailAddress" name="emailAddress" required><br><br>

    <label for="messageContent">Message:</label><br>
    <textarea id="messageContent" name="messageContent" rows="5" cols="30" required></textarea><br><br>

    <button type="submit">Send</button>
</form>
</body>
</html>
