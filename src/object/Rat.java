package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rat extends Animal {

	public Rat() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(0,0,0,0,0,0);
		
		lifespan = 5;
		minimum = 0.1;
		optimal = 0.3;
		safeRadiation = 100;
		maxRadiation = 1000;
		consumed = 1;
		combat = 3;
		
		name = "Rat";
		mutation = "Giant Rat";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\rat.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
