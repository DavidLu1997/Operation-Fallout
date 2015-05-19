package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Crab extends Animal {

	public Crab() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(0,0,0,0,0,0);
		
		lifespan = 20;
		minimum = 0.5;
		optimal = 0.7;
		safeRadiation = 100;
		maxRadiation = 1000;
		consumed = 1;
		combat = 1;
		
		name = "Crab";
		mutation = "Lakelurk";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\crab.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
