import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstagramLogin {

    public void login(String username, String password) {
        // ChromeDriver yolunu belirleyin
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // WebDriver nesnesi oluştur
        WebDriver driver = new ChromeDriver();

        try {
            // Instagram giriş sayfasını aç
            driver.get("https://www.instagram.com/accounts/login/");

            // Sayfanın yüklenmesi için bekleyin
            Thread.sleep(3000);

            // Kullanıcı adı ve şifre alanlarını bulun
            WebElement usernameField = driver.findElement(By.name("username"));
            WebElement passwordField = driver.findElement(By.name("password"));

            // Kullanıcı adı ve şifreyi girin
            usernameField.sendKeys(username);
            passwordField.sendKeys(password);

            // Giriş Yap butonuna tıklayın
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();

            // Giriş işlemi sonrası birkaç saniye bekle
            Thread.sleep(5000);

            // Başarıyla giriş yapıldıktan sonra, istenilen işlemleri gerçekleştirin
            System.out.println("Instagram'a giriş başarılı.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Tarayıcıyı kapat
            driver.quit();
        }
    }

    public static void main(String[] args) {
        InstagramLogin login = new InstagramLogin();
        login.login("kullanıcıAdınız", "şifreniz");
    }
}
