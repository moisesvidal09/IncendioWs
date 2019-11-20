package br.pucgoias.cmp1144.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.http.HttpStatus;

import br.pucgoias.cmp1144.entidade.Ocorrencia;
import br.pucgoias.cmp1144.util.IncendioException;

public class OcorrenciaDAOImpl {
	
	private static OcorrenciaDAOImpl instance;

	protected EntityManager entityManager;

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("incendio");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
    public static OcorrenciaDAOImpl getInstance(){
        if (instance == null){
           instance = new OcorrenciaDAOImpl();
        }
         
        return instance;
      }

      private OcorrenciaDAOImpl() {
        entityManager = getEntityManager();
      }

	/**
	 * Inclui um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws IncendioException
	 */
	public HttpStatus incluir(Ocorrencia ocorrencia) throws IncendioException {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(ocorrencia);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.BAD_REQUEST;
		}
		return HttpStatus.OK;
	}

	/**
	 * Exclui um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws IncendioException
	 */
	public Ocorrencia excluir(Ocorrencia ocorrencia) throws IncendioException {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(Ocorrencia.class, ocorrencia.getId()));
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new IncendioException(e, "Não foi possivel excluir.");
		}
		return ocorrencia;
	}
	
	
	/**
	 * Altera um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws IncendioException
	 */
	public HttpStatus alterar(Ocorrencia ocorrencia) throws IncendioException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(ocorrencia);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			return HttpStatus.BAD_REQUEST;
		}
		return HttpStatus.OK;
	}

    @SuppressWarnings("unchecked")
    public List<Ocorrencia> listar() {
      return entityManager.createQuery("FROM " + 
      Ocorrencia.class.getName()).getResultList();
    }

}
