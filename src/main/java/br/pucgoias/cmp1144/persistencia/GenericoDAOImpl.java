package br.pucgoias.cmp1144.persistencia;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.pucgoias.cmp1144.util.IncendioException;

/**
 * Classe que define as operacoes da camada de persistencia generica
 * 
 * @author Moises
 *
 */
public class GenericoDAOImpl<T, ID extends Serializable> implements GenericoDAO<T, ID> {

	private EntityManager entityManager;
	private final Class<T> oClass;

	// Classe a ser persistida
	public Class<T> getObjectClass() {
		return this.oClass;
	}

	// Gerenciador de persistencia
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(unitName = "incendio")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public GenericoDAOImpl() {
		this.oClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Inclui um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws IncendioException
	 */
	public T incluir(T object) throws IncendioException {
		try {
			getEntityManager().merge(object);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IncendioException(e, "N�o foi possivel realizar a inclus�o.");
		}
		return object;
	}

	/**
	 * Altera um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws IncendioException
	 */
	public T alterar(T object) throws IncendioException {
		try {
			getEntityManager().merge(object);
		} catch (Exception e) {
			throw new IncendioException(e, "N�o foi possivel realizar a altera��o.");
		}
		return object;
	}

	/**
	 * Consulta um objeto T da base de dados
	 * 
	 * @param id
	 * @return
	 * @throws IncendioException
	 */
	public T consultar(Integer id) throws IncendioException {
		T object = null;
		try {
			object = getEntityManager().find(getObjectClass(), id);
		} catch (EntityNotFoundException e) {
			throw new IncendioException(e, "Registro não encontrado.");
		} catch (Exception e) {
			throw new IncendioException(e, "N�o foi possivel realizar a consulta.");
		}
		return object;
	}

	/**
	 * Exclui um objeto T da base de dados
	 * 
	 * @param id
	 * @throws IncendioException
	 */
	public void excluir(Integer id) throws IncendioException {
		try {
			getEntityManager().remove(getEntityManager().getReference(getObjectClass(), id));
		} catch (EntityNotFoundException e) {
			throw new IncendioException(e, "Registro n�o encontrado para exclus�o.");
		} catch (Exception e) {
			throw new IncendioException(e, "Não foi possivel realizar a exclus�o.");
		}

	}

	/**
	 * Lista os objetos T da base de dados
	 * 
	 * @return
	 * @throws IncendioException
	 */
	@SuppressWarnings("unchecked")
	public List<T> listar() throws IncendioException {
		List<T> lista = null;
		try {
			Query query = getEntityManager()
					.createQuery("SELECT object(o) FROM " + getObjectClass().getSimpleName() + " AS o");
			lista = query.getResultList();
		} catch (Exception e) {
			throw new IncendioException(e, "Problemas na localiza��o dos objetos");
		}
		return lista;
	}

}
