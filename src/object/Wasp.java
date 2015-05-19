/**
 * 
 */
package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author David Lu
 *
 */
public class Wasp extends Animal {

	public Wasp() {
		//super(lifespan, minimum, optimal, safeRadiation, maxRadiation, consumed);

		super(0,0,0,0,0,0);
		
		lifespan = 10;
		minimum = 0.5;
		optimal = 0.7;
		safeRadiation = 100;
		maxRadiation = 1000;
		consumed = 2;
		combat = 2;
		
		name = "Wasp";
		mutation = "Cazadore";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\wasp.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
