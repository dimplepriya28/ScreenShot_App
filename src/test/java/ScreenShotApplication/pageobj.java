package ScreenShotApplication;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ScreenShotApplication.javascriptexecutor;

public class pageobj {
	private WebDriver driver;
	private javascriptexecutor jse;  
	private WebDriverWait wait;
	public pageobj(WebDriver driver){
		this.driver = driver;
		jse = new javascriptexecutor(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

	private  WebElement element = null;
	
	public  WebElement spanele(String name) {
		element = driver.findElement(By.xpath("//span[.='"+name+"']"));
		return element;
	}
	
	public  WebElement partiallink(String name) {
		element = driver.findElement(By.partialLinkText(name));
		return element;
	}
	
	public  WebElement size(String name) {
		element = driver.findElement(By.xpath("//div[@aria-label='"+name+"']"));
		return element;
	}
	
	public WebElement colour(String name) {
		element = driver.findElement(By.xpath("//div[@aria-label='"+name+"']"));
		return element;
	}
	
	public WebElement quantity() {
		element = driver.findElement(By.xpath("//input[@id='qty']"));
		return element;
	}
	
	public WebElement addcartbtn() {
		element = driver.findElement(By.xpath("//span[.='Add to Cart']"));
		return element;
	}
	
	public WebElement showcartbtn() {
		element = driver.findElement(By.xpath("//a[@class='action showcart']"));
		return element;
	}
	
	public WebElement cartcount() {
		element = driver.findElement(By.xpath("//span[@class='counter-number']"));
		return element;
	}
	
	public WebElement button(String name) {
		element = driver.findElement(By.xpath("//button[.='"+name+"']"));
		return element;
	}
	
	public WebElement inputfield(String name) {
		element = driver.findElement(By.xpath("//*[@name='"+name+"']"));
		return element;
	}
	
	public WebElement radiobtn() {
		element = driver.findElement(By.xpath("//*[@class='radio']"));
		return element;
	}
	
	public WebElement dropdownOption(String name) {
		element = driver.findElement(By.xpath("//option[text()='" + name + "']"));
		return element;
	}
	
	public WebElement shpaddcheckbox() {
		element = driver.findElement(By.xpath("//input[@id='billing-address-same-as-shipping-checkmo']"));
		return element;
	}
	
	public WebElement ordernumber() {
		element = driver.findElement(By.xpath("//a[@class='order-number']"));
		return element;
	}
	
	
	
	
	public void clearcart() throws InterruptedException {
		jse.jse_scroll(showcartbtn());
		wait.until(ExpectedConditions.elementToBeClickable(showcartbtn()));
		Thread.sleep(3000);
		showcartbtn().click();
		List<WebElement> cartElements = driver.findElements(By.xpath("//span[contains(text(),'View and Edit Cart')]"));
		if (!cartElements.isEmpty() && cartElements.get(0).isDisplayed()) {
			jse.jse_scroll(spanele("View and Edit Cart"));
		    spanele("View and Edit Cart").click();

		    // Loop until all items are removed from the cart
		    while (true) {
		        List<WebElement> ele = driver.findElements(By.xpath("//span[contains(text(),'Remove item')]"));
		        if (ele.isEmpty()) {
		            System.out.println("No items left in the cart to remove.");
		            break; // Exit the loop when there are no items left
		        }

		        System.out.println("Total items in cart: " + ele.size());

		        // Remove the first item in the list
		        WebElement itemToRemove = ele.get(0); // Always pick the first item to avoid stale element issues
		        try {
		            wait.until(ExpectedConditions.visibilityOf(itemToRemove));
		            jse.jse_scroll(itemToRemove);
		            jse.jse_click(itemToRemove); // Custom click method
		            System.out.println("Deleted item 1");
		        } catch (StaleElementReferenceException e) {
		            System.out.println("Element became stale. Refetching elements.");
		        }
		    }
		}else {
			driver.findElement(By.id("btn-minicart-close")).click();
		    System.out.println("No items in cart to clear");
		}
		
		
	}
	
    public void selectDropdownOption(WebElement element,String valuetobeSelected) throws Exception {
		
		Select select = new Select(element);
		try {
			
			select.selectByVisibleText(valuetobeSelected);
		} catch (Exception e) {
			throw new Exception("Value to be selected - "+valuetobeSelected +" not found");
		}
		
	}
	
}
