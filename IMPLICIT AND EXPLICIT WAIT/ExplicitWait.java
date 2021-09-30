import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//here we declear implicit wait in globally
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String[] itemNeeded= {"Brocolli","Cauliflower","Beetroot"};
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Thread.sleep(3000);
		addItems(driver,itemNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		/*hence following driver could't send keys "rahulshettyacademy" in  defined element because hence page takes 
		some wait for executing this element, so to solve this problem or achive this things in proper way we should 
		use the concept of implicit Wait, Which is decleared in above line number 16*/ 

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		WebDriverWait w=new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		WebElement dropdownval=driver.findElement(By.cssSelector("select[style='width: 200px;']"));
		Select Dropdown=new Select(dropdownval);
		Dropdown.selectByVisibleText("India");
		driver.findElement(By.cssSelector("input[class='chkAgree']")).click();


	}

	public static void addItems(WebDriver driver,String[] itemNeeded)
	{
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
		{
			String[] name=products.get(i).getText().split("-");
			String formatedName=name[0].trim();
			List itemNeededList=Arrays.asList(itemNeeded);
			//Thread.sleep(3000);
			if(itemNeededList.contains(formatedName))
			{
				j++;
				
				//click on ADD TO CART
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemNeeded.length)
				break;
			}
		}




	}

}
