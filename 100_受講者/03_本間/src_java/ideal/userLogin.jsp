<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userLogin</title>

<style>
<!--
	body{
   		width: 960px;
    	margin: auto;
    	text-align: center;
    	}
table {
	border: 1px black solid;
	text-align: center;
	margin: auto;
}

caption {
	font-size: 18pt;
	color: #009967;
}

tr.data0 {
	background: #E3FFE3;
}

tr.data1 {
	background: #A4FFDB;
}

th {
	background: #007B66;
	color: #ECFFF3;
}

td {
	border: 1px black solid;
	text-align: left;
	vertical-align: top;
	white-space: nowrap;
}

td.outer {
	padding: 10px;
	background: #FAFFE3;
}

.code {
	width: 40px;
	text-align: center;
}

.menu {
	width: 250px;
}

.price {
	width: 60px;
	text-align: right;
	padding-right: 5px;
}

.comm {
	width: 400px;
}

.ord {
	width: 100px;
	text-align: center;
}

.btn {
	width: 100px;
}

h1 {
	text-align: center;
	background: #007B66;
	color: #ECFFF3;
}

div#type1 {
	width: 130px;
	border: solid gray 1px;
	background: #E3FFE3;
	color: #007B53;
	padding: 2px;
	cursor: pointer;
	margin-top: 5px;
}

div#type2 {
	width: 130px;
	border: solid gray 1px;
	background: #007B53;
	color: #E3FFE3;
	padding: 2px;
	cursor: pointer;
	margin-top: 5px;
}
-->
</style>
<script type="text/javascript">
<!--
	function dataCheck(obj) {
		var massage = "";
		var result = obj.usrId.value.match(/[^0-9]/);
		
		if (obj.usrId.value.length < 1) {
			massage += "お客様IDを入力してください。\n";
		} else if (obj.password.value.length < 1) {
			massage += "パスワードを入力してください。\n";
		}
		if (massage.length > 0) {
			alert(massage);
			return false;
		}
		if(result){
			massage += "半角数字以外入力不可です。\n";
			alert(massage);
			return false;
		}
		else {
			return true;
		}
	}
//-->
</script>
</head>
<body>
	<h1>お客様ログイン</h1>
	 <jsp:useBean id="userInfo" class="model.User" scope="session" />		
	<jsp:useBean id="msg" class="controller.UserLoginSvl" scope="request" />
		
	<div>
	<% if(userInfo == null){ %>
	<hr width=400 size=3 />
	<%-- <div><%= msg.getMsg() %></div> --%>
	<hr width=400 size=3 />
	<% } %>
	</div>
	
	<table>
		<form name="loginForm" action="UserLoginSvl" method="post"
			onSubmit="return dataCheck(this);">
			<tr>
				<th>お客様ID ※1</th>
				<td><input type="text" id="usrId" name="usrId" size="10"
					maxlength="10" /></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" id="password" name="password"
					size="8" maxlength="10" /></td>
			<tr>
				<th colspan="2" id="bottom" name="bottom"><input type="submit"
					value="送信" /></th>
			</tr>
		</form>
	</table>※1：数字のみ
	<br />
	<p id="boder">
		<a href="home.jsp">ホームページ</a>
	</p>
</body>
</html>