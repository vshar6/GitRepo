<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather Report</title>
<script src="./js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">


$(document).ready(function($) {
$("#submitButton").click(function () {
	var zipCode = $("#zipCode").val();
	var jsonUrl = "./weatherinfo/";
    $("#dvJson").empty();
  if(validateZipCode(zipCode)){	
	  jsonUrl = jsonUrl+zipCode;
     $.getJSON(jsonUrl,function (json) {
    	var items = [];
    	$.each( json, function( key, val ) {
    	items.push( "<li id='" + key + "'>" + val + "</li>" );
    	});
    	
    	$( "<ul/>", {
    	"class": "my-new-list",
    	html: items.join( "" )
    	}).appendTo( "#dvJson" );
    }); // End of Fetching of JSON Data
   }// End of validation
  return false;
});
});

function validateZipCode(zipCode){
	if(zipCode.length !=5){
		alert("Zip Code Length should be 5 digit");
		return false;
	} 
	return true;
}

</script>
</head>

<body>
<div style="text-align: center; border: 1px solid;
				margin-left: 27%; margin-right: 27%; padding: 10px 10px 20px 10px;
				border-radius: 5px; -moz-border-radius: 5px; font-family: Arial;">
<form action="./weatherinfo" method="POST">
	
		<div style="text-align: right; margin-right: 25%;">
				
				<div style="padding: 5px;">
					<label>Zip Code:</label>
					&nbsp;
					<input type="text" id="zipCode" name="zipCode" tabindex="1"/>
					<font color="red" size="2">*</font>
					<br/>
				</div>
				<div style="padding: 5px;">
					<input type="reset" id="resetButton" name="resetButton" value="Reset" tabindex="3"/>
					&nbsp;&nbsp;
					<input type="button" id="submitButton" name="submitButton" value="Submit" tabindex="2"/>
					<br/><br/>
				</div>
			</div>
		</form>
	</div>
	
	<div style="padding: 5px;" id="dvJson" class="dvJson">
				</div>
</body>
</html>