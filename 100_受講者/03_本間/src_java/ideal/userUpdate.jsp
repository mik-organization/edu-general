<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/JavaScript" src="incScript.js"></script>
<script type="text/JavaScript">
<!--
	//1.入力項目チェック
	function checkData(obj) {
		//1.メッセージを宣言
		var msg = "";
		//2.ふりがなが未入力の時、
		if (obj.nameReading.value == null || obj.nameReading.value == "") {
			//1.メッセージに"ふりがなを入力してください！\n"を追加
			msg += "ふりがなを入力してください！\n";
		}
		//3.連絡方法で電話が選択されていて、電話番号が未入力の時、
		if (obj.comm[0].checked
				&& (obj.phone.value == null || obj.phone.value == "")) {
			//1.メッセージに"電話番号を入力してください！\n"を追加
			msg += "電話番号を入力してください！\n";
		}
		//4.連絡方法でメールが選択されていて、メールが未入力の時、
		if (obj.comm[1].checked
				&& (obj.mail.value == null || obj.mail.value == "")) {
			//1.メッセージに"e_mailを入力してください！\n"を追加
			msg += "e_mailを入力してください！\n";
		}
		//5.連絡方法ではがきが選択されていて、住所が未入力の時、
		if (obj.comm[2].checked
				&& (obj.address.value == null || obj.address.value == "")) {
			//1.メッセージに"住所を入力してください！\n"を追加
			msg += "住所を入力してください！\n";
		}
		//6.メッセージが空白の時、
		if (msg == "") {
			//1."true"を返す。
			return true;
		} else {
			//7.メッセージが空白以外の時、
			//1.アラーとでメッセージを表示し"false"を返す。
			alert(msg);
			return false;
		}
	}
//-->
</script>


<style type="text/css">
<!--
* {
	padding: 5px;
	margin: 0px;
}

body {
	text-align: center;
}

table {
	width: 800px;
	background-color: white;
	border: 2px black solid;
	border-collapse: collapse;
	margin-left: auto;
	margin-right: auto;
}

th {
	border: 1px black solid;
	background: skyblue;
}

td {
	border: 1px black solid;
	text-align: left;
}

td#button {
	border: 1px black solid;
	text-align: center;
}
-->
</style>
</head>
<body>

	<jsp:useBean id="userinfo" class="model.User" scope="session" />
	<%-- 	<jsp:useBean id="msg" class="model.IdealException" scope="request" /> --%>


	<h2>お客様情報変更</h2>
	<br />

	<form action="UserOperationSvl" onsubmit="return checkData(this)"
		method="post">
		<table border>
			<tr>

				<th>お客様ID</th>
				<td><jsp:getProperty name="userinfo" property="usrId"/></td>
			</tr>
			<tr>
				<th>お名前</th>
				<td><input type="text" name="usrName" size="30" maxlength="30"
					value='<jsp:getProperty name="userinfo" property="usrName"/>' />
				</td>
			</tr>
			<tr>

				<th>住 所</th>
				<td><input type="text" name="address" size="50" maxlength="200"
					value='<jsp:getProperty name = "userinfo" property = "address" />' />
				</td>
			</tr>
			<tr>

				<th>電話番号</th>
				<td><input type="text" name="phone" size="15" maxlength="20"
					value='<jsp:getProperty name = "userinfo" property = "phone" />'</td>
			</tr>
			<tr>

				<th>e-mail</th>
				<td><input type="text" name="mail" size="30" maxlength="100"
					style="ime-mode: disabled;"
					value='<jsp:getProperty name = "userinfo" property = "mail" />' />
				</td>
			</tr>

			<tr>

				<th>パスワード</th>
				<td><input type="password" name="password" size="8"
					maxlength="8" /> ※変更時のみ入力してください。</td>
			</tr>

			<tr>

				<td id="sub" colspan="2">※は必修入力です。 <input type="submit"
					value=" 変更 " />
				</td>
			</tr>

			<input type="hidden" name="usrId" value="3" />

			<input type="hidden" name="mode" value="12" />
		</table>
		<br />
	</form>
	<br />

	<p id="boder">
		<a href="userIndex.jsp">戻る</a>
	</p>
</body>



</html>