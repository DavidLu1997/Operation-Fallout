package object;

import java.awt.Graphics;
import java.util.ArrayList;

public class Animal extends Object {
	
	//Lifespan
	protected int lifespan;
	
	//Minimum environment factor to survive
	protected double minimum;
		
	//Optimal environment factor to allow growth
	protected double optimal;
		
	//Minimum radiation before mutation starts
	protected int safeRadiation;
		
	//Maximum radiation tolerated before death
	protected int maxRadiation;
	
	//Minimum other combat power consumed per turn
	protected int consumed;
	
	//Amount of CP eaten
	protected int eaten;
	
	//Constructor
	public Animal(int lifespan, double minimum, double optimal, int safeRadiation, int maxRadiation, int consumed)
	{
		this.lifespan = lifespan;
		this.minimum = minimum;
		this.optimal = optimal;
		this.safeRadiation = safeRadiation;
		this.maxRadiation = maxRadiation;
		this.consumed = consumed;
		this.eaten = 0;
		this.effects = new ArrayList<objectEffect>();
	}

	@Override
	public boolean survive(double environment)
	{
		age(1);
		
		return age < lifespan && radiation < maxRadiation;
	}

	@Override
	public boolean mutate(double environment) 
	{
		//Doubles safe and max radiation if radiation within parameters for mutation
		if(radiation > safeRadiation && radiation <= maxRadiation)
		{
					
			return true;
		}
				
		return false;
	}
	
	//Eating stuff
	public void eat(int cp)
	{
		eaten += cp;
	}

	@Override
	public void action() 
	{
		
	}
	
	//Getter for eaten
	public int getEaten()
	{
		return eaten;
	}
	
	//Get consumed
	public int consumed()
	{
		return consumed;
	}
}
