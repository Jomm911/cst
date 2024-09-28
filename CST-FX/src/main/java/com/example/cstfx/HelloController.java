package com.example.cstfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;


public class HelloController {

    @FXML
    private Button clear;

    @FXML
    private TextField input;

    @FXML
    private Button simulate;

    @FXML
    private Button validate;

    @FXML
    public void handleClear() {
        // Clear the text field
        input.clear();
    }

}
