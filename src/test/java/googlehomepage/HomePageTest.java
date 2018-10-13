package googlehomepage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import singletonpractice.WebDriver_Singleton;

public class HomePageTest {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriver_Singleton instanceDriver=WebDriver_Singleton.getInstance();
		driver=instanceDriver.openBrowser();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void homePageTitleTest() {
		Assert.assertEquals("Google", "Google");
	}
	
	@Test
	public void checkAllLinksTest() {
		WebDriver_Singleton.checkAllLinks();
	}
	
	@ Test
	public void googleLogoTest() {
		WebDriver_Singleton.checkGoogleLogo();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
