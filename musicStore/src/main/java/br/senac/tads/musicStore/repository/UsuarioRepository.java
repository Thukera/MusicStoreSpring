/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.musicStore.repository;

import br.senac.tads.musicStore.entidade.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ahardmanborg
 */

@Repository
public class UsuarioRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *
     * @return
     */
    public List<Usuario> findAllUsuarios() {
        Query jpqlQuery;
        jpqlQuery = entityManager.createNamedQuery("Usuario.findAll");
        return jpqlQuery.getResultList();
    }
    
    public Usuario findByIdUsuario(Integer id) {
        Query jpqlQuery
                = entityManager.createQuery(
                        "SELECT u FROM Categoria u WHERE u.id = :idUsr");
        jpqlQuery.setParameter("idUsr", id);
        Usuario usr = (Usuario) jpqlQuery.getSingleResult();
        return usr;
    }
    
}
