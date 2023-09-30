import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame implements ActionListener {
    private JTextField textField;

    // Constructor
    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create text field
        textField = new JTextField();
        textField.setBounds(50, 50, 280, 30);
        add(textField);

        // Create buttons and set up their positions
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sin", "cos", "tan", "C",
                "<"
        };

        int x = 50, y = 100, w = 80, h = 50, padding = 10;

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            button.setBounds(x, y, w, h);
            add(button);

            x += w + padding;
            if (x > 250) {
                x = 50;
                y += h + padding;
            }
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();
        if (command.equals("=")) {
            String expression = textField.getText();
            // Implement evaluation logic here
            // You might use a library or implement your own evaluator
        } else if (command.equals("C")) {
            textField.setText("");
        } else if (command.equals("<")) {
            String text = textField.getText();
            if (!text.isEmpty()) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        } else if (command.equals("sin") || command.equals("cos") || command.equals("tan")) {
            // Implement trigonometric function logic here
        } else {
            textField.setText(textField.getText() + command);
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
