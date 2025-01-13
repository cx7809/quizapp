<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Quiz Categories</h1>
<ul>
    <c:forEach var="category" items="${categories}">
        <li>
            <h2>${category.name}</h2>
            <a href="/quiz/${category.slug}" class="start-quiz-button">
                <button>Start Quiz</button>
            </a>
        </li>
    </c:forEach>
</ul>
<h2>Recent Quiz Results</h2>
<p>Feature coming soon!</p>
</body>
</html>
