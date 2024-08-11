package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ElementUtils.Elements;

public class SearchresultPage {
	
	 WebDriver driver;
	
	public SearchresultPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public String getResult() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement error = driver.findElement(By.xpath("//p[@class='error-title']"));
		Elements.WaitTillVisible(driver, By.xpath("//p[@class='error-title']"));
		return Elements.GetText(error);
	}
}
