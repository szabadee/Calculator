package com.flow.calculator;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
