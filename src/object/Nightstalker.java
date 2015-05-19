package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Nightstalker extends Coyote {

	public Nightstalker() {
		super();
		
		lifespan = 30;
		minimum = 0.1;
		optimal = 0.3;
		safeRadiation = 10000;
		maxRadiation = 100000;
		consumed = 3;
		combat = 20;
		
		name = "Nightstalker";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\night_stalker.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
