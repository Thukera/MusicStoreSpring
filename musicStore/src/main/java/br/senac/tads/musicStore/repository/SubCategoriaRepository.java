/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.repository;


import br.senac.tads.musicStore.entidade.SubCategoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Thukera
 */
@Repository
public class SubCategoriaRepository {

    @PersistenceContext
    private EntityManager entityManager;
 
    public List<SubCategoria> findAllSubCategorias() {
        Query jpqlQuery;
        jpqlQuery = entityManager.createNamedQuery("SubCategoria.findAllSub");
        return jpqlQuery.getResultList();
    }

    
   
}
