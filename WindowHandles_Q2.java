package task21;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles_Q2 {
	public WindowHandles_Q2() {
		//set the driver name and path
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
	}
	
	WebDriver driver = new ChromeDriver(); //chrome driver instantiation
	
	public void launchSite() {
		driver.navigate().to("https://the-internet.herokuapp.com/windows"); //launch url
		driver.findElement(By.linkText("Click Here")).click(); //click the link
		
		String parentWindow = driver.getWindowHandle(); //get the address of the parent window
		Set<String> childWindows = driver.getWindowHandles(); //get the address of all the windows
		
		for (String childWindow : childWindows) {
			if(!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow); //switch to child window
				String text = driver.findElement(By.tagName("h3")).getText(); 
				if(text.equalsIgnoreCase("New Window")) //verify the text is present
				{
					System.out.println("The text 'New Window' is present in child window"); 
				}
			}					
		}
		
		driver.close(); //close the current window
		
		driver.switchTo().window(parentWindow); //switch to parent window and get the title to check it is active
		System.out.println("The original window is active and it's title is : "+driver.getTitle());
		driver.quit(); //close the browser instance
		
	}

	public static void main(String[] args) {
		WindowHandles_Q2 obj = new WindowHandles_Q2(); //obj creation
		obj.launchSite(); //method call

	}

}
