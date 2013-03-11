import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;

import util.Util;

public class  SimpleExample {

	
	public static void main(String[] args) {
		String browser=Util.getProp("browser").trim();
		WebDriver driver=null;
		String bin=Util.getProp("webdriver."+browser+".bin");
		if(bin!=null){
			System.setProperty("webdriver."+browser+".bin",bin);
		}
		driver = new FirefoxDriver();
		((Selenium)driver).getEval("");
	      //((JavascriptExecutor)driver).executeScript("alert(\"hello,this is a alert!\")");
	}

}