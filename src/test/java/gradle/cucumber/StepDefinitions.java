package gradle.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefinitions {
    
	WebDriver driver;

	/*
    @Before
    public void openBrowser(){
    driver = new ChromeDriver();
    }
    */
    @Given("I open {string}")
    public void openBrowser(String browser)
    {
        if (browser ==null)
        {
            driver = new ChromeDriver();
        }
        if (browser.equals("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else
        {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        //*/
        // driver = new FirefoxDriver();
        // driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get ("https://www.google.com");
    }


    @Given("I open wikipedia")
    public void i_open_wikipedia() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
    }

    @When("I search {string}")
    public void i_search(String article) {
        // Write code here that turns the phrase above into concrete actions
        //WebElement barreRecherche = driver.findElement(By.id("firstHeading"));
        WebElement barreRecherche = driver.findElement(By.name("search"));
        barreRecherche.sendKeys(article);
        barreRecherche.sendKeys(Keys.ENTER);

    }

    @Then("I should see {string} in the title")
    public void i_should_see_in_the_title(String title) {
        //Assert
        String expectedResult = title;
        WebElement ElementRecherche = driver.findElement(By.id("firstHeading"));
        Assert.assertEquals(expectedResult,ElementRecherche.getText());
    }

    @After
    public void CloseBrowser()
    {
        driver.quit();
    }

    
}
