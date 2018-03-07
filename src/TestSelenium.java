
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.Thread.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestSelenium
{
    private static int a1;
    private int a;


    public static void main(String[] args)
    {
        String struserName, strPwd;
         final String URL = "https://test.salesforce.com";
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
       ChromeDriver driver=new ChromeDriver();
        //WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
        driver.get(URL);
        login("srepc2@pmic.com.t1", "Passwrd1", driver);
       // WebDriverWait wait = new WebDriverWait(driver, 10);
        Search("N830000026", driver);
        //driver.navigate().refresh();
        /*driver = null;*/
        navigatetoCustomermenu ( driver);

    }

    public static void login (String struserName, String strPwd, ChromeDriver driver)
    {
        WebElement element =driver.findElement(By.id("username"));
        element.sendKeys(struserName);

        WebElement element2=driver.findElement(By.id("password"));
        element2.sendKeys(strPwd);

        WebElement button=driver.findElement(By.id("Login"));
        button.click();
    }

    public  static void Search (String strPolicyNumber, ChromeDriver driver)
    {
        driver.switchTo().frame(0);

        driver.switchTo().frame(0);
        WebElement element2 = (new WebDriverWait(driver, 50))
                .until(presenceOfElementLocated(By.id("customerSearchPage:customerSearchForm:policyNumber")));
//     WebElement element2 =driver.findElement(By.id("customerSearchPage:customerSearchForm:policyNumber"));
        element2.sendKeys(strPolicyNumber);
        driver.findElementsByTagName("element");

        WebElement button=driver.findElement(By.id("searchButton"));
        button.click();
    }

    public  static void navigatetoCustomermenu (ChromeDriver driver)
    {
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
//        WebDriverWait wait = new WebDriverWait(driver,10000);
//        WebElement element2 = (new WebDriverWait(driver, 150))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("customerMenu")));
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        WebElement element2 = (new WebDriverWait(driver, 150))
               .until(ExpectedConditions.visibilityOfElementLocated(By.id("iframeTab_1744573")));

        driver.switchTo().frame("iframeTab_1744573");
//        thread.sleep(2000);
//        List ifrms = driver.findElementsByTagName("iframe");
//        System.out.println(ifrms.size());

//        WebElement menubutton = (new WebDriverWait(driver, 150))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("customerMenu")));
        WebDriverWait wait = new WebDriverWait(driver, 1500);
        WebElement menubutton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customerMenu")));
        menubutton.click();
// WebElement menubutton=driver.findElement(By.id("customerMenu"));
//        new WebDriverWait(driver, timeout)
//                .ignoring(StaleElementReferenceException.class)
//                .until(new Predicate<WebDriver>() {
//                    @Override
//                    public boolean apply(@Nullable WebDriver driver) {
//                        driver.findElement(By.id("customerMenu")).click();
//                        return true;
//                    }
//                });
    }
}

