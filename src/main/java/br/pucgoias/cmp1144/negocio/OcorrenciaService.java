package br.pucgoias.cmp1144.negocio;

import java.util.List;

import br.pucgoias.cmp1144.entidade.Ocorrencia;
import br.pucgoias.cmp1144.util.IncendioException;


/**
 * Interface que define as operacoes da camada de negocio de Ocorrencia
 * @author Moises
 *
 */
public interface OcorrenciaService {
	
	/**
	 * Inclui uma Ocorrencia
	 * 
	 * @param Ocorrencia
	 * @return
	 * @throws IncendioException
	 */
	public Ocorrencia incluir(Ocorrencia ocorrencia) throws IncendioException;
	
	/**
	 * Altera uma Ocorrencia
	 * @param Ocorrencia
	 * @return
	 * @throws IncendioException
	 */
	public Ocorrencia alterar(Ocorrencia ocorrencia) throws IncendioException;
	
	/**
	 * Exclui uma Ocorrencia
	 * @param id
	 * @throws IncendioException
	 */
	public void excluir(Integer id) throws IncendioException;
	
	/**
	 * Consulta uma Ocorrencia pelo identificadors
	 * @param id
	 * @return
	 * @throws IncendioException
	 */
	public Ocorrencia consultar(Integer id) throws IncendioException;
	
	/**
	 * Lista todas as Ocorrencias cadastradas
	 * @return
	 * @throws IncendioException
	 */
	public List<Ocorrencia> listar() throws IncendioException;

}
