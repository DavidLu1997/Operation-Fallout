package map;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Main {
	
	//Frame
	static JFrame frame;
	
	//Tick speed
	static JSlider tick;
	
	//Information panel
	static JPanel information;
	
	//Toolbox
	static JPanel toolbox;
	
	//Main panel
	static JPanel panel;
	
	//Map
	static Map map;
	
	//Animal buttons
	static JRadioButton 
	ant, 
	bear,
	cow,
	crab,
	coyote,
	dog,
	goat,
	lizard,
	rat,
	roach,
	scorpion,
	wasp, nuke;
	
	//JButtons
	static JButton add, generate;
	
	//Textfields
	static JTextField yield, dirty;
	
	//Sets up everything
	public static void setup()
	{
		frame = new JFrame("Operation Fallout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		map = new Map();
		
		tick = new JSlider(0, 40, 5);
		tick.setMajorTickSpacing(10);
		tick.setMinorTickSpacing(5);
		tick.setPaintLabels(true);
		tick.setPaintTicks(true);
		
		generate = new JButton("Generate!");
		generate.setActionCommand("generate");
		generate.addActionListener(map);
		
		information = new JPanel();
		information.add(new JLabel("Ticks per second: "));
		information.add(tick);
		information.add(generate);
		
		ant = new JRadioButton("Ant");
		ant.setActionCommand("ant");
		ant.setSelected(true);
		
		bear = new JRadioButton("Bear");
		bear.setActionCommand("bear");
		
		cow = new JRadioButton("Cow");
		cow.setActionCommand("cow");
		
		crab = new JRadioButton("Crab");
		crab.setActionCommand("crab");
		
		coyote = new JRadioButton("Coyote");
		coyote.setActionCommand("coyote");
		
		dog = new JRadioButton("Dog");
		dog.setActionCommand("dog");
		
		goat = new JRadioButton("Goat");
		goat.setActionCommand("goat");
		
		lizard = new JRadioButton("Lizard");
		lizard.setActionCommand("lizard");
		
		rat = new JRadioButton("Rat");
		rat.setActionCommand("rat");
		
		roach = new JRadioButton("Roach");
		roach.setActionCommand("roach");
		
		scorpion = new JRadioButton("Scorpion");
		scorpion.setActionCommand("scorpion");
		
		wasp = new JRadioButton("Wasp");
		wasp.setActionCommand("wasp");
		
		nuke = new JRadioButton("Nuke");
		nuke.setActionCommand("nuke");
		
		ButtonGroup group = new ButtonGroup();
		group.add(ant);
		group.add(bear);
		group.add(cow);
		group.add(crab);
		group.add(coyote);
		group.add(dog);
		group.add(goat);
		group.add(lizard);
		group.add(rat);
		group.add(roach);
		group.add(scorpion);
		group.add(wasp);
		group.add(nuke);
		
		GridLayout grid = new GridLayout(0,1);
		
		toolbox = new JPanel();
		toolbox.setLayout(grid);
		
		toolbox.add(new JLabel("Add: "));
		toolbox.add(ant);
		toolbox.add(bear);
		toolbox.add(cow);
		toolbox.add(crab);
		toolbox.add(coyote);
		toolbox.add(dog);
		toolbox.add(goat);
		toolbox.add(lizard);
		toolbox.add(rat);
		toolbox.add(roach);
		toolbox.add(scorpion);
		toolbox.add(wasp);
		toolbox.add(nuke);
		
		JPanel dial = new JPanel();
		
		dial.add(new JLabel("Dial-A-Yield: "));
		
		yield = new JTextField(2);
		yield.setText("5");
		dial.add(yield);
		
		dial.add(new JLabel("Kt"));
		
		dial.add(new JLabel("Dirtyness: "));
		
		dirty = new JTextField(3);
		dirty.setText("100");
		dial.add(dirty);
		
		toolbox.add(dial);
		
		add = new JButton("Add!");
		add.setActionCommand("add");
		add.addActionListener(map);
		
		toolbox.add(add);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(map, BorderLayout.CENTER);
		panel.add(information, BorderLayout.PAGE_END);
		panel.add(toolbox, BorderLayout.WEST);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setSize(1200, 1200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) 
	{
		setup();
		
		//Run simulation
		while(true)
		{	
			//If value is above 0
			if(tick.getValue() != 0)
			{
				map.tick();
				
				//Delay
				try 
				{
					Thread.sleep(1000/tick.getValue());
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			
			//Otherwise, delay for 100ms before rechecking
			try 
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}

	}

}
