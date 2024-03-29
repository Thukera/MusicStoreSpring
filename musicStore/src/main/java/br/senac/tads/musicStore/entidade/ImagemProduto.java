/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Thukera
 
@Entity
class ImagemProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nomeArquivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public ImagemProduto(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public ImagemProduto(Long id, String nomeArquivo) {
        this.id = id;
        this.nomeArquivo = nomeArquivo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

        public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;

    }
    
    @Override
    public String toString() {
        return "ImagemProduto{" + "id=" + id + ", nomeArquivo=" + nomeArquivo + '}';
    }

} */
