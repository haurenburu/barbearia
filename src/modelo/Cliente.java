/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Hauren
 */
public class Cliente extends Pessoa{

    public Cliente(String cpf, String nome, String sexo, String endereco, String telefone) {
        super(cpf, nome, sexo, endereco, telefone);
    }
}