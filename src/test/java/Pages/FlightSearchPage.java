package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import ElementUtils.Elements;

public class FlightSearchPage
{
	
	public WebDriver driver;
	public FlightSearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	//CLOSE POP-UP
	public void ClosePopUp() throws Exception
	{
		Thread.sleep(1000);
		WebElement popup = driver.findElement(By.cssSelector("span[data-cy='closeModal']"));
		Elements.WaitTillClickable(driver, popup);
		Elements.Click(driver, popup);
	}

	//CLICK FROM LOCATION
	public void clickfrom() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement clicfrm =  driver.findElement(By.cssSelector("label[for='fromCity']"));
		Elements.WaitTillClickable(driver,clicfrm);
		Elements.Click(driver, clicfrm);
	}
	
	
	//SELECT FROM LOCATION
	public void GetFromlocation(String from) throws InterruptedException
	{
		Elements.WaitTillVisible(driver,By.xpath("//div//li[contains(@id,'react-autowhatever-1-section')][last()]"));
		
		List<WebElement> GetfromList = driver.findElements(By.xpath("//div//li[contains(@id,'react-autowhatever-1-section')]"));
		
		for(WebElement EachGetfromlist :GetfromList )
		{
			String gettext = EachGetfromlist.findElement(By.cssSelector("div[class*='font14']")).getText();
			
			if(gettext.equalsIgnoreCase(from))
			{
				Elements.WaitTillClickable(driver, EachGetfromlist);
				EachGetfromlist.click();
				break;
			}
		}
	}
	
	//CLICK TO LOCATION
	public void clickto() throws InterruptedException
	{
		Elements.WaitTillClickable(driver, driver.findElement( By.cssSelector("label[for='toCity']")));
		Elements.Click(driver, driver.findElement(By.cssSelector("label[for='toCity']")));
	}
	
	//SELECT TO LOCATION
	public void GetToLocation(String to) throws Exception
	{
		Elements.WaitTillVisible(driver,By.xpath("//div//li[contains(@id,'react-autowhatever-1-section')][last()]"));
		
		List<WebElement> GettoList = driver.findElements(By.xpath("//div//li[contains(@id,'react-autowhatever-1-section')]"));
		
		for(WebElement EachGettolist :GettoList )
		{
			String gettext = EachGettolist.findElement(By.cssSelector("div[class*='font14']")).getText();
			
			if(gettext.equalsIgnoreCase(to))
			{
				Elements.WaitTillClickable(driver, EachGettolist);
				Elements.Click(driver, EachGettolist);
				break;
			}
		}
	}
	
	
	//SELECT DEPATURE DATE
	public void selectDepartureDate(String date, String monthAndYear) throws InterruptedException 
	{
	    String monthAbbreviation = monthAndYear.substring(0, 3);
	    By monthCaptionLoc = By.xpath("//div[@class='datePickerContainer']//div[@class='DayPicker-Caption']");
	    WebElement nextMonthButtonLocator = driver.findElement(By.cssSelector("span[aria-label^='Next']"));
	    By dayLocator = By.xpath("//div[contains(@class, 'DayPicker-Day') and contains(@aria-label, '" + monthAbbreviation + "') and contains(@aria-disabled,'false')]");

	    while (true) 
	    {
	        WebElement monthCaption = driver.findElement(monthCaptionLoc);
	        Elements.WaitTillVisible(driver, monthCaptionLoc);
	        String currentMonth = monthCaption.getText();
	        
	        if (currentMonth.equalsIgnoreCase(monthAndYear)) 
	        {
	            List<WebElement> days = driver.findElements(dayLocator);
	            for (WebElement day : days) 
	            {
	                String dayText = day.findElement(By.tagName("p")).getText();
	               
	                if (dayText.equalsIgnoreCase(date)) 
	                {
	                    Elements.WaitTillClickable(driver, day);
	                    Elements.Click(driver, day);
	                    return;
	                }
	            }
	        }
	        else 
	        {
	            Elements.WaitTillClickable(driver, nextMonthButtonLocator);
	            Elements.Click(driver, nextMonthButtonLocator);
	        }
	    }
	}
	
	//SELECTING TRAVELLERS
	
	public void clicktravelsandclass() throws InterruptedException
	{
		WebElement clicktravellers = driver.findElement(By.xpath("//div[@data-cy='flightTraveller']//label[@for='travellers']"));
		Elements.Click(driver, clicktravellers);
	}
	
	//ADULT
	public void GetAdultcount( String getAdultcount) throws InterruptedException
	{
		 List<WebElement> getadult=driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'adults-')]"));
		   
		   for(WebElement EachAdult :getadult )   
		   {
			   String gettext = EachAdult.getText();
			   if(gettext.contains(getAdultcount))
			   {
				   Elements.WaitTillClickable(driver, EachAdult);
				   Elements.Click(driver, EachAdult);
				   break;
			   }
		   }
		   
	}
	
	public void GetChildcount( String getChildcount) throws InterruptedException
	{
		    List<WebElement> getachild =driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'children-')]"));
				   
				   for(WebElement Eachgetachild :getachild )   
				   {
					   String gettext = Eachgetachild.getText();
					   
					   if(gettext.contains(getChildcount))
					   {
						   Elements.WaitTillClickable(driver, Eachgetachild);
						   Elements.Click(driver, Eachgetachild);
						   break;
					   }
				   }
	}
	
	
	public void getInfantcount(String getInfantcount) throws InterruptedException
	{
		   List<WebElement> getainftant =driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'infants-')]"));
			   
			   for(WebElement Eachgetgetainftant :getainftant )   
			   {
				   String gettext = Eachgetgetainftant.getText();
				   
				   if(gettext.contains(getInfantcount))
				   {
					   Elements.WaitTillClickable(driver, Eachgetgetainftant);
					   Elements.Click(driver, Eachgetgetainftant);
					   break;
				   }
			   }
			   
	}
	
	
	public void SelectTravelClass(String TravelClass) throws InterruptedException
	{
		Elements.WaitTillClickable(driver, driver.findElement(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'travelClass-')][last()]")));
		List<WebElement> classlist =driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'travelClass-')]"));
		
		for(WebElement Eachclass : classlist)
		{
			String text = Eachclass.getText();
			if(text.equalsIgnoreCase(TravelClass))
			{
				Elements.WaitTillClickable(driver, Eachclass);
				Elements.Click(driver, Eachclass);
				break;
			}
		}
	}
	
	public void TravellersAndClassApply() throws InterruptedException
	{
		Elements.WaitTillClickable(driver,  driver.findElement(By.cssSelector("button[data-cy='travellerApplyBtn']")));
		Elements.Click(driver, driver.findElement(By.cssSelector("button[data-cy='travellerApplyBtn']")));
	}
	
	
	public void SelectFareType(String faretype ) throws InterruptedException
	{
		
		List<WebElement> Fare =driver.findElements(By.xpath("//div[@class='fareCardItem ']"));
		
		for(WebElement eachfare : Fare)
		{
			String gettext = eachfare.findElement(By.cssSelector("div.appendBottom3")).getText();
			if(gettext.equalsIgnoreCase(faretype))
			{
				Elements.WaitTillClickable(driver, eachfare);
				Elements.Click(driver, eachfare);
				break;
			}
		}	
	}
	
	public void ClickSearch() throws InterruptedException
	{
		Thread.sleep(2000);
		Elements.WaitTillClickable(driver,driver.findElement(By.cssSelector("a[class*='widgetSearchBtn']")));
		Elements.Click(driver,driver.findElement(By.cssSelector("a[class*='widgetSearchBtn']")));
	}
	
}
