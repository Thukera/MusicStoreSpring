package br.senac.tads.musicStore.repository;

import br.senac.tads.musicStore.entidade.Produto;
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
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Produto> findAllProd() {
        Query jpqlQuery = entityManager.createNamedQuery("Produto.findAll");
                        
        return jpqlQuery.getResultList();
    }

    public List<Produto> findByCategoria(List<Integer> idsCat) {
        Query jpqlQuery
                = entityManager
                        .createNamedQuery("Produto.findByCategoria")
                        .setParameter("idCat", idsCat);
        return jpqlQuery.getResultList();
    }

    public Produto findById(Long id) {
        Query jpqlQuery
                = entityManager
                        .createNamedQuery("Produto.findById")
                        .setParameter("idProd", id);
        Produto p = (Produto) jpqlQuery.getSingleResult();
        return p;
    }

    @Transactional
    public void save(Produto p) {
        if (p.getId() == null) {
            // Criando uma Produto novo
            entityManager.persist(p);
        } else {
            // Atualiza uma Produto já existente
            entityManager.merge(p);
        }
    }

    @Transactional
    public void delete(Long id) {
        // TEM QUE FAZER CONSULTA PARA ESTAR ASSOCIADO AO
        // ENTITY MANAGER (ATTACHED)
        Produto p = entityManager.find(Produto.class, id);
        entityManager.remove(p);
    }
}
