package mantis.pages;

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

	public ViewIssuesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30, 500); //TODO неправильно определился тип занчений int вместо времени
		PageFactory.initElements(driver, this);
	}
	public int countIssues() {
		return issues.size();
	}
}