package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Radroach extends Cockroach {

	public Radroach() {
		super();
		
		lifespan = 5;
		minimum = 0.1;
		optimal = 0.3;
		safeRadiation = 1000;
		maxRadiation = 10000;
		consumed = 1;
		combat = 4;
		
		name = "Radroach";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\radroach.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
