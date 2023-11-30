package AutomationExercise;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class C01_Register_User {

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

               public void demented() {
                   WebDriverManager.chromedriver().setup();
                   WebDriver driver=new ChromeDriver();
                   driver.manage().window().maximize();
                   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

                   driver.get("http://automationexercise.com");

                   WebElement singupElementi= driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
                   Actions actions=new Actions(driver);
                   actions.click(singupElementi).perform();

                   WebElement nameKutusu= driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
                   actions.click(nameKutusu)
                           .sendKeys("Burhan")
                           .sendKeys(Keys.TAB)
                           .sendKeys("slmnkt@add.com")
                           .sendKeys(Keys.TAB)
                           .sendKeys(Keys.ENTER)
                           .perform();
                   WebElement titleRadiButton=driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
                   actions.click(titleRadiButton  )
                           .sendKeys(Keys.TAB)
                           .sendKeys("12345")
                           .sendKeys(Keys.TAB)
                           .sendKeys("3")
                           .sendKeys(Keys.TAB)
                           .sendKeys("May")
                           .sendKeys(Keys.TAB)
                           .sendKeys("1989")
                           .sendKeys(Keys.TAB)
                           .click()
                           .sendKeys(Keys.TAB)
                           .click()
                           .sendKeys(Keys.TAB)
                           .sendKeys("burhan")
                           .sendKeys(Keys.TAB)
                           .sendKeys("Tas")
                           .sendKeys(Keys.TAB)
                           .sendKeys("mir")
                           .sendKeys(Keys.TAB)
                           .sendKeys("gladbach strasse 22")
                           .sendKeys(Keys.TAB)
                           .sendKeys(Keys.TAB)
                           .sendKeys("Canada")
                           .sendKeys(Keys.TAB)
                           .sendKeys("Hamburg")
                           .sendKeys(Keys.TAB)
                           .sendKeys("Hamburg")
                           .sendKeys(Keys.TAB)
                           .sendKeys("50123")
                           .sendKeys(Keys.TAB)
                           .sendKeys("15770298388")
                           .sendKeys(Keys.TAB)
                           .sendKeys(Keys.ENTER).perform();

                   String expectedYazi="ACCOUNT CREATED!";
                   String actualYazi=driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
                   Assert.assertEquals(expectedYazi,actualYazi);
                   driver.close();



               }

}
