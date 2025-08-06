package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmpayCoreUI extends JFrame {
    private JTextField nameField;
    private JTextField salaryField;
    private JComboBox<String> empTypeBox;
    private JButton processButton;
    private JTextArea outputArea;

    public EmpayCoreUI() {
        setTitle("EmpayCore - Employee Payroll System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top panel - input form
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        formPanel.add(new JLabel("Employee Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        formPanel.add(salaryField);

        formPanel.add(new JLabel("Employee Type:"));
        empTypeBox = new JComboBox<>(new String[]{"Full Time", "Part Time"});
        formPanel.add(empTypeBox);

        processButton = new JButton("Process Payroll");
        formPanel.add(processButton);

        // Output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createTitledBorder("Payroll Output"));

        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Button click action
        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String salaryStr = salaryField.getText();
                String type = (String) empTypeBox.getSelectedItem();

                if (name.isEmpty() || salaryStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                    return;
                }

                try {
                    double salary = Double.parseDouble(salaryStr);

                    // For now, just display; later connect with backend logic
                    outputArea.append("Employee: " + name + "\n");
                    outputArea.append("Type: " + type + "\n");
                    outputArea.append("Salary: ₹" + salary + "\n");
                    outputArea.append("--------------------------\n");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Salary must be a number.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmpayCoreUI().setVisible(true);
        });
    }
}

