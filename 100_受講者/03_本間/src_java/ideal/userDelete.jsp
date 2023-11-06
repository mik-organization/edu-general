<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
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
<script type="text/javascript">
	
</script>
</head>
<body>

	<jsp:useBean id="userinfo" class="model.User" scope="session" />
	<%-- 	<jsp:useBean id="msg" class="model.IdealException" scope="request" /> --%>

	<title>お客様脱会手続き</title>
	<form action="UserOperationSvl" method="post"
		onsubmit="return dc(this);">

		</head>
		<body>


			<h2>お客様脱会手続き</h2>
			<br />

			<table border>

				<tr>
					<th>お客様ID</th>
					<td><jsp:getProperty name="userinfo" property="usrId" /></td>
				</tr>

				<tr>
					<th>お名前</th>
					<td><jsp:getProperty name="userinfo" property="usrName" /></td>
				</tr>

				<tr>
					<th>住 所</th>
					<td><jsp:getProperty name="userinfo" property="address" /></td>
				</tr>

				<tr>
					<th>電話番号</th>
					<td><jsp:getProperty name="userinfo" property="phone" /></td>
				</tr>

				<tr>
					<th>e-mail</th>
					<td><jsp:getProperty name="userinfo" property="mail" /></td>
				</tr>

				<tr>
					<td id="sub" colspan="2">お客様情報を削除します。確認してください！ <input
						type="submit" value="脱会" />
					</td>

					</form>
				</tr>

			</table>
			<br />
			<br />

			<p id="boder">
				<a href="userIndex.jsp">処理メニューに戻る</a>
			</p>
		</body>
</html>