package ww.q2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindStudioPage extends BasePage {
    @FindBy(id = "meetingSearch")
    private WebElement meetingSearchField;

    @FindBy(xpath = "(//div[@class='location__name']/span)")
    private List<WebElement> locationNames;

    @FindBy(xpath = "(//div[@class='location__distance'])")
    private List<WebElement> locationDistances;

    @FindBy(xpath = "(//div[contains(@class, 'hours-list--currentday')]/div[@class='hours-list-item-hours']/div)")
    private List<WebElement> todaysHours;

    @FindBy(xpath = "(//div[@class='schedule-detailed-day-label'])")
    private List<WebElement> scheduleDetailLabels;

    private Map<String, WebElement> scheduleDetailLabelsByDay;

    public FindStudioPage(WebDriver driver) {
        super(driver);
    }

    private void initializeScheduleDetailLabelsByDay() {
        scheduleDetailLabelsByDay = new HashMap<>();
        for (WebElement label : scheduleDetailLabels) {
            scheduleDetailLabelsByDay.put(label.getText(), label);
        }
    }

    public FindStudioPage enterText(String text) {
        meetingSearchField.sendKeys(text);
        meetingSearchField.sendKeys(Keys.ENTER);
        return this;
    }

    public String getLocationName(int index) {
        return getListItem(locationNames, index).getText();
    }

    public String getLocationDistance(int index) {
        return getListItem(locationDistances, index).getText();
    }

    private WebElement getListItem(List<WebElement> elements, int index) {
        waitUntilAllElementsAreVisible(elements);
        if (index > elements.size() || index < 0) {
            throw new IllegalArgumentException();
        }
        return elements.get(index);
    }

    public FindStudioPage clickSearchResult(int index) {
        getListItem(locationNames, index).click();
        return this;
    }

    public List<String> getTodaysHours() {
        return todaysHours.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void printMeetings(String day) {
        if (scheduleDetailLabelsByDay == null) {
            initializeScheduleDetailLabelsByDay();
        }

        WebElement label = scheduleDetailLabelsByDay.get(day.toUpperCase());
        if (label == null) {
            return;
        }

        List<WebElement> leaders = label.findElements(By.xpath(
                "following-sibling::div[@class='schedule-detailed-day-meetings']//" +
                        "div[@class='schedule-detailed-day-meetings-item-leader']"));

        Map<String, Long> leadersCounts = leaders.stream()
                .collect(Collectors.groupingBy(WebElement::getText, Collectors.counting()));
        leadersCounts.forEach((leader, count) -> System.out.println(String.format("%s  %d", leader, count)));
    }
}
