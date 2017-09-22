package pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page for elements of the Landing Page and Result page
 */

public class LoanPage {

	// Nettokreditbetrag
	@FindBy(css = ".select1 .text")
	private WebElement getAmount;

	@FindBy(css = ".select1 .item[data-value='2750']")
	private WebElement selectAmount;

	// Laufzeit
	@FindBy(css = ".select2 .text")
	private WebElement getMonate;

	@FindBy(css = ".select2 .item[data-value='24']")
	private WebElement selectMonate;

	// Verwendung
	@FindBy(css = ".select3 .text")
	private WebElement getVerwendung;

	@FindBy(css = ".select3 .item[data-value='886']")
	private WebElement selectVerwendung;

	// Weiter
	@FindBy(css = ".bank__credit button i")
	private WebElement getWeiter;

	private static int TIME_IN_SECONDS = 10;
	private WebDriver webDriver;
	private WebDriverWait wait;

	/**
	 * Default constructor
	 * 
	 * @param webDriverProvider
	 */

	public LoanPage(WebDriver driver) {
		this.webDriver = driver;
		wait = new WebDriverWait(driver, TIME_IN_SECONDS);

	}

	public void testLandingPage() {
		System.out.println("in landing page" + webDriver.getTitle());
	}

	public String selectAmount() {
		wait.until(ExpectedConditions.visibilityOf(getAmount)).click();
		selectAmount.click();
		String amount = getAmount.getText();
		System.out.println("Amount is " + amount);
		return amount;
	}

	public String selectMonaten() {
		wait.until(ExpectedConditions.visibilityOf(getMonate)).click();
		selectMonate.click();
		String duration = getMonate.getText();
		System.out.println("Months are " + duration);
		return duration;
	}

	public String selectVerwendung() {
		wait.until(ExpectedConditions.visibilityOf(getVerwendung)).click();
		selectVerwendung.click();
		String vervendung = getVerwendung.getText();
		System.out.println("Verwendung is"+ vervendung );
		return vervendung;
	}

	public String clickWeiter() {
		wait.until(ExpectedConditions.visibilityOf(getWeiter)).click();

		// wait till page is loaded
		this.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String newTitle = this.webDriver.getTitle();
		System.out.println("New page title is" + newTitle);
		return newTitle;
	}

}
