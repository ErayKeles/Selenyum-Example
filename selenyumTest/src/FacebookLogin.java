import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

    public void login(String username, String password) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.facebook.com/login/");

            Thread.sleep(3000);

            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("pass"));

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);

            WebElement loginButton = driver.findElement(By.name("login"));
            loginButton.click();

            Thread.sleep(5000);

            System.out.println("Facebook'a giriş başarılı.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        FacebookLogin login = new FacebookLogin();
        login.login("kullanıcıAdınız", "şifreniz");
    }
}
