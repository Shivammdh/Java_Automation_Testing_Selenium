import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowScroll {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		int sum=0;
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		List<WebElement> value= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i=0;i<value.size();i++)
		{
			System.out.println(Integer.parseInt(value.get(i).getText()));
			int val=Integer.parseInt(value.get(i).getText());
			sum+=val;
			
		}
		System.out.println(sum);

	}

}
