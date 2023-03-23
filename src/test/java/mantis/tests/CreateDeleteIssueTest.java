package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class CreateDeleteIssueTest extends BaseTest{

	private MantisSite mantisSite;

	@Test
	public void createIssue() {
		SoftAssertions softAssert = new SoftAssertions();
		mantisSite = new MantisSite(driver);
		mantisSite.login(TestData.loginTrue, TestData.passwordTrue);

		mantisSite.newIssue(TestData.summary, TestData.description);

		String issueId = mantisSite.getViewIssuesPage().getIssueId();
		String actualIdSummary = mantisSite.getViewIssuesPage().getIssueIdSummary();
		System.out.println("My issue_for_delition id: " + issueId + "\nActual Id + Summary are: "
				+ actualIdSummary + "\nExpected Id + Summary are: " + issueId + ": " + TestData.summary);
		softAssert.assertThat(actualIdSummary).isEqualTo(issueId + ": " + TestData.summary);
		//Assertions.assertEquals(issueId + ": " + TestData.summary, actualIdSummary);

		String actualDescription = mantisSite.getViewIssuesPage().getIssueDescription();
		softAssert.assertThat(actualDescription).isEqualTo(TestData.description);
		//Assertions.assertEquals(TestData.description, actualDescription);

		mantisSite.deleteIssue();
		String lastIssueNumber = mantisSite.getViewIssuesPage().scanLastIssue();
		softAssert.assertThat(lastIssueNumber).isNotEqualTo(issueId);
		//Assertions.assertNotEquals(lastIssueNumber, issueId);

		softAssert.assertAll();
		System.out.println("Last issue remained is: " + lastIssueNumber);
	}
}