package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public WebDriver driver;
	private Properties prop;
	private OptionsManager om;
	
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	
	public static String highlight;

	public WebDriver initDriver(Properties prop) {
		om = new OptionsManager(prop);
		highlight =prop.getProperty("highlight");
		
		String browserName = prop.getProperty("browser").trim().toLowerCase();

		if (browserName.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver(om.getChromeOptions());
			tlDriver.set(new ChromeDriver(om.getChromeOptions()));
		} else if (browserName.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver(om.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(om.getFirefoxOptions()));
		} else if (browserName.equalsIgnoreCase("Edge")) {
//			driver = new EdgeDriver(om.getEdgeOptions());
			tlDriver.set(new EdgeDriver(om.getEdgeOptions()));
		} else {

			System.out.println("Pass the correct browser.......");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}

	public synchronized static WebDriver getDriver() {
		
		return tlDriver.get();
	}
	public Properties initProp() {
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtil.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
