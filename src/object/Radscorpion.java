package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Radscorpion extends Scorpion {

	public Radscorpion() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super();
		
		lifespan = 25;
		minimum = 0.1;
		optimal = 0.3;
		safeRadiation = 10000;
		maxRadiation = 100000;
		consumed = 3;
		combat = 10;
		
		name = "Radscorpion";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\radscorpion.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
