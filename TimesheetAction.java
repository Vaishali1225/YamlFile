package Hris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimesheetAction
{
	WebDriver driver;
void initialiseWebDriver()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaishali.yadav\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
	driver = new ChromeDriver();
}

void LaunchUrl()
{
	driver.navigate().to("https://hris.qainfotech.com/login.php");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[@href='#panel1']//span")).click();
//	click().elememts(Login_Screen);
	
}

By username=By.id("txtUserName");
By pass=By.id("txtPassword");
By loginbtn=By.name("Submit");


public void inputUserName(String uid)
{
	driver.findElement(username).sendKeys(uid);
}
public void inputPassword(String pass2)
{
	driver.findElement(pass).sendKeys(pass2);
}

public void clickOnLoginButton()
{
driver.findElement(loginbtn).click();
}
public void extractWorkHours()
{
	String data= driver.findElement(By.xpath("(//div[@id='dv_2019-07-05']//span[@class='ng-binding'])[1]")).getText();
	System.out.println("Working hours "+data);
	
	}
}
