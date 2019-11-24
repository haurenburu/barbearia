/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;
/**
 *
 * @author Hauren
 */
public class ClienteDAO implements DAO{
    private Conexao con = new Conexao();
    private final String BUSCAR = "SELECT * FROM \"CLIENTE\" WHERE \"CPF\"=?";
    private final String INSERIR = "INSERT INTO \"CLIENTE\" (\"CPF\", \"NOME\", \"SEXO\", \"ENDERECO\", \"TELEFONE\", \"SENHA\") VALUES(?,?,?,?,?,?)";
    private final String EXCLUIR = "DELETE FROM \"CLIENTE\" WHERE \"CPF\" = ?";
    private final String ALTERAR = "UPDATE \"CLIENTE\" SET \"NOME\"=?, \"SEXO\"=?, \"ENDERECO\"=?, \"TELEFONE\"=?, \"SENHA\"=? WHERE \"cpf\"=?";

    @Override
    public Object buscar(String cpf) {
        Cliente clien = null;
        
        try {
            con.conecta();
            PreparedStatement instruction = con.getConexao().prepareStatement(BUSCAR);
            instruction.setString(1, cpf);
            ResultSet res = instruction.executeQuery();
            while(res.next()){
                clien = new Cliente(res.getString("CPF"), res.getString("NOME"), res.getString("SEXO"), res.getString("ENDERECO"), res.getString("TELEFONE"), res.getString("SENHA"));
            }
            con.desconecta();
        } catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        return clien;
    }

    @Override
    public void inserir(Object obj) {
        Cliente clien = (Cliente) obj;
        try {
            con.conecta();
            PreparedStatement instruction = con.getConexao().prepareStatement(INSERIR);
            
            //CLIENTE\" (\"CPF\", \"NOME\", \"SEXO\", \"ENDERECO\", \"TELEFONE\", \"SENHA
            instruction.setString(1, clien.getCpf());
            instruction.setString(2, clien.getNome());
            instruction.setString(3, clien.getSexo());
            instruction.setString(4, clien.getEndereco());
            instruction.setString(5, clien.getTelefone());
            instruction.setString(6, clien.getSenha());
            instruction.execute();
            con.desconecta();
             
        } catch (SQLException e){
            
            System.out.println("Erro no sql: " + e.getMessage());
        }
    }

    @Override
    public void excluir(String cpf) {
        try {
            con.conecta();
            PreparedStatement instruction = con.getConexao().prepareStatement(EXCLUIR);
            instruction.setString(1, cpf);
            instruction.execute();
            con.desconecta();
        } catch(SQLException e){
            System.out.println("Erro: "+ e.getMessage());
        }
                
    }

    @Override
    public void alterar(String cpf, String nome, String sexo, String enredeco, String telefone, String senha) {
        try {
            con.conecta();
            PreparedStatement instruction = con.getConexao().prepareStatement(ALTERAR);
            //"CPF\"=?,\"NOME\"=?, \"SEXO\"=?, \"ENDERECO\"=?, \"TELEFONE\"=?, \"SENHA\"=? WHERE \"cpf\"=?"
            instruction.setString(1, nome);
            instruction.setString(2, sexo);
            instruction.setString(3, enredeco);
            instruction.setString(4, telefone);
            instruction.setString(5, senha);
            instruction.setString(6, cpf);
            instruction.execute();
            con.desconecta();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar dados do cliente no banco de dados " + e.getMessage());
        }
    }

    @Override
    public void alterarFnc(String cpf, String nome, String sexo, String enredeco, String telefone, String senha, double salario) {
        // nadah
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
