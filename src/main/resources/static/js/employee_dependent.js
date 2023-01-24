var rowIndex=0;
$(document).ready(function() {
	addFields();
	$('#addDependent').on('click', addFields);
});

function addFields() {
	//var lastField = $("#addDependentForm div:last");
    //var intId = (lastField && lastField.length && lastField.data("idx") + 1) || 1;
    var intId = rowIndex++;
    var fieldWrapper = $("<div class=\"row fieldwrapper\" id=\"field" + intId + "\"/>");

	// Dependent IDs
	if (employeeId !== null && employeeId !== '') {
		var employeeIdInput = $("<input type=\"hidden\" name=\"employeeDependent["+intId+"].id.employeeId\" value=\""+employeeId+"\" />");
	    fieldWrapper.append(employeeIdInput);
	}

	//Dependent Name
	var nameWrapper = $("<div class=\"col\" />");
	var nameLabel = $("<label for=\"dependentName"+intId+"\" class=\"form-label\">Dependent Name</label>");
	var nameField = $("<input type=\"text\" name=\"employeeDependent["+intId+"].dependentName\" id=\"dependentName"+intId+"\" class=\"form-control\" required>");
	nameWrapper.append(nameLabel);
	nameWrapper.append(nameField);
	
	//Dependent Relationship
	var relationshipWrapper = $("<div class=\"col-auto\" />");
	var relationshipLabel = $("<label for=\"dependentRelationship"+intId+"\" class=\"form-label\">Dependent Relationship</label>");
	var relationshipField = $("<input type=\"text\" name=\"employeeDependent["+intId+"].dependentRelationship\" id=\"dependentRelationship"+intId+"\" class=\"form-control\" required>");
	relationshipWrapper.append(relationshipLabel);
	relationshipWrapper.append(relationshipField);
	
	//Dependent Birthdate
	var birthdateWrapper = $("<div class=\"col-auto\" />");
	var birthdateLabel = $("<label for=\"dependentBirthdate"+intId+"\" class=\"form-label\">Birthdate</label >");
	var birthdateField = $("<input type=\"date\" name=\"employeeDependent["+intId+"].dependentBirthdate\" id=\"dependentBirthdate"+intId+"\" class=\"form-control\" required>");
	birthdateWrapper.append(birthdateLabel);
	birthdateWrapper.append(birthdateField);
	
	//Dependent Gender
	var genderWrapper = $("<div class=\"col-auto\" />");
	var genderLabel = $("<label for=\"gender"+intId+"\" class=\"form-label\">Gender</label >");
	var genderInputGrp = $("<div class=\"input-group mb-2\" />");
	var genderSelectField = $("<select name=\"employeeDependent["+intId+"].gender\" class=\"form-select form-control\" required aria-label=\"GenderSelect\"><option value=\"M\">Male</option><option value=\"F\">Female</option></select>");
	//var genderOptionM = $("<option value=\"'M'\" text=\"Male\"></option>");
	//var genderOptionF = $("<option value=\"'F'\" text=\"Female\"></option>");
	var removeButton = $("<a type=\"button\" class=\"btn btn-outline-danger\">Remove</a >");
	genderInputGrp.append(genderSelectField);
	genderInputGrp.append(removeButton);
	genderWrapper.append(genderLabel);
	genderWrapper.append(genderInputGrp);
	
    removeButton.click(function() {
        $(this).parent().parent().parent().remove();
    });
    fieldWrapper.append(nameWrapper);
    fieldWrapper.append(relationshipWrapper);
	fieldWrapper.append(birthdateWrapper);
	fieldWrapper.append(genderWrapper);
    $("#addDependentForm").append(fieldWrapper);
}