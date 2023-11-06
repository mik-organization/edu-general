<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userIndex</title>

<style>
<!--
	table {border:1px black solid; 
			text-align: center;
			margin: auto;}
	caption {font-size: 18pt;
		      color: #009967;}
	tr.data0 {background: #E3FFE3;}
	tr.data1 {background: #A4FFDB;}
	th {background: #007B66;
		color: #ECFFF3;}
	td {border:1px black solid;
	    text-align: left;
		vertical-align: top;
		white-space: nowrap;}
	td.outer {padding: 10px;
			  background: #FAFFE3;}

	.code {width: 40px;
		   text-align: center;}
	.menu {width: 250px;}
	.price {width: 60px;
	        text-align: right;
	        padding-right: 5px;}
	.comm {width: 400px;}
	.ord {width: 100px;
	      text-align: center;}
	.btn {width: 100px;}
	h1 {text-align: center;
		background: #007B66;
		color: #ECFFF3;}
	h2 {text-align: center;
		color: #ECFFF3;}
	h3 {text-align: center;
		color: #ECFFF3;}
	div#type1 {width: 130px;
		       border: solid gray 1px;
		       background: #E3FFE3;
		       color: #007B53;
		       padding: 2px;
		       cursor: pointer;
		       margin-top: 5px;}
	div#type2 {width: 130px;
		       border: solid gray 1px;
		       background: #007B53;
		       color: #E3FFE3;
		       padding: 2px;
		       cursor: pointer;
		       margin-top: 5px;}

-->
</style>
<script type="text/javascript">
<!--
function dataCheck(obj){
	var massage=""
	if(obj.usrName.value.length < 1){
		massage += "お客様IDを入力してください。\n";
	}else if(obj.password.value.length < 1){
		massage += "パスワードを入力してください。\n";
	}
	if(massage.length > 0){
		alert(massage);
		return false;
	}else{
		return true;
	}
}
//-->
</script>

</head>
<body>
	<h1>Restaurante IDEALLE</h1>
		<br/>
		
	<%-- 
	<jsp:useBean id="user" class="controller.UserLoginSvl" scope="session" />
	
	<hr width=400 size=3 />
	<div><%= user.getUsrName() %>様、いらっしゃいませ。</div>
	<hr width=400 size=3 /> --%>
	
		<h3><a href="ShowMenuSvl">●メニュー紹介</a></h>
		<h3><a href="ReserveListSvl">●ご予約</a></h>
		<h3><a href="UserUpdateSvl">●お客様情報変更</a></h>
		<h3><a href="UserDeleteSvl">●お客様脱会手続き</a></h>
		<h3><a href="UserLogoffSvl">●ログオフ</a></h2>
</body>
</html>
