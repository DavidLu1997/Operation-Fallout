package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dog extends Animal {

	public Dog() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(0,0,0,0,0,0);
		
		lifespan = 20;
		minimum = 0.4;
		optimal = 0.7;
		safeRadiation = 100;
		maxRadiation = 1000;
		consumed = 3;
		combat = 8;
		
		name = "Dog";
		mutation = "Large Dog";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\dog.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
