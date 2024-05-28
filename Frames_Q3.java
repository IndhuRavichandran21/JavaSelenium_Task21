package task21;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Frames_Q3 {

		public Frames_Q3() {
			//set the driver name and path
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Indhu_ZenClass\\JavaPrograms\\eclipse-workspace\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
		}
		
		WebDriver driver = new ChromeDriver(); //chrome driver instantiation
		
		public void launchSite() {
			driver.navigate().to("http://the-internet.herokuapp.com/nested_frames"); //launch url
			
            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']"))); //switch to top frame
            
            //get the no.of frames and verify whether 3 frames available
			List<WebElement> frameElement = driver.findElements(By.cssSelector("frameset[name='frameset-middle']>frame"));
			if(frameElement.size()==3) {
				System.out.println("There are 3 frames in the top frame");
			}
			else
				System.out.println("Expected no.of frames not present in the top frame");
			
			WebElement leftFrame = driver.findElement(By.cssSelector("frame[name='frame-left']"));			
		    driver.switchTo().frame(leftFrame); //switch to left frame and print the text	    
		    WebElement leftFrameText = driver.findElement(By.xpath("//body"));		
		    if((leftFrameText.getText()).equals("LEFT")) {
		    	System.out.println("The left frame has the text LEFT");
		    }
		    
		    else 
		    	System.out.println("The left frame does not has the text LEFT");
			
		   
		    topFrameSwitch(); //switch to top frame
		    
		    WebElement middleFrame = driver.findElement(By.cssSelector("frame[name='frame-middle']"));			
		    driver.switchTo().frame(middleFrame); //switch to middle frame and print the text
		    WebElement middleFrameText = driver.findElement(By.xpath("//body"));		
		    if(middleFrameText.getText().equals("MIDDLE")) {
		    	System.out.println("The middle frame has the text MIDDLE");
		    }
		    
		    else 
		    	System.out.println("The middle frame does not has the text MIDDLE");
		    
		   
		    topFrameSwitch(); //switch to top frame
		    
		    WebElement rightFrame = driver.findElement(By.cssSelector("frame[name='frame-right']"));			
		    driver.switchTo().frame(rightFrame); //switch to the right frame and print the text
		    WebElement rightFrameText = driver.findElement(By.xpath("//body"));	
		    if(rightFrameText.getText().equals("RIGHT")) {
		    	System.out.println("The right frame has the text RIGHT");
		    }
		    
		    else 
		    	System.out.println("The right frame does not has the text RIGHT");
		    
		    topFrameSwitch(); //switch to top frame
		    
		    driver.switchTo().defaultContent();
		   
		    WebElement bottomFrame = driver.findElement(By.cssSelector("frame[name='frame-bottom']"));			
		    driver.switchTo().frame(bottomFrame); //switch to bottom frame and print the text
		    WebElement bottomFrameText = driver.findElement(By.xpath("//body"));	
		    if(bottomFrameText.getText().equals("BOTTOM")) {
		    	System.out.println("The bottom frame has the text BOTTOM");
		    }
		    
		    else 
		    	System.out.println("The bottom frame does not has the text BOTTOM");
			
		    topFrameSwitch(); //switch to top frame
		    
		    String title = driver.getTitle(); //get the page title
		    System.out.println("The page title is "+title); // returns a null value since title tag is not present
		    
		    if(title.contains("frames"))
		    	System.out.println("The page title contains frames ");
		    else 
		    	System.out.println("The page title does not contains frames "); //returns false since title tag is not present in DOM
		}
		
		public void topFrameSwitch() {
			driver.switchTo().defaultContent();
		
			driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']"))); //switch to the top frame
		}
		
		
		public static void main(String[] args) {
			Frames_Q3 obj = new Frames_Q3(); //obj creation
			obj.launchSite(); //method call
		}

}
