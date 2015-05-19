package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cockroach extends Animal {

	public Cockroach() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(0,0,0,0,0,0);
		
		lifespan = 2;
		minimum = 0.1;
		optimal = 0.3;
		safeRadiation = 10;
		maxRadiation = 100;
		consumed = 1;
		combat = 2;
		
		name = "Cockroach";
		mutation = "Radroach";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\cockroach.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
