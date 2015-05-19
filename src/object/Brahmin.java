package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brahmin extends Cow {

	public Brahmin(){
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super();
		
		lifespan = 20;
		minimum = 0.3;
		optimal = 0.5;
		safeRadiation = 10000;
		maxRadiation = 100000;
		consumed = 2;
		combat = 8;

		name = "Brahmin";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\brahmin.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
