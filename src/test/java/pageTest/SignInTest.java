package pageTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pageObjects.SignInErrorPage;

/**
 * Test Scenario : User Opens url 
 * Clicks on sign in button
 * Enter wrong username
 * Enter wrong password
 * Clicks on Sign in
 * Verify the page new page with error is loaded
 */

public class SignInTest extends BaseSetup {
	public static final String RESULT_PAGETITLE = "Sicheres Einloggen mit Zugangsdaten - smava.de";

	@Test
	public void testInValidLogin() {

		SignInErrorPage signInError = PageFactory.initElements(driver, SignInErrorPage.class);

		signInError.clickAnmelden();
		signInError.enterEmail();
		signInError.enterPassword();
		signInError.signIn();
		
		String error = signInError.errorPage();

		assertThat(error, is(RESULT_PAGETITLE));
	}

	
}
