package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ViewIssuesPage {
	private final WebDriver driver;
	private final WebDriverWait wait;

	@FindBy(xpath = "//*[@id='buglist']//tbody/tr")
	private List<WebElement> issues;

	@FindBy(xpath = "//*[@id='breadcrumbs']/div[1]/a[1]")
	private WebElement newIssueLink;

	@FindBy(xpath = "//td[@class='bug-summary']")
	private WebElement bugSummaryField;

	@FindBy(xpath = "//td[@class='bug-description']")
	private WebElement bugDescriptionField;

	@FindBy(xpath = "//*[@value='Delete']")
	private WebElement deleteButton;

	@FindBy(xpath = "//*[@value='Delete Issues']")
	private WebElement confirmDeleteButton;

	@FindBy(xpath = "//*[@id='buglist']/tbody/tr[1]/td[4]/a")
	private WebElement lastIssueLeft;


	public ViewIssuesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30, 500);
		PageFactory.initElements(driver, this);
	}
	public int countIssues() {
		return issues.size();
	}

	public String getIssueId() {
		return newIssueLink.getText();
	}

	public String getIssueIdSummary() {
		driver.get("https://academ-it.ru/mantisbt/view.php?id=" + newIssueLink.getText());
		return bugSummaryField.getText();
	}

	public String getIssueDescription() {
		driver.get("https://academ-it.ru/mantisbt/view.php?id=" + newIssueLink.getText());
		return bugDescriptionField.getText();
	}

	public void removeIssue() {
		driver.get("https://academ-it.ru/mantisbt/view.php?id=" + newIssueLink.getText());
		deleteButton.sendKeys(Keys.ENTER);
		confirmDeleteButton.sendKeys(Keys.ENTER);
		//Thread.sleep(1000);
	}
	public String scanLastIssue() {
		return lastIssueLeft.getText();
	}
}