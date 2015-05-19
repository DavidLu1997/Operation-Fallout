package object;

//Location class, stores location and related methods
public class Location {
	
	//X
	private int x;
	
	//Y
	private int y;
	
	//Grid size in pixels
	public final int GRID = 20;
	
	//Constructor
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//Getter for x
	public int x()
	{
		return x;
	}
	
	//Getter for y
	public int y()
	{
		return y;
	}
	
	//Distance to another location
	public int distance(Location l)
	{
		return Math.abs(l.x() - x) + Math.abs(l.y() - y);
	}
}
