package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IssuesTest extends BaseTest {

	private MantisSite mantisSite;

	@Test
	public void checkIssuesNumber () throws InterruptedException {
		mantisSite = new MantisSite(driver); 				// TODO Можно вынести в baseTest
		mantisSite.login("admin", "admin20");	//

		mantisSite.getMainPage().goToViewIssuesPage();
		Thread.sleep(3000);
		int actualNumber = mantisSite.getViewIssuesPage().countIssues();
		Assertions.assertEquals(50, actualNumber);
	}

}
