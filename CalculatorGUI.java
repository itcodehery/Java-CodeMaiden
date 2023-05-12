package calculator_beta;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.AbstractBorder;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener{
	JTextField displayField = new JTextField();
	public CalculatorGUI() {
		//Set frame properties
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//set Border layout
		setLayout(new BorderLayout());
		
		//Creating a text field

		displayField.setEditable(false);
		add(displayField, BorderLayout.NORTH);
		
		//Create panel, border for number buttons and rounded corners
		JPanel numberPanel = new JPanel(new GridLayout(4,3));
		Border emptyBorder = new EmptyBorder(10, 10, 10, 10);
		
		//Create number buttons using a loop
		for (int i = 1;i<=9;i++) {
			JButton numberButton = new JButton(String.valueOf(i));
			numberButton.addActionListener(this);
			numberButton.setFont(new Font("Arial", Font.BOLD,20));
			numberButton.setBackground(Color.LIGHT_GRAY);
			numberButton.setFocusable(false);
			//Rounded corners
			Border roundedBorder = new RoundedBorder(15,Color.white);
			Border compoundBorder = new CompoundBorder(roundedBorder, emptyBorder);
			numberButton.setBorder(compoundBorder);
			numberPanel.add(numberButton);
		}
		
		//Creating zero button separately
		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener(this);
		zeroButton.setFont(new Font("Arial", Font.BOLD,20));
		zeroButton.setBackground(Color.LIGHT_GRAY);
		zeroButton.setFocusable(false);
		//Rounded corners
		Border roundedBorder = new RoundedBorder(15,Color.white);
		Border compoundBorder = new CompoundBorder(roundedBorder, emptyBorder);
		zeroButton.setBorder(compoundBorder);
		numberPanel.add(zeroButton);
		
		//adding number panel to the frame
		add(numberPanel, BorderLayout.CENTER);
		
		//set frame size and visibility
		setSize(300, 400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("0") || command.equals("1") || command.equals("2") || command.equals("3")
			|| command.equals("4") || command.equals("5") || command.equals("6") || command.equals("7")
			|| command.equals("8") || command.equals("9")) {
			displayField.setText(displayField.getText() + command);
		}
		else
		{
			System.out.println("Do Nothing Basically");
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				CalculatorGUI calculator = new CalculatorGUI();
				
			}
		});
	}
}
