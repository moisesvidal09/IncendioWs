package br.pucgoias.cmp1144.controle;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.pucgoias.cmp1144.entidade.Ocorrencia;
import br.pucgoias.cmp1144.negocio.OcorrenciaService;
import br.pucgoias.cmp1144.util.IncendioException;

/**
 * Controlador responsavel por receber e enviar requisições
 * 
 * @author moisesvidal.senai
 *
 */
@RestController
@RequestMapping("/ocorrenciaController")
public class OcorrenciaController {

	@Autowired
	private OcorrenciaService ocorrenciaService;

	Ocorrencia ocorrencia;

	/**
	 * Metodo responsavel por inserir uma ocorrencia
	 * 
	 * @param ocorrenciaJson
	 * @return String
	 * @throws IncendioException
	 */
	@RequestMapping(value = "/inserir", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String inserir(@RequestBody Ocorrencia ocorrenciaJson) throws IncendioException {

		ocorrencia = new Ocorrencia();

		// validações de obrigatoriedade
		if (ocorrenciaJson.getNomeSolicitante() == null) {

			return "Erro na inclusão, Nome é obrigatório!";

		} else if (ocorrenciaJson.getCpf() == null) {

			return "Erro na inclusão, CPF é obrigatório!";

		} else if (ocorrenciaJson.getCep() == 0) {

			return "Erro na inclusão, CEP é obrigatório!";

		} else if (ocorrenciaJson.getLocalizacao() == null) {

			return "Erro na inclusão, Localização é obrigatório!";

		} else if (ocorrenciaJson.getDescricao() == null) {

			return "Erro na inclusão, Descrição é obrigatório!";

		} else {

			// se todos os dados forem validos
			ocorrencia.setNomeSolicitante(ocorrenciaJson.getNomeSolicitante());
			ocorrencia.setCpf(ocorrenciaJson.getCpf());
			ocorrencia.setCep(ocorrenciaJson.getCep());
			ocorrencia.setDescricao(ocorrenciaJson.getDescricao());
			ocorrencia.setLocalizacao(ocorrenciaJson.getLocalizacao());
			ocorrencia.setNumeroViatura(ocorrenciaJson.getNumeroViatura());

			// Obter data autal  
			Calendar calendar = Calendar.getInstance();
			java.sql.Date data = new java.sql.Date(calendar.getTime().getTime());
			ocorrencia.setData(data);
			ocorrencia.setAreaAtingida(ocorrenciaJson.getAreaAtingida());
			getOcorrenciaService().incluir(ocorrencia);

			return "Incluido com sucesso";
		}
	}

	/**
	 * Metodo responsavel por listar todas as ocorrencias
	 * @return List<Ocorrencia>
	 * @throws IncendioException
	 */
	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ocorrencia> listar() throws IncendioException {
		return getOcorrenciaService().listar();
	}

	/**
	 * Metodo responsavel por consultar no bd um objeto com id informado
	 * @param ocorrenciaJson
	 * @return Ocorrencia
	 * @throws IncendioException
	 */
	@RequestMapping(value = "/consultar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Ocorrencia consultar(@RequestBody Ocorrencia ocorrenciaJson) throws IncendioException {

		ocorrencia = new Ocorrencia();

		ocorrencia.setId(ocorrenciaJson.getId());

		return getOcorrenciaService().consultar(ocorrencia.getId());
	}

	/**
	 * Metodo responsavel pela exclusão de uma ocorrencia
	 * @param ocorrenciaJson
	 * @return String
	 * @throws IncendioException
	 */
	@RequestMapping(value = "/excluir", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String excluir(@RequestBody Ocorrencia ocorrenciaJson) throws IncendioException {

		ocorrencia = new Ocorrencia();

		//verifica se existe o elemento antes de excluir
		if (getOcorrenciaService().consultar(ocorrenciaJson.getId()) == null) {
			
			return "Ocorrencia não existe";
		
		} else {
			ocorrencia.setId(ocorrenciaJson.getId());

			getOcorrenciaService().excluir(ocorrencia.getId());

			return "Excluido com sucesso!";
		}
	}

	/**
	 * Metodo responsavel por alterar um objeto no bd com id informado
	 * @param ocorrenciaJson
	 * @return String
	 * @throws IncendioException
	 */
	@RequestMapping(value = "/alterar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String alterar(@RequestBody Ocorrencia ocorrenciaJson) throws IncendioException {

		ocorrencia = new Ocorrencia();

		// validações de obrigatoriedade
		if (ocorrenciaJson.getNomeSolicitante() == null) {

			return "Erro na inclusão, Nome é obrigatório!";

		} else if (ocorrenciaJson.getCpf() == null) {

			return "Erro na inclusão, CPF é obrigatório!";

		} else if (ocorrenciaJson.getCep() == 0) {

			return "Erro na inclusão, CEP é obrigatório!";

		} else if (ocorrenciaJson.getLocalizacao() == null) {

			return "Erro na inclusão, Localização é obrigatório!";

		} else if (ocorrenciaJson.getDescricao() == null) {

			return "Erro na inclusão, Descrição é obrigatório!";

		} else {

		ocorrencia.setId(ocorrenciaJson.getId());
		ocorrencia.setNomeSolicitante(ocorrenciaJson.getNomeSolicitante());
		ocorrencia.setCep(ocorrenciaJson.getCep());
		ocorrencia.setDescricao(ocorrenciaJson.getDescricao());
		ocorrencia.setLocalizacao(ocorrenciaJson.getLocalizacao());
		ocorrencia.setNumeroViatura(ocorrenciaJson.getNumeroViatura());
		ocorrencia.setAreaAtingida(ocorrenciaJson.getAreaAtingida());
		ocorrencia.setCpf(ocorrenciaJson.getCpf());

		Calendar calendar = Calendar.getInstance();
		java.sql.Date data = new java.sql.Date(calendar.getTime().getTime());
		ocorrencia.setData(data);
		
		
		getOcorrenciaService().alterar(ocorrencia);

		return "Alterado com sucesso!";
		}
	}

	public OcorrenciaService getOcorrenciaService() {
		return ocorrenciaService;
	}

	public void setNotaService(OcorrenciaService ocorrenciaService) {
		this.ocorrenciaService = ocorrenciaService;
	}

}
