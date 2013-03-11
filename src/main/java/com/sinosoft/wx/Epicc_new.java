package com.sinosoft.wx;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverCommandProcessor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

import util.Util;

public class Epicc_new {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String browser = Util.getProp("browser").trim();
		WebDriver driver = null;
		String baseUrl="http://www.epicc.com.cn/piccallweb/";
		String bin = Util.getProp("webdriver." + browser + ".bin");
		if (bin != null) {
			System.setProperty("webdriver." + browser + ".bin", bin);
		}
		if ("ie".equals(browser.trim())) {
			String driverStr = Util.getProp("webdriver." + browser + ".driver");
			System.setProperty("webdriver." + browser + ".driver", driverStr);
			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities.setBrowserName("iexplore");
			ieCapabilities.setPlatform(Platform.WINDOWS);
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			driver = new InternetExplorerDriver(ieCapabilities);
		} else if ("chrome".equals(browser.trim())) {
			String driverStr = Util.getProp("webdriver." + browser + ".driver");
			System.setProperty("webdriver." + browser + ".driver", driverStr);
			driver = new ChromeDriver();
		} else if ("firefox".equals(browser.trim())) {
			driver = new FirefoxDriver();
		}
		WebDriverCommandProcessor commandProcessor=new WebDriverCommandProcessor(baseUrl, driver);
		Selenium selenium = new DefaultSelenium(commandProcessor);
		selenium.open(baseUrl);
	}

}
