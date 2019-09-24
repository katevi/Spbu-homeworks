package Vinnik.g144;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Stack;

/** Implements user's work with calculator. */
public class Controllers {

    private Calculator calculator;
    private StringBuilder expression;
    private Button[] numbers;
    private Button[] signs;

    @FXML
    private void handleButtonEvent(ActionEvent event) throws IncorrectFormException {
        if (event.getSource() == clear) {
            enteredExpression.setText("0");
            resultOfCalculating.setText("0");
            expression = new StringBuilder();
        } else {
            for (Button i : numbers) {
                if (event.getSource() == i) {
                    enteredExpression.setText(enteredExpression.getText() + i.getText());
                    expression.append(i.getText());
                }
            }
            for (Button i : signs) {
                if (event.getSource() == i) {
                    if (event.getSource().equals(minus)) {
                        enteredExpression.setText(enteredExpression.getText() + "-");
                        if (expression.length() == 0) {
                            expression.append("- ");
                        } else {
                            expression.append(" - ");
                        }
                    } else {
                        enteredExpression.setText(enteredExpression.getText() + i.getText());
                        expression.append(" ");
                        expression.append(i.getText());
                        expression.append(" ");
                    }
                }
            }
            if (expression.charAt(expression.length() - 1) >= '0' && expression.charAt(expression.length() - 1) <= '9') {
                resultOfCalculating.textProperty().setValue(calculator.calculate(expression.toString()).toString());
            }
        }
    }

    @FXML
    private TextField resultOfCalculating;

    @FXML
    private void initialize() {
        enteredExpression.setEditable(false);
        Stack<String> operations = new Stack<String>();
        Stack<Float> numbers = new Stack<Float>();
        calculator = new Calculator(operations, numbers);
        this.numbers = new Button[] {button0, button1, button2,button3, button4, button5, button6, button7, button8, button9};
        this.signs = new Button[] {minus, plus, div, mult};
        expression = new StringBuilder();
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
