$(document).ready(
		function() {
			$('#lnkAddPhone').click(function() {
				$('#areaCode').val('');
				$('#prefix').val('');
				$('#number').val('');

				$.blockUI({
					message : $('#divAddPhone'),
					css : {
						cursor : 'default'
					},
					overlayCSS : {

						cursor : 'default'
					},
				});
			});

			$('.chkRole').change(
					function() {
						if ($(this).is(':checked')) {
							var index = $(this).attr('roleId') - 1;
							$(this).after(
									'<input type="hidden" class="roleId hidden" name="roles['
											+ index + '].id" value="'
											+ $(this).attr('roleId') + '" />');
							$(this).after(
									'<input type="hidden" class="roleName hidden" name="roles['
											+ index + '].name" value="'
											+ $(this).attr('value') + '" />');
						} else {
							$(
									'.roleId.hidden[value='
											+ $(this).attr('roleId') + ']')
									.remove();
							$(
									'.roleName.hidden[value='
											+ $(this).attr('value') + ']')
									.remove();
						}

					});

			$('#submitPhone').click(
					function() {
						var phone = '<label>' + $('#area').val() + '</label>'
								+ '<input type="hidden" name="phones['
								+ $('.phonesList .phone').size()
								+ '].area" value="' + $('#area').val() + '">'
								+ '-' + '<label>' + $('#prefix').val()
								+ '</label>'
								+ '<input type="hidden" name="phones['
								+ $('.phonesList .phone').size()
								+ '].prefix" value="' + $('#prefix').val()
								+ '">' + '-' + '<label>' + $('#number').val()
								+ '</label>'
								+ '<input type="hidden" name="phones['
								+ $('.phonesList .phone').size()
								+ '].number" value="' + $('#number').val()
								+ '">';

						phone = '<div class="phone">' + phone + '</div>';
						$('.phonesList').append(phone);

						$.unblockUI();

						name = ""
					});

			$('.closeDialog').click(function() {
				$.unblockUI();
			});

		})