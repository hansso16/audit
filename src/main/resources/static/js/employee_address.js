
$('input[id^="zipCode"]').keyup(function() {
    var val = this.value.replace(/\D/g, '');
    val = val.replace(/^(\d{4})./, '$1');
    this.value = val;
});


function deriveAddress(element) {
	let elementId = element.id;
	let iter = elementId.slice(-1);
	let type = elementId.slice(0,-1);
	let val = document.getElementById(elementId).value;
	if (val === '') {return;}
	if ('region' == type) {
		getAddressDetails(val, '#province'+iter, type)
	} else if ('province' === type) {
		getAddressDetails(val, '#municipal'+iter, type)
	} else if ('municipal' === type) {
		getAddressDetails(val, '#barangay'+iter, type)
	}
}

function getAddressDetails(elementValue, nextChild, type) {
	$.ajax({
		type:'GET',
		url: '/util/'+ type + '/'+elementValue,
		contentType: 'application/json',
		dataType: 'json',
		//data: JSON.stringify(data),
		async: true,
		//processData: false,
		//beforeSend: triggerProgress(),
		success: function(res) {
			$(nextChild).find('option').remove().end();
			if (res !== null) {
				$(nextChild).append($('<option>'));
				$.each(res, function (i, address) {
					$(nextChild).append($('<option>', {
						value: deriveAddressId(address, type),
						text: deriveAddressName(address, type)
					}));
				});
			}
		}, error: function(res, error) {
			//handleResponse(res);
			console.log(res);
			console.log(JSON.stringify(res));
			console.log("ERROR: " + error);
			alert("Something went wrong. Please try again.");
		}/*,
		complete: function() {
			//$("#submitBtn").prop('disabled', false);
			//triggerProgress()
		}*/
	});
}

function deriveAddressId(res, type) {
	if ('region' == type) {
		return res.provinceId;
	} else if ('province' === type) {
		return res.municipalId;
	} else if ('municipal' === type) {
		return res.barangayId;
	}
}

function deriveAddressName(res, type) {
	if ('region' == type) {
		return res.provinceName;
	} else if ('province' === type) {
		return res.municipalName;
	} else if ('municipal' === type) {
		return res.barangayName;
	}
}
