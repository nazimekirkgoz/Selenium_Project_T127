package AutomationExercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Before_After;
import utilities.ReusableMethods;

import java.time.Duration;

public class RegisterAnUser extends Before_After {

               /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
         */


    @Test
    public void test01() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserTitle = driver.findElement(By.xpath("//div[@class='signup-form']"));
        Assert.assertTrue(newUserTitle.isDisplayed());

        //6-Enter name and email address
        WebElement name = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        actions.click(name)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .perform();


        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement account = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(account.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title = driver.findElement(By.xpath("//div[@class='radio-inline'][2]")); //titlet
        Actions actions1 = new Actions(driver);
        actions1.click(title)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)

                .sendKeys(Keys.TAB)

                .sendKeys("2344545")
                .sendKeys(Keys.TAB)
                .sendKeys("5")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("1993")
                .sendKeys(Keys.TAB)
                .perform();
        ReusableMethods.bekle(3);


        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("name")).sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//*[@data-qa='first_name']"));

        actions.click(firstName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys("Efficy")
                .sendKeys(Keys.TAB)
                .sendKeys("12. street")
                .sendKeys(Keys.TAB)
                .sendKeys("next to the rond point").perform();

        WebElement country = driver.findElement(By.id("country"));
        Select countryElement = new Select(country);
        countryElement.selectByVisibleText("Canada");

        WebElement state = driver.findElement(By.id("state"));
        actions.click(state)
                .sendKeys("California")
                .sendKeys(Keys.TAB)
                .sendKeys("Los Angeles")
                .sendKeys(Keys.TAB)
                .sendKeys("90001")
                .sendKeys(Keys.TAB)
                .sendKeys("12345678").perform();

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).submit();

        //14. Verify that 'ACCOUNT CREATED!' is visible
       WebElement accountText = driver.findElement(By.xpath("//*[@data-qa='account-created']"));
       Assert.assertTrue(accountText.isDisplayed());
//       accountText.sendKeys(Keys.PAGE_DOWN);

        //15. Click 'Continue' button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[data-qa='continue-button']")));
        continueButton.click();

        //16. Verify that 'Logged in as username' is visible
        driver.findElement(By.xpath("//*[text()=' Logged in as '] ")).isDisplayed();

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='account-deleted'")).isDisplayed();

        driver.findElement(By.xpath("//*[@data-qa='continue-button'")).click();


    }
}
