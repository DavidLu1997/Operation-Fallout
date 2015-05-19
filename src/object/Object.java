package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//Abstract class for object
public abstract class Object {
	
	//Combat power of the object
	protected int combat;
	
	//Age of object
	protected int age;
	
	//Radiation received by the object
	protected int radiation;
	
	//Location of object
	protected Location location;
	
	//Effects on object
	protected ArrayList<objectEffect> effects;
	
	//Image of object
	protected BufferedImage image;
	
	//Name of object
	protected String name = new String();
	
	//Mutates into
	protected String mutation = new String();
	
	//Survive, checks if organism will survive
	public abstract boolean survive(double environment);
	
	//Mutate, checks if organism will mutate
	public abstract boolean mutate(double environment);
	
	//Action, performs action of organism
	public abstract void action();

	//Show method, displays object on given graphics panel
	public void show(Graphics g, int x, int y)
	{
		g.drawImage(image, x, y, null);
	}
	
	//Irradiate
	public void irradiate(int rads)
	{
		radiation += rads;
	}
	
	//Modify combat power
	public void strengthen(int amount)
	{
		combat += amount;
	}
	
	//Modify age
	public void age(int ticks)
	{
		age += ticks;
	}
	
	//MoveTo to a new location
	public void moveTo(Location l)
	{
		location = l;
	}
	
	//Getter for combat power
	public int getCombat()
	{
		return combat;
	}
	
	//Getter for age
	public int getAge()
	{
		return age;
	}
	
	//Getter for radiation
	public int getRadiation()
	{
		return radiation;
	}
	
	//Getter for effects
	public ArrayList<objectEffect> getEffects()
	{
		return effects;
	}
	
	//toString
	public String toString()
	{
		return name;
	}
	
	//Get mutation
	public String mutation()
	{
		return mutation;
	}
}
