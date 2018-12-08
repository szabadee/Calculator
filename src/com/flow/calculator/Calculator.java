package com.flow.calculator;

import javax.swing.*;

public class Calculator extends JFrame {
    private JLabel label;
    private JButton button;
    private JTextField inputLeft;
    private JTextField inputRight;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        add(contentPanel);

        JTextField inputLeft = new JTextField();
        inputLeft.setBounds(10,10,135,30);
        contentPanel.add(inputLeft);

        JTextField inputRight = new JTextField();
        inputRight.setBounds(155,10,135,30);
        contentPanel.add(inputRight);

        JButton button = new JButton("Calculate");
        button.setBounds(150, 160, 90, 40);
        contentPanel.add(button);

        JRadioButton sum = new JRadioButton("Sum");
        sum.setBounds(10,50,70,30);
        sum.setSelected(true);
        contentPanel.add(sum);

        JRadioButton sub = new JRadioButton("Sub");
        sub.setBounds(80,50,70,30);
        sum.setSelected(true);
        contentPanel.add(sub);

        JRadioButton div = new JRadioButton("Div");
        div.setBounds(140,50,70,30);
        sum.setSelected(true);
        contentPanel.add(div);

        JRadioButton multi = new JRadioButton("Multi");
        multi.setBounds(200,50,70,30);
        sum.setSelected(true);
        contentPanel.add(multi);

        ButtonGroup group = new ButtonGroup();
        group.add(sum);
        group.add(sub);
        group.add(div);
        group.add(multi);

        JLabel resultLabel = new JLabel("Result");
        resultLabel.setBounds(100,120,70,30);
        contentPanel.add(resultLabel);

        JTextField resultField = new JTextField();
        resultField.setBounds(155,120,135,30);
        contentPanel.add(resultField);

        button.addActionListener (e -> {
            try {
                String.valueOf(Integer.parseInt(inputLeft.getText()));
                String.valueOf(Integer.parseInt(inputRight.getText()));
                if (sum.isSelected()) {
                    resultField.setText(String.valueOf(Integer.parseInt(inputLeft.getText()) + (Integer.parseInt(inputRight.getText()))));
                } else if (sub.isSelected()) {
                    resultField.setText(String.valueOf(Integer.parseInt(inputLeft.getText()) - (Integer.parseInt(inputRight.getText()))));
                } else if (div.isSelected()) {
                    resultField.setText(String.valueOf(Integer.parseInt(inputLeft.getText()) / (Integer.parseInt(inputRight.getText()))));
                } else {
                    resultField.setText(String.valueOf(Integer.parseInt(inputLeft.getText()) * (Integer.parseInt(inputRight.getText()))));
                }
            } catch (NumberFormatException err) {
                resultField.setText("Invalid value");
            }
        });
    }

}
