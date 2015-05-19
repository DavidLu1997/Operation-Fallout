package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Lizard extends Animal {

	public Lizard() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(0,0,0,0,0,0);
		
		lifespan = 10;
		minimum = 0.2;
		optimal = 0.4;
		safeRadiation = 100;
		maxRadiation = 1000;
		consumed = 1;
		combat = 5;
		
		name = "Lizard";
		mutation = "Gecko";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\lizard.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
