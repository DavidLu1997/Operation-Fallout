package tile;

//Elevation with their environment factor
public enum Elevation {
	
	LOW(0.1),
	MEDIUM(0),
	HIGH(-0.2);
	
	//Environment factor
	public final double environment;
	
	//Constructor
	Elevation(double environment)
	{
		this.environment = environment;
	}
}
