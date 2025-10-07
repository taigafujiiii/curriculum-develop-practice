// formの値をリアルタイムで比べる

window.onload = function() {
	
	document.getElementById("input_name").oninput = function () {
		const myName = document.getElementById("input_name").value;
		if(myName == ''){
			$('#input_name').css('background-color', '#f79999');
			$('#submit_btn').attr('disabled', 'true');
		}else{
			$('#input_name').css('background-color', '#ffffff');
			$('#submit_btn').removeAttr('disabled');
		}	
	}
	
	//メールアドレスチェック
	document.getElementById("input_email").oninput = function () {
		//emailの正規表現
		const emailRegex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}$/i;
		const myEmail = document.getElementById("input_email").value;
	
		//input_emailの中身を正規チェック
		if(emailRegex.test(myEmail) == true && myEmail != '') {
			$('#input_email').css('background-color', '#ffffff');
			$('#submit_btn').removeAttr('disabled');
		}else{
			$('#input_email').css('background-color', '#f79999');
			$('#submit_btn').attr('disabled', 'true');
		}	
	}
	
	
	//パスワードチェック
    document.getElementById("input_password").oninput = function () {
		//パスワードの正規表現
		const passwordRegex = /^(?=.*?[a-z])(?=.*?\d)[a-z\d]{8,200}$/i;
		const myPassword = document.getElementById("input_password").value;
		
		if(passwordRegex.test(myPassword) == true && myPassword != ''){
			$('#input_password').css('background-color', '#ffffff');
		}else{
			$('#input_password').css('background-color', '#f79999');
			document.getElementById("input_password_confirmation").value = "";
			$('#submit_btn').attr('disabled', 'true');
		}
	}
	
	document.getElementById("input_password_confirmation").oninput = function getMyPassword() {
		//入力値の取得
		const password = document.getElementById("input_password").value;
		const password_conf = document.getElementById("input_password_confirmation").value;
		
		if(password == password_conf && password != '' && password_conf != '') {
			$('#input_password_confirmation').css('background-color', '#ffffff');
			$('#submit_btn').removeAttr('disabled');
		}else{
			$('#input_password_confirmation').css('background-color', '#f79999');
			$('#submit_btn').attr('disabled', 'true');
		} 
	}
}
