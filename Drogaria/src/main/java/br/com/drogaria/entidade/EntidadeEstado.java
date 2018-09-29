package br.com.drogaria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity(name = "TB_ESTADO")
public class EntidadeEstado extends EntidadeGenerica {
	
	@Column(name="CL_SIGLA", length = 2, nullable = false)
	private String sigla;
	
	@Column(name="CL_NOME", length = 50, nullable = false)
	private String nome;
	
	//Getters e Setters
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
