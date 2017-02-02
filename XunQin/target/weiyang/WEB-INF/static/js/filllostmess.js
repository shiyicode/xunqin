
var pic;
function add_files(files) 
{
	if (files.length){
		var file = files[0];
		var reader = new FileReader();
		reader.onload = function(e) {
		document.getElementById("pic").src = e.target.result;
		pic = e.target.result;
		}
		reader.readAsDataURL(file);
	}
}


var showArea = function(){
	var province = document.getElementById("s_province").value;
	var city = document.getElementById("s_city").value;
	var country = "";
	var sel = document.getElementById("s_county");
	country = sel.options[sel.selectedIndex].value;
	document.getElementById("lostaddress").value = province + city + country;
}

var showPlace = function(){
	
	var province = document.getElementById("l_province").value;
	var city = document.getElementById("l_city").value;
	var country = "";
	var sel = document.getElementById("l_county");
	country = sel.options[sel.selectedIndex].value;
	document.getElementById("lostplace").value = province + city + country;
}

			
 