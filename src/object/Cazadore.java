package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cazadore extends Wasp {

	public Cazadore() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super();
		
		lifespan = 50;
		minimum = 0.2;
		optimal = 0.5;
		safeRadiation = 10000;
		maxRadiation = 100000;
		consumed = 5;
		combat = 25;
		
		name = "Cazadore";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\cazador.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
