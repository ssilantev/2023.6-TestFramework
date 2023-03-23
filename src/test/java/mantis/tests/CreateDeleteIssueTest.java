package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateDeleteIssueTest extends BaseTest{

	private MantisSite mantisSite;

	@Test
	public void createIssue() {
		mantisSite = new MantisSite(driver);
		mantisSite.login(TestData.loginTrue, TestData.passwordTrue);

		mantisSite.newIssue(TestData.summary, TestData.description);

		String issueId = mantisSite.getViewIssuesPage().getIssueId();
		String actualIdSummary = mantisSite.getViewIssuesPage().getIssueIdSummary();
		System.out.println("My issue_for_delition id: " + issueId + "\nActual Id + Summary are: "
				+ actualIdSummary + "\nExpected Id + Summary are: " + issueId + ": " + TestData.summary);
		//Check Creation

		// softAssert врет, ничего не проверяет
		SoftAssertions softAssert1 = new SoftAssertions();
		softAssert1.assertThat(actualIdSummary).isNotEqualTo(issueId + ": " + TestData.summary);
		Assertions.assertEquals(issueId + ": " + TestData.summary, actualIdSummary);

		String actualDescription = mantisSite.getViewIssuesPage().getIssueDescription();
		SoftAssertions softAssert2 = new SoftAssertions();
		softAssert2.assertThat(actualDescription).isEqualTo(TestData.description + "123123123");
		Assertions.assertEquals(TestData.description, actualDescription);

		mantisSite.deleteIssue();
		// Check removal
		String lastIssueNumber = mantisSite.getViewIssuesPage().scanLastIssue();
		SoftAssertions softAssert3 = new SoftAssertions();
		softAssert3.assertThat(lastIssueNumber).isNotEqualTo(issueId);
		Assertions.assertNotEquals(lastIssueNumber, issueId);

		System.out.println("Last issue remained is: " + lastIssueNumber);
	}
}