package seleniumpractice;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShotsClass {

	public static WebDriver driver;

	public static void failed(String testMethodName) {

		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcfile, new File(
					"D:\\Automation\\Practice\\Soltex\\Practice\\screenshots\\" + testMethodName + "-" + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
