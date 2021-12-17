package com.example.form;

public class InsertUserForm {

	//メールアドレス
	private String userMailAddress;
	//ユーザーネーム
	private String userName;
	//ユーザーの本名
	private String userFullName;
	//パスワード
	private String userPassword;
	
	//ゲッターとセッター
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	
	public String getUserMailAddress() {
		return userMailAddress;
	}
	public void setUserMailAddress(String userMailAddress) {
		this.userMailAddress = userMailAddress;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "InsertUserForm [userName=" + userName + ", userFullName=" + userFullName + ", userMailAddress="
				+ userMailAddress + ", userPassword=" + userPassword + "]";
	}
	
	
}
