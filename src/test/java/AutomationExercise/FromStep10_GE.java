package AutomationExercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Before_After;

public class FromStep10_GE extends Before_After {
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
    public void registerUser() throws InterruptedException {
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully

        //  4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible

        //6. Enter name and email address
        WebElement signUpName = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        Actions actions = new Actions(driver);
        actions.click(signUpName)
                .sendKeys("Ecrinn")
                .sendKeys(Keys.TAB)
                .sendKeys("ecrinn@gmail.com")
                .perform();

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).submit();
        Thread.sleep(2000);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //9. Fill details: Title, Name, Email, Password, Date of birth

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("name")).sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//*[@data-qa='first_name']"));
        actions.click(firstName)
                .sendKeys("Ecrin")
                .sendKeys(Keys.TAB)
                .sendKeys("Yilmaz")
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

        // Verify that 'ACCOUNT CREATED!' is visible



}}
