package linkedList;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class PatternExample {

	public static void main(String[] args) {
		
		try {
			File file = new File("C:\\Users\\saura\\Downloads\\heart (1).jpg");
			BufferedImage image = ImageIO.read(file);
			
			for (int i = 0; i < image.getHeight(); i++) {
				for (int j = 0; j < image.getWidth(); j++) {
					Color color = new Color(image.getRGB(j, i));  
					if (color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {
						System.out.print("❤");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println(); // Move to the next line after each row
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
	}
}
