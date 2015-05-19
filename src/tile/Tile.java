package tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import object.Animal;
import object.Object;
import object.objectEffect;

//Tile, used to represent basic tiles
//Programmed primarily by: David Lu
public class Tile {

	//Biome
	private Biome biome;
	
	//Elevation
	private Elevation elevation;
	
	//Radiation
	private Radiation radiation;
	
	//Temperature
	private Temperature temperature;
	
	//Objects
	private ArrayList<Animal> objects;
	
	//Effects on tile
	protected ArrayList<tileEffect> effects;
	
	//Image
	private BufferedImage image;
	
	//Constructor
	public Tile(Biome biome, Elevation elevation, Radiation radiation, Temperature temperature)
	{
		this.biome = biome;
		this.elevation = elevation;
		this.radiation = radiation;
		this.temperature = temperature;
		
		effects = new ArrayList<tileEffect>();
		
		this.objects = new ArrayList<Animal>();
		
		switch(biome)
		{
		case DESERT:
			//Load image
			try 
			{
				this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\desert.png"));
			}
			catch (IOException e) 
			{
				System.out.println("Invalid path.");
			}
			break;
		case GRASSLAND:
			//Load image
			try 
			{
				this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\grassland.png"));
			}
			catch (IOException e) 
			{
				System.out.println("Invalid path.");
			}
			break;
		case FOREST:
			//Load image
			try 
			{
				this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\forest.png"));
			}
			catch (IOException e) 
			{
				System.out.println("Invalid path.");
			}
			break;
		case OCEAN:
			//Load image
			try 
			{
				this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\ocean.png"));
			}
			catch (IOException e) 
			{
				System.out.println("Invalid path.");
			}
			break;
		case TUNDRA:
			//Load image
			try 
			{
				this.image = (BufferedImage) ImageIO.read(new File("src\\fallout\\tundra.png"));
			}
			catch (IOException e) 
			{
				System.out.println("Invalid path.");
			}
			break;
		}
	}
	
	//Draw
	public void draw(Graphics g, int x, int y)
	{
		g.drawImage(image, x, y, 100, 100, Color.WHITE, null);
	}
	
	//Updates the objects on this tile
	public void update(ArrayList<Animal> objects)
	{
		this.objects = objects;
	}
	
	//Get objects
	public ArrayList<Animal> getObjects()
	{
		return objects;
	}
	
	//Get effects
	public ArrayList<tileEffect> getEffects()
	{
		return effects;
	}
	
	//Getter for biome
	public Biome getBiome()
	{
		return biome;
	}
	
	//Getter for elevation
	public Elevation getElevation()
	{
		return elevation;
	}
	
	//Getter for radiation
	public Radiation getRadiation()
	{
		return radiation;
	}
	
	//Getter for temperature
	public Temperature getTemperature()
	{
		return temperature;
	}
	
	//Get environment factor
	public double environment()
	{
		return biome.environment + elevation.environment + radiation.environment();
	}
	
	//Irradiate
	public void irradiate(int rads)
	{
		radiation.irradiate(rads);
	}
	
	//Deradiate
	public void deradiate(int rads)
	{
		radiation.deradiate(rads);
	}
	
	//Heat
	public void heat(double degrees)
	{
		temperature.heat(degrees);
	}
	
	//Cool
	public void cool(double degrees)
	{
		temperature.cool(degrees);
	}
}
