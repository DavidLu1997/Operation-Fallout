package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Gecko extends Lizard {

	public Gecko() {
		super();
		
		lifespan = 15;
		minimum = 0.2;
		optimal = 0.4;
		safeRadiation = 1000;
		maxRadiation = 10000;
		consumed = 2;
		combat = 10;
		
		name = "Gecko";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\gecko.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
