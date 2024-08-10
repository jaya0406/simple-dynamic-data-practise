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
		PageFactory.initElements(this.driver, driver);
	}
	
	
	public void ClosePopUp() throws Exception
	{
		//Elements.WaitTillClickable(driver,driver.findElement(By.cssSelector("span[data-cy='closeModal']")));
		Elements.Click(driver, driver.findElement(By.cssSelector("span[data-cy='closeModal']")));
	}
	

	public void clickfrom() throws InterruptedException
	{
		Elements.WaitTillClickable(driver,driver.findElement(By.cssSelector("label[for='fromCity']")));
		Elements.Click(driver, driver.findElement(By.cssSelector("label[for='fromCity']")));
	}
	
	public void GetFromlocation(String from) throws InterruptedException
	{
		Elements.WaitTillClickable(driver,driver.findElement(By.xpath("//div//li[contains(@id,'react-autowhatever-1-section')][last()]")));
		
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

	public void clickto() throws InterruptedException
	{
		Elements.WaitTillClickable(driver, driver.findElement( By.cssSelector("label[for='toCity']")));
		Elements.Click(driver, driver.findElement(By.cssSelector("label[for='toCity']")));
	}
	
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
	
	
	public void SelectDepaturedate(String date, String monthAndyr  ) throws InterruptedException
	{
		List<WebElement>getMonths= driver.findElements(By.xpath("//div[@class='DayPicker-Months']//div[@class='DayPicker-Month']"));
		   
		   for(WebElement Eachmonth : getMonths)
		   {
			   String monthtext = Eachmonth.findElement(By.className("DayPicker-Caption")).getText();
			   
			   if(monthtext.equalsIgnoreCase(monthAndyr))
			   {
				   List<WebElement>getdate = driver.findElements(By.xpath("//div[contains(@class, 'DayPicker-Day') and contains(@aria-label, 'Sep') and contains(@aria-disabled,'false')]"));
			   
				   for(WebElement eachgetdate: getdate )
				   {
					   String getdatetext =eachgetdate.findElement(By.tagName("p")).getText();
					   //System.out.println(getdatetext);
					   
					   if(getdatetext.equalsIgnoreCase(date))
					   {
						   Elements.WaitTillClickable(driver, eachgetdate);
						   Elements.Click(driver, eachgetdate);
						   break;
					   }
				   }
			   }
		   }
	}
	
	
	
	public void getTravellers( int getAdultcount , int getChildAge  , int getChildcount , int getinftantage , int getInfantcount) throws InterruptedException
	{
		Elements.WaitTillVisible(driver,By.cssSelector("label[for='travellers']"));
		
		Elements.Click(driver, driver.findElement(By.cssSelector("label[for='travellers']")));
		
		
		//To Select Adult Travelers
		 List<WebElement> getadult=driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'adults-')]"));
		   
		   for(WebElement EachAdult :getadult )   
		   {
			   int Getadult = Integer.parseInt(EachAdult.getText());
			   if(Getadult==(getAdultcount))
			   {
				   Elements.WaitTillClickable(driver, EachAdult);
				   Elements.Click(driver, EachAdult);
				   break;
			   }
		   }
		   
		   //To Select Child and Infants
		   if(getChildAge>2)
			{
				   List<WebElement> getachild =driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'children-')]"));
				   
				   for(WebElement Eachgetachild :getachild )   
				   {
					   String gettext = Eachgetachild.getText();
					   int getnum = Integer.parseInt(gettext);
					   
					   if(getnum==getChildcount)
					   {
						   Elements.WaitTillClickable(driver, Eachgetachild);
						   Elements.Click(driver, Eachgetachild);
						   break;
					   }
				   }
				   
			}
			
		   else
			{
				System.out.println("Please select under INFANTS if AGE is less than 2yrs.");
			}
		   
		   
		   if(getinftantage<2)
		   {
			   List<WebElement> getainftant =driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'infants-')]"));
			   
			   for(WebElement Eachgetgetainftant :getainftant )   
			   {
				   String gettext = Eachgetgetainftant.getText();
				   int getnum = Integer.parseInt(gettext);
				   
				   if(getnum==getInfantcount)
				   {
					   Elements.WaitTillClickable(driver, Eachgetgetainftant);
					   Elements.Click(driver, Eachgetgetainftant);
					   break;
				   }
			   }
			   
		   }
	}
	
	public void SelectTravelClass(String TravelClass) throws InterruptedException
	{
		Elements.WaitTillVisible(driver, By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'travelClass-')][last()]"));
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
			String gettext = eachfare.findElement(By.xpath("//div[contains(@class,'appendBottom3')]")).getText();
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
