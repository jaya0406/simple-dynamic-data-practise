package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ElementUtils.Elements;

public class SearchresultPage {
	
	 WebDriver driver;
	
	public SearchresultPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public String getResult()
	{
		return Elements.GetText(driver.findElement(By.xpath("//p[@class='error-title']")));
	}
}
