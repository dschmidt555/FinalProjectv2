package finalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;


public class GUI implements ActionListener {
	
BurgerFactory factory = new BurgerFactory();
	
	private JLabel burgerLabel;
	private JLabel costLabel;
	private int totalCost;
	private String stringCost;
	private JLabel descriptionLabel;
	private static String burgerType;
	
	public GUI() {
		burgerLabel = new JLabel("Burger Type: ");
		costLabel = new JLabel("Cost: ");
		descriptionLabel = new JLabel("Description: ");

	
		
		
		//Frame
		JFrame frame = new JFrame("Burger Joint");
		frame.setLayout(new GridLayout(0,2));
		
		//Drop down menus 
		String[] test = {"Regular", "Beast", "Monster"};
		JComboBox testList = new JComboBox(test);
		testList.setSelectedIndex(0);
		testList.addActionListener(new Action0());
		frame.add(testList);
		
		
		frame.add(burgerLabel);
		
		//Buttons----------------------------------------------
		JButton addSlawButton = new JButton("Add Coleslaw");
		addSlawButton.addActionListener(new Action1());
		addSlawButton.setBackground(Color.GRAY);
		frame.add(addSlawButton);
		
		JButton minusSlawButton = new JButton("Take away Slaw");
		minusSlawButton.addActionListener(new Action1());
		minusSlawButton.setBackground(Color.cyan);
		frame.add(minusSlawButton);
		
		
		
		
		JButton addFriesButton = new JButton("Add Coleslaw");
		addFriesButton.addActionListener(new Action2());
		addFriesButton.setBackground(Color.GRAY);
		frame.add(addFriesButton);
		
		JButton minusFriesButton = new JButton("Take away Slaw");
		minusFriesButton.addActionListener(new Action3());
		minusFriesButton.setBackground(Color.cyan);
		frame.add(minusFriesButton);
		
	

		//Buttons----------------------------------------------
		
		
		//Adds the bottom two labels
		frame.add(costLabel);
		frame.add(descriptionLabel);
		
		//Sets size of frame
		frame.setSize(800,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Burger Joint");
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
	
	//Method called from drop down menu
	public class Action0 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JComboBox<String> combo = (JComboBox<String>) e.getSource();
			burgerType = (String) combo.getSelectedItem();
			
			//FACTORY ===============================================================**
			
			//create the type of rocket from the factory 
			factory.createBurger(burgerType);
			//update the text labels on the GUI
			burgerLabel.setText("Burger Type: " + factory.createBurger(burgerType).description);
			
			//Update the cost
			totalCost+=factory.createBurger(burgerType).cost();
			System.out.println(totalCost);
			
			
			stringCost = String.valueOf(totalCost);
			System.out.println("String Cost: " + stringCost);
			costLabel.setText("Cost: " + stringCost);
		}
	}
	

	public class Action1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			costLabel.setText("Cost..");
					
		}
	}

	public class Action2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			costLabel.setText("Cost..");
				
		}
	}
	
	//Method to update cost, range for adding Warp Drive
	public class Action3 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			costLabel.setText("Cost..");
			
			
		}
	}

}
