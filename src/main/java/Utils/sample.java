package Utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sample {
	
	public void samplemethod() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("span[data-cy='closeModal']"))));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span[data-cy='closeModal']")).click();	
		
		//from
		  Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("label[for='fromCity']")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//li[contains(@id,'react-autowhatever-1-section')][last()]")));
		
		List <WebElement>getfromlist= driver.findElements(By.xpath("//div//li[contains(@id,'react-autowhatever-1-section')]"));
		
	   for(WebElement eachgetfromlist: getfromlist )
	   {
		   String Text = eachgetfromlist.findElement(By.cssSelector("div[class*='font14']")).getText();
		   if(Text.equalsIgnoreCase("PNQ"))
		   {
			   eachgetfromlist.click();
			   break;
		   }
	   }
	 
	   
	   //to 
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("label[for='toCity']")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//li[contains(@id,'react-autowhatever-1-section')][last()]")));
		
		List <WebElement>Getto= driver.findElements(By.xpath("//div//li[contains(@id,'react-autowhatever-1-section')]"));
		
	   for(WebElement eachGetto: Getto )
	   {
		   String Text = eachGetto.findElement(By.cssSelector("div[class*='font14']")).getText();
		   if(Text.equalsIgnoreCase("MAA"))
		   {
			   eachGetto.click();
			   break;
		   }
	   }
	   
	//depature date
	   List<WebElement>getMonths= driver.findElements(By.xpath("//div[@class='datePickerContainer']//div[@class='DayPicker-Months']//div[@class='DayPicker-Month']"));
	   
	   for(WebElement Eachmonth : getMonths)
	   {
		   String monthtext = Eachmonth.findElement(By.className("DayPicker-Caption")).getText();
		   //System.out.println(monthtext);
		   
		   if(monthtext.equalsIgnoreCase("September 2024"))
		   {
			   List<WebElement>getdate = driver.findElements(By.xpath("//div[contains(@class, 'DayPicker-Day') and contains(@aria-label, 'Sep') and contains(@aria-disabled,'false')]"));
		   
			   for(WebElement eachgetdate: getdate )
			   {
				   String getdatetext =eachgetdate.findElement(By.tagName("p")).getText();
				   //System.out.println(getdatetext);
				   
				   if(getdatetext.equalsIgnoreCase("11"))
				   {
					   eachgetdate.click();
					   break;
				   }
			   }
		   }
	   }
	    
	   //travellers
	   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("label[for='travellers']")))).click();
	 //  int Age=15;
	   int Adcount =2;
	   List<WebElement> getadult=driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'adults-')]"));
		   
		   for(WebElement EachAdult :getadult )   
		   {
			   String gettext = EachAdult.getText();
			   int getad = Integer.parseInt(gettext);
			   if(getad==(Adcount))
			   {
				   EachAdult.click();
				   break;
			   }
		   }
	
	
	int childcount = 3 ;
	int childage=5;
	//getChild and Infant
	
	if(childage>2)
	{
		   List<WebElement> getachild =driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'children-')]"));
		   
		   for(WebElement Eachgetachild :getachild )   
		   {
			   String gettext = Eachgetachild.getText();
			   int getnum = Integer.parseInt(gettext);
			   
			   if(getnum==childcount)
			   {
				   Eachgetachild.click();
				   break;
			   }
		   }
		   
	}
	
	if(childage<2)
	{
		List<WebElement> getainftant =driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'infants-')]"));
		   
		   for(WebElement Eachgetgetainftant :getainftant )   
		   {
			   String gettext = Eachgetgetainftant.getText();
			   int getnum = Integer.parseInt(gettext);
			   
			   if(getnum==childcount)
			   {
				   Eachgetgetainftant.click();
				   break;
			   }
		   }
	}
	
	//Selecting class
	
	String getClass= "Premium Economy";
	List<WebElement> Tclass =driver.findElements(By.xpath("//div[@class='appendBottom20']//li[contains(@data-cy,'travelClass-')]"));
	
	for(WebElement EachTclass : Tclass)
	{
		String text = EachTclass.getText();
		if(text.equalsIgnoreCase(getClass))
		{
			EachTclass.click();
			break;
		}
	}
	
	driver.findElement(By.cssSelector("button[data-cy='travellerApplyBtn']")).click();
	
	//Select Fare type
	String faretype="Reagular";
	List<WebElement> Fare =driver.findElements(By.xpath("//div[@class='fareCardItem ']"));
	
	for(WebElement eachfare : Fare)
	{
		String gettext = eachfare.findElement(By.xpath("//div[contains(@class,'appendBottom3')]")).getText();
		if(gettext.equalsIgnoreCase(faretype))
		{
			eachfare.click();
			break;
		}
	}
	
	 driver.findElement(By.xpath("//p//a[contains(@class,'widgetSearchBtn')]")).click();
	}
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		sample s = new sample();
		s.samplemethod();
	}

}
