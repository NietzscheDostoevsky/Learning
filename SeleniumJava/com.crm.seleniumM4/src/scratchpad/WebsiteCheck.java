package scratchpad;

import java.awt.Toolkit;
import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebsiteCheck {
    public static void main(String[] args) throws InterruptedException {
        
    	for (int i = 1; i < 1000; i++) {
    		System.out.println("Check number " + i);
    		LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            System.out.println("Current Date and Time: " + formattedDateTime);
    		checkNew();
    		Thread.sleep(1000 * 60 * 10);
    	}
    }

    
    
    public static void checkNew() {
    	WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://ovarit.com/new");

        var allPosts = driver.findElement(By.className("alldaposts"));
        var posts = allPosts.findElements(By.className("post"));
        var firstid = posts.get(0).getAttribute("pid").contains("622087");

        if (firstid) {
           Toolkit.getDefaultToolkit().beep(); 
        } else {
        	 playSound("../com.crm.seleniumM4/gun.wav");  
        }

        System.out.println(firstid);
        driver.quit();
    }
    
 // Method to play a sound
    public static void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();  // Plays the sound
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
