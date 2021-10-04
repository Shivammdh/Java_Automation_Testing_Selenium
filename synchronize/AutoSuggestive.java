import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //URL in the browser
		WebElement source=driver.findElement(By.id("autosuggest"));
		//source.clear();
		source.sendKeys("India");
		Thread.sleep(2000);
		source.sendKeys(Keys.ENTER);
		
//		WebElement destination=driver.findElement(By.id("hp-widget__sTo"));
//		destination.clear();
//		destination.sendKeys("DEL");
//		Thread.sleep(2000);
//		destination.sendKeys(Keys.ARROW_DOWN);
//		destination.sendKeys(Keys.ENTER);
		
		
		
		
		
		
	
		
	}

}
