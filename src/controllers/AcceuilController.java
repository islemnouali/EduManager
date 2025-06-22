package controllers;

import java.io.IOException;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AcceuilController {

    @FXML
    private Button btnconnecter;

    @FXML
    private Button btnquitter;

    @FXML
    private FontAwesomeIcon icon;

    @FXML
    private AnchorPane pane;

    @FXML
    private Text txt;

    @FXML
    private TextField txtlogin;

    @FXML
    private PasswordField txtpass;
    
    @FXML
    void Quitter(ActionEvent event) {
    	System.exit(0);  
    }

    @FXML
    void seConnecter(ActionEvent event) {
        String login = txtlogin.getText();
        String password = txtpass.getText();

        if (login.equals("a") && password.equals("a")) {
            try {
                // Load the FXML using the static method
                Parent p = FXMLLoader.load(getClass().getResource("/views/Choice.fxml"));
               
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
        } else {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Connexion");
            a.setHeaderText(null);
            a.setContentText("Login ou password erroné");
            a.showAndWait();
        }
    }



}
