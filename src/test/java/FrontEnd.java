import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrontEnd {
    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://shop.pragmatic.bg/admin/");
        driver.manage().window().maximize();

    }
    @Test
    public void userNameAndPasswordTest() {
        WebElement userName = driver.findElement(By.id("input-username"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("parola123!");
        String password1= password.getText();
        String actualPassword=password1;
        String expectedPassword=password.getText();
        Assert.assertEquals(actualPassword,expectedPassword);

        if (password1.equalsIgnoreCase(expectedPassword)){
            System.out.println("Successfully log in");

        }
        else  {
            System.out.println("Wrong password");
        }

        WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        logInButton.click();

        //WebElement logOutButton = driver.findElement(By.xpath("//a[contains(@href, 'logout')]"));
//        String logOutButtonText = logOutButton.getText();
//        Assert.assertEquals(logOutButtonText, "Logout");
//
//        logOutButton.click();

    }
}
