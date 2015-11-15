$(document).ready(function() {

	$(".productdetails").click(function() {

		var productId = this.id;

		showProduct(productId);

	});

	$(".categorydetails").click(function() {

		var categoryId = this.id;

		showCategory(categoryId);

	});

	$(".btnPurchase").click(function() {

		var productId = this.id;
		var productName = $(this).parents('.item').find('.productName').text();
		displayPurchaseDialog(productName, productId);

	});
	
	$(".btnPurchaseConfirm").click(function() {
		purchaseProduct($(this).attr('selectedProductId'));
	});
	

	$('.closeDialog').click(function() {
		$.unblockUI();
	});

	scanPurchasedProducts();
});

function scanPurchasedProducts()
{
	$('.purchasedProducts .productId').each(function(){
		markPurchased($(this).attr('productId'));
	});
}

function purchaseProduct(productId) {
	$.ajax({
		url : '/cns/products/purchaseProduct',
		type : 'GET',
		dataType : 'text json',
		contentType : "application/json",
		data : {
			'productId' : productId
		},
		success : function(response) {
		
		},
		error : function(error) {
			if(error.statusText == "OK"){
				markPurchased(productId);
				$.unblockUI();
			}
		}
	});
}

function markPurchased(productId){
	$('.btnPurchase[id='+productId+']').parents('.item').addClass('purchased');
}

// Get product object from Server...
function showProduct(productId) {
	$.ajax({
		url : '/cns/products/product/' + productId,
		type : 'GET',
		dataType : 'json',
		contentType : "application/json",
		// data:'id=' + productId,
		success : function(response) {
			displayProduct(response);
		},
		error : function() {

		}
	});
}

function displayProduct(product) {

	$('#lblProductName').text(product.name);
	$('#lblProductDesc').text(product.description);
	$('#lblProductCategory').text(product.category.name);

	$.blockUI({
		message : $('#divShowProduct'),
		css : {
			cursor : 'default'
		},
		overlayCSS : {

			cursor : 'default'
		}
	});

}

function displayCatgory(category) {

	$('#lblCategoryName').text(category.name);
	$('#lblCategoryDesc').text(category.description);

	$.blockUI({
		message : $('#divShowCategory'),
		css : {
			cursor : 'default'
		},
		overlayCSS : {

			cursor : 'default'
		}
	});

}

function displayPurchaseDialog(productName, productId) {

	$('#lblPurchaseProductName').text(productName);
	$('.btnPurchaseConfirm').attr('selectedProductId', productId);

	$.blockUI({
		message : $('#divPurchase'),
		css : {
			cursor : 'default'
		},
		overlayCSS : {

			cursor : 'default'
		}
	});

}

// Get product object from Server...
function showCategory(categoryId) {
	$.ajax({
		url : '/cns/categories/category/' + categoryId,
		type : 'GET',
		dataType : 'json',
		contentType : "application/json",
		// data:'id=' + productId,
		success : function(response) {
			displayCatgory(response);
		},
		error : function() {

		}
	});
}
