import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BMICalculator1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        JLabel heightLabel = new JLabel("Enter your height (m):");
        JTextField heightField = new JTextField();
        JLabel weightLabel = new JLabel("Enter your weight (kg):");
        JTextField weightField = new JTextField();
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel();

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double height = Double.parseDouble(heightField.getText());
                    double weight = Double.parseDouble(weightField.getText());

                    double bmi = calculateBMI(weight, height);
                    String bmiCategory = interpretBMI(bmi);

                    resultLabel.setText("Your BMI: " + String.format("%.2f", bmi) + " (" + bmiCategory + ")");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter valid values.");
                }
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(heightLabel)
                .addComponent(weightLabel)
                .addComponent(calculateButton));
        hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(heightField)
                .addComponent(weightField)
                .addComponent(resultLabel));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(heightLabel)
                .addComponent(heightField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(weightLabel)
                .addComponent(weightField));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(calculateButton)
                .addComponent(resultLabel));
        layout.setVerticalGroup(vGroup);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static String interpretBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
