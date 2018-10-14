package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ExtentReportListener.ExtentListenerClass;

public class Log4jTest extends ExtentListenerClass {

	public static WebDriver driver;
	public static Actions action;
	public static Select select;
	public static WebDriverWait wait;

	public static String value = "how to resize a window in selenium";

	@BeforeMethod
	public static void setUp() {
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Automation\\Practice\\jars\\geckodriver.exe"); driver =new
		 * FirefoxDriver();
		 * 
		 *
		 */
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Practice\\jars\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.google.com");
		driver.manage().window().maximize(); //
		driver.manage().window().fullscreen();

		action = new Actions(driver);

	}

	@Test(enabled = true, groups = { "Google" })
	public static void upperCase() {

		WebElement element = driver.findElement(By.id("gs_htif0"));
		action.keyDown(element, Keys.SHIFT).sendKeys(value).build().perform();
	}

}
