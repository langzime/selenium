import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.Util;


public class test {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 * @throws URISyntaxException 
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
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
		driver.get("http://11.201.0.40:7008/attendance/");
		WebElement elUserName=driver.findElement(By.name("UserCode"));
		WebElement elPassword=driver.findElement(By.name("PassWord"));
		String name=Util.getProp("name");
		String pwd=Util.getProp("pwd");
		elUserName.sendKeys(name);
		elPassword.sendKeys(pwd);
		WebElement elImageField=driver.findElement(By.name("imageField"));
		elImageField.click();
		driver.getTitle();//没有生效
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("BoardTitle");
		WebElement elKaoqin=driver.findElement(By.linkText("考勤"));
		elKaoqin.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("frainner");
		WebElement elOnDuty=driver.findElement(By.name("OnDuty"));
		elOnDuty.click();
		WebElement elOffDuty=driver.findElement(By.name("OffDuty"));
		elOffDuty.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	

}
