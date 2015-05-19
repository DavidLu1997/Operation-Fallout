package object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class YaoGuai extends Bear {

	public YaoGuai() {
		super();
		
		lifespan = 50;
		minimum = 0.3;
		optimal = 0.5;
		safeRadiation = 1000;
		maxRadiation = 10000;
		consumed = 5;
		combat = 24;
		
		name = "Yao Guai";
		mutation = "";
		
		//Load image
		try 
		{
			this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\yao_guai.png"));
		}
		catch (IOException e) 
		{
			System.out.println("Invalid path.");
		}
	}

}
