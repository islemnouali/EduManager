package controllers;

import java.io.IOException;
import crud.CrudFiliere;
import entities.filiere;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjoutController {

    @FXML
    private Button btnajouter;

    @FXML
    private Button btnquitter;

    @FXML
    private Button btnvider;

    @FXML
    private TextField txtFiliere;

    @FXML
    void Quitter(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void Ajouter(ActionEvent event) {
        String t = txtFiliere.getText();

        if (t == null || t.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Champ vide");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer un nom de filière !");
            alert.showAndWait();
            return;
        }

        filiere f = new filiere(t);
        int result = CrudFiliere.create(f);  // already returns 0 on error

        if (result == 0) {  
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Une erreur s'est produite lors de l'ajout.");
            alert.showAndWait();
        } else {
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Filière ajoutée avec succès !");
            alert.showAndWait();
        }
    }


    @FXML
    void Vider(ActionEvent event) {
        txtFiliere.clear();
    }
    
    @FXML
    void Return(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/filiere.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
