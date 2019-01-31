<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="./css/complete.css">
	<META http-equiv="refresh" content="3; url=HomeAction">
	<title>パスワード再設定完了</title>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="contents">
		<h1>パスワード再設定完了画面</h1>
		<div class="success">
		パスワード再設定が完了しました。
		</div>

		<s:include value="footer.jsp" />
	</div>
</body>
</html>