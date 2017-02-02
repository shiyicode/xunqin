// JavaScript Document
var count = 0;
var btn = document.getElementById("submit");
var email=0;	//0:未验证 1:已被注册 2:成功

function checkEmail() {
	var useremail = document.getElementById("useremail");
	var emailspan = document.getElementById("emailspan");
	var reg = /^([a-zA-Z0-9_-])+@[a-zA-Z0-9_-]+((\.[a-z]{2,3}){1,2})$/;

	// alert('sfdddsd');


	if (useremail.value == "") {
		// alert('rggr');
		useremail.style.borderColor = "#F73F52";
		emailspan.innerHTML = "邮箱不能为空";
		emailspan.style.display = "block";
	}
	else if (!reg.test(useremail.value)) {
		useremail.style.borderColor = "#F73F52";
		emailspan.innerHTML = "邮箱格式错误";
		emailspan.style.display = "block";
		// alert("邮箱错误");
	}
	else {
		// alert('gggg');
		var url = "/goto/isexist?email=" + useremail.value;
		if (window.XMLHttpRequest)
			req = new XMLHttpRequest();
		else if (window.ActiveXObject)
			req = new ActiveXObject("Microsoft.XMLHTTP");
		if (req) {

			req.open("get", url, true);
			req.onreadystatechange = function () {
				// alert("aaaaa");

				if (req.readyState == 4) {
					// alert("sfafsa");

					if (req.status == 200) {
						// alert("eeee");
						var result = req.responseText;
						if (result == "yes")
						{
							useremail.style.borderColor = "#ccc";
							emailspan.style.display = "none";
							count++;
							if (count == 4)
							{
								btn.style.background = "#1b435d";
								btn.style.cursor = "pointer";
							}
							email=2;
						}
						else
						{
							useremail.style.borderColor = "#F73F52";
							emailspan.innerHTML = "该邮箱已被注册";
							emailspan.style.display = "block";
							email=1;
						}

					}
				}
			}
			req.send(null);
		}
	}
}


function checkPass()
{
	var userpass = document.getElementById("userpass");
	var passspan = document.getElementById("passspan");
	var reg = /^\w{6,16}$/;
	if (userpass.value == "")
	{
		userpass.style.borderColor = "#F73F52";
		passspan.innerHTML = "密码不能为空";	
		passspan.style.display = "block";
		return false;
	}
	else if(!reg.test(userpass.value))
	{
		userpass.style.borderColor = "#F73F52";
		passspan.innerHTML = "密码格式为字母数字下划线，长度10-16位";	
		passspan.style.display = "block";
		return false;
	}
	else
	{
		userpass.style.borderColor = "#ccc";
		passspan.style.display = "none";
		count++;
		if (count == 4)
		{
			btn.style.background = "#1b435d";
			btn.style.cursor = "pointer";
		}
		return true;
	}
}

function checkRepass()
{
	var userpass = document.getElementById("userpass");
	var userrepass = document.getElementById("userrepass");
	var repassspan = document.getElementById("repassspan");
	if (userrepass.value == "")
	{
		userrepass.style.borderColor = "#F73F52";
		repassspan.innerHTML = "密码不能为空";	
		repassspan.style.display = "block";
		return false;
	}
	else if(userpass.value != userrepass.value)
	{
		userrepass.style.borderColor = "#F73F52";
		repassspan.innerHTML = "与第一次密码不一致，请重新输入";	
		repassspan.style.display = "block";
		return false;
	}
	else
	{
		userrepass.style.borderColor = "#ccc";
		repassspan.style.display = "none";
		count++;
		if (count == 4)
		{
			btn.style.background = "#1b435d";
			btn.style.cursor = "pointer";
		}
		return true;
	}
}

function checkAll() {
	var pass = checkPass();
	var repass = checkRepass();
	if (email != 1 && pass == true && repass == true) {
		return true;
	}
	else {
		return false;
	}
}




