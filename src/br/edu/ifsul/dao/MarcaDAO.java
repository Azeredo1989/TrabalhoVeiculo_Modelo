package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Marca;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MarcaDAO implements Serializable {

    private List<Marca> listarTodos;

    public MarcaDAO() {

    }
    
    public void persistir(Marca objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }
    
    public void merge(Marca objeto) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.merge(objeto);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }   
    
    public void remover(Integer codigo) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            Marca objeto = em.find(Marca.class, codigo);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }      
    
    public Marca getObjectById(Integer codigo) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Marca.class, codigo);
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }    

    public List<Marca> getListarTodos() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Veiculos_modeloPU");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from marca order by nome").getResultList();
        } catch (Exception e){
            throw  new Exception("Erro ao executar a operação de persistência: "+e.getMessage());
        } finally{
            em.close();
            emf.close();
        }
    }

    public void setListarTodos(List<Marca> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
