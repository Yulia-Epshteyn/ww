package ww.q2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {
    private static final String PAGE_URL = "https://www.weightwatchers.com/us/";

    @FindBy(id = "ela-menu-visitor-desktop-supplementa_find-a-studio")
    private WebElement findStudio;

    public IndexPage(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
    }

    public IndexPage clickOnFindStudio() {
        findStudio.click();
        return this;
    }
}
