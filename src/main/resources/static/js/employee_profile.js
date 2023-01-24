	/*var val = this.value.replace(/\D/g, '');
  	var newVal = '';
  	if(val.length > 3) {
    	this.value = val;
  	}
  	if((val.length > 2) && (val.length < 10)) {
    	newVal += val.substr(0, 2) + '-';
    	val = val.substr(2);
  	}
  	if (val.length > 7) {
    	newVal += val.substr(0, 2) + '-';
    	newVal += val.substr(2, 7) + '-';
    	val = val.substr(9);
   	}
   	newVal += val;
   	this.value = newVal.substring(0, 12);*/

$('#sssNo').keyup(function() {
    var val = this.value.replace(/\D/g, '');
    val = val.replace(/^(\d{2})/, '$1-');
    val = val.replace(/-(\d{7})/, '-$1-');
    val = val.replace(/(\d{7})-(\d{1}).*/, '$1-$2');
    this.value = val;
});

$('#philHealthNo').keyup(function() {
    var val = this.value.replace(/\D/g, '');
    val = val.replace(/^(\d{4})/, '$1-');
    val = val.replace(/^(\d{4})-(\d{4})/, '$1-$2-');
    val = val.replace(/^(\d{4})-(\d{4})-(\d{4}).*/, '$1-$2-$3');
    this.value = val;
});

$('#pagibigNo').keyup(function() {
    var val = this.value.replace(/\D/g, '');
    val = val.replace(/^(\d{4})/, '$1-');
    val = val.replace(/^(\d{4})-(\d{4})/, '$1-$2-');
    val = val.replace(/^(\d{4})-(\d{4})-(\d{4}).*/, '$1-$2-$3');
    this.value = val;
});

$('#tinNo').keyup(function() {
    var val = this.value.replace(/\D/g, '');
    val = val.replace(/^(\d{3})/, '$1-');
    val = val.replace(/^(\d{3})-(\d{3})/, '$1-$2-');
    val = val.replace(/^(\d{3})-(\d{3})-(\d{3})/, '$1-$2-$3-');
    val = val.replace(/^(\d{3})-(\d{3})-(\d{3})-(\d{3}).*/, '$1-$2-$3-$4');
    this.value = val;
});

setInputFilter(document.getElementById("cellNo"), function(value) {
	return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});

setInputFilter(document.getElementById("telNo"), function(value) {
	return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});

$('#company').on('change', function () {
	let companyCode = this.value;
	$.ajax({
		type:'GET',
		url: '/util/company/'+companyCode,
		contentType: 'application/json',
		dataType: 'json',
		//data: JSON.stringify(data),
		async: true,
		//processData: false,
		//beforeSend: triggerProgress(),
		success: function(res) {
			$('#division').find('option').remove().end();
			if (res !== null) {
				$('#division').append($('<option>'));
				$.each(res, function (i, division) {
					$('#division').append($('<option>', {
						value: division.id.divisionCode,
						text: division.divisionDescription != null? division.divisionShortName + '-'+division.divisionDescription : division.divisionName
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
});

$('#division').on('change', function () {
	let divisionCode = this.value;
	$.ajax({
		type:'GET',
		url: '/util/division/'+divisionCode,
		contentType: 'application/json',
		dataType: 'json',
		//data: JSON.stringify(data),
		async: true,
		//processData: false,
		//beforeSend: triggerProgress(),
		success: function(res) {
			$('#position').find('option').remove().end();
			if (res !== null) {
				$('#position').append($('<option>'));
				$.each(res, function (i, position) {
					$('#position').append($('<option>', {
						value: position.id.positionCode,
						text: position.positionName
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
});
