package test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.LoginPage;
import utility.BrowserUtility;
import utility.ExcelSheetReader;
import utility.JsonReader;

public class LoginTest extends BrowserUtility
{
	AndroidDriver driver;

	@BeforeMethod
	public void browserSetup() throws MalformedURLException, InterruptedException 
	{
		driver = launchApp();
	}

	@Test
	public void loginWithExcel() throws IOException
	{
		ExcelSheetReader reader = new ExcelSheetReader();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(reader.readCellContent(1, 0),reader.readCellContent(1, 1));
		
		loginPage.enterDetails(reader.readCellContent(1, 2),reader.readCellContent(1, 3),
							   reader.readCellContent(1, 4),reader.readCellContent(1, 5));
		
		boolean flag = loginPage.profileSaved_Check();
		Assert.assertTrue(flag, "Profile is not Saved");
	}
	
 	@Test
 	public void loginWithJson() throws IOException, ParseException 
 	{
 		JsonReader json = new JsonReader();
		
 		LoginPage loginPage = new LoginPage(driver);
 		loginPage.login(json.readJsonContent("UserName"), json.readJsonContent("Password"));
		
 		loginPage.enterDetails(json.readJsonContent("Country"),json.readJsonContent("Address"),
 							   json.readJsonContent("EmailId"),json.readJsonContent("MobileNo"));
		
 		boolean flag = loginPage.profileSaved_Check();
 		Assert.assertTrue(flag, "Profile is not Saved");
 	}
	
	@AfterMethod
	public void browserTearDown()
	{
		closeApp();
	}
}
