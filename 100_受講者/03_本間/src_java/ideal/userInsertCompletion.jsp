<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お客様情報登録完了</title>
	<link rel="stylesheet" type="text/css" href="completion.css"/>
	</head>

	<body>
	
	<!-- 参照元のフィールド名未入力-->
	<jsp:useBean id="" class="" scope="request" />
	<jsp:useBean id="" class="java.util.ArrayList" scope="request" />
		
     	<h1>お客様情報の登録が完了いたしました。</h1>
     	<form action="User" method="post"
			onsubmit="return dc(this);">
     	<br/>

		<h2> <a><style="ime-mode: disabled;" 
		value= '<jsp:getProperty name = "" property = "usrName" />'
		</a></style>
		様のお客様IDは、「
		<a><style="ime-mode: disabled;" 
		value= '<jsp:getProperty name = "" property = "UsrId" />'
		</a></style>
		」でごさいます。</h2>
		<br/>

		<h2>ログインの際、必要となりますので</h2>
		<br/>
		<h2>大切に保管なさってください。</h2>

        </form>

		<br />
		
		<p id="boder"><a href="userIndex.jsp">戻る</a></p>
	</body>
</html>