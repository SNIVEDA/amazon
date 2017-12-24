$(function() {
	// Active menu

	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');

		break;

	case 'Manage Products':
		$('#manageProducts').addClass('active');

		break;

	case 'Cart':
		$('#userCart').addClass('active');

		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	// csrf token

	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');

	if (token.length > 0 && header.length > 0) {

		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});

	}
	// jquery code

	var $table = $('#productListTable');

	if ($table.length) {

		console.log(window.categoryId);

		var jsonUrl = '';
		if (window.categoryId == '') {

			jsonUrl = window.contextRoot + '/json/data/all/products';

		} else {

			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';

		}
		$table
				.DataTable({
					lengthMenu : [
							[ 5, 10, 15, -1 ],
							[ '5 Products', '10 Products', '15 Products',
									'All Products' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImages"/>'
								}
							},
							{
								data : 'name',

							},
							{
								data : 'brand',

							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';

									}
									return data;
								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href ="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"> <span class="fa fa-eye"></span></a>'
									if (row.quantity < 1) {
										str += '<a href ="javascript:void(0)" class="btn btn-success disabled"><span class="fa fa-shopping-cart"></span></a>'

									} else {

										if (userRole == 'ADMIN') {
											str += '<a href ="'
													+ window.contextRoot
													+ '/manage/'
													+ data
													+ '/product" class="btn btn-danger"><span class="fa fa-pencil"></span></a>'

										} else {
											str += '<a href ="'
													+ window.contextRoot
													+ '/cart/add/'
													+ data
													+ '/product" class="btn btn-success"><span class="fa fa-shopping-cart"></span></a>'

										}

									}
									return str
								}
							}

					]
				});
	}

	// dismiss the alert after 3 secs

	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}

	// admin

	var $adminProductsTable = $('#adminProductsTable');

	if ($adminProductsTable.length) {

		console.log(window.categoryId);

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable
				.DataTable({
					lengthMenu : [
							[ 10, 30, 50, -1 ],
							[ '10 Products', '30 Products', '50 Products',
									'All Products' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [

							{
								data : 'id'
							},

							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImages"/>'
								}
							},
							{
								data : 'name',

							},
							{
								data : 'brand',

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';

									}
									return data;
								}

							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},

							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<label class="switch">';
									if (data) {
										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '" />';

									} else {
										str += '<input type="checkbox"  value="'
												+ row.id + '" />';

									}
									str += '<div class="slider"></div></label>';

									return str;
								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-primary">';
									str += '<span class="fa fa-pencil" aria-hidden="true"></span></a>';

									return str;
								}
							}

					],

					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'Activate?'
													: 'Deactivate?';
											var value = checkbox.prop('value');
											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activation and Deactivation',
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {
																console
																		.log(value);

																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';

																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data
																							});
																				});

															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}
													});
										});
					}
				});
	}

	// refresh cart

	$('button[name="refreshCart"]')
			.click(
					function() {

						var cartLineId = $(this).attr('value');
						var countElement = $('#count_' + cartLineId);

						var originalCount = countElement.attr('value');
						var currentCount = countElement.val();

						if (currentCount !== originalCount) {

							if (currentCount < 1 || currentCount > 3) {
								countElement.val(originalCount);
								bootbox
										.alert({
											size : 'medium',
											title : 'Error',
											message : 'Product count should be between 1 and 3 (inclusive)'

										});

							} else {
								var updateUrl = window.contextRoot + '/cart/'
										+ cartLineId + '/update?count='
										+ currentCount;
								window.location.href = updateUrl;
							}

						}

					});

});
