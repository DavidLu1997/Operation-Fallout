package tile;

//Biomes with their environment factor
public enum Biome{

	DESERT(0.1),
	GRASSLAND(0.4),
	FOREST(0.5),
	OCEAN(0.1),
	TUNDRA(0.2);
	
	//Environment factor of a particular tile, 0-1
	public final double environment;
	
	//Constructor
	Biome(double environment)
	{
		this.environment = environment;
	}
}
