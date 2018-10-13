package singletonpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebDriver_Singleton {

	private static WebDriver_Singleton instanceDriver = null;
	private static WebDriver driver;

	public WebDriver_Singleton() {

	}
	
	public WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver_Singleton getInstance() {
		if (instanceDriver == null) {
			instanceDriver = new WebDriver_Singleton();
		}
		return instanceDriver;
	}

	public static void checkAllLinks() {
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("Total links on home page---->"+allLinks.size());
		
		for(WebElement link: allLinks) {
			
			System.out.println(link.getAttribute("href"));
			System.out.println(link.getText());
		
		}
	}
		
		public static void checkGoogleLogo() {
			boolean logoPresent= driver.findElement(By.xpath("//*[@id=\'hplogo\']")).isDisplayed();
		Assert.assertTrue(logoPresent);	
		}
	}

