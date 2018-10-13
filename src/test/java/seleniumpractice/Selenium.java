package seleniumpractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Selenium {

	public static WebDriver driver;
	public static Actions action;
	public static Select select;

	public static String value = "how to resize a window in selenium";

	@BeforeMethod
	public static void setUp() {
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Automation\\Practice\\jars\\geckodriver.exe"); driver =new
		 * FirefoxDriver();
		 */
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Practice\\jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		// driver.manage().window().fullscreen();

		action = new Actions(driver);

	}

	@Test(enabled = true, groups = { "Google" })
	public static void upperCase() {

		WebElement element = driver.findElement(By.id("gs_htif0"));
		action.keyDown(element, Keys.SHIFT).sendKeys(value).build().perform();
	}

	// ********************************************

	@Test(enabled = true, groups = { "Google" })
	public static void windowResize() {
		org.openqa.selenium.Dimension dim = new org.openqa.selenium.Dimension(800, 400);
		driver.manage().window().setSize(dim);
	}

	// ***************************************************//
	@Test(enabled = true, groups = { "Google" })
	public void rightClick() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a"));
		action.contextClick(element).build().perform();
	}

	// ************************************************//

	@Test(priority = 4, groups = { "Facebook", "FB" })
	public void selectElementWithSameLocator() throws InterruptedException {
		driver.navigate().to("https://www.facebook.com");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"month\"]"));
		select = new Select((element));
		select.selectByIndex(10);
		Thread.sleep(3000);
		select.selectByValue("4");
		Thread.sleep(3000);
		select.selectByVisibleText("Apr");

	}

	@Test(priority = 5, groups = { "Facebook" })
	public void enterUserId() {
		driver.findElement(By.id("email")).sendKeys("mdwaseeem6666@gmail.com");
	}

	@Test(priority = 6, dependsOnMethods = { "enterUserId" }, dependsOnGroups = { "Facebook.*" }) // "Facebook.*"---means
																									// all Facebook
																									// groups invoked
																									// before it
	public void enterPassword() {
		driver.findElement(By.id("pass")).sendKeys("soltex123");
	}

	// Retry Listener ********** expectedExceptions
	@Test(expectedExceptions = NoSuchElementException.class) // retryAnalyzer =
																// seleniumpractice.RetryAnalyzer2.class--->
	@Parameters("mail")
	public void clickOnLoginBtn(String email) {
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("u_0_2")).submit();
		System.out.println("Btn element not found");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				FileUtils.copyFile(srcfile, new File("D:\\Automation\\Practice\\Soltex\\Practice\\screenshots\\-"
						+ result.getName() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}
}
