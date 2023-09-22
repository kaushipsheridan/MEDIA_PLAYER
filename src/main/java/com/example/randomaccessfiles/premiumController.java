package com.example.randomaccessfiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class premiumController {
    @FXML private Button getStartedButton;

    @FXML
    private void handleGetStartedButtonClick(ActionEvent event) {
        try {
            // Load the PremiumPayment FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("premiumpayment.fxml"));
            Parent root = loader.load();

            // Set the controller for PremiumPayment screen (if necessary)
            premiumPaymentController premiumPaymentController = loader.getController();

            // Get the stage from the current button and set the new scene
            Stage stage = (Stage) getStartedButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
