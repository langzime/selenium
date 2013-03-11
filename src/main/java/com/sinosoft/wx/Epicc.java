package com.sinosoft.wx;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Util;

public class Epicc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String browser = Util.getProp("browser").trim();
		String baseUrl="http://11.201.1.79:7009/piccallweb/";
		WebDriver driver = null;
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
		driver.get(baseUrl);
		driver.findElement(By.id("city_input")).click();
		driver.findElement(By.linkText("郑州")).click();
		driver.findElement(By.xpath("//input[@value='立即报价']")).click();
		System.out.println("新页面打开le 。。。。");
		String winHandleBefore = driver.getWindowHandle();
		// 切换到新窗口
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println("+++" + winHandle);
			driver.switchTo().window(winHandle);
		}
		// 关闭原理的窗口
		driver.switchTo().window(winHandleBefore);
		driver.close();
		// 切换到新窗口
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println("+++" + winHandle);
			driver.switchTo().window(winHandle);
		}
		System.out.println("等待车辆信息页面加载。。。。");
		(new WebDriverWait(driver, 100)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver dr) {
				String flag=(String) ((JavascriptExecutor)dr).executeScript("if($('#step1-1').is(':visible')) return \"true\"; else return \"false\";");
				if("true".equals(flag)){
					return true;
				}else{
					return false;
				}
        	}
		});
		driver.findElement(By.id("isNewCar_check")).click();
		driver.findElement(By.id("CarOwner")).clear();
		driver.findElement(By.id("CarOwner")).sendKeys(Util.getRandomString(8, true, false));
		driver.findElement(By.id("AppliMobile")).clear();
		driver.findElement(By.id("AppliMobile")).sendKeys("135"+Util.getRandomString(8, false, true));
		driver.findElement(By.id("AppliEmail")).clear();
		driver.findElement(By.id("AppliEmail")).sendKeys(Util.getRandomEmail());
		driver.findElement(By.id("itemCarInput_1_next_btn")).click();
		System.out.println("等待车型信息页面加载。。。。");
		(new WebDriverWait(driver, 100)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver dr) {
				String flag=(String) ((JavascriptExecutor)dr).executeScript("if($('#step1-2').is(':visible')) return \"true\"; else return \"false\";");
				if("true".equals(flag)){
					return true;
				}else{
					return false;
				}
        	}
		});
		driver.findElement(By.id("FrameNo")).clear();
		driver.findElement(By.id("FrameNo")).sendKeys(Util.getRandomString(17, true, true).toUpperCase());
		driver.findElement(By.id("EngineNo")).clear();
		driver.findElement(By.id("EngineNo")).sendKeys(Util.getRandomString(17, true, true).toUpperCase());
		driver.findElement(By.id("VEHICLE_MODELSH")).click();
		driver.findElement(By.id("VEHICLE_MODELSH")).clear();
		driver.findElement(By.id("VEHICLE_MODELSH")).sendKeys("hg7240");
		System.out.println("等待打开选择车型div....");
		(new WebDriverWait(driver, 100)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver dr) {
				String flag=(String) ((JavascriptExecutor)dr).executeScript("if($('#brand').is(':visible')) return \"true\"; else return \"false\";");
				if("true".equals(flag)){
					return true;
				}else{
					return false;
				}
        	}
		});
		driver.findElement(By.id("haveLoan")).click();
		((JavascriptExecutor)driver).executeScript("$('#carModelList0').click();");
		driver.findElement(By.id("itemCarInput_2_next_btn")).click();
		driver.findElement(By.id("BasicPackage")).click();
		driver.findElement(By.id("notBuyBZBtn")).click();
		System.out.println("等待计算保费,请稍后。。。。");
		(new WebDriverWait(driver, 100)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver dr) {
				String flag=(String) ((JavascriptExecutor)dr).executeScript("if(parseFloat($(\"#SumPremium_SY_step\").find(\"b\").text())>0) return \"true\";");
				System.out.println(flag);
				if("true".equals(flag)){
					return true;
				}else{
					return false;
				}
        	}
		});
		driver.findElement(By.id("itemkindNextBtn2")).click();
		(new WebDriverWait(driver, 100)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver dr) {
				String flag=(String) ((JavascriptExecutor)dr).executeScript("if($('#step3').is(':visible')) return \"true\"; else return \"false\";");
				if("true".equals(flag)){
					return true;
				}else{
					return false;
				}
        	}
		});
		driver.findElement(By.id("InsuredIdentifyNumber")).clear();
		driver.findElement(By.id("InsuredIdentifyNumber")).sendKeys("111111111111111");
		new Select(driver.findElement(By.id("county")))
				.selectByVisibleText("中原区");
		driver.findElement(By.cssSelector("option[value=\"410102\"]")).click();
		driver.findElement(By.id("AppliAddress")).clear();
		driver.findElement(By.id("AppliAddress")).sendKeys("111111111111111111");
		driver.findElement(By.id("wxinsuredinput_next_btn")).click();
		(new WebDriverWait(driver, 100)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver dr) {
				String flag=(String) ((JavascriptExecutor)dr).executeScript("if($('#step4').is(':visible')) return \"true\"; else return \"false\";");
				if("true".equals(flag)){
					return true;
				}else{
					return false;
				}
        	}
		});
		driver.findElement(By.id("verifyAgreement")).click();
		driver.findElement(By.id("saveProposalBtn")).click();
		//driver.quit();
	}
}
