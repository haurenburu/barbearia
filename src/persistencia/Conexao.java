/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hauren
 */
public class Conexao {
    //ATRIBUTOS DA CLASSE
	private static final String USUARIO = "admin";	
	private static final String SENHA = "admin";
	private static final String CAMINHO = "jdbc:h2:~/barbearia;INIT=runscript from '~/script.sql'";
	private static final String DRIVER = "org.h2.Driver";
	private Connection conexao;		
	
	//METODO QUE EFETUA A CONEXAO COM O BANCO DE DADOS
	public void conecta() throws SQLException {
		try {
			Class.forName(DRIVER); //Carrega o driver (inicializa um objeto da classe org.postgresql.Driver) 
			conexao = DriverManager.getConnection(CAMINHO, USUARIO,SENHA); //Cria a conexao
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e);
		}
	}

	//METODO QUE DESCONECTA O BANCO DE DADOS
	public void desconecta() {
		try {
			conexao.close();//fecha a conexao
		} catch (SQLException ex) {
			System.err.println(ex);
		}
	}

	public Connection getConexao() {
		return conexao;
	}
}
