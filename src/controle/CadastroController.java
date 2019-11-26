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
import javafx.scene.control.ToggleGroup;

import modelo.Cliente;
import modelo.Funcionario;
import persistencia.ClienteDAO;

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
    private JFXTextField tf_telefone;

    @FXML
    private JFXTextField tf_endereco;
    
    @FXML
    private ToggleGroup sexo;

    @FXML
    void cadasBtnAction(ActionEvent event) {
        String nome = tf_name.getText();
        String cpf = tf_username.getText();
        String senha = tf_password.getText();
        String senha2 = tf_password_repeat.getText();
        String telefone = tf_telefone.getText();
        String endereco = tf_endereco.getText();
        // radio button
        RadioButton selectedSexo = (RadioButton) sexo.getSelectedToggle();
        String sexoText = selectedSexo.getText();
        
       
        
        System.out.println(sexoText);
        
        
        
        Cliente cli = new Cliente(cpf, nome, senha, endereco, telefone, senha);
    }
}
