package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.Utility;

public class BaseClass {
	
	public static WebDriver driver;
	
	FileInputStream fileInputStream;
	public static String projectpath = System.getProperty("user.dir");
	
	public  void launchTheWeb() throws IOException{
		
		fileInputStream = new FileInputStream(projectpath+"\\src\\main\\resources\\property\\config.properties");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Properties properties = new Properties();
		
		properties.load(fileInputStream);
		
		properties.getProperty("weburl1");
		
		driver.get(properties.getProperty("weburl1"));
		
		Utility.implictWeight();
	}

}
