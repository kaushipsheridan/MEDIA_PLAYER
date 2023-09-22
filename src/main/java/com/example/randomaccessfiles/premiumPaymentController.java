package com.example.randomaccessfiles;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class premiumPaymentController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField cardNumberField;

    @FXML
    private TextField mmyyField;

    @FXML
    private PasswordField cvvField;

    @FXML
    private TextField addressField;

    @FXML
    private Button premiumButton;

    @FXML
    private void handlePremiumButtonClick() {
        String validationMessage = validateFields();
        if (validationMessage.isEmpty()) {
            showSuccessAlert();
        } else {
            displayValidationError(validationMessage);
        }
    }

    private String validateFields() {
        String name = nameField.getText().trim();
        String cardNumber = cardNumberField.getText().trim();
        String mmyy = mmyyField.getText().trim();
        String cvv = cvvField.getText().trim();
        String address = addressField.getText().trim();

        if (name.isEmpty()) {
            return "Please enter the cardholder name.";
        } else if (cardNumber.length() != 14) {
            return "Card number should be exactly 14 digits.";
        } else if (mmyy.length() != 4) {
            return "MMYY should be exactly 4 digits.";
        } else if (cvv.length() != 3) {
            return "CVV should be exactly 3 digits.";
        } else if (address.isEmpty()) {
            return "Please enter the address.";
        }

        return ""; 
    }

    private void showSuccessAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment Successful");
        alert.setHeaderText(null);
        alert.setContentText("Congratulations! All fields passed. Payment successful.");
        alert.showAndWait();
    }

    private void displayValidationError(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}



