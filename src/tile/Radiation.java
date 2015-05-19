package tile;

//Radiation present and it's effects
public class Radiation {
	
	//Actual rad/s count
	private int rads;
	
	//Max rads
	private final int max = 1000;
	
	//Constructor
	public Radiation(int rads)
	{
		this.rads = rads;
	}
	
	//Getter for rads
	public int rads()
	{
		return rads;
	}
	
	//Getter for max
	public int max()
	{
		return max;
	}
	
	//Calculate environment factor
	public double environment()
	{
		return -(double)rads/max;
	}
	
	//Irradiates
	public void irradiate(int rads)
	{
		this.rads += rads;
		
		//Bounds checking
		if(this.rads > max)
			this.rads = max;
		
		//Bounds checking
		if(this.rads < 0)
			this.rads = 0;
	}
	
	//Deradiate
	public void deradiate(int rads)
	{
		this.rads -= rads;
		
		//Bounds checking
		if(this.rads > max)
			this.rads = max;
		
		//Bounds checking
		if(this.rads < 0)
			this.rads = 0;
	}
}
