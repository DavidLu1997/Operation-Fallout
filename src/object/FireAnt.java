package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FireAnt extends Ant {

	public FireAnt() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super();
		
		lifespan = 25;
		minimum = 0.2;
		optimal = 0.5;
		safeRadiation = 10000;
		maxRadiation = 100000;
		consumed = 2;
		combat = 10;
		
		name = "Fire Ant";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\fire_ant.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
