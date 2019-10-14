package com.paralle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paralle.pages.HomePage;

public class HomePage extends BasePage {
	
	public HomePage(){
		super();
	}
	
	public void launchApp(String url) {
		try{
		getDriver().get(url);
		Thread.sleep(4000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void login(String username, String password) {
		try{
		getDriver().findElement(By.xpath("//a[text()='Login']")).click();
		Thread.sleep(3000);
		getDriver().findElement(By.id("lid")).sendKeys(username);
		getDriver().findElement(By.id("pwd")).sendKeys(password);
		getDriver().findElement(By.id("signin_submit")).click();
		Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean verifySearchDisplayed(){
		boolean flag = false;
		try{
		 flag= getDriver().findElement(By.xpath("//a[contains(@href, 'calendar')]/span")).isDisplayed();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	public void browserClose(){
		try{
		getDriver().quit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

}
