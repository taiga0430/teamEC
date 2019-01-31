package com.internousdev.gerbera.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.gerbera.dao.UserInfoDAO;
import com.internousdev.gerbera.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware{

	private String loginId;
	private String password;
	private String newPassword;
	private String reConfirmationPassword;

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> passwordIncorrectErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordErrorMessageList = new ArrayList<String>();
	private List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordIncorrectErrorMessageList = new ArrayList<String>();

	private Map<String,Object> session;

	public String execute(){
		if(!session.containsKey("mCategoryList")){
			return "sessionTimeOut";
			}
			String result = ERROR;

			InputChecker inputChecker = new InputChecker();

			//フォームの入力内容が入力規則に一致するかを確認する
			loginIdErrorMessageList = inputChecker.doCheck("ユーザーID",loginId,1,8,true,false,false,true,false,false,false,false,false);
			passwordErrorMessageList = inputChecker.doCheck("現在のパスワード",password,1,16,true,false,false,true,false,false,false,false,false);
			newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード",newPassword,1,16,true,false,false,true,false,false,false,false,false);
			reConfirmationNewPasswordErrorMessageList = inputChecker.doCheck("(再確認)",reConfirmationPassword,1,16,true,false,false,true,false,false,false,false,false);

			//入力規則に一致している場合の処理
			if(loginIdErrorMessageList.size()==0
			&& passwordErrorMessageList.size()==0
			&& newPasswordErrorMessageList.size()==0
			&& reConfirmationNewPasswordErrorMessageList.size()==0){

				UserInfoDAO userInfoDAO = new UserInfoDAO();

				//DBにユーザー情報が存在し、パスワードが一致する場合の処理
				if(userInfoDAO.isExistUserInfo(loginId, password)){
					newPasswordIncorrectErrorMessageList = inputChecker.doPasswordCheck(newPassword, reConfirmationPassword);

					//「新しいパスワード」「(再確認)」が一致している場合の処理
					if(newPasswordIncorrectErrorMessageList.size()==0){
						String concealedPassword = concealPassword(newPassword);
						session.put("newPassword",newPassword);
						session.put("concealedPassword",concealedPassword);
						session.put("resetPasswordLoginId",loginId);
						result = SUCCESS;
					}

				//DBにユーザー情報が存在しない、またはパスワードが一致しない場合の処理
				}else{
					passwordIncorrectErrorMessageList.add("ユーザーIDまたは現在のパスワードが異なります。");
				}
			}


		return result;
	}

	public String concealPassword(String password){
		int beginIndex = 0;
		int endIndex = 1;

		StringBuilder stringBuilder = new StringBuilder("****************");

		String concealPassword = stringBuilder.replace(beginIndex,endIndex,password.substring(beginIndex,endIndex)).toString();
		return concealPassword;
	}

	public String getLoginId(){
			return loginId;
	}

	public void setLoginId(String loginId){
			this.loginId = loginId;
	}

	public String getPassword(){
			return password;
	}

	public void setPassword(String password){
			this.password = password;
	}

	public String getNewPassword(){
			return newPassword;
	}

	public void setNewPassword(String newPassword){
			this.newPassword = newPassword;
	}

	public String getReConfirmationPassword(){
			return reConfirmationPassword;
	}

	public void setReConfirmationPassword(String reConfirmationPassword){
			this.reConfirmationPassword = reConfirmationPassword;
	}

	public List<String> getLoginIdErrorMessageList(){
			return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList){
			this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList(){
			return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList){
			this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<String> getPasswordIncorrectErrorMessageList(){
			return passwordIncorrectErrorMessageList;
	}

	public void setPasswordIncorrectErrorMessageList(List<String>passwordIncorrectErrorMessageList){
			this.passwordIncorrectErrorMessageList = passwordIncorrectErrorMessageList;
	}

	public List<String> getNewPasswordErrorMessageList(){
			return newPasswordErrorMessageList;
	}

	public void setNewPasswordErrorMessageList (List<String> newPasswordErrorMessageList){
			this.newPasswordErrorMessageList = newPasswordErrorMessageList;
	}

	public List<String> getReConfirmationNewPasswordErrorMessageList(){
			return reConfirmationNewPasswordErrorMessageList;
	}

	public void setReConfirmationNewPasswordErrorMessageList(List<String> reConfirmationNewPasswordErrorMessageList){
			this.reConfirmationNewPasswordErrorMessageList = reConfirmationNewPasswordErrorMessageList;
	}

	public List<String> getNewPasswordIncorrectErrorMessageList(){
			return newPasswordIncorrectErrorMessageList;
	}

	public void setNewPasswordIncorrectErrorMessageList(List<String> newPasswordIncorrectErrorMessageList){
			this.newPasswordIncorrectErrorMessageList = newPasswordIncorrectErrorMessageList;
	}

	public Map<String,Object>getSession(){
			return session;
	}

	public void setSession(Map<String,Object>session){
			this.session = session;
	}
}
