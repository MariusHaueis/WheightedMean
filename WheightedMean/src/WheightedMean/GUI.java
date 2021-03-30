package WheightedMean;
/**
 * This class represents the GUI of this project.
 * @author Marius Haueis
 * @version 30.03.2021
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class GUI {
	private JFrame frame;
	private JPanel panel;
	private JTextField input;
	private JTextField input2;
	private JButton exitButton;
	ArrayList<Integer> list = new ArrayList<Integer>(51);
	ArrayList<Integer> list2 = new ArrayList<Integer>(51);
	
	
	public GUI() {
	//Set up
	WeightedMeanCalculator calculator = new WeightedMeanCalculator();
	frame = new JFrame();
	panel = new JPanel();

	//Buttons and input fields
	exitButton = new JButton("Start");
	exitButton.setFont(new Font("SansSerif", Font.BOLD, 50));
	input = new JTextField("Input numerator here", 51);
	input.setFont(new Font("SansSerif", Font.BOLD, 25));
	input2 = new JTextField("Input denominator here", 51);
	input2.setFont(new Font("SansSerif", Font.BOLD, 25));
	
	
		//Panel settings
		panel.setBorder(BorderFactory.createEmptyBorder(40, 80, 80, 80));
		panel.setLayout(new GridLayout(0, 1)); 		
		panel.setLayout(new GridLayout(0, 1));
		panel.add(exitButton);
		panel.add(input); 
		panel.add(input2); 
		
		exitButton.addActionListener(e -> {
			if (e.getSource() == exitButton) {			
				int n = Integer.parseInt(input.getText().trim());
				int k = Integer.parseInt(input2.getText().trim());				
					 while (n > 0) {
				            list.add(n % 10);
				            n = n / 10;
				}
					 while (k > 0) {
				            list2.add(k % 10);
				            k = k / 10;
				}		
				calculator.weightedMean(list, list2);				
		}
		});
		
		frame.setSize(800, 400);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Quartiles");
		frame.setVisible(true);	
}
}
