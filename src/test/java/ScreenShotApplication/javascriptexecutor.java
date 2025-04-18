package ScreenShotApplication;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javascriptexecutor {
	private WebDriver driver;
	private JavascriptExecutor jse;
	public javascriptexecutor(WebDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor) driver;
	}

		
	public void jse_scroll(WebElement element) {
		 jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void jse_click(WebElement element) {
		jse.executeScript("arguments[0].click()", element);
	}
	
	public void jse_entervalue(WebElement element,String text) {
		jse.executeScript("arguments[0].value='"+text+"';", element);
	}
	

}
