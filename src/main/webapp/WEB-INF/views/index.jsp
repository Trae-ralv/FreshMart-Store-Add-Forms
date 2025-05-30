<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>FreshMart</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>

<body>
	<div class="container-fluid content">
		<div class="row" id="main-container">
			<h1 class="text-center mb-4">Welcome to FreshMart</h1>
			<div class="text-center">
				<a href="${pageContext.request.contextPath}/stores/add" class="btn btn-primary me-4">Add a New Store</a>
				<a href="${pageContext.request.contextPath}/stores" class="btn btn-secondary">View All Stores</a>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
