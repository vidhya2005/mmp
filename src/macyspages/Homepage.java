package macyspages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	public class Homepage{
				WebDriver driver;
	
			public Homepage(WebDriver driver) {
				this.driver=driver;
			}
			public void searchItem(String itemName){
				System.out.println("");
				driver.findElement(By.id("globalSearchInputField")).sendKeys(itemName);
				driver.findElement(By.id("subnavSearchSubmit")).click();
				
				
			}
				
			
		}

