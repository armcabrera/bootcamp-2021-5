package selenium.foliva;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Atc01 {
    private WebDriver driver;
    @BeforeClass
    public static void Setup(){
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void before(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }
    @Test
    public void searchDress(){
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("dress");
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
        List<WebElement> products = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));

        Assert.assertTrue(products.size() > 2);
    }
    @After
    public void after(){
        if(driver != null){
            driver.close();
        }
    }
}
