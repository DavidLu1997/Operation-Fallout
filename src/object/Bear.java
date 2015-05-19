package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bear extends Animal {

	public Bear() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(30,0.5,0.6,100,1000,5);
		
		combat = 20;
		
		name = "Bear";
		mutation = "Yao Guai";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\bear.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
