package utilityClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromProperties {

    public static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("./Configure/dwsLogin.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
