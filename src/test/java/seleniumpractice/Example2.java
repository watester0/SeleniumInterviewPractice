package seleniumpractice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ExtentReportListener.ExtentListenerClass;

public class Example2  {
	public static WebDriver driver;
	public static Actions action;
	public static Select select;
	public static WebDriverWait wait;
	public static Alert alert;
	public static JavascriptExecutor jsexe;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Practice\\jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

	}

	@Test
	public void checkSameObjectLocators() {
		List<WebElement> element = driver.findElements(By.tagName("a"));
		System.out.println(element.size());
		System.out.println(element.get(20).getText());
		WebElement cokieLink = driver.findElement(By.xpath("//*[@id=\"cookie-use-link\"]"));
		action.contextClick(cokieLink).perform();
	}
	
	public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
}
	
	public WebElement findElement(By by) {
	    WebElement elem = driver.findElement(by);
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	    }
	    return elem;
	}

	@AfterMethod
	public void tearDown(ITestResult result)  {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
			/*	jsexe.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');");
				Thread.sleep(2000);*/
				FileUtils.copyFile(src, new File("D:\\Automation\\Practice\\Soltex\\Practice\\screenshots\\"
						+ result.getMethod().getMethodName() +"\\"+timestamp()+ ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}
