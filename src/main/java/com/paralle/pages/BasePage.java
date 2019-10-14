package com.paralle.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public void setDriver(WebDriver driver){
		dr.set(driver);
	}
	
	public WebDriver getDriver(){
		return dr.get();
	}
	
	public void setUp(String browser){
		try{
		if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")){

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		setDriver(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
}
