// Initialize jQuery when document is ready
$(document).ready(function() {
	// Define context path for AJAX URLs
	const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf('/', 1));

	// Form validation for edit modal
	$('#editStoreForm').on('submit', function(e) {
	    e.preventDefault();
	    if (this.checkValidity()) {
	        const store = {
	            name: $('#editName').val(),
	            phoneNumber: $('#editPhoneNumber').val(),
	            localities: $('#editLocalities').val().split(',')
	        };
	        // AJAX request to update store
	        $.ajax({
	            url: `${contextPath}/stores/${$('#editStoreId').val()}/edit`,
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(store),
	            success: function() {
	                $('#editModal').modal('hide');
	                window.location.href = `${contextPath}/stores`; // Navigate to store-list.jsp
	            },
	            error: function() {
	                alert('Error updating store');
	            }
	        });
	    } else {
	        $(this).addClass('was-validated');
	    }
	});
	
	// Edit button click handler
	$(document).on('click', '.edit-btn', function() {
		const id = $(this).closest('tr').data('id');
		// AJAX request to get store details
		$.getJSON(`${contextPath}/stores/${id}`, function(store) {
			$('#editStoreId').val(store.id);
			$('#editName').val(store.name);
			$('#editPhoneNumber').val(store.phoneNumber);
			$('#editLocalities').val(store.localities.join(','));
			$('#editModal').modal('show');
		});
	});

	// Delete button click handler
	$(document).on('click', '.delete-btn', function() {
		if (confirm('Are you sure you want to delete this store?')) {
			const id = $(this).closest('tr').data('id');
			// AJAX request to delete store
			$.ajax({
				url: `${contextPath}/stores/${id}/delete`,
				type: 'DELETE',
				success: function() {
					window.location.href = `${contextPath}/stores`; // Navigate to store-list.jsp
				},
				error: function() {
					alert('Error deleting store');
				}
			});
		}
	});

	// Search filter handler
	$('#searchLocalities').on('input', function() {
		const locality = $(this).val();
		// AJAX request to search stores
		$.getJSON(`${contextPath}/stores/search`, { locality: locality }, function(stores) {
			updateStoreTable(stores);
		});
	});

	// Function to update store table
	function updateStoreTable(stores) {
		const tbody = $('#storeTableBody');
		tbody.empty();
		stores = stores || [];
		// Populate table with store data
		stores.forEach(store => {
			const localities = store.localities.join(',');
			tbody.append(`
                <tr data-id="${store.id}">
                    <td>${store.name}</td>
                    <td>${store.phoneNumber}</td>
                    <td>${localities}</td>
                    <td>
                        <button class="btn btn-sm btn-warning edit-btn">Edit</button>
                        <button class="btn btn-sm btn-danger delete-btn">Delete</button>
                    </td>
                </tr>
            `);
		});
	}
});