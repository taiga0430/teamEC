<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="./css/table.css">
	<title>パスワード再設定確認</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script type="text/javascript">
		function submitAction(url){
			$('form').attr('action', url);
			$('form').submit();
		}
	</script>

</head>
<body>
	<s:include value="header.jsp"/>
	<div id="contents">
	<h1>パスワード再設定確認画面</h1>
	<s:form>
	<table class="vertical-list-table">
		<tr>
			<th scope="row"><s:label value="ユーザーID"/></th>
			<td><div class="txt"><s:property value="loginId"/><br><s:hidden name="loginId" value="%{loginId}" /></div></td>
		</tr>
		<tr>
			<th scope="row"><s:label value="新しいパスワード"/></th>
			<td><div class="txt"><s:property value="#session.concealedPassword"/><br></div></td>
	</table>
				<div class="submit_btn_box">
				    <input type="button" class="submit_btn" value="パスワード再設定" onclick="submitAction('ResetPasswordCompleteAction')" />
				 </div>

					<input type="button" class="submit_btn" value="戻る" onclick="submitAction('ResetPasswordAction')" />

		</s:form>
	</div>
	<s:include value="footer.jsp"/>
</body>
</html>