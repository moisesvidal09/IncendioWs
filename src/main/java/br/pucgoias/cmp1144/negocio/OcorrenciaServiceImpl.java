package br.pucgoias.cmp1144.negocio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.pucgoias.cmp1144.entidade.Ocorrencia;
import br.pucgoias.cmp1144.persistencia.OcorrenciaDAO;
import br.pucgoias.cmp1144.util.IncendioException;

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

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Ocorrencia incluir(Ocorrencia ocorrencia) throws IncendioException {
		return getOcorrenciaDAO().incluir(ocorrencia);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Ocorrencia alterar(Ocorrencia ocorrencia) throws IncendioException {

		return getOcorrenciaDAO().alterar(ocorrencia);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Ocorrencia consultar(Integer id) throws IncendioException {
		Ocorrencia ocorrencia = getOcorrenciaDAO().consultar(id);
		return ocorrencia;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Ocorrencia> listar() throws IncendioException {
		return getOcorrenciaDAO().listar();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excluir(Integer id) throws IncendioException {

		getOcorrenciaDAO().excluir(id);
	}
	
}
