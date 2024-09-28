package com.example.cstfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    private static int currentState = 1; //initial state

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        BorderPane root = fxmlLoader.load();
        Scene scene = new Scene(root, 1300, 1000);

        TextField inputField = (TextField) root.lookup("#input");
        Button clearButton = (Button) root.lookup("#clear");
        Button validateButton = (Button) root.lookup("#validate");
        Button simulateButton = (Button) root.lookup("#simulate");

        clearButton.setOnAction(event -> {
            inputField.clear();
            currentState = 1; //reeset state
        });

        validateButton.setOnAction(event -> {
            String input = inputField.getText();
            if (isValid(input)) {
                currentState = 1;
                boolean isAccepted = transition(input);
                if (isAccepted) {
                    System.out.println("The input is accepted by the DFA.");
                } else if (currentState == -1) {
                    System.out.println("In Trap state.");
                } else {
                    System.out.println("The input is rejected by the DFA.");
                }
            } else {
                System.out.println("Input is invalid. Only 'a' and 'b' are allowed.");
            }
        });

        simulateButton.setOnAction(event -> {
            simulateInput(inputField.getText());
            //code simulate
        });

        stage.setTitle("CST");
        stage.setScene(scene);
        stage.show();
    }

    private static boolean isValid(String input) {
        for (char c : input.toCharArray()) {
            if (c != 'a' && c != 'b') {
                return false;
            }
        }
        return true;
    }

    private static void simulateInput(String input) {
        //simulate code dri
    }

    public static boolean transition(String input) {
        for (char ch : input.toCharArray()) {
            if (currentState == -1) {
                return false;
            }

            switch (currentState) {
                case 1:
                    if (ch == 'a') currentState = 2;
                    else if (ch == 'b') currentState = 4;
                    break;
                case 2:
                    if (ch == 'a') currentState = -1;
                    else if (ch == 'b') currentState = 3;
                    break;
                case 3:
                    if (ch == 'a') currentState = 6;
                    else if (ch == 'b') currentState = -1;
                    break;
                case 4:
                    if (ch == 'a') currentState = -1;
                    else if (ch == 'b') currentState = 5;
                    break;
                case 5:
                    if (ch == 'a') currentState = -1;
                    else if (ch == 'b') currentState = 6;
                    break;
                case 6:
                    if (ch == 'b') currentState = 7;
                    break;
                case 7:
                    if (ch == 'a') currentState = 8;
                    break;
                case 8:
                    if (ch == 'a') currentState = 6;
                    else if (ch == 'b') currentState = 9;
                    break;
                case 9:
                    if (ch == 'a' || ch == 'b') currentState = 10;
                    break;
                case 10:
                    //accepted
                    break;
                default:
                    System.out.println("Invalid input or state.");
                    return false;
            }
        }
        return isAcceptingState(); //return if the final state accepted
    }

    public static boolean isAcceptingState() {
        return currentState == 10;
    }

    public static void main(String[] args) {
        launch();
    }
}
