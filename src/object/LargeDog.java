package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LargeDog extends Dog {

	public LargeDog() {
		super();
		
		lifespan = 25;
		minimum = 0.3;
		optimal = 0.5;
		safeRadiation = 1000;
		maxRadiation = 2500;
		consumed = 5;
		combat = 12;
		
		name = "Large Dog";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\dog.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
