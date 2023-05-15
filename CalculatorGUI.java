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
	
	//This method creates a Jbutton with the specified font, color and rounded corners
	private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(Color.WHITE);
        button.setFocusable(false);

        Border roundedBorder = new RoundedBorder(15, Color.BLACK);
        Border compoundBorder = new CompoundBorder(roundedBorder, new EmptyBorder(10, 10, 10, 10));
        button.setBorder(compoundBorder);

        return button;
    }
	
	private JButton createClearButton(){
        JButton button = new JButton("C");
        button.addActionListener(this);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(Color.WHITE);
        button.setFocusable(false);

        Border roundedBorder = new RoundedBorder(15, Color.BLACK);
        Border compoundBorder = new CompoundBorder(roundedBorder, new EmptyBorder(10, 10, 10, 10));
        button.setBorder(compoundBorder);

        return button;
    }
	
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
		
		//creating the operator panel
		JPanel operatorPanel = new JPanel(new GridLayout(4, 1));
        JButton addButton =  createButton("+");
        JButton subtractButton = createButton("-");
        JButton multiplyButton = createButton("*");
        JButton divideButton = createButton("/");

        operatorPanel.add(addButton);
        operatorPanel.add(subtractButton);
        operatorPanel.add(multiplyButton);
        operatorPanel.add(divideButton);
		
        //adding both panels to the frame
		add(numberPanel, BorderLayout.CENTER);
		add(operatorPanel, BorderLayout.CENTER);
		
		// creating the clear panel
		JPanel clearPanel = new JPanel(new GridLayout(1,1));
		JButton clearButton = createClearButton();
		clearPanel.add(clearButton);
		add(clearPanel, BorderLayout.CENTER);
		
		//adding a super panel: buttonPanel for all sub panels
		JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        buttonPanel.add(numberPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        buttonPanel.add(operatorPanel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        buttonPanel.add(clearPanel, gbc);

        add(buttonPanel, BorderLayout.CENTER);


		
		//set frame size and visibility
		setSize(300, 400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    String command = e.getActionCommand();

	    if (command.matches("[0-9]")) {
	        displayField.setText(displayField.getText() + command);
	    } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
	        String currentText = displayField.getText();
	        String lastChar = currentText.substring(currentText.length() - 1);	    
	        
	        // Check if the last character is an operator, replace it with the new operator
	        // 
	        if (lastChar.matches("[+\\-*/]")) {
	            currentText = currentText.substring(0, currentText.length() - 1) + command;
	        } else {
	            currentText += command;
	        }

	        displayField.setText(currentText);
	    } else if (command.equals("C")) {
	        displayField.setText("");
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
