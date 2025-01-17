<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
<h1>Quiz Result</h1>
<p>Quiz Name: ${result.quizName}</p>
<p>User Name: ${result.userName}</p>
<p>Start Time: ${result.startTime}</p>
<p>End Time: ${result.endTime}</p>
<p>Result: ${result.passed ? 'Passed' : 'Failed'}</p>

<h2>Question Results:</h2>
<ul>
    <c:forEach var="question" items="${result.questionResults}">
        <li>
            <p>Question: ${question.questionText}</p>
            <p>Your Answer: ${question.userAnswer}</p>
            <p>Correct Answer: ${question.correctAnswer}</p>
        </li>
    </c:forEach>
</ul>

<a href="/home">Take Another Quiz</a>
</body>
</html>
