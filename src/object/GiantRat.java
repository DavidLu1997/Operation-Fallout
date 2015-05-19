package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GiantRat extends Rat {

	public GiantRat() {
		super();
		
		lifespan = 10;
		minimum = 0.1;
		optimal = 0.3;
		safeRadiation = 1000;
		maxRadiation = 100000;
		consumed = 2;
		combat = 6;
		
		name = "Giant Rat";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\giant_rat.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
