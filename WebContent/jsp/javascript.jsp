<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaScript Session</title>

	<script type="text/javascript">
		function getCookie(name){
			var str = document.cookie;
			if(!str||str.indexOf(name+"=")<0) return;
			var cookies = str.split(";");
			for(var i=0;i<cookies.length;i++){
				var cookie = cookies[i];
				if(cookie.indexOf(name+"=")==0){
					var value = cookie.substring(name.length+1);
					return decodeURI(value);
				}
			}
		}
		function setCookie(name,value){
			document.cookie=name+"="+encodeURI(value);
		}
	</script>

</head>
<body>
	<div align="center" style="margin:10px">
		<fieldset>
			<legend>the valid cookie</legend>
			<div id="cookieDiv">
				<script type="text/javascript">
					cookieDiv.innerHTML= document.cookie;
				</script>
			</div>
		</fieldset>
		<fieldset>
			<legend>Welcome!</legend>
				<table>
					<tr>
						<td>read cookie:</td>
						<td><input name="name1"><input class="button" type="button" value="read" onclick="alert(getCookie(name1.value));"></td>
					</tr>
					<tr>
						<td>set Cookie:</td>
						<td></td>
					</tr>
					<tr>
						<td align="right">Name attribute:</td>
						<td><input name="name2"></td>
					</tr>
					<tr>
						<td align="right">Value attribute:</td>
						<td><input name="value2"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="button" value="set" onclick="setCookie(name2.value,value2.value);cookieDiv.innerHTML=document.cookie;" class="button"></td>
					</tr>
				</table>
		</fieldset>
	</div>
</body>
</html>