<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.dylinstoen.issuetracker.model.Issue"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issues</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 30px;
}

.card {
	border: 1px solid #ccc;
	padding: 12px;
	margin-bottom: 12px;
	border-radius: 6px;
}

form div {
	margin-bottom: 10px;
}

input, textarea, select {
	width: 300px;
}

textarea {
	height: 90px;
}
</style>
</head>
<body>
	<h1>Issue Tracker</h1>

	<h2>Create Issue</h2>
	<form action="${pageContext.request.contextPath}/issues/create"
		method="post">
		<div>
			<label>Title</label><br> <input type="text" name="title"
				required>
		</div>

		<div>
			<label>Description</label><br>
			<textarea name="description" required></textarea>
		</div>

		<div>
			<label>Status</label><br> <select name="status">
				<option value="Open">Open</option>
				<option value="In Progress">In Progress</option>
				<option value="Closed">Closed</option>
			</select>
		</div>

		<div>
			<label>Priority</label><br> <select name="priority">
				<option value="Low">Low</option>
				<option value="Medium">Medium</option>
				<option value="High">High</option>
			</select>
		</div>

		<button type="submit">Create Issue</button>
	</form>

	<hr>

	<h2>All Issues</h2>

	<%
        List<Issue> issues = (List<Issue>) request.getAttribute("issues");
        if (issues != null && !issues.isEmpty()) {
            for (Issue issue : issues) {
    %>
	<div class="card">
		<strong><%= issue.getTitle() %></strong><br>
		<br>
		<%= issue.getDescription() %><br>
		<br> Status:
		<%= issue.getStatus() %><br> Priority:
		<%= issue.getPriority() %>

		<form action="${pageContext.request.contextPath}/issues/delete"
			method="post" style="margin-top: 10px;">
			<input type="hidden" name="id" value="<%= issue.getId() %>">
			<button type="submit">Delete</button>
		</form>
	</div>
	<%
            }
        } else {
    %>
	<p>No issues yet.</p>
	<%
        }
    %>

	<p>
		<a href="<%= request.getContextPath() %>/index.jsp">Back to home</a>
	</p>
</body>
</html>