package ww.q2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WWTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void findStudioTest() {
        IndexPage indexPage = new IndexPage(driver);
        FindStudioPage findStudioPage = new FindStudioPage(driver);

//        2. Verify loaded page title matches “WW (Weight Watchers): Weight Loss & Wellness Help”
        indexPage.waitForTitle("WW (Weight Watchers): Weight Loss & Wellness Help");

//        3. On the right corner of the page, click on “Find a Studio”
        indexPage.clickOnFindStudio();

//        4. Verify loaded page title contains “Find WW Studios & Meetings Near You | WW USA”
        findStudioPage.waitForTitle("Find WW Studios & Meetings Near You | WW USA");

//        5. In the search field, search for meetings for zip code: 10011
        findStudioPage.enterText("10011");

//        6. Print the title of the first result and the distance (located on the right of location title/name)
        final String locationName = findStudioPage.getLocationName(0);
        System.out.println(locationName);
        System.out.println(findStudioPage.getLocationDistance(0));
        System.out.println();

//        7. Click on the first search result and then, verify displayed location name/title matches with the name of the first searched result that was clicked.
        findStudioPage.clickSearchResult(0);
        Assert.assertEquals(locationName, findStudioPage.getLocationName(0));

//        8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
        List<String> hours = findStudioPage.getTodaysHours();
        for (String item : hours) {
            System.out.println(item);
        }
        System.out.println();

//        9. Create a method to print the number of meeting the each person(under the scheduled time) has a particular day of the week
//        e.g. printMeetings("Sun")
//        Output should be:
//        Person A  3
//        Person B  1
        System.out.println("TUESDAY:");
        findStudioPage.printMeetings("Tue");
        System.out.println();
        System.out.println("THURSDAY:");
        findStudioPage.printMeetings("Thu");
        driver.close();
    }

//    @After
//    public void afterTest() {
//        if (driver != null) {
//            driver.close();
//           // driver.quit();
//        }
//    }
}
