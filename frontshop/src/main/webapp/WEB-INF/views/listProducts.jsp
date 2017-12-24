<div class="container">
	<div class="row">
		<!-- sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<link
			href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
			rel="stylesheet">

		<!-- Products -->
		<div class="col-md-9">

			<!-- breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">
					<c:if test="${userClickAllProducts==true }">

						<script>
							window.categoryId = "";
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>

					</c:if>
					<c:if test="${userClickCategoryProducts==true }">

						<script>
							window.categoryId = "${category.id}";
						</script>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>

					</c:if>
				</div>
				
					
				
				<table id="productListTable"
					class="table table-striped table-bordered">
				
					<thead>

						<tr>
							<th></th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Quantity</th>
							<th></th>
						</tr>
					</thead>

					<tfooter>

					<tr>

						<th></th>
						<th>Name</th>
						<th>Brand</th>
						<th>Price</th>
						<th>Quantity</th>
					</tr>
					</tfooter>
				</table>
			</div>
		</div>
	</div>

</div>
