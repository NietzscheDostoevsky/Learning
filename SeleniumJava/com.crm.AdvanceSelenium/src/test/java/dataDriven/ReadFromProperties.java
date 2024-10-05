package dataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadFromProperties {

	@Test
	public void login() throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("./Configure/dwsLogin.properties");
		properties.load(fis);
		String browserString = properties.getProperty("browser");
		String urlString = properties.getProperty("url");
		String emailString = properties.getProperty("email");
		String passString = properties.getProperty("password");

		String workingDirectory = System.getProperty("user.dir");
		System.out.println("Current Working Directory: " + workingDirectory);
		
		System.out.println(browserString + "\n" + urlString + "\n" + emailString + "\n" + passString + "\n");
		fis.close();
	}
}
