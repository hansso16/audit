var rowIndex=0;
$(document).ready(function() {
	addFields();
	$('#addPhone').on('click', addFields);
});

function addFields() {
	//var lastField = $("#addDependentForm div:last");
    //var intId = (lastField && lastField.length && lastField.data("idx") + 1) || 1;
    var intId = rowIndex++;
    var fieldWrapper = $("<div class=\"row fieldwrapper\" id=\"field" + intId + "\"/>");
    
	// Dependent IDs
	if (customerId !== null && customerId !== '') {
		var employeeIdInput = $("<input type=\"hidden\" name=\"customerPhone["+intId+"].customerId\" value=\""+customerId+"\" />");
	    fieldWrapper.append(employeeIdInput);
	}

	//Phone Number
	var phoneNumberWrapper = $("<div class=\"col\" />");
	var phoneNumberLabel = $("<label for=\"phoneNumber"+intId+"\" class=\"form-label\">Phone Number</label>");
	var phoneNumberField = $("<input type=\"text\" name=\"customerPhone["+intId+"].phoneNumber\" id=\"phoneNumber"+intId+"\" class=\"form-control phone\" required>");
	phoneNumberWrapper.append(phoneNumberLabel);
	phoneNumberWrapper.append(phoneNumberField);
	
	//Phone Type
	var phoneTypeWrapper = $("<div class=\"col-auto\" />");
	var phoneTypeLabel = $("<label for=\"phoneType"+intId+"\" class=\"form-label\">Phone Type</label >");
	var phoneTypeInputGrp = $("<div class=\"input-group mb-2\" />");
	var phoneTypeSelectField = $("<select name=\"customerPhone["+intId+"].phoneType\" class=\"form-select form-control\" required aria-label=\"GenderSelect\"><option value=\"1\">Mobile Number</option><option value=\"2\">Office Number</option><option value=\"3\">Work Number</option></select>");
	var removeButton = $("<a type=\"button\" class=\"btn btn-outline-danger\">Remove</a >");
	phoneTypeInputGrp.append(phoneTypeSelectField);
	phoneTypeInputGrp.append(removeButton);
	phoneTypeWrapper.append(phoneTypeLabel);
	phoneTypeWrapper.append(phoneTypeInputGrp);
	
    removeButton.click(function() {
        $(this).parent().parent().parent().remove();
    });
    fieldWrapper.append(phoneNumberWrapper);
	fieldWrapper.append(phoneTypeWrapper);
    $("#addPhoneForm").append(fieldWrapper);
}