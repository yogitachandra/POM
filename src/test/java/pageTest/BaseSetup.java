package pageTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Setup and Tear down methods , Select browser and url from configuration.properties
 * Initialize driver . Open URL 
 */

public class BaseSetup {
	protected static WebDriver driver;
	public static String driverPath = getParameters().getProperty("driverPath");
	public static String browser = getParameters().getProperty("browser");
	public static String appURL = getParameters().getProperty("appURL");

	public WebDriver getDriver() {
		return driver;
	}

	private static Properties getParameters() {
		File file = new File("src/utils/configuration.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	protected static void setDriver(String browser, String appURL) {
		switch (browser) {
		case "Chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
			driver = initChromeDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@Before
	public void initializeTestBaseSetup() {
		try {
			setDriver(browser, appURL);

		} catch (Exception e) {
			System.out.println("Error......." + e.getStackTrace());
		}
	}

	@After
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

}
