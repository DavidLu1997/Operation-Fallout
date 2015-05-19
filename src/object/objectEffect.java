package object;

public class objectEffect
{
	//Type of effect
	private Effect effect;
	
	//Modifier
	private double modifier;
	
	//Name of effect
	private String name;
	
	//Duration in ticks
	private int ticks;
	
	//Constructor
	public objectEffect(Effect effect, double modifier, String name, int ticks)
	{
		this.effect = effect;
		this.modifier = modifier;
		this.name = name;
		this.ticks = ticks;
	}
	
	//Getter for effect
	public Effect effect()
	{
		return effect;
	}
	
	//Getter for modifier
	public double modifier()
	{
		return modifier;
	}
	
	//Getter for name
	public String name()
	{
		return name;
	}
	
	//Getter for ticks left
	public int ticks()
	{
		return ticks;
	}
	
	//Change ticks
	public void change(int c)
	{
		ticks += c;
	}
}
