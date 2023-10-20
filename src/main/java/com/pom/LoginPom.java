package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPom extends BaseClass {
	
	public LoginPom()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Username : Admin']")
	private WebElement username;
	
	@FindBy(xpath = "//p[text()='Password : admin123']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='hidden']")
	private WebElement inputUsername;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement inputPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	private WebElement forgotPassword;
	
	public String getUserName(){
		String uname = username.getText();
		return uname.substring(uname.indexOf(':'), uname.length()-1);
	}
	
	public String getPassword(){
	  String pass =  password.getText();
	  return pass.substring(pass.indexOf(':'));
	}
	
	public void loginButtonClick() {
		loginButton.click();
	}


	public void setInputUsername(String inputUsername) {
		String username  = inputUsername.toString();
	}

	
	public void setInputPassword(String inputPassword) {
		String password = inputPassword.toString();
	}

	
	
	
}
