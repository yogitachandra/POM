package pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page for elements of the Sign in Pop up and Wrong sign in page
 */

public class SignInErrorPage {

	@FindBy(css = ".login-popup i")
	private WebElement getLoginPopUp;

	@FindBy(id = "signonForm.email")
	private WebElement emailTextBox;

	@FindBy(id = "signonForm.password")
	private WebElement passwordTextBox;

	@FindBy(css = ".unlock")
	private WebElement signInIcon;

	@FindBy(css = ".error")
	private WebElement errorMessage;
	
	private static int TIME_IN_SECONDS = 10;
	private WebDriver webDriver;
	private WebDriverWait wait;

	/**
	 * Default constructor
	 * 
	 * @param webDriverProvider
	 */

	public SignInErrorPage(WebDriver driver) {
		this.webDriver = driver;
		wait = new WebDriverWait(driver, TIME_IN_SECONDS);
	}

	public void testSignInPage() {
		System.out.println("in signInPopUp" + webDriver.getTitle());
	}

	public void clickAnmelden() {
		getLoginPopUp.click();
		System.out.println("Clicked Login");

	}

	public void enterEmail() {
		emailTextBox.click();
		emailTextBox.sendKeys("abc@gmail.co");
		System.out.println("Entered email");

	}

	public void enterPassword() {
		passwordTextBox.click();
		passwordTextBox.sendKeys("abc");
		System.out.println("Entered passwordTextBox");

	}

	public void signIn() {
		signInIcon.click();
		System.out.println("Clicked signInIcon");

	}

	public String errorPage() {
		// WebDriverWait wait = new WebDriverWait(webDriver, 10);

		wait.until(ExpectedConditions.visibilityOf(errorMessage));

		// wait till page is loaded
		this.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("New Url is" + this.webDriver.getCurrentUrl());
		String newTitle = this.webDriver.getTitle();
		return newTitle;
	}

}
