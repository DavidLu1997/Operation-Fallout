package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Coyote extends Animal {

	public Coyote() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(0,0,0,0,0,0);
		
		lifespan = 10;
		minimum = 0.4;
		optimal = 0.5;
		safeRadiation = 100;
		maxRadiation = 1000;
		consumed = 2;
		combat = 10;
		
		name = "Coyote";
		mutation = "Nightstalker";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\coyote.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
