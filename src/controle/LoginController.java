/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import modelo.Cliente;
import persistencia.ClienteDAO;

/**
 *
 * @author Hauren
 */
public class LoginController {

    @FXML
    private JFXTextField tf_username;

    @FXML
    private JFXPasswordField tf_password;

    @FXML
    private JFXButton btn_login;

    @FXML
    void logBtnAction(ActionEvent event) {
        String username = tf_username.getText();
        String password = tf_password.getText();

        ClienteDAO daoc = new ClienteDAO();

        Cliente clien = (Cliente) daoc.buscar(username);

        if (clien == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Usuario inexistente");
            alert.show();
        } else if (!password.equals(clien.getSenha())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Senha incorreta");
            alert.show();
        } else {
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = null;

            try {
                root = FXMLLoader.load(getClass().getResource("/visao/Welcome.fxml"));
                System.out.println(clien.toString());
            } catch (IOException ex) {
                Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            mainStage.setScene(new Scene(root));
            mainStage.show();

        }

    }

    @FXML
    void voltBtnAction(ActionEvent event) {
            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = null;

            try {
                root = FXMLLoader.load(getClass().getResource("/visao/Welcome.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            mainStage.setScene(new Scene(root));
            mainStage.show();
        
     
    }

}
