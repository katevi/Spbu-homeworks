package Vinnik.g144;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class Controllers {

    private ObservableList<String> operationsList = FXCollections.observableArrayList("+", "-", "/", "*");

    @FXML
    private Spinner <Integer> firstNumber, secondNumber;

    @FXML
    private ChoiceBox <String> operation;

    @FXML
    private TextField outputResult;

    /** Initializing method.
     * Sets the range of numbers, initial values of the numbers and the result to zero,
     * adds list of the available operations with numbers.
     * Calculates the result of applying an operation on two numbers.
     */
    @FXML
    public void initialize() {
        SpinnerValueFactory<Integer> valueFirst = new SpinnerValueFactory.IntegerSpinnerValueFactory(-1000, 1000, 0);
        SpinnerValueFactory<Integer> valueSecond = new SpinnerValueFactory.IntegerSpinnerValueFactory(-1000, 1000, 0);

        this.firstNumber.setValueFactory(valueFirst);
        this.secondNumber.setValueFactory(valueSecond);
        firstNumber.setEditable(true);
        secondNumber.setEditable(true);
        outputResult.setEditable(false);

        this.operation.setItems(operationsList);
        this.operation.setValue("");
        outputResult.textProperty().setValue("0");

        //Spinners to select numbers light up green during clicking on them
        operation.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
        firstNumber.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
        secondNumber.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
    }

    private void calculate() {
        int first = firstNumber.getValue();
        int second = secondNumber.getValue();
        outputResult.textProperty().setValue(String.valueOf(Calculator.calculate(first, second, this.operation.getValue())));
    }
}
