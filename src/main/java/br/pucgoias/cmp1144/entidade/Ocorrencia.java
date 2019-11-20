package br.pucgoias.cmp1144.entidade;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ocorrencia")
public class Ocorrencia {

	private static final long serialVersionUID = 6487849002108370775L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nomeSolicitante")
	private String nomeSolicitante;

	@Column(name = "numeroViatura")
	private int numeroViatura;

	@Column(name = "cep")
	private int cep;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "localizacao")
	private String localizacao;

	@Column(name = "data")
	private Date data;

	@Column(name = "areaAtingida")
	private double areaAtingida;

	public String getNomeSolicitante() {
		return nomeSolicitante;
	}

	public void setNomeSolicitante(String nomeSolicitante) {
		this.nomeSolicitante = nomeSolicitante;
	}

	public int getNumeroViatura() {
		return numeroViatura;
	}

	public void setNumeroViatura(int numeroViatura) {
		this.numeroViatura = numeroViatura;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getAreaAtingida() {
		return areaAtingida;
	}

	public void setAreaAtingida(double areaAtingida) {
		this.areaAtingida = areaAtingida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(areaAtingida);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + cep;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
		result = prime * result + ((nomeSolicitante == null) ? 0 : nomeSolicitante.hashCode());
		result = prime * result + numeroViatura;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ocorrencia other = (Ocorrencia) obj;
		if (Double.doubleToLongBits(areaAtingida) != Double.doubleToLongBits(other.areaAtingida))
			return false;
		if (cep != other.cep)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		if (nomeSolicitante == null) {
			if (other.nomeSolicitante != null)
				return false;
		} else if (!nomeSolicitante.equals(other.nomeSolicitante))
			return false;
		if (numeroViatura != other.numeroViatura)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ocorrencia [id=" + id + ", nomeSolicitante=" + nomeSolicitante + ", numeroViatura=" + numeroViatura
				+ ", cep=" + cep + ", descricao=" + descricao + ", localizacao=" + localizacao + ", data=" + data
				+ ", areaAtingida=" + areaAtingida + "]";
	}

}
