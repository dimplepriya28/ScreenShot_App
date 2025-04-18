package ScreenShotApplication;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class GUI_steps {
	static WebDriver driver = new ChromeDriver();
	
	public void application_login(String url,String emailid,String pwd) throws InterruptedException {
		By email = By.id("email");
		By password = By.id("pass");

		driver.get(url);
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(email).sendKeys(emailid);
		driver.findElement(password).sendKeys(pwd);
		takescreenshot("SignInPage");
		driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
		Thread.sleep(3000);
		takescreenshot("HomePage");
		driver.quit();
		System.exit(0);

	}
	
	public void takescreenshot(String filename) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String folderPath = "C:\\Users\\user\\Dimple\\ECLIPSE_WORKSPACE\\Take_Screenshot\\Screenshots"; // Change to your path
			File dest = new File(folderPath + File.separator +filename+".png");
			FileHandler.copy(src, dest);
			
			
			
			
			
			 //JOptionPane.showMessageDialog(null, "Screenshot saved at:\n" + dest.getAbsolutePath());
		}catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error capturing screenshot:\n" + ex.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
