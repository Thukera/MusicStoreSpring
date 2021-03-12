/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Thukera
 * 
 */

@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    //@NamedQuery(name = "Produto.findByCategoria", query = "SELECT DISTINCT p FROM Produto p INNER JOIN p.categorias c WHERE c.id IN :idCat"),
    //@NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p LEFT JOIN FETCH p.categorias WHERE p.id = :idProd")
})

@Entity
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="usuario", length = 100, nullable = false)
    private String usuario;
    
    @Column(precision = 7, nullable = false)
    private int totalItem;

    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal valorTotal;

    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal frete;

    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal valorCompra;
    
    @Column(nullable = false, insertable = true, updatable = false)
    private LocalDateTime data;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public LocalDateTime getData() {
        return data;
    }
    
    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", usuario=" + usuario + ", totalItem=" + totalItem + ", valor_total=" + valorTotal + ", frete=" + frete + ", valorCompra=" + valorCompra + ", data=" + data +'}';
    }
    
    
    
    //criar relação de tabelas e variavel date para timestamp
}
