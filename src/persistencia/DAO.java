/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author Hauren
 */
public interface DAO {
    public abstract Object buscar(String cpf);
    public abstract void inserir(Object obj);
    public abstract void excluir(String cpf);
    public abstract void alterar(String cpf, String nome, String sexo, String enredeco, String telefone, String senha);
    public abstract void alterarFnc(String cpf, String nome, String sexo, String enredeco, String telefone, String senha, double salario);
    
    
}
