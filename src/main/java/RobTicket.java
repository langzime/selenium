import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.thoughtworks.selenium.Selenium;

import util.Util;


public class RobTicket  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String browser=Util.getProp("browser").trim();
		WebDriver driver=null;
		String bin=Util.getProp("webdriver."+browser+".bin");
		if(bin!=null){
			System.setProperty("webdriver."+browser+".bin",bin);
		}
		if("ie".equals(browser.trim())){
			String driverStr=Util.getProp("webdriver."+browser+".driver");
			System.setProperty("webdriver."+browser+".driver",driverStr);
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setBrowserName("iexplore");
			ieCapabilities.setPlatform(Platform.WINDOWS);
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver=new InternetExplorerDriver(ieCapabilities);
		}else if("chrome".equals(browser.trim())){
			String driverStr=Util.getProp("webdriver."+browser+".driver");
			System.setProperty("webdriver."+browser+".driver",driverStr);
			driver=new ChromeDriver();
		}else if("firefox".equals(browser.trim())){
			driver=new FirefoxDriver();
		}
		driver.get("https://dynamic.12306.cn/otsweb/");
		driver.switchTo().frame("main");
		WebElement elUserName=driver.findElement(By.id("UserName"));
		WebElement elPassword=driver.findElement(By.id("password"));
		String name=Util.getProp("name");
		String pwd=Util.getProp("pwd");
		elUserName.sendKeys(name);
		elPassword.sendKeys(pwd);//
		WebElement denglu=driver.findElement(By.id("subLink"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		denglu.click();
		//((JavascriptExecutor)driver).executeScript("alert(\"你好啊\");");
		Selenium browse1r = null;
		browse1r.getEval("window.alert(\"你好啊\");");
		
		System.out.println(driver.getTitle()+"####\n##"+driver.getPageSource());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle()+"####\n##"+driver.getPageSource());
		driver.switchTo().frame("main");
		WebElement ticket=driver.findElement(By.linkText("车票预定"));
		
		
		ticket.click();
	}

}
