package br.pucgoias.cmp1144.persistencia;

import java.io.Serializable;
import java.util.List;

import br.pucgoias.cmp1144.util.IncendioException;

/**
 * Interface que define as operacoes da camada de persistencia generica
 * @author Moises
 *
 */
public interface GenericoDAO<T, ID extends Serializable> {
	
	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<T> getObjectClass();
	
	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws IncendioException
	 */
	public T incluir(T object) throws IncendioException;
	
	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws IncendioException
	 */
	public T alterar(T object) throws IncendioException;
	
	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws IncendioException
	 */
	public T consultar(Integer id) throws IncendioException;
	
	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws IncendioException
	 */
	public void excluir(Integer id) throws IncendioException;
	
	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws IncendioException
	 */
	public List<T> listar() throws IncendioException;
}
