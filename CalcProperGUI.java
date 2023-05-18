package calculator_beta;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CalcProperGUI extends JFrame implements ActionListener {
    private JTextField displayField;

    public CalcProperGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(new BorderLayout());
        displayField = new JTextField();
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        JPanel numberPanel = new JPanel(new GridLayout(4, 3));
        for (int i = 1; i <= 9; i++) {
            JButton numberButton = createButton(String.valueOf(i));
            numberPanel.add(numberButton);
        }

        JButton zeroButton = createButton("0");
        numberPanel.add(zeroButton);

        JPanel operatorPanel = new JPanel(new GridLayout(4, 1));
        JButton addButton = createButton("+");
        JButton subtractButton = createButton("-");
        JButton multiplyButton = createButton("*");
        JButton divideButton = createButton("/");
        operatorPanel.add(addButton);
        operatorPanel.add(subtractButton);
        operatorPanel.add(multiplyButton);
        operatorPanel.add(divideButton);

        JPanel clearPanel = new JPanel(new GridLayout(4, 1));
        JButton clearButton = createButton("C");
        clearPanel.add(clearButton);

        JPanel equalsPanel = new JPanel(new GridLayout(4, 1));
        JButton equalsButton = createButton("=");
        equalsPanel.add(equalsButton);

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

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        buttonPanel.add(equalsPanel, gbc);

        add(buttonPanel, BorderLayout.CENTER);

        setSize(300, 400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            displayField.setText(displayField.getText() + command);
        } else if (command.equals("=")) {
            String expression = displayField.getText();
            double result = evaluateExpression(expression);
            displayField.setText(String.valueOf(result));
        } else if (command.equals("C")) {
            displayField.setText("");
        }
    }

    private double evaluateExpression(String expression) {
        String postfix = convertToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    private String convertToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Discard the opening parenthesis
            } else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private int getPrecedence(char operator) {
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
    
    private double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Double.parseDouble(String.valueOf(c)));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(operand1, operand2, c);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private double performOperation(double operand1, double operand2, char operator) {
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

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorGUI();
            }
        });
    }
}

