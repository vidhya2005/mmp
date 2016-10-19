package macyspages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultspage {
	WebDriver driver;
	public static int count;
	public SearchResultspage(WebDriver driver)
	{
		this.driver = driver;
	}

	public boolean verifyTitle(String expected)
	{
		String actual = driver.getTitle();
		return actual.contains(expected);
	}
	/**
	 * 
	 * 
	 * @param itemsCount
	 * @param loopCount
	 * @return
	 * @throws InterruptedException
	 */
	public int assertAndDisplay(int itemsCount,int loopCount) throws InterruptedException
	{
		int temp = loopCount;
		count =0;
		while(loopCount>0)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='thumbnails']/li/div[1]/div[2]")));
			List<WebElement> links = null;
			links = driver.findElements(By.xpath("//*[@id='thumbnails']/li/div[1]/div[2]"));
			System.out.println("links size" + links);
			if(links.size() == (itemsCount/temp))
			{

				System.out.println("Total result count is 60");
				for (int i = 0; i<links.size(); i++)
				{
					wait.until(ExpectedConditions.elementToBeClickable(links.get(i)));
					//System.out.println(links.get(i).getText());
					//Verifying the Search Item Jeans in the Description of the Item displayed
					if(itemsInDescription(links.get(i).getText()) == true)
					{
						count++;
					}
				}
				System.out.println("Total result with Jeans in it is "+ count);
			}
			System.out.println("Clicking on Nextb utton");
			for(int i=0;i<=2;i++)
			{
				try
				{
					driver.findElement(By.xpath(".//*[@id='paginateTop']/a[7]")).click();
					break;
				}
				catch(Exception e)
				{
						System.out.println(e.getMessage());
				}
			}
			 
			loopCount--;
		}
		return count;


	}
	public boolean itemsInDescription(String description)
	{
		if(description.contains("Jeans"))
			return true;
		else
			return false;
	}


}


/*
 * //int count =2;

		List<WebElement> links = null;
		for(int i=0;i<=2;i++)
		{
			try
			{
				links = driver.findElements(By.xpath("//*[@id='thumbnails']/li/div[1]/div[2]"));
				break;
			}
			catch(StaleElementReferenceException e)
			{

			}
		}
 */


/*import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultspage {
	WebDriver driver;
	static int count;
	
	
public SearchResultspage(WebDriver driver){
	this.driver= driver;
}

public boolean verifyTitle(String expected){
	String actual = driver.getTitle();
	System.out.println(actual);
	System.out.println(expected);
	return actual.contains(expected);
}	


//____________________________________________________________________________________________________________________
	public int assertAndDisplay(int itemsCount,int loopCount) throws InterruptedException	{
		
		{
		while(loopCount>0){
			WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='thumbnails']/li/div[1]/div[2]")));
	List<WebElement> links = null;	
links = driver.findElements(By.xpath("//*[@id='thumbnails']/li/div[1]/div[2]"));
System.out.println("sizeoflink"+links.size());
	
	
	if(links.size() == (itemsCount/loopCount))
	{
		//System.out.println("Total result count of 1 set of item in this page is 60");
		//count =
		for(int i =0;i<links.size();i++){
			wait.until(ExpectedConditions.elementToBeClickable(links.get(i)));
			if(itemsInDescription(links.get(i).getText()) == true)
			{
				count=count+1;
				
								  
			}
		}
		
	                     }
	
		                                                                   
				System.out.println("Clicking on Nextbutton");
	for(int i=0;i<=2;i++)
	{
	try{
		
		driver.findElement(By.xpath(".//*[@id='paginateTop']/a[7]")).click();
		break;
	}
	
		catch(Exception e)
	{
	
		System.out.println(e.getMessage());
		
	}
		}
	loopCount--;
	

	
		}
		
	
	
	return count;
		}
		
		}
		
		
		
		
	
	
	public boolean itemsInDescription(String description){
		
		if(description.contains("Jeans"))
			return true;
	else
		return false;
	}	

	}
}
*/