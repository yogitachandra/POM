package pageTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoanPage;

/**
 * Test Scenario : User Opens url 
 * Enter loan amount
 * Enter duration
 * Enter Usage 
 * Clicks on next
 * Verify the page is loaded or not 
 */

public class LoanResultTest extends BaseSetup {
	
	public static final String LOAN_PAGETITLE = "SMAVA - Das Online-Vergleichsportal für Kredite | SMAVA";
	public static final String RESULT_PAGETITLE = "Kredit beantragen | Kreditantrag in 4 Schritten | SMAVA";

	@Test
	public void testLoanResult() {

		LoanPage result = PageFactory.initElements(driver, LoanPage.class);
		String title = driver.getTitle();
		System.out.println(title);
		result.testLandingPage();
		
		String amount = result.selectAmount();
		System.out.println("amount is" + amount);
		
		String months = result.selectMonaten();
		System.out.println("month" + months);
		
		String verwendung = result.selectVerwendung();
		System.out.println("vervendung" + verwendung);
		String result_title = result.clickWeiter();
		
		assertThat(title, is(LOAN_PAGETITLE));	
		assertThat(result_title,is(RESULT_PAGETITLE));		
	}
	
	
	
	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
