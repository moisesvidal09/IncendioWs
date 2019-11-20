package br.pucgoias.cmp1144.util;

/**
 * Classe que encapsula as excecoes da aplicacao Nota
 * @author Moises
 *
 */
public class IncendioException extends Exception {
	
	private static final long serialVersionUID = 1189188521388183949L;
	private Exception ex;
	private String msg;

	public IncendioException(Exception e){
		ex = e;
		msg = e.getMessage();
	}

	public IncendioException(Exception e, String mensagem){
		e.printStackTrace();
		ex = e;
		msg = mensagem;
	}

	public Exception getEx() {
		return ex;
	}

	public String getMsg() {
		return msg;
	}
	
}
