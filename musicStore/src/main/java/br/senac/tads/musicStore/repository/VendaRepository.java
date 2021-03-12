/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.repository;

import br.senac.tads.musicStore.entidade.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thukera
 */
@Repository
public class VendaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

   
    public List<Venda> findAllVenda() {
        Query jpqlQuery  = entityManager.createNamedQuery("Venda.findAll");
        return jpqlQuery.getResultList();
    }
    
    @Transactional
    public void save(Venda v) {
        if (v.getId() == null) {
            // Salva uma nova venda
            entityManager.persist(v);
        } else {
            // Atualiza um produto existente
            entityManager.merge(v);
        }
    }
    
}
