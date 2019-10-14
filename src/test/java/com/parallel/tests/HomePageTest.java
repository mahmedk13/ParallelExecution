package com.parallel.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paralle.pages.BasePage;
import com.paralle.pages.HomePage;

public class HomePageTest extends BasePage {
	
	HomePage home= null;
	
	
	
	@AfterMethod
	public void tearDown(){
		home.browserClose();

	}
	
	@Test(dataProvider="getData")
	public void Test(String username, String password, String browser) {
		try{
		
		home = new HomePage();
		super.setUp(browser);
		home.launchApp("https://www.zoho.com/");
		home.login(username, password);
		Assert.assertTrue(home.verifySearchDisplayed());
		Thread.sleep(4000);
		}catch(Exception e){
			e.printStackTrace();
		}

		
		
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		
		Object[][] data = new Object[2][3];
		
		data[0][0]="mahmedk13@gmail.com";
		data[0][1]="Hasnain@135";
		data[0][2]="Chrome";
															
		data[1][0]="mahmedk16@gmail.com";
		data[1][1]="Hasnain@135";
		data[1][2]="firefox";


		
		return data;
		
	}
	

}
