/*function validateForm() {
//	 return false;
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var phone = document.getElementById("phone").value;
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var pincode = document.getElementById("pincode").value;
	
	var tfld = trim(email.value); // value of field with whitespace trimmed

	var emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/;
	var illegalChars = /[\(\)\<\>\,\;\:\\\"\[\]]/;
	var pincodestripped = pincode.replace(/[\(\)\.\-\ ]/g, '');
	var phonestripped = phone.replace(/[\(\)\.\-\ ]/g, '');
	

	if (name == "" || email == "" || phone == "" || username == ""
			|| password == "") {
		alert("First fill form ");
		return false;
	}
	
	if(name == "" ){
		alert("The name is the wrong length.\n");
		return false;
	}
	if (email == ""  ) {
		alert("The email address contains illegal characters.\n");
		return false;
	}if (phone == ""  ) {
		alert("The phone number contains illegal characters.\n");
		return false;
	} if (username == "" ) {
		alert("The username is the wrong length.\n");
		return false;
	}if ( password == "" ) {
		window.alert("The password is the wrong length. \n");
		return false;
	}
	return true;
	
}
*/
/*validateForm(function() {
	if (validateName()) {
		if (emailId()) {
			if (validatePhone) {
				if (validateUsername) {
					if (validatePassword) {
						if (validatePincode) {
							return false;
						}
					}
				}
			}
		}
	}
	return true;
});
*/
function validateName() {
	var name = document.getElementById("name");
	var illegalChars = /\W/; // allow letters, numbers, and underscores

	if (name.value == "") {
		alert("You didn't enter a name.\n");
		return false;
	} else if ((uname.value.length < 3) || (uname.value.length > 15)) {
		alert("The name is the wrong length.\n");
		// document.regF.name.focus();

		return false;
	} else if (illegalChars.test(name.value)) {
		name.style.background = 'Yellow';
		alert("The name contains illegal characters.\n");
		document.getElementById("name").focus();
		return false;
	} else {
		name.style.background = 'White';
		return true;
	}
}

function trim(s) {
	return s.replace(/^\s+|\s+$/, '');
}

function emailId() {
	var email = document.getElementById("email");
	var tfld = trim(email.value); // value of field with whitespace trimmed

	var emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/;
	var illegalChars = /[\(\)\<\>\,\;\:\\\"\[\]]/;

	if (email.value == "") {
		email.style.background = 'Yellow';
		alert("You didn't enter an email address.\n");
		return false;
	} else if (email.value.match(illegalChars)) {
		email.style.background = 'Yellow';
		alert("The email address contains illegal characters.\n");
		return false;
	} else if (!emailFilter.test(tfld)) { // test email for illegal characters
		email.style.background = 'Yellow';
		alert("Find illegal characters.\n");
		return false;
	} else {
		email.style.background = 'White';
		return true;
	}
}

function validatePhone() {
	var phone = document.getElementById("phone");
	var stripped = phone.value.replace(/[\(\)\.\-\ ]/g, '');

	if (phone.value == "") {
		// error = "You didn't enter a phone number.\n";
		alert("You didn't enter a phone number.\n");
		phone.style.background = 'Yellow';
		return false;
	} else if (isNaN(parseInt(stripped))) {
		alert("The phone number contains illegal characters.\n");
		// error = "The phone number contains illegal characters.\n";
		phone.style.background = 'Yellow';
		return false;
	} else if (!(stripped.length == 10)) {
		alert("The phone number is the wrong length. \n");
		phone.style.background = 'Yellow';
		return false;
	} else {
		phone.style.background = 'White';
		return true;

	}
}
function validateUsername() {
	var userName = document.getElementById("username");
	var illegalChars = /\W/; // allow letters, numbers, and underscores

	if (userName.value == "") {
		userName.style.background = 'Yellow';
		window.alert("You didn't enter a username.\n");
		return false;
	} else if ((userName.value.length < 3) || (userName.value.length > 15)) {
		userName.style.background = 'Yellow';
		alert("The username is the wrong length.\n");
		return false;
	} else if (illegalChars.test(userName.value)) {
		userName.style.background = 'Yellow';
		alert("The username contains illegal characters.\n");
		return false;
	} else {
		userName.style.background = 'White';
		return true;
	}
}

function validatePassword() {
	var password = document.getElementById("password");
	var illegalChars = /[\W_]/; // allow only letters and numbers

	if (password.value == "") {
		password.style.background = 'Yellow';
		window.alert("You didn't enter a password.\n");
		return false;
	} else if ((password.value.length < 3) || (password.value.length > 15)) {
		window.alert("The password is the wrong length. \n");
		password.style.background = 'Yellow';
		return false;
	} else {
		password.style.background = 'White';
		return true;
	}
}

//function validatePincode() {
//	var pincode = document.getElementById("pincode");
//	var stripped = pincode.value.replace(/[\(\)\.\-\ ]/g, '');
//	if (pincode.length == "") {
//		alert("Please enter value");
//		return false;
//	} else if (isNaN(parseInt(stripped))) {
//		alert("The Pincode contains illegal characters.\n");
//		phone.style.background = 'Yellow';
//		return false;
//	} else if (!(stripped.length == 6)) {
//		alert("The pincode is the wrong length. Make sure you included an area code.\n");
//		phone.style.background = 'Yellow';
//		return false;
//	} else {
//		password.style.background = 'White';
//		return true;
//	}
//}

function validatePincode() {
	var pincode=document.getElementById("pincode");
	var pat1=/^([0-9](6,6)+$/;
	var stripped = pincode.value.replace(/[\(\)\.\-\ ]/g, '');
	
	if (!pat1.test(pincode.value))  {
        alert("Pin code should be 6 digits ");
        pincode.focus();
        return false;
    }

}


/*
 * function city() { if (document.getElementById("ddlCity").value == 0) {
 * errormsg = "\nPlease select city." flag = false; } if (flag == false) {
 * alert(errormsg); return false; } }
 */

/* https://webcheatsheet.com/javascript/form_validation.php#required */