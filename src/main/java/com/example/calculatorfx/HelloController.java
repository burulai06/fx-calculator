package com.example.calculatorfx;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class HelloController {

    Calculator calc = new Calculator();

    @FXML
    private TextField text;
    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private void onClickBut1() { appendToTextField("1"); }

    @FXML
    private void onClickBut2() { appendToTextField("2"); }

    @FXML
    private void onClickBut3() { appendToTextField("3"); }

    @FXML
    private void onClickBut4() { appendToTextField("4"); }

    @FXML
    private void onClickBut5() { appendToTextField("5"); }

    @FXML
    private void onClickBut6() { appendToTextField("6"); }

    @FXML
    private void onClickBut7() { appendToTextField("7"); }

    @FXML
    private void onClickBut8() { appendToTextField("8"); }

    @FXML
    private void onClickBut9() { appendToTextField("9"); }

    @FXML
    private void onClickBut0() { appendToTextField("0"); }

    @FXML
    private void onPlusClick() { setOperator('+'); }

    @FXML
    private void onMinusClick() { setOperator('-'); }

    @FXML
    private void onMultiplyClick() { setOperator('*'); }

    @FXML
    private void onDivideClick() { setOperator('/'); }

    @FXML
    private void onEqualClick() {
        try {
            String op2 = text.getText();
            calc.setOp2(Double.parseDouble(op2));
            calc.calculate();
            text.setText(String.valueOf(calc.getResult()));
        } catch (NumberFormatException e) {
            text.setText("Error");
        }
    }

    @FXML
    private void initialize() {
        exitMenuItem.setOnAction(event -> onExitMenuClick());
    }

    @FXML
    private void onExitMenuClick() {
        System.exit(0);
    }

    @FXML
    private void onDotClick() {
        String currentText = text.getText();
        if (!currentText.contains(".")) {
            text.setText(currentText + ".");
        }
    }

    private void appendToTextField(String value) {
        String currentText = text.getText();
        text.setText(currentText + value);
    }

    private void setOperator(char operator) {
        String op1 = text.getText();
        if (!op1.isEmpty()) {
            calc.setOp1(Double.parseDouble(op1));
            calc.setOperator(operator);
            text.setText("");
        }
    }
}