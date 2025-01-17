<%@ include file="navbar.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${category} Quiz</title>
</head>
<body>
<h1>${category.name} Quiz</h1>
<form action="/quiz/submit" method="POST">
    <c:forEach var="question" items="${questions}">
        <div class="question">
            <p>${question.questionText}</p>
            <ul>
                <li><input type="radio" name="q${question.id}" value="${question.optionA}" required> ${question.optionA}</li>
                <li><input type="radio" name="q${question.id}" value="${question.optionB}" required> ${question.optionB}</li>
                <li><input type="radio" name="q${question.id}" value="${question.optionC}" required> ${question.optionC}</li>
                <li><input type="radio" name="q${question.id}" value="${question.optionD}" required> ${question.optionD}</li>
            </ul>
        </div>
    </c:forEach>
    <button type="submit">Submit</button>
</form>
</body>
</html>
