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
    @NamedQuery(name = "SubCategoria.findAllSub", query = "SELECT s FROM SubCategoria s"),
})

@Entity
public class SubCategoria implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nome" , length = 100, nullable = false, unique = true)
    private String nome;

    /* "categorias" é o atributo na classe Produto onde o @ManyToMany foi configurado
    @ManyToMany(mappedBy = "subcategorias", fetch = FetchType.LAZY)
    private Set<Produto> produtos;
    */
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*
    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
*/

    @Override
    public String toString() {
        return "SubCategoria{" + "id=" + id + ", nome=" + nome + '}';
    }
    
}
