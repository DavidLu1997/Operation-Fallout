package map;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import tile.Biome;
import tile.Elevation;
import tile.Radiation;
import tile.Temperature;
import tile.Tile;
import tile.tileEffect;
import tile.Effect;
import object.*;
import object.Object;

public class Map extends JPanel implements MouseListener, ActionListener{

	//Arraylist of tiles
	ArrayList< ArrayList <Tile> > tiles;
	
	//Length
	public final int length = 10;
	
	//Width
	public final int width = 10;
	
	//Background radiation
	public final int backgroundRadiation = 100;
	
	//Temperature range
	public final int highTemperature = 50;
	
	//Temperature range
	public final int lowTemperature = -30;
	
	//Selection
	private Tile selected = null;
	
	//SelectedX
	private int selectedX = 0;
	
	//SelectedY
	private int selectedY = 0;
	
	//Tiles to show in a square
	private int square = 10;
	
	//Pixels per tile
	private int pixels = 100;
	
	//Biomes
	private final Biome[] biomes = {Biome.DESERT, Biome.GRASSLAND, Biome.FOREST, Biome.OCEAN, Biome.TUNDRA};
			
	//Elevations
	private final Elevation[] elevations = {Elevation.LOW, Elevation.MEDIUM, Elevation.HIGH};
	
	//Default constructor, generates random map
	public Map()
	{
		
		//public Tile(Biome biome, Elevation elevation, Radiation radiation, Temperature temperature)
		
		//Assign tiles
		tiles = new ArrayList<ArrayList<Tile>>();
		
		//Randomize tiles
		for(int i = 0; i < width; i++)
		{
			tiles.add(new ArrayList<Tile>());
			
			for(int j = 0; j < length; j++)
			{
				tiles.get(i).add( new Tile(
						biomes[(int)(Math.random() * biomes.length)], 
						elevations[(int)(Math.random() * elevations.length)], 
						new Radiation((int)(Math.random() * backgroundRadiation)), 
						new Temperature( (Math.random() * (highTemperature + lowTemperature)) + lowTemperature) ) );
			}
			
			System.out.println("Loading...");
		}
		
		selectedX = length/2;
		selectedY = width/2;
		
		selected = tiles.get(selectedX).get(selectedY);
		
		addMouseListener(this);
	}
	
	//Processes one tick of the map
	public void tick()
	{
		//Temp tile array
		ArrayList< ArrayList <Tile> > temp = tiles;
		
		//Go through each tile
		for(int i = 0; i < tiles.size(); i ++)
		{
			for(int j = 0; j < tiles.get(i).size(); j ++)
			{
				//Process effects
				temp.get(i).add(j, processEffects(tiles.get(i).get(j)));
				temp.get(i).remove(j);
			}
		}
		
		//Go through each tile
		for(int i = 0; i < tiles.size(); i ++)
		{
			for(int j = 0; j < tiles.get(i).size(); j ++)
			{
				//Process objects
				temp.get(i).add(j, processObjects(tiles.get(i).get(j)));
				temp.get(i).remove(j);
			}
		}
		
		//Check for conflict
		for(int i = 0; i < tiles.size(); i ++)
		{
			for(int j = 0; j < tiles.get(i).size(); j++)
			{
				while(tiles.get(i).get(j).getObjects().size() > 1)
				{
					double rand = Math.random();
					
					//Randomized combat
					if(tiles.get(i).get(j).getObjects().get(0).getCombat() > tiles.get(i).get(j).getObjects().get(1).getCombat() && rand < Math.random())
					{
						tiles.get(i).get(j).getObjects().get(0).eat(tiles.get(i).get(j).getObjects().get(1).getCombat());
						tiles.get(i).get(j).getObjects().remove(1);
					}
					else
					{
						tiles.get(i).get(j).getObjects().get(1).eat(tiles.get(i).get(j).getObjects().get(0).getCombat());
						tiles.get(i).get(j).getObjects().remove(0);
					}
				}
			}
		}
		
		//Movement
		for(int i = 0; i < tiles.size(); i ++)
		{
			for(int j = 0; j < tiles.get(i).size(); j ++)
			{
				for(int k = 0; k < tiles.get(i).get(j).getObjects().size(); k++)
				{
					//Moves one block in a random direction
					int direction = (int)(Math.random()*4);
					
					switch(direction)
					{
					//Left
					case 0:
						tiles.get(i).get(j).getObjects().get(k).moveTo(new Location(i-1, j));
						if(i-1 < 0)
							break;
						tiles.get(max(0, i-1)).get(j).getObjects().add(tiles.get(i).get(j).getObjects().get(k));
						break;
					//Right
					case 1:
						tiles.get(i).get(j).getObjects().get(k).moveTo(new Location(i+1, j));
						if(i+1 == tiles.size())
							break;
						tiles.get(min(tiles.size()-1, i+1)).get(j).getObjects().add(tiles.get(i).get(j).getObjects().get(k));
						break;
					//Up
					case 2:
						tiles.get(i).get(j).getObjects().get(k).moveTo(new Location(i, j-1));
						if(j-1 < 0)
							break;
						tiles.get(i).get(max(0, j-1)).getObjects().add(tiles.get(i).get(j).getObjects().get(k));
						break;
					//Down
					case 3:
						tiles.get(i).get(j).getObjects().get(k).moveTo(new Location(i, j-1));
						if(j+1 == tiles.get(i).size())
							break;
						tiles.get(i).get(min(tiles.get(i).size()-1, j+1)).getObjects().add(tiles.get(i).get(j).getObjects().get(k));
						break;
					}
				}
			}
		}
		
		Main.frame.validate();
		Main.frame.repaint();
	}
	
	//Processes effects given a tile
	private Tile processEffects(Tile t)
	{
		//For each effect
		for(int i = 0; i < t.getEffects().size(); i++)
		{
			//If no ticks left, skip and remove
			if(t.getEffects().get(i).ticks() <= 0)
			{
				t.getEffects().remove(i);
				i--;
				continue;
			}
			
			//Switch for different effect type
			switch(t.getEffects().get(i).effect())
			{
			case RADIATION:
				t.irradiate((int) t.getEffects().get(i).modifier());
				break;
				
			case TEMPERATURE:
				t.heat(t.getEffects().get(i).modifier());
				break;
			}
			
			//Reduce by one tick
			t.getEffects().get(i).change(-1);
		}
		
		//For each object
		for(int i = 0 ; i < t.getObjects().size(); i++)
		{
			//For each effect
			for(int j = 0; j < t.getObjects().get(i).getEffects().size(); j++)
			{
				
				//If no ticks left, skip and remove
				if(t.getObjects().get(i).getEffects().get(i).ticks() <= 0)
				{
					t.getEffects().remove(i);
					i--;
					continue;
				}
				
				//Switch effect type
				switch(t.getObjects().get(i).getEffects().get(i).effect())
				{
				case COMBAT:
					t.getObjects().get(i).strengthen((int) t.getObjects().get(i).getEffects().get(i).modifier());
					break;
				case RADIATION:
					t.getObjects().get(i).irradiate((int) t.getObjects().get(i).getEffects().get(i).modifier());
					break;
				case AGE:
					t.getObjects().get(i).age((int) t.getObjects().get(i).getEffects().get(i).modifier());
					break;
				}
				
				//Reduce by one tick
				t.getObjects().get(i).getEffects().get(i).change(-1);
			}
		}
		
		return t;
	}
	
	//Processes objects given a tile
	private Tile processObjects(Tile t)
	{
		//For each object
		for(int i = 0 ; i < t.getObjects().size(); i++)
		{
			//Add radiation
			t.getObjects().get(i).irradiate(t.getRadiation().rads());
			
			//Survival
			if(!t.getObjects().get(i).survive(t.environment()))
				t.getObjects().remove(i);
			
			//Mutation
			else if(t.getObjects().get(i).mutate(t.environment()))
			{
				Animal object = null;
				
				//Mutation tables
				switch(t.getObjects().get(i).mutation())
				{
				case "Cazadore":
					object = new Cazadore();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Radscorpion":
					object = new Radscorpion();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Large Dog":
					object = new LargeDog();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Fire Ant":
					object = new FireAnt();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Brahmin":
					object = new Brahmin();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Lakelurk":
					object = new Lakelurk();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Bighorner":
					object = new Bighorner();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Giant Rat":
					object = new GiantRat();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Nightstalker":
					object = new Nightstalker();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Radroach":
					object = new Radroach();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Gecko":
					object = new Gecko();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				case "Yao Guai":
					object = new YaoGuai();
					t.getObjects().add(object);
					t.getObjects().remove(i);
					i--;
					break;
				}
			}
			
			//Action
			else
			{
				t.getObjects().get(i).action();
				
				//Reproduction
				if(t.getObjects().get(i).getEaten() >= t.getObjects().get(i).consumed())
				{
					Animal baby = t.getObjects().get(i);
					
					t.getObjects().add(baby);
				}
			}
		}
		
		return t;
	}
	
	//Adds a column of tiles at the front, randomized
	private void addFrontColumn()
	{
		for(int i = 0; i < tiles.size(); i++)
		{
			tiles.get(i).add(0, new Tile(
					biomes[(int)(Math.random() * biomes.length)], 
					elevations[(int)(Math.random() * elevations.length)], 
					new Radiation((int)(Math.random() * backgroundRadiation)), 
					new Temperature( (Math.random() * (highTemperature + lowTemperature)) + lowTemperature) ) );
		}
	}
	
	//Adds a column of tiles at the bottom, randomized
	private void addEndColumn()
	{
		for(int i = 0; i < tiles.size(); i++)
		{
			tiles.get(i).add( new Tile(
					biomes[(int)(Math.random() * biomes.length)], 
					elevations[(int)(Math.random() * elevations.length)], 
					new Radiation((int)(Math.random() * backgroundRadiation)), 
					new Temperature( (Math.random() * (highTemperature + lowTemperature)) + lowTemperature) ) );
		}
	}
	
	//Adds a row of tiles at the top, randomized
	private void addTopRow()
	{
		tiles.add(0, new ArrayList<Tile>(tiles.get(1).size()));
		
		for(int i = 0; i < tiles.get(1).size(); i++)
		{
			tiles.get(0).add( new Tile(
					biomes[(int)(Math.random() * biomes.length)], 
					elevations[(int)(Math.random() * elevations.length)], 
					new Radiation((int)(Math.random() * backgroundRadiation)), 
					new Temperature( (Math.random() * (highTemperature + lowTemperature)) + lowTemperature) ) );
		}
	}
	
	//Adds a row of tiles at the bottom, randomized
	private void addBottomRow()
	{
		tiles.add( new ArrayList<Tile>(tiles.get(0).size()));
		
		for(int i = 0; i < tiles.get(0).size(); i++)
		{
			tiles.get(tiles.size()-1).add( new Tile(
					biomes[(int)(Math.random() * biomes.length)], 
					elevations[(int)(Math.random() * elevations.length)], 
					new Radiation((int)(Math.random() * backgroundRadiation)), 
					new Temperature( (Math.random() * (highTemperature + lowTemperature)) + lowTemperature) ) );
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		switch(arg0.getActionCommand())
		{
		case "add":
			if(Main.ant.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Ant());
			}
			
			if(Main.bear.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Bear());
			}
			
			if(Main.cow.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Cow());
			}
			
			if(Main.crab.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Crab());
			}
			
			if(Main.coyote.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Coyote());
			}
			
			if(Main.dog.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Dog());
			}
			
			if(Main.goat.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Goat());
			}
			
			if(Main.lizard.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Lizard());
			}
			
			if(Main.rat.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Rat());
			}
			
			if(Main.roach.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Cockroach());
			}
			
			if(Main.scorpion.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Scorpion());
			}
			
			if(Main.wasp.isSelected())
			{
				tiles.get(selectedX).get(selectedY).getObjects().add( new Wasp());
			}
			
			if(Main.nuke.isSelected())
			{
				
				int nukeRadius = Integer.parseInt(Main.yield.getText());
				
				int radiation = Integer.parseInt(Main.dirty.getText());
				
				for(int i = max(0, selectedX - nukeRadius/2); i < min(tiles.size(), selectedX + nukeRadius/2); i++)
				{
					for(int j = max(0, selectedY - nukeRadius/2); j < min(tiles.get(i).size(), selectedY + nukeRadius/2); j++)
					{
						tiles.get(i).get(j).getEffects().add(new tileEffect(Effect.RADIATION, (double)radiation, "NUKE", 5));
					}
				}
			}
			
			Main.tick.setValue(0);
			
			Main.frame.validate();
			Main.frame.repaint();
			break;
			
		case "generate":
			
			//Assign tiles
			tiles = new ArrayList<ArrayList<Tile>>();
			
			//Randomize tiles
			for(int i = 0; i < width; i++)
			{
				tiles.add(new ArrayList<Tile>());
				
				for(int j = 0; j < length; j++)
				{
					tiles.get(i).add( new Tile(
							biomes[(int)(Math.random() * biomes.length)], 
							elevations[(int)(Math.random() * elevations.length)], 
							new Radiation((int)(Math.random() * backgroundRadiation)), 
							new Temperature( (Math.random() * (highTemperature + lowTemperature)) + lowTemperature) ) );
				}
				
				System.out.println("Loading...");
			}
			
			selectedX = length/2;
			selectedY = width/2;
			
			selected = tiles.get(selectedX).get(selectedY);
			
			Main.tick.setValue(0);
			
			Main.frame.validate();
			Main.frame.repaint();
			
			break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		//Get coordinates
		int x = arg0.getX();
		int y = arg0.getY();
		
		//Integer division to truncate
		x = x/pixels;
		y = y/pixels;
		
		if(x >= tiles.size())
			addBottomRow();
		if(x <= 0)
			addTopRow();
		if(y >= tiles.get(x).size())
			addEndColumn();
		if(y <= 0)
			addFrontColumn();
		
		//Update selection
		selectedX = selectedX + (x - selectedX);
		selectedY = selectedY + (y - selectedY);
		
		selected = tiles.get(selectedX).get(selectedY);
		
		Main.frame.validate();
		Main.frame.repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	//Paintcomponent
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int x = 0, y = 0;
		
		//Draw each displayable square
		for(int i = max(0, selectedX - square/2); i < min(tiles.size(), max(selectedX + square/2, square)); i ++)
		{
			for(int j = max(0, selectedY - square/2); j < min(tiles.get(i).size(), max(selectedY + square/2, square)); j++)
			{
				tiles.get(i).get(j).draw(g, x * pixels, y * pixels);
				
				//Draw each object on a tile
				for(int k = 0 ; k < tiles.get(i).get(j).getObjects().size(); k++)
				{
					tiles.get(i).get(j).getObjects().get(k).show(g, x * pixels, y * pixels);
				}
				
				//If it selected
				if(selectedX == i && selectedY == j)
				{
					g.drawRect(x * pixels, y * pixels, 100, 100);
				}
				
				y++;
			}
			
			x++;
			y=0;
		}
	}

	private int min(int i, int j) {
		if(i<j)
			return i;
		else
			return j;
	}

	private int max(int i, int j) {
		if(i>j)
			return i;
		else
			return j;
	}

}
