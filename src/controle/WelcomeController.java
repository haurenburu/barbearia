/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hauren
 */
public class WelcomeController implements Initializable{
    @FXML
    private JFXButton btn_signin;

    @FXML
    private JFXButton btn_signup;
    
    @FXML
    private void btnLoginAction(ActionEvent event) {
        System.out.println("asdas");
        //to::
        //Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //mesmaJanela(mainStage, "Login");
    }
    @FXML
    private void btnRegisterAction(ActionEvent event) {
        // to::
        //Stage mainStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //mesmaJanela(mainStage, "Cadastro");
    }
    
    public void mesmaJanela(Stage mainStage, String tela){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/visao/Login.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mainStage.setScene(new Scene(root));
        mainStage.show();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // NAHDAH
    }
}
