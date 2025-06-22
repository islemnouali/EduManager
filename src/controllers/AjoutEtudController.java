package controllers;

import java.io.IOException;

import crud.CrudEtudiant;
import entities.etudiant;
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

public class AjoutEtudController {

    @FXML
    private Button btnajouter;

    @FXML
    private Button btnquitter;

    @FXML
    private Button btnreturn;

    @FXML
    private Button btnvider;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtIdFiliere;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrenom;

    @FXML
    void Ajouter(ActionEvent event) {
        String nom = txtNom.getText().trim();
        String prenom = txtPrenom.getText().trim();
        String email = txtEmail.getText().trim();
        String idFiliereStr = txtIdFiliere.getText().trim();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || idFiliereStr.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Champs vides", "Veuillez remplir tous les champs !");
            return;
        }

        int idFiliere;
        try {
            idFiliere = Integer.parseInt(idFiliereStr);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Format invalide", "L'identifiant de la filière doit être un nombre entier !");
            return;
        }

        // Create filiere by ID only — no need to query DB if we just insert ID
        filiere f = new filiere(idFiliere);

        etudiant e = new etudiant(0, nom, prenom, email, f);
        int result = CrudEtudiant.create(e);

        if (result == 0) {
            showAlert(Alert.AlertType.ERROR, "Erreur", "Erreur lors de l'ajout de l'étudiant.");
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Succès", "Étudiant ajouté avec succès !");
            Vider(null);
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }



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
    void Vider(ActionEvent event) {
    	txtNom.clear();
    	txtPrenom.clear();
    	txtEmail.clear();
    	txtIdFiliere.clear();
    }

}
