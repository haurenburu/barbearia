/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

/**
 *
 * @author Hauren
 */
public class CadastroController {

    @FXML
    private JFXTextField tf_name;

    @FXML
    private JFXTextField tf_username;

    @FXML
    private JFXPasswordField tf_password;

    @FXML
    private JFXPasswordField tf_password_repeat;

    @FXML
    private RadioButton rb_male;

    @FXML
    private RadioButton rb_female;

    @FXML
    private RadioButton rb_other;
    
    @FXML
    private JFXToggleButton tb_funcionario;

    @FXML
    void cadasBtnAction(ActionEvent event) {
        System.out.println("askdpasd");
    }
}
