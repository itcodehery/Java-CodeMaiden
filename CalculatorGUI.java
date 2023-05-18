package calculator_beta;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.event.*;
import java.util.*;
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
	
	//to evaluate in fix
	private static double evaluateInfix(String infix) {
		String postfix = new String();
	    Stack<Character> stack = new Stack<>();

	    for (char c : infix.toCharArray()) {
	        if (Character.isDigit(c)) {
	            postfix += c;
	        } else if (c == '(') {
	            stack.push(c);
	        } else if (c == ')') {
	            while (!stack.isEmpty() && stack.peek() != '(') {
	                postfix += stack.pop();
	            }
	            stack.pop(); // Discard the opening parenthesis
	        } else {
	            // Operator encountered
	            while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
	                postfix += stack.pop();
	            }
	            stack.push(c);
	        }
	    }

	    while (!stack.isEmpty()) {
	        postfix += stack.pop();
	    }
	    
	    Stack<Double> stack1 = new Stack<>();

	    for (char c : postfix.toCharArray()) {
	        if (Character.isDigit(c)) {
	            stack1.push((double) (c - '0')); // Convert char digit to double
	        } else {
	            double operand2 = stack1.pop();
	            double operand1 = stack1.pop();
	            double result = performOperation(c, operand1, operand2);
	            stack1.push(result);
	        }
	    }

	    return stack.pop();
	}
	
	private static double performOperation(char operator, double operand1, double operand2) {
	    switch (operator) {
	        case '+':
	            return operand1 + operand2;
	        case '-':
	            return operand1 - operand2;
	        case '*':
	            return operand1 * operand2;
	        case '/':
	            return operand1 / operand2;
	        default:
	            throw new IllegalArgumentException("Invalid operator: " + operator);
	    }
	}
	
	private static int getPrecedence(char operator) {
	    switch (operator) {
	        case '+':
	        case '-':
	            return 1;
	        case '*':
	        case '/':
	            return 2;
	        default:
	            return 0;
	    }
	}

	//The main calculator UI with the super frame
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
		
		// creating the equals button
		JButton equalsButton = new JButton("=");
		equalsButton.addActionListener(this);
		equalsButton.setFont(new Font("Arial", Font.BOLD,20));
		equalsButton.setBackground(Color.LIGHT_GRAY);
		equalsButton.setFocusable(false);
		//Rounded corners
		equalsButton.setBorder(compoundBorder);
		numberPanel.add(equalsButton);
		
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
	    } 
	    else if (command.equals("C")) {
	        displayField.setText("");
	    } 
	    else if (command.equals("=")) {
	    	String expression = displayField.getText();
            double result = evaluateInfix(expression);
            displayField.setText("");
            displayField.setText(String.valueOf(result));
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
