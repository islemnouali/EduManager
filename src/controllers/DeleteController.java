package controllers;

import java.io.IOException;
import java.util.Optional;
import crud.CrudFiliere;
import entities.filiere;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteController {

    @FXML
    private Button btnajouter;

    @FXML
    private Button btnquitter;

    @FXML
    private Button btnreturn;

    @FXML
    private Button btnvider;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    void Quitter(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void Supprimer(ActionEvent event) {
        int id = Integer.parseInt(txtid.getText());
        String nom = txtname.getText();

        if (nom == null || txtid.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucune sélection");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir l'id et le nom du filière à supprimer.");
            alert.showAndWait();
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmation de suppression");
        confirm.setHeaderText(null);
        confirm.setContentText("Voulez-vous vraiment supprimer la filière \"" + txtname.getText() + "\" ?");

        Optional<ButtonType> result = confirm.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
        	filiere f = new filiere(id, nom);
            int res = CrudFiliere.delete(f);

            if (res == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Cette Filiere n'existe pas!");
                alert.showAndWait();
            } else {
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succès");
                alert.setHeaderText(null);
                alert.setContentText("Filière supprimée avec succès !");
                alert.showAndWait();
            }
        }
    }


    @FXML
    void Vider(ActionEvent event) {
    	txtname.clear();
    	txtid.clear();
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
