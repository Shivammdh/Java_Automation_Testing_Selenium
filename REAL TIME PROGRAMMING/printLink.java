import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class printLink {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//print the number of total link in this page
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
		//print total number of all the footer link 
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		WebElement coloumdriver=footerdriver.findElement(By.xpath("//table//tbody//tr//td[1]/ul"));
		//print total number of link in footer first coloum 
		System.out.println(coloumdriver.findElements(By.tagName("a")).size());
		coloumdriver.findElements(By.tagName("a")).size();
		for(int i=1;i<coloumdriver.findElements(By.tagName("a")).size();i++)
		{
			
			String cntlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			coloumdriver.findElements(By.tagName("a")).get(i).sendKeys(cntlinkTab);
			Thread.sleep(5000L);
		}
			Set<String> abc=driver.getWindowHandles();
			Iterator<String> it=abc.iterator();
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
				
			}
			
		
		

	}

}
