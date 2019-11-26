package br.pucgoias.cmp1144.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.pucgoias.cmp1144.entidade.Ocorrencia;
import br.pucgoias.cmp1144.negocio.OcorrenciaService;
import br.pucgoias.cmp1144.util.IncendioException;

@RestController
@RequestMapping("/ocorrenciaController")
public class OcorrenciaController {

	@Autowired
	private OcorrenciaService ocorrenciaService;
	
	Ocorrencia ocorrencia;
	//private OcorrenciaDAOImpl ocorrenciaDAO;
//	public EntityManagerFactory factory = Persistence.createEntityManagerFactory("incendio");

	@RequestMapping(value = "/inserir", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HttpStatus inserir(@RequestBody Ocorrencia ocorrenciaJson) throws IncendioException {

		ocorrencia = new Ocorrencia();

		ocorrencia.setNomeSolicitante(ocorrenciaJson.getNomeSolicitante());
		ocorrencia.setCep(ocorrenciaJson.getCep());
		ocorrencia.setDescricao(ocorrenciaJson.getDescricao());
		ocorrencia.setLocalizacao(ocorrenciaJson.getLocalizacao());
		ocorrencia.setNumeroViatura(ocorrenciaJson.getNumeroViatura());
		ocorrencia.setData(ocorrenciaJson.getData());
		ocorrencia.setAreaAtingida(ocorrenciaJson.getAreaAtingida());

		getOcorrenciaService().incluir(ocorrencia);
		
		return HttpStatus.OK;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ocorrencia> listar() throws IncendioException {

		List<Ocorrencia> ocorrencias;

		//ocorrencias = OcorrenciaDAOImpl.getInstance().listar();

		return getOcorrenciaService().listar();
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Ocorrencia consultar(@RequestBody Ocorrencia ocorrenciaJson) throws IncendioException {

		ocorrencia = new Ocorrencia();

		ocorrencia.setId(ocorrenciaJson.getId());

		return getOcorrenciaService().consultar(ocorrencia.getId());
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String excluir(@RequestBody Ocorrencia ocorrenciaJson) throws IncendioException {

		ocorrencia = new Ocorrencia();

		ocorrencia.setId(ocorrenciaJson.getId());

		getOcorrenciaService().excluir(ocorrencia.getId());

		return "OK";
	}

	@RequestMapping(value = "/alterar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String alterar(@RequestBody Ocorrencia ocorrenciaJson) throws IncendioException {

		ocorrencia = new Ocorrencia();

		ocorrencia.setId(ocorrenciaJson.getId());
		ocorrencia.setNomeSolicitante(ocorrenciaJson.getNomeSolicitante());
		ocorrencia.setCep(ocorrenciaJson.getCep());
		ocorrencia.setDescricao(ocorrenciaJson.getDescricao());
		ocorrencia.setLocalizacao(ocorrenciaJson.getLocalizacao());
		ocorrencia.setNumeroViatura(ocorrenciaJson.getNumeroViatura());
		ocorrencia.setData(ocorrenciaJson.getData());
		ocorrencia.setAreaAtingida(ocorrenciaJson.getAreaAtingida());

		getOcorrenciaService().alterar(ocorrencia);

		return "";
	}

	
	public OcorrenciaService getOcorrenciaService() {
		return ocorrenciaService;
	}

	public void setNotaService(OcorrenciaService ocorrenciaService) {
		this.ocorrenciaService = ocorrenciaService;
	}

	
}
