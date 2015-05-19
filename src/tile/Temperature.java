package tile;

//Temperature of tile
public class Temperature {
	
	//Actual temperature, ranges from -273.15 to practically infinity
	private double temperature;
	
	//Constructor
	public Temperature(double temperature)
	{
		this.temperature = temperature;
	}
	
	//Getter for temperature
	public double temperature()
	{
		return temperature;
	}
	
	//Heat
	public void heat(double heat)
	{
		temperature += heat;
		
		//Bounds checking
		if(temperature < 273.15)
			temperature = 273.15;
	}
	
	//Cool
	public void cool(double cool)
	{
		temperature -= cool;
		
		//Bounds checking
		if(temperature < 273.15)
			temperature = 273.15;
	}
}
