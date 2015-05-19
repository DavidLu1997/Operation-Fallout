package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ant extends Animal {

	public Ant() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(5,0.1,0.3,10,100,1);
		
		combat = 2;
		
		name = "Ant";
		mutation = "Fire Ant";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\ant.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
