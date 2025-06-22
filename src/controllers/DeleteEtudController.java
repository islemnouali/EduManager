package controllers;

import crud.CrudEtudiant;
import entities.etudiant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteEtudController {

    @FXML
    private Button btnSupprimer;

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
    void Return(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Etudiant.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Supprimer(ActionEvent event) {
        String idStr = txtid.getText().trim();
        String name = txtname.getText().trim();

        if (idStr.isEmpty() || name.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Champs vides", "Veuillez remplir l'identifiant et le nom de l'étudiant !");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Format invalide", "L'identifiant doit être un nombre entier !");
            return;
        }

        // Create student object with ID and name only
        etudiant e = new etudiant(id, name, null, null, null);

        int result = CrudEtudiant.delete(e);

        if (result == 0) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "La suppression a échoué. Vérifiez l'ID.");
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Succès", "Étudiant supprimé avec succès !");
            Vider(null);
        }
    }


    @FXML
    void Vider(ActionEvent event) {
        txtid.clear();
        txtname.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
