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
public class Funcionario extends Pessoa {
    private double salario;
    private int cortes;

    public Funcionario(double salario, String cpf, String nome, String sexo, String endereco, String telefone, String senha) {
        super(cpf, nome, sexo, endereco, telefone, senha);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCortes() {
        return cortes;
    }

    public void setCortes(int cortes) {
        this.cortes = cortes;
    }

    public double getPagamento() {
        //cada corte é 1% do salario eu acho
        return salario + salario*(cortes*0.01);
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + getCpf() + ", nome=" + getNome() + ", sexo=" + getSexo() + ", endereco=" + getEndereco() + ", telefone=" + getTelefone() + ", salario=" + getPagamento() + '}';
    }
}
