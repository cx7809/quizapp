<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quiz</title>
</head>
<body>
<h1>Quiz</h1>
<form action="/submit-quiz" method="post">
    <c:forEach var="question" items="${questions}">
        <div>
            <p>${question.questionText}</p>
            <input type="radio" name="${question.id}" value="${question.optionA}">${question.optionA}<br>
            <input type="radio" name="${question.id}" value="${question.optionB}">${question.optionB}<br>
            <input type="radio" name="${question.id}" value="${question.optionC}">${question.optionC}<br>
            <input type="radio" name="${question.id}" value="${question.optionD}">${question.optionD}<br>
        </div>
    </c:forEach>
    <button type="submit">Submit</button>
</form>
</body>
</html>
