import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	@Test
	   public void loginTest() {
	      WebDriverManager.chromedriver().setup();
	      WebDriver driver = new ChromeDriver();
	 
	       driver.get("https://the-internet.herokuapp.com/login");
	 
	      driver.findElement(By.id("username")).sendKeys("tomsmith");
	      driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	      driver.findElement(By.cssSelector("button[type='submit']")).click();
	 
	      String message = driver.findElement(By.id("flash")).getText();
	      if(message.contains("You logged into a secure area!")){
	    	  
	    	  System.out.println("Test case passed");
	    	   
	    	  }
	    	   
	    	  else
	    	   
	    	  {
	    	   
	    	  System.out.println("Test case failed");
	    	   
	    	  }
	    	   
	      Assert.assertTrue(message.contains("You logged into a secure area!"));
	 
	      driver.quit();
	   }
}
