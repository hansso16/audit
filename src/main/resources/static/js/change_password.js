
// one small caps, one upper caps, one number, one special char, at least 6 char
var regularExpression = /^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
function validatePassword() {
    var changePasswordForm = document.getElementById('changePassword');
    var password1 = changePasswordForm.newPwd1.value;
    var password2 = changePasswordForm.newPwd2.value;
    alert(password1 + password2);
    
    alert('test regex');
    if(!regularExpression.test(password1)) {
        alert("password should contain at least one number and one special character");
        return false;
    } else if(password1 != password2) {
		alert('not same');
		return false;
	}
    alert('done');
}