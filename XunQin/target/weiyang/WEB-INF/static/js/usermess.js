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