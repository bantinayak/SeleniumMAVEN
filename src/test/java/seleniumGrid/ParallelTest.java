package seleniumGrid;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ParallelTest {
	public WebDriver driver;

	@Parameters({ "bname" })
	@Test
	public void crossBrowserTesting(String bname)
			throws MalformedURLException, InterruptedException, URISyntaxException {
		System.out.println("RemoteDriver connectivity is started");
		URL url = new URI("http://localhost:4444").toURL();
		if (bname.equals("Chrome")) {

			ChromeOptions option = new ChromeOptions();
			driver = new RemoteWebDriver(url, option);
			System.out.println("session created on Chrome");
		} else if (bname.equals("Firefox")) {
			FirefoxOptions option = new FirefoxOptions();
			driver = new RemoteWebDriver(url, option);
			System.out.println("session created on Firefox");
		} else if (bname.equals("Edge")) {
			EdgeOptions option = new EdgeOptions();
			driver = new RemoteWebDriver(url, option);
			System.out.println("session created on Edge");
		}
		System.out.println("RemoteDriver connectivity is completed");
		Thread.sleep(10000);
		driver.get("https://www.amazon.in/");
		Thread.sleep(6000);
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
