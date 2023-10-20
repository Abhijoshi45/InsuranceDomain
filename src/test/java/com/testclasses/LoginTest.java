package com.testclasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.LoginPom;
import com.utility.Utility;

public class LoginTest extends BaseClass {
	

	@BeforeMethod
	public void setUp() {
		try {
			launchTheWeb();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearup() {
		driver.quit();
	}
	
	@Test
	public void loginTest() {
		LoginPom loginPom = new LoginPom();
		loginPom.setInputUsername(loginPom.getUserName());
		loginPom.setInputPassword(loginPom.getPassword());
		loginPom.loginButtonClick();
	}
	
	//forget password
	
	//getTitle
	
	//getCurrentUrl
	
	//Logo
	
	//differentusers
	@Test		
	public void testUsers() throws EncryptedDocumentException, IOException {
		
		LoginPom loginPom = new LoginPom();
		
        Utility utility = new Utility();
		
		Sheet sh = utility.getSheet("Sheet");
		
		String key = (String) utility.getSingleData(1, 0, sh);
		String value = (String) utility.getSingleData(1, 1, sh);
		
		loginPom.setInputPassword(key);
		loginPom.setInputPassword(value);
	}
	
	public void getDataFromExcel() throws EncryptedDocumentException, IOException {
		
		Utility utility = new Utility();
		
		Sheet sh = utility.getSheet("Sheet");
		
		String key = (String) utility.getSingleData(1, 0, sh);
		String value = (String) utility.getSingleData(1, 1, sh);
		
		
	}
}
