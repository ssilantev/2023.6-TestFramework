package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportIssuePage {
	private final WebDriver driver;
	private final WebDriverWait wait;

	@FindBy(css = "#summary")
	private WebElement summaryField;

	@FindBy(css = "#description")
	private WebElement descriptionField;

	@FindBy(css = "[type=submit]")
	private WebElement submitButton;

	public ReportIssuePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30, 500);
		PageFactory.initElements(driver, this);
	}

	public void fillForm(String summaryText, String descriptionText) {
		driver.get("https://academ-it.ru/mantisbt/bug_report_page.php");
		summaryField.sendKeys(summaryText);
		descriptionField.sendKeys(descriptionText);
		submitButton.sendKeys(Keys.ENTER);
	}
}