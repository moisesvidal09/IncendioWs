package br.pucgoias.cmp1144.negocio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.pucgoias.cmp1144.entidade.Ocorrencia;
import br.pucgoias.cmp1144.persistencia.OcorrenciaDAO;
import br.pucgoias.cmp1144.util.IncendioException;

/**
 * Classe responsavel por realizar os serviços e a mediação entre controle e DAO
 * @author moisesvidal.senai
 *
 */
@Service
@Transactional
public class OcorrenciaServiceImpl implements OcorrenciaService {

	private OcorrenciaDAO ocorrenciaDAO;

	public OcorrenciaDAO getOcorrenciaDAO() {
		return ocorrenciaDAO;
	}

	@Autowired
	public void setOcorrenciaDAO(OcorrenciaDAO ocorrenciaDAO) {
		this.ocorrenciaDAO = ocorrenciaDAO;
	}

	/**
	 * Inclui uma Ocorrencia
	 * 
	 * @param Ocorrencia
	 * @return
	 * @throws IncendioException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Ocorrencia incluir(Ocorrencia ocorrencia) throws IncendioException {
		return getOcorrenciaDAO().incluir(ocorrencia);
	}

	/**
	 * Altera uma Ocorrencia
	 * @param Ocorrencia
	 * @return
	 * @throws IncendioException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Ocorrencia alterar(Ocorrencia ocorrencia) throws IncendioException {

		return getOcorrenciaDAO().alterar(ocorrencia);
	}

	/**
	 * Exclui uma Ocorrencia
	 * @param id
	 * @throws IncendioException
	 */
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Ocorrencia consultar(Integer id) throws IncendioException {
		Ocorrencia ocorrencia = getOcorrenciaDAO().consultar(id);
		return ocorrencia;
	}

	/**
	 * Consulta uma Ocorrencia pelo identificadors
	 * @param id
	 * @return
	 * @throws IncendioException
	 */
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Ocorrencia> listar() throws IncendioException {
		return getOcorrenciaDAO().listar();
	}

	/**
	 * Lista todas as Ocorrencias cadastradas
	 * @return
	 * @throws IncendioException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excluir(Integer id) throws IncendioException {

		getOcorrenciaDAO().excluir(id);
	}
	
}
