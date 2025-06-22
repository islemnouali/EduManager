package controllers;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChoiceController {

    @FXML
    private Button btnetudiant;

    @FXML
    private Button btnfiliere;

    @FXML
    private Button btnquitter;

    @FXML
    void Quitter(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void goEtudiant(ActionEvent event) {
    	try {
            // Load the FXML using the static method
            Parent p = FXMLLoader.load(getClass().getResource("/views/etudiant.fxml"));
           
            // Get the current stage (window)
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(p);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gofiliere(ActionEvent event) {
    	try {
            // Load the FXML using the static method
            Parent p = FXMLLoader.load(getClass().getResource("/views/filiere.fxml"));
           
            // Get the current stage (window)
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(p);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
