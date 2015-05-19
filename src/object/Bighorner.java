package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bighorner extends Goat {

	public Bighorner() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super();
		
		lifespan = 10;
		minimum = 0.3;
		optimal = 0.5;
		safeRadiation = 10000;
		maxRadiation = 100000;
		consumed = 4;
		combat = 20;
		
		name = "Bighorner";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\bighorner.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
