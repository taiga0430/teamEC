<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="./css/table.css">
	<link rel="stylesheet" href="./css/form.css">
	<title>パスワード再設定</title>
</head>
<body>
	<s:include value="header.jsp"/>
	<div id="contents">
	<h1>パスワード再設定画面</h1>

	<!-- エラーがある場合エラーメッセージを表示する -->
	<s:if test="!loginIdErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="loginIdErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</s:if>

	<s:if test="!passwordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="passwordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</s:if>

	<s:if test="!passwordIncorrectErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="passwordIncorrectErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</s:if>

	<s:if test="!newPasswordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="newPasswordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</s:if>

	<s:if test="!reConfirmationNewPasswordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="reConfirmationNewPasswordErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</s:if>

	<s:if test="!newPasswordIncorrectErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="newPasswordIncorrectErrorMessageList"><s:property />
		<br></s:iterator>
		</div>
		</div>
		</s:if>
	<s:form action="ResetPasswordConfirmAction">

		<!-- パスワード再設定の入力フォーム -->
		<table class="vertical-list-table">
		<tr>
				<th scope="row"><s:label value="ユーザーID"/></th>
				<td><div class="txt-box"><s:textfield name="loginId" class="form-txt" placeholder="ユーザーID"/></div></td>
		</tr>
		<tr>
				<th scope="row"><s:label value="現在のパスワード"/></th>
				<td><div class="txt-box"><s:password name="password" placeholder="現在のパスワード" class="form-txt"/></div></td>
		</tr>
		<tr>
				<th scope="row"><s:label value="新しいパスワード"/></th>
				<td><div class="txt-box"><s:password name="newPassword" placeholder="新しいパスワード" class="form-txt"/></div></td>
		</tr>
		<tr>
				<th scope="row"><s:label value="(再確認)"/></th>
				<td><div class="txt-box"><s:password name="reConfirmationPassword" placeholder="(再確認)" class="form-txt"/></div></td>
		</tr>
		</table>

		<div class="submit_btn_box">
		<s:submit value="確認" class="submit_btn"/>
        </div>
	</s:form>
	</div>
	<s:include value="footer.jsp"/>
</body>
</html>