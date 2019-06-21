$(document).ready(function() {
	$('#regF').submit(function(event) {
		var username = $('#username').val();
		var data = 'username=' + encodeURIComponent(username);
		
		$.ajax({
			/*url : $("#regF").attr("action"),*/
			url : "${pageContext.request.contextPath}/addUser.html",
            data : data,
            type : "GET",
            success : function(response) {
                alert( response );
            },
            error : function(xhr, status, error) {
                alert(xhr.responseText);
            }
		});
		return false;
		
	})
});




$(document).ready(function() {
	$('#number').bind("cut copy paste", function(e) {
		alert("Enter only numeric data");
		e.preventDefault();
	});
});

/*// To prevent form submission
$("#regF").submit(function() {
	var nullFormCheck = $("#regF").val();
	if(nullFormCheck == ""){
		alert("First  Fill all details");
		return false;
	}
	
	
});*/

/*
 * $(document).ready(function() { //option A $("regF").submit(function(e) {
 * alert("First Fill all details"); e.preventDefault(e); }); });
 */

/*
 * <script>
 * src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 */