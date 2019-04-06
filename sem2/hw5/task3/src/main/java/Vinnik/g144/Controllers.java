package Vinnik.g144;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Stack;

/** Implements user's work with calculator. */
public class Controllers {

    private Calculator calculator;
    private String expression;

    @FXML
    private void handleButtonEvent(ActionEvent event) throws IncorrectFormException {
        if (event.getSource() == clear) {
            enteredExpression.setText("0");
            resultOfCalculating.setText("0");
            expression = "";
        } else {
            if (event.getSource() == button1) {
                enteredExpression.setText(enteredExpression.getText() + "1");
                expression = expression + "1";
            }
            if (event.getSource() == button2) {
                enteredExpression.setText(enteredExpression.getText() + "2");
                expression = expression + "2";
            }
            if (event.getSource() == button3) {
                enteredExpression.setText(enteredExpression.getText() + "3");
                expression = expression + "3";
            }
            if (event.getSource() == button4) {
                enteredExpression.setText(enteredExpression.getText() + "4");
                expression = expression + "4";
            }
            if (event.getSource() == button5) {
                enteredExpression.setText(enteredExpression.getText() + "5");
                expression = expression + "5";
            }
            if (event.getSource() == button6) {
                enteredExpression.setText(enteredExpression.getText() + "6");
                expression = expression + "6";
            }
            if (event.getSource() == button7) {
                enteredExpression.setText(enteredExpression.getText() + "7");
                expression = expression + "7";
            }
            if (event.getSource() == button8) {
                enteredExpression.setText(enteredExpression.getText() + "8");
                expression = expression + "8";
            }
            if (event.getSource() == button9) {
                enteredExpression.setText(enteredExpression.getText() + "9");
                expression = expression + "9";
            }
            if (event.getSource() == button0) {
                enteredExpression.setText(enteredExpression.getText() + "0");
                expression = expression + "0";
            }
            if (event.getSource() == plus) {
                enteredExpression.setText(enteredExpression.getText() + "+");
                expression = expression + " + ";
            }
            if (event.getSource() == minus) {
                enteredExpression.setText(enteredExpression.getText() + "-");
                if (expression.length() == 0) {
                    expression = expression + "- ";
                } else {
                    expression = expression + " - ";
                }
            }
            if (event.getSource() == mult) {
                enteredExpression.setText(enteredExpression.getText() + "*");
                expression = expression + " * ";
            }
            if (event.getSource() == div) {
                enteredExpression.setText(enteredExpression.getText() + "/");
                expression = expression + " / ";
            }
            if (expression.charAt(expression.length() - 1) >= '0' && expression.charAt(expression.length() - 1) <= '9') {
                resultOfCalculating.textProperty().setValue(calculator.calculate(expression).toString());
            }
        }
    }

    @FXML
    private TextField resultOfCalculating;

    @FXML
    private void initialize() {
        enteredExpression.setEditable(false);
        Stack<String> operations = new Stack();
        Stack<Float> numbers = new Stack();
        calculator = new Calculator(operations, numbers);
        expression = "";
    }

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button button0;

    @FXML
    private Button plus;

    @FXML
    private Button minus;

    @FXML
    private Button mult;

    @FXML
    private Button div;

    @FXML
    private Button clear;

    @FXML
    private TextField enteredExpression;
}
