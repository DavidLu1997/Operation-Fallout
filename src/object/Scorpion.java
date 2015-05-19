package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Scorpion extends Animal {

	public Scorpion() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(0,0,0,0,0,0);
		
		lifespan = 25;
		minimum = 0.1;
		optimal = 0.3;
		safeRadiation = 100;
		maxRadiation = 1000;
		consumed = 1;
		combat = 3;
		
		name = "Scorpion";
		mutation = "Radscorpion";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\scorpion.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
