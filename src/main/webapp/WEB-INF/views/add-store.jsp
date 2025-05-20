<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<title>AddStore</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/add-store.css">
</head>

<body>
	<c:if test="${not empty param.error}">
		<div class="alert alert-danger alert-slide" id="error-alert" role="alert">
			<span>${param.error[0]}</span>
		</div>
	</c:if>
	<c:if test="${not empty param.success}">
		<div class="alert alert-success alert-slide" id="success-alert" role="alert">
			<span>${param.success[0]}</span>
		</div>
	</c:if>

	<div class="container-fluid content">
		<div class="container" id="ext-box">
			<div class="row bg-body-tertiary" id="main-container">
				<div class="row">
					<h2 class="col mb-5">FreshMart &#128722</h2>
					<h2 class="col mb-5 text-end">Add Store</h2>
				</div>
				<form action="${pageContext.request.contextPath}/stores" method="post">
					<div class="mb-4">
						<div class="form-floating">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="Store Name" required>
							<label for="name">Store Name</label>
							<div class="error-message" id="name_error"></div>
						</div>
					</div>
					<div class="mb-4">
						<div class="form-floating">
							<input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
								placeholder="Phone Number" required>
							<label for="phoneNumber">Phone Number</label>
							<div class="error-message" id="password_error"></div>
						</div>
					</div>
					<div class="mb-4">
						<div class="form-floating">
							<input type="text" class="form-control" id="localities" name="localities"
								placeholder="Localities" required>
							<label for="localities">Localities (comma-separated)</label>
							<div class="error-message" id="password_error"></div>
						</div>
					</div>
					<div class="p-0 text-end" id="submit-container">
						<button type="submit" class="btn btn-primary mt-2" id="submit-button">Add Store</button>
					</div>
				</form>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/" class="btn btn-link mt-2 back-to-home">Back to Homepage</a>
			</div>
		</div>
	</div>
	<div class="sub-container">
		<p class="ps-4">© 2025 FreshMart Sdn. Bhd. All Rights Reserved</p>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
