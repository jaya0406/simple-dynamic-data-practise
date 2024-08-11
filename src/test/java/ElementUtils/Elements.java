package ElementUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements
{
	
	public static void Click(WebDriver driver, WebElement Element) throws InterruptedException
	{
		if(Element.isDisplayed())
		{
			Element.click();
		}
	}
	

	public static String GetText(WebElement Element)
	{
		if(Element != null && Element.isDisplayed())
		{
			return Element.getText();
		}
		return "";
	}

	public static void SentKeys(WebElement Element,String gettext)
	{
		if(Element.isDisplayed())
		{
			Element.sendKeys(gettext);
		}
	}

	public static void GetAttribute(WebElement Element,String attribute)
	{
		if(Element.isDisplayed())
		{
			Element.getAttribute(attribute);
		}
	}
	

	public static void WaitTillClickable(WebDriver driver, WebElement Elements)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.elementToBeClickable(Elements));
	}
	
	public static void WaitTillVisible(WebDriver driver, By Element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	}
	
	
	public static String GetScreenshot(WebDriver driver, String FileName) throws IOException
	{
		TakesScreenshot ss =  (TakesScreenshot)driver;
		File Source = ss.getScreenshotAs(OutputType.FILE);
		File Destination = new File (System.getProperty("user.dir")+"//Screenshot//"+FileName+"test.png");
		FileUtils.copyFile(Source, Destination);
		return Destination.toString();
	}
}
