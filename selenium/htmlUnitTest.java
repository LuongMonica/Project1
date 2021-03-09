import java.io.*;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;	
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Assert;

public class htmlUnitTest {				

	public static void main(String[] args) {

		// silencing CSS errors
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);

		// Creating a new instance of the HTML unit driver
		WebDriver driver = new HtmlUnitDriver(true); //enable JavaScript
				
		// Navigate to local Jekyll site
		driver.get("http://localhost:4000");					
          
		// This code will test and print the page title
		String pageTitle = driver.getTitle();
		Assert.assertNotEquals(pageTitle, "");
		Assert.assertFalse(pageTitle.matches("^\\s*$")); // uses regexp, checks if title contains only spaces
		System.out.println("Page title is: " + pageTitle);

		// This code will check the HTML source for Jekyll 404 errors
		String pageSource = driver.getPageSource();
		Assert.assertFalse(pageSource.contains("404.html")); 
		Assert.assertFalse(pageSource.contains("requested page could not be found")); 

		// Create a test that is specific to YOUR Jekyll site here -->
		// Checks if page title contains Monica
		if (pageTitle.contains("Monica")) {
			//System.out.println("Page title should not contain Monica");
			Assert.assertFalse(pageTitle.contains("Monica"));
		}

		// <-- End of your test code

		driver.quit();			
	}		
}
