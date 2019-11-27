/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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

        // tratamento
        if (nome.isEmpty() || cpf.isEmpty() || senha.isEmpty() || senha2.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Os campos não podem ficar vazios!");
            alert.show();
        } else if (!senha.equals(senha2)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "As senhas não correspodem!");
            alert.show();
        } else {
            ClienteDAO daoc = new ClienteDAO();

            Cliente cli = new Cliente(cpf, nome, sexoText, endereco, telefone, senha);

            Stage mainStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = null;

            try {
                daoc.inserir(cli);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Cadastrado com sucesso!");
                alert.show();
                root = FXMLLoader.load(getClass().getResource("/visao/Login.fxml"));
            } catch (Exception e) {
                System.out.println(e.getMessage());

                Alert alert = new Alert(Alert.AlertType.ERROR, "Algo deu errado!");
                alert.show();
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
