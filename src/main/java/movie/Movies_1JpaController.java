/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import movie.exceptions.NonexistentEntityException;
import movie.exceptions.PreexistingEntityException;

/**
 *
 * @author Tatva
 */
public class Movies_1JpaController implements Serializable {

    public Movies_1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movies_1 movies_1) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movies_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovies_1(movies_1.getMoiveid()) != null) {
                throw new PreexistingEntityException("Movies_1 " + movies_1 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movies_1 movies_1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movies_1 = em.merge(movies_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = movies_1.getMoiveid();
                if (findMovies_1(id) == null) {
                    throw new NonexistentEntityException("The movies_1 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movies_1 movies_1;
            try {
                movies_1 = em.getReference(Movies_1.class, id);
                movies_1.getMoiveid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movies_1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(movies_1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movies_1> findMovies_1Entities() {
        return findMovies_1Entities(true, -1, -1);
    }

    public List<Movies_1> findMovies_1Entities(int maxResults, int firstResult) {
        return findMovies_1Entities(false, maxResults, firstResult);
    }

    private List<Movies_1> findMovies_1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movies_1.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Movies_1 findMovies_1(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movies_1.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovies_1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movies_1> rt = cq.from(Movies_1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
