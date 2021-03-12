/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author Thukera
 */


@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    //@NamedQuery(name = "Produto.findByCategoria", query = "SELECT DISTINCT p FROM Produto p INNER JOIN p.categorias c WHERE c.id IN :idCat"),
    //@NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p LEFT JOIN FETCH p.categorias WHERE p.id = :idProd")
})

@Entity
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @Column(length = 6, nullable = false)
    private String codigoId;
    
    @Column(length = 100, nullable = false)
    private String modelo;
    
    @Column(length = 100)
    private String estilo;
    
    @Column(length = 1000)
    private String descricao;
    
    @Column(length = 1000)
    private String especificacoes;

    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal precoCompra;

    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal precoVenda;

    @Column(precision = 6, nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private boolean disponivel;

    @Column(nullable = false, insertable = true, updatable = false)
    private LocalDateTime dtCadastro;

    /*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "ID_PRODUTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_CATEGORIA")
    )
    private Set<Categoria> categorias;
    
     @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "ID_PRODUTO"),
            inverseJoinColumns = @JoinColumn(name = "ID_SUBCATEGORIA")
    )
    private Set<SubCategoria> subCategorias;

    // "produto" é o atributo na classe ImagemProduto onde o @ManyToOne foi configurado
    //@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    //private Set<ImagemProduto> imagens;

    @Transient
    private Set<Integer> idsCategorias;
    
    @Transient
    private Set<Integer> idsSubCategorias;
    
    */
    
    @Transient
    private String observacoes;

    
    public Produto() {

    }
    
     public Produto(Long id,String codigoId, String modelo, String estilo, String descricao, String especificacoes, BigDecimal precoCompra, BigDecimal precoVenda, int quantidade, boolean disponivel, LocalDateTime dtCadastro) {
        this.id = id;
        this.codigoId = codigoId;
        this.modelo = modelo;
        this.estilo = estilo;
        this.descricao = descricao;
        this.especificacoes = especificacoes;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        this.dtCadastro = dtCadastro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCodigoId(String codigoId) {
        this.codigoId = codigoId;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra = precoCompra;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setDtCadastro(LocalDateTime dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    /*
    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setSubCategorias(Set<SubCategoria> subCategorias) {
        this.subCategorias = subCategorias;
    }

  //  public void setImagens(Set<ImagemProduto> imagens) {
  //      this.imagens = imagens;
  //  }

    public void setIdsCategorias(Set<Integer> idsCategorias) {
        this.idsCategorias = idsCategorias;
    }
    */

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public String getCodigoId() {
        return codigoId;
    }

    public String getModelo() {
        return modelo;
    }

    public String getEstilo() {
        return estilo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public LocalDateTime getDtCadastro() {
        return dtCadastro;
    }

    /*
    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public Set<SubCategoria> getSubCategorias() {
        return subCategorias;
    }

 //   public Set<ImagemProduto> getImagens() {
 //       return imagens;
 //   }

   public Set<Integer> getIdsCategorias() {
        return idsCategorias;
    }

    */
    public String getObservacoes() {
        return observacoes;
    }
    
    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", " + "codigoId=" + codigoId + ",modelo=" + modelo + ", estilo=" + estilo + ", descricao=" + descricao + ", especificacoes=" + especificacoes + ", precoCompra=" + precoCompra + ", precoVenda=" + precoVenda + ", quantidade=" + quantidade + ", dtCadastro=" + dtCadastro + /* ", categorias=" + categorias + ", subCategoria=" + subCategorias + ", imagens=" +  /* imagens +  ", idsCategorias=" + idsCategorias + ", idsSubcategorias=" + idsSubCategorias + */ ", observacoes=" + observacoes + '}';
    }
    
    
    
    
}
