package utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BrowserUtility 
{
	AndroidDriver driver;
	String nodePath = "C:\\Program Files\\nodejs\\node.exe";
	String appiumMainJsPath = "C:\\Users\\River\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	String appiumMainJsPath2 = "C:\\Users\\River\\AppData\\Local\\Programs\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	private AppiumDriverLocalService service;
	
	@BeforeSuite
	public void startAppiumServer() 
	{
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodePath))
				.withAppiumJS(new File(appiumMainJsPath))
				.withIPAddress("127.0.0.1")
				.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
				.usingPort(4723)
				.withLogFile(new File("C:\\Users\\River\\Desktop\\Logfile.txt")));
		
		System.out.println("Appium Server Started.......");
		
		service.start();
	}
	
	public AndroidDriver launchApp() throws MalformedURLException, InterruptedException 
	{
		//Device Properties :
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "13");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("deviceName", "Pixel 6");
		cap.setCapability("appPackage", "io.testproject.demo");
		cap.setCapability("appActivity", "io.testproject.demo.MainActivity");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public void closeApp()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void stopAppiumServer() 
	{
		if (service.isRunning()) 
		{
			service.stop();
			System.out.println("Appium Server Stopped......");
		}
	}
}
