<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">

				<div class="alert alert-success alert-dismissible ">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="card card-inverse card-danger text-center">
				<div class="card-header">

					<h4>Product Management</h4>

				</div>
				<div class="card-block">

					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">

						<div class="form-group">

							<div class="col-md-8">
								<br>
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-8">

								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-8">

								<sf:textarea rows="10" cols="50" path="description"
									id="description" placeholder="Product Description"
									class="form-control"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-8">

								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Enter Unit Price" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-8">

								<sf:input type="file" path="file" id="file" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-8">

								<sf:input type="number" path="quantity" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-8">

								<sf:select class="form-control" id="categoryId"
									path="categoryId" items="${categories }" itemLabel="name"
									itemValue="id" />
								<c:if test="${product.id == 0}">

									<br />
									<button type="button" data-toggle="modal"
										data-target="#myCategoryModal" class="btn btn-danger btn-sm">Add
										Category</button>

								</c:if>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">

								<input type="submit" name="submit" id="submit" value="Save"
									class="btn btn-primary" />

								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />

							</div>
						</div>
					</sf:form>

				</div>
			</div>


		</div>

	</div>
	<div class="row">
		<h3>Available Products</h3>
		<hr>
	</div>
	<div class="row">


		<div class="col-xs-12">

			<div style="overflow: auto">

				<table id="adminProductsTable"
					class="table table-striped table-bordered">
					<thead>

						<tr>

							<th>ID</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>



					<tfoot>

						<tr>

							<th>ID</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myCategoryModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New Category</h4>
				</div>
				<div class="modal-body">

					<sf:form id="categoryForm" class="form-horizontal"
						modelAttribute="category" action="${contextRoot}/manage/category"
						method="POST">

						<div class="form-group">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8 validate">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Category Name" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8 validate">
								<sf:textarea path="description" class="form-control"
									placeholder="Enter category description here!" />
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<input type="submit" name="submit" value="Save"
									class="btn btn-primary" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>