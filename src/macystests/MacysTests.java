package macystests;
import jxl.read.biff.BiffException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import macyspages.Homepage;
import macyspages.SearchResultspage;
import macysutil.Utility;

public class MacysTests{
		public static WebDriver driver;
		Homepage hPage;
		SearchResultspage sPage;
		@BeforeClass
		public void driverSetUp()
		{		 
			driver = new FirefoxDriver();		 

		}

		@DataProvider(name="DP")
		public String[][] feedDP() throws BiffException, IOException
		{
			String input[][] = Utility.readExcel("InputData.xls");
			return input;
		}

		@Test(dataProvider="DP")
		public void verifySearchResultsPageTitle(String itemName,String itemCount) throws NumberFormatException, InterruptedException
		{	
			System.out.println("###############SearchResultsPageTitleof#############    "+itemName);
			driver.get("http://www1.macys.com/");

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			/*try{
				Utility.isAlertPresent(driver);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}*/

			SoftAssert sa = new SoftAssert();
			//Creating an object and pass the parameter driver invokes the constructor
			hPage = new Homepage(driver);
			hPage.searchItem(itemName);
			sPage = new SearchResultspage(driver);
			boolean result = sPage.verifyTitle(itemName);
	        System.out.println("****************Asserting the verify Title method    **********");	
			sa.assertTrue(result);

			int actual = sPage.assertAndDisplay(Integer.parseInt(itemCount),4);
			System.out.println("*************Asserting the assertAndDisplay method*************");			
			sa.assertEquals(actual, itemCount);		
System.out.println("******Asserting All methods******");
			sa.assertAll();
		}
	
}

	
	
	

