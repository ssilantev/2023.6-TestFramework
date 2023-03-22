package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateDeleteIssueTest extends BaseTest{

	private MantisSite mantisSite;

	@Test
	public void createIssue() throws InterruptedException {
		mantisSite = new MantisSite(driver);
		mantisSite.login("admin", "admin20");
		Thread.sleep(1000);
		mantisSite.fillForm("Vsem Privet!", "Vsem Udachi!");

		String currentUserName = mantisSite.getMainPage().getUserName();
		Assertions.assertEquals("admin", currentUserName);
		Thread.sleep(9000);



	}
}

