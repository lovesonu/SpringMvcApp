function validateForm() {
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var phone = document.getElementById("phone").value;
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var pincode = document.getElementById("pincode").value;

	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	var phonestripped = phone.replace(/[\(\)\.\-\ ]/g, '');

	if (name.length < 3 || name.length > 15) {
		alert("Name between 3 to 15 alphabet only .\n");
		return false;
	}
	if (reg.test(email) == false) {
		alert('Invalid Email Address');
		return false;
	}
	if (isNaN(parseInt(phonestripped)) || !(phonestripped.length == 10)) {
		alert("Phone number must be 10 digits long contains Numeric value only.\n");
		return false;
	}
	if ((username.length < 3) || (username.length > 15)) {
		alert("UserName must be between 3 to 15 long  .\n");
		return false;
	}
	if ((password.length < 3) || (password.length > 15)) {
		alert("Password must be between 3 to 15 long . \n");
		return false;
	}
	if (pincode.length !== 6) {
		alert("Enter pincode");
		return false;
	}
}


function doAjaxPost() {
	// get the form values
	$.ajax({
		type : "GET",
		url : "verifyUsername.html?username=" + $('#username').val(),
		success : function(result) {
			if (result === 'success') {
				alert("Alreday register user : " + $('#username').val());
			} 
			console.log(result);
		},
	});
}

function country_change() {
	var country = $(".countryid").val();
	$.ajax({
		type : "POST",
		url : "state.jsp",
		data : "country_id=" + country,
		cache : false,
		success : function(response) {
			$(".state").html(response);
		}
	});
}

function state_change() {
	var state = $(".state").val();
	$.ajax({
		type : "POST",
		url : "city.jsp",
		data : "state_id=" + state,
		cache : false,
		success : function(response) {
			$(".city").html(response);
		}
	});
}

function city_change() {
	var city = $(".city").val();
	$.ajax({
		type : "POST",
		url : "city",
		data : "city_id=" + cityid,
		cache : false,
		success : function(response) {
			$(".city").html(response);
		}
	});
}


function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		return false;
	return true;
}




