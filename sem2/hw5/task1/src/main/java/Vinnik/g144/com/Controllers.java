package Vinnik.g144.com;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;

public class Controllers {

    @FXML
    private Slider slider;

    @FXML
    private ProgressBar progressBar;

    /**
     * Initialization method
     *
     * Sets the value of progress bar is equal to the value of the slider.
     */
    public void initialize() {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> progressBar.progressProperty().setValue(newValue));
    }
}