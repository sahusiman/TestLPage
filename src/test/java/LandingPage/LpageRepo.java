package LandingPage;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LpageRepo {

public WebDriver driver;
 
@Test

public void LandingPgBrowserOpen() throws InterruptedException
  {
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Simanxhal\\Desktop\\selenium Jars\\geckodriver.exe");
    FirefoxOptions options = new FirefoxOptions();
    options.setCapability("marionette", false);
    driver=new FirefoxDriver(options);
    driver.manage().window().maximize();
    driver.get("https://vodafone.sharepoint.com/");
    Set<String> ids=driver.getWindowHandles();
    Iterator<String> it=ids.iterator();
    String parentid=it.next();
    while(it.hasNext())
    {
     
        String childid=it.next();
    if(parentid.equals(childid))
    {
    driver.switchTo().window(childid);
     
    }
     
    }
    
    driver.findElement(By.xpath(".//*[@id='i0116']")).sendKeys("simanchal.sahu@vodafone.com");
    driver.findElement(By.xpath(".//*[@id='idSIButton9']")).click();  
    Thread.sleep(50000);
    driver.findElement(By.xpath(".//*[@id='passwordInput']")).sendKeys("Vodass@63");
    driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
    driver.findElement(By.xpath(".//*[@id='continueButton']")).click();
    Set<String> ids1=driver.getWindowHandles();
    Iterator<String> it1=ids1.iterator();
    String parentid1=it1.next();
    while(it1.hasNext())
    {
     
    String childid1=it1.next();
    if(parentid1.equals(childid1))
    {
    driver.switchTo().window(childid1); 
    }  
    }
    WebDriverWait wait = new WebDriverWait(driver, 30000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='idSIButton9']")));
    driver.findElement(By.xpath(".//*[@id='idSIButton9']")).click();
    WebDriverWait wait1 = new WebDriverWait(driver, 30000);
    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='bookMarkHome']/div/div/div[2]")));
    //driver.findElement(By.xpath(".//*[@id='obtopics']/ul/li[4]/p")).click();
    driver.findElement(By.xpath(".//*[@id='bookMarkHome']/div/div/div[2]")).click();
    System.out.println("Acronym App Opened");
    
  }
    @Test(dependsOnMethods = { "LandingPgBrowserOpen" })
    
    public void LandingPgAcronymclick() throws InterruptedException
    {
    
    	Set<String> ids2=driver.getWindowHandles();
        Iterator<String> it2=ids2.iterator();
        String parentid2=it2.next();
        while(it2.hasNext())
        {
        String childid2=it2.next();
      
		if(parentid2.equals(childid2))
        {
        driver.switchTo().window(childid2); 
        }  
        }
        WebDriverWait wait2 = new WebDriverWait(driver,500);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='detail-pane-content']/acro-bot-poc-detail-pane/div[1]/div[3]/input[1]")));
   	 JavascriptExecutor jse = (JavascriptExecutor) driver;
   	 driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
   	//Declare and set the start time		
        long start_time = System.currentTimeMillis();	
        //Call executeAsyncScript() method to wait for 5 seconds
        jse.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
   	 driver.findElement(By.xpath(".//*[@id='detail-pane-content']/acro-bot-poc-detail-pane/div[1]/div[3]/input[1]")).sendKeys("SDLC");
   	 driver.findElement(By.xpath(".//*[@id='detail-pane-content']/acro-bot-poc-detail-pane/div[1]/div[3]/input[2]")).click();
   	 //driver.findElement(By.xpath(".//*[@id='detail-pane-content']/acro-bot-poc-detail-pane/div[1]/div[1]/div[2]/div/a[2]")).click();
	}
    
    
    @Test(dependsOnMethods = { "LandingPgAcronymclick" })
    public void LandingPgComp() throws InterruptedException
    {
    	//Thread.sleep(30000);
    	WebElement S = driver.findElement(By.xpath(".//*[@id='detail-pane-content']/acro-bot-poc-detail-pane/div[1]/div[2]/div/span[1]"));;
    	//WebElement Y=driver.findElement(By.xpath(".//*[@id='detail-pane-content']/acro-bot-poc-detail-pane/div[1]/div[2]/div/span[5]")); 
    	String A=S.getText();
    	//String B=Y.getText();
    	//A=B;
    	Assert.assertEquals("Google Search",A);
    }
    
    @Test(dependsOnMethods = { "LandingPgAcronymclick" })
    public void LandingPgInvent()
    {
    	 driver.findElement(By.xpath(".//*[@id='detail-pane-content']/acro-bot-poc-detail-pane/div[1]/div[3]/input[1]")).clear();
    	 driver.findElement(By.xpath(".//*[@id='detail-pane-content']/acro-bot-poc-detail-pane/div[1]/div[3]/input[1]")).click();
    	 Assert.fail("Failed");
    }
    @Test(dependsOnMethods = {"LandingPgComp"})
    public void LandingPgInventdummy()
    {
    	 driver.findElement(By.xpath(".//*[@id='detail-pane-content']/acro-bot-poc-detail-pane/div[1]/div[3]/input[1]")).clear();
    	 driver.findElement(By.xpath(".//*[@id='detail-pane-content']/acro-bot-poc-detail-pane/div[1]/div[3]/input[1]")).click();
    }
}



