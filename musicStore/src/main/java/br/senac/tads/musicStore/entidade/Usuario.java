/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Thukera
 */

@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
})

@Entity
public class Usuario implements Serializable {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 15, nullable = false)
    private int CPF;
    
    @Column(length = 255, nullable = false)
    private int nascimento;
    
    @Column(length = 11, nullable = false)
    private int telefone;
    
    @Column(length = 10, nullable = false)
    private String CEP;
    
    @Column(length = 100, nullable = false)
    private String rua;
    
    @Column(nullable = false)
    private int numero;
    
    @Column(length = 100, nullable = true)
    private String complemento;
    
    @Column(length = 100, nullable = false)
    private String bairro;
    
    @Column(length = 100, nullable = false)
    private String cidade;
    
    @Column(length = 2, nullable = false)
    private String estado;
    
    @Column(length = 100, nullable = false)
    private String email;
    
    @Column(length = 100, nullable = false)
    private String senha;
    

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public void setNascimento(int nascimento) {
        this.nascimento = nascimento;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCPF() {
        return CPF;
    }

    public int getNascimento() {
        return nascimento;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getCEP() {
        return CEP;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

   

}
