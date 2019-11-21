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
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hauren
 */
public class LoginController implements Initializable {
    @FXML
    private JFXTextField tf_username;

    @FXML
    private JFXPasswordField tf_password;

    @FXML
    private JFXButton btn_login;
    
    private void handleButtonAction(ActionEvent event) {
        // do:: somethin 
    }


    // to:: remove this, global variables are not a gud thingy
    String  usernameTXT = tf_username.getText(),
            passwordTXT = tf_password.getText();
    
    
    
    public void chanceState(Stage mainStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/visao/caminho.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mainStage.setScene(new Scene(root));
        mainStage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //NAHDAH é gay
    }
}
