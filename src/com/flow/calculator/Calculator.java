package com.flow.calculator;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class Calculator extends JFrame {
    private JLabel label;
    private JButton button;
    private JTextField inputLeft;
    private JTextField inputRight;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 240);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        add(contentPanel);

        JTextField inputLeft = new JTextField();
        inputLeft.setBounds(10,10,130,30);
        contentPanel.add(inputLeft);

        JLabel operationLabel = new JLabel("+");
        operationLabel.setBounds(145,10,30,30);
        contentPanel.add(operationLabel);

        JTextField inputRight = new JTextField();
        inputRight.setBounds(160,10,130,30);
        contentPanel.add(inputRight);

        JButton button = new JButton("Calculate");
        button.setBounds(160, 160, 130, 40);
        contentPanel.add(button);

        JRadioButton sum = new JRadioButton("Sum");
        sum.setBounds(10,50,70,30);
        sum.setSelected(true);
        contentPanel.add(sum);
        sum.addActionListener(e -> {
            if (sum.isSelected()); {
                operationLabel.setText("+");
            }
        });

        JRadioButton sub = new JRadioButton("Sub");
        sub.setBounds(80,50,70,30);
        sum.setSelected(true);
        contentPanel.add(sub);
        sub.addActionListener(e -> {
            if (sum.isSelected()); {
                operationLabel.setText("-");
            }
        });

        JRadioButton div = new JRadioButton("Div");
        div.setBounds(150,50,70,30);
        sum.setSelected(true);
        contentPanel.add(div);
        div.addActionListener(e -> {
            if (sum.isSelected()); {
                operationLabel.setText("/");
            }
        });

        JRadioButton multi = new JRadioButton("Multi");
        multi.setBounds(220,50,70,30);
        sum.setSelected(true);
        contentPanel.add(multi);
        multi.addActionListener(e -> {
            if (sum.isSelected()); {
                operationLabel.setText("*");
            }
        });

        ButtonGroup group = new ButtonGroup();
        group.add(sum);
        group.add(sub);
        group.add(div);
        group.add(multi);

        JLabel errorLabel = new JLabel();
        errorLabel.setBounds(15,165,130,30);
        contentPanel.add(errorLabel);
        errorLabel.setForeground(Color.RED);

        JLabel resultLabel = new JLabel("Result");
        resultLabel.setBounds(115,120,70,30);
        contentPanel.add(resultLabel);

        JTextField resultField = new JTextField();
        resultField.setBounds(160,120,130,30);
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
                    try {
                        resultField.setText(String.valueOf(Integer.parseInt(inputLeft.getText()) / (Integer.parseInt(inputRight.getText()))));
                    } catch (ArithmeticException err) {
                        errorLabel.setText("Can't divide by 0");
                    }
                } else {
                    resultField.setText(String.valueOf(Integer.parseInt(inputLeft.getText()) * (Integer.parseInt(inputRight.getText()))));
                }
            } catch (NumberFormatException err) {
                errorLabel.setText("Invalid value");
            }
        });
    }

}
