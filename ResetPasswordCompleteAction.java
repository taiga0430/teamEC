package com.internousdev.gerbera.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.gerbera.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware{
	private String loginId;
	private String password;
	private Map<String,Object>session;

	public String execute(){
		if(!session.containsKey("mCategoryList")) {
		return "sessionTimeOut";
		}

		if (!session.containsKey("newPassword")){
			return ERROR;
		}

		String result;

		if(loginId.equals(session.get("resetPasswordLoginId").toString())){

			session.remove("resetPasswordLoginId");

			UserInfoDAO userInfoDAO = new UserInfoDAO();
			int count = userInfoDAO.resetPassword(String.valueOf(loginId),String.valueOf(session.get("newPassword")));
			if(count>0){
					result = SUCCESS;
			}else{
					result =ERROR;
			}

		}else{
			result =ERROR;
		}

		return result;

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

	public Map<String,Object>getSession(){
			return session;
	}

	public void setSession(Map<String,Object>session){
			this.session = session;
	}

}
