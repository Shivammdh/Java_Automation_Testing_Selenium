import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String[] vName= {"Brocolli - 1 Kg","Cauliflower - 1 Kg","Beetroot - 1 Kg"};
		int j=0;
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Thread.sleep(3000);
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
		{
			String name=products.get(i).getText();
			System.out.println(name);
			List<String> list = Arrays.asList(vName);
			System.out.println(list);
			//Thread.sleep(3000);
			if(list.contains(name))
			{
				j++;
				
				//click on ADD TO CART
				driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
				if(j==3)
				break;
			}
		}
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.tagName("PROCEED TO CHECKOUT")).click();

	}

}
