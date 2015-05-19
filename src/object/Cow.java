package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cow extends Animal {

	public Cow() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(0,0,0,0,0,0);
		
		lifespan = 10;
		minimum = 0.5;
		optimal = 0.7;
		safeRadiation = 100;
		maxRadiation = 1000;
		consumed = 2;
		combat = 5;

		name = "Cow";
		mutation = "Brahmin";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\cow.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
