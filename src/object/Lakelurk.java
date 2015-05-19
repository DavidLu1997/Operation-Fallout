package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Lakelurk extends Crab {

	public Lakelurk() {
		super();
		
		lifespan = 50;
		minimum = 0.3;
		optimal = 0.5;
		safeRadiation = 10000;
		maxRadiation = 100000;
		consumed = 3;
		combat = 15;
		
		name = "Lakelurk";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\lakelurk.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
