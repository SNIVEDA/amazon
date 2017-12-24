<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<%@include file="../shared/flows-header.jsp"%>

<div class="row">

	<div class="col-sm-6">

		<div class="card card-inverse card-danger text-center">
			<div class="card-header">
				<h4>Personal Details</h4>
			</div>

			<div class="card-block">
				<div class="text-center">
					<p>
						Name : <strong>${registerModel.user.firstName}
							${registerModel.user.lastName}</strong>
					</p>
					<p>
						Email : <strong>${registerModel.user.email}</strong>
					</p>
					<p>
						Contact : <strong>${registerModel.user.contactNumber}</strong>
					</p>
					<p>
						Role : <strong>${registerModel.user.role}</strong>
					</p>
					<p>
						<a href="${flowExecutionUrl}&_eventId_personal"
							class="btn btn-primary">Edit</a>
					</p>
				</div>
			</div>

		</div>


	</div>

	<div class="col-sm-6">

		<div class="card card-inverse card-danger text-center">
			<div class="card-header">
				<h4>Billing Address</h4>
			</div>

			<div class="card-block">
				<div class="text-center">
					<p>${registerModel.billing.addressLineOne},</p>
					<p>${registerModel.billing.addressLineTwo},</p>
					<p>${registerModel.billing.city}-
						${registerModel.billing.postalCode},</p>
					<p>${registerModel.billing.state}</p>
					<p>${registerModel.billing.country}</p>
					<p>
						<a href="${flowExecutionUrl}&_eventId_billing"
							class="btn btn-primary">Edit</a>
					</p>
				</div>
			</div>

		</div>

	</div>

</div>

<div class="row">

	<div class="col-sm-4 col-sm-offset-4">

		<div class="text-center">

			<a href="${flowExecutionUrl}&_eventId_submit"
				class="btn btn-lg btn-primary">Confirm</a>

		</div>

	</div>

</div>

</div>

<%@include file="../shared/flows-footer.jsp"%>
