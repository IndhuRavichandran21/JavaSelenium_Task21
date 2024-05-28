package task21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe_Q1 {
	
		public Iframe_Q1() {
			//set the driver name and path
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
		}
		
		WebDriver driver = new ChromeDriver(); //chrome driver instantiation
		
		public void launchSite() {
			driver.navigate().to("https://the-internet.herokuapp.com/iframe"); //launch url
			driver.switchTo().frame(driver.findElement(By.cssSelector(".tox-edit-area__iframe"))); //switch to iframe
			try {
				WebElement element = driver.findElement(By.cssSelector("#tinymce>p")); //find the p tag
				element.sendKeys("Hello People"); //passing the text to the element
			}
			catch (Exception e) {
				System.out.println(e); //print the exception
			}
			driver.quit(); //quit the driver instance
			}
		
		public static void main(String[] args) {
			Iframe_Q1 obj = new Iframe_Q1(); //object creation
			obj.launchSite(); //method call
		}

}
