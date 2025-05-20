<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.StringJoiner" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Set character encoding and responsive viewport -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Locate Me</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/store-list.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>

<body>
	<div class="container-fluid content">
		<div class="bg-body-tertiary" id="main-container">
			<h1 class="mb-4">Locate Me</h1>
			<div class="mb-3">
			            <input type="text" class="form-control" id="searchLocalities" placeholder="Search by localities...">
			        </div>
			        <!-- Store table -->
			        <table class="table table-striped table-bordered" id="storeTable">
			            <thead class="table-dark">
			                <tr>
			                    <th>Name</th>
			                    <th>Phone Number</th>
			                    <th>Localities</th>
			                    <th>Actions</th>
			                </tr>
			            </thead>
			            <tbody id="storeTableBody">
			                <c:forEach var="store" items="${stores}">
			                    <tr data-id="${store.id}">
			                        <td><c:out value="${store.name}"/></td>
			                        <td><c:out value="${store.phoneNumber}"/></td>
			                        <td>
			                            <c:forEach var="locality" items="${store.localities}" varStatus="status">
			                                <c:out value="${locality}"/>
			                                <c:if test="${!status.last}">,</c:if>
			                            </c:forEach>
			                        </td>
			                        <td>
			                            <button class="btn btn-sm btn-warning edit-btn">Edit</button>
			                            <button class="btn btn-sm btn-danger delete-btn">Delete</button>
			                        </td>
			                    </tr>
			                </c:forEach>
			            </tbody>
			        </table>
			<p>
			            <a href="${pageContext.request.contextPath}/stores/add" class="btn btn-primary me-2">Add Another Store</a>
			            <a href="${pageContext.request.contextPath}/" class="btn btn-outline-secondary">Back to Home</a>
			        </p>
			        <!-- Edit Modal -->
			        <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
			            <div class="modal-dialog">
			                <div class="modal-content">
			                    <div class="modal-header">
			                        <h5 class="modal-title" id="editModalLabel">Edit Store</h5>
			                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			                    </div>
			                    <div class="modal-body">
			                        <form id="editStoreForm" class="needs-validation" novalidate>
			                            <input type="hidden" id="editStoreId">
			                            <div class="mb-3">
			                                <label for="editName" class="form-label">Store Name</label>
			                                <input type="text" class="form-control" id="editName" required>
			                                <div class="invalid-feedback">Please enter the store name.</div>
			                            </div>
			                            <div class="mb-3">
			                                <label for="editPhoneNumber" class="form-label">Phone Number</label>
			                                <input type="text" class="form-control" id="editPhoneNumber" required>
			                                <div class="invalid-feedback">Please enter the phone number.</div>
			                            </div>
			                            <div class="mb-3">
			                                <label for="editLocalities" class="form-label">Localities (comma-separated)</label>
			                                <input type="text" class="form-control" id="editLocalities" required>
			                                <div class="invalid-feedback">Please enter localities.</div>
			                            </div>
			                            <button type="submit" class="btn btn-success">Save Changes</button>
			                        </form>
			                    </div>
			                </div>
			            </div>
			        </div>
			    </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
	        // Pass context path to external JS
	        const contextPath = '${pageContext.request.contextPath}';
	    </script>
	    <script src="${pageContext.request.contextPath}/js/store-list.js"></script>
</body>

</html>
