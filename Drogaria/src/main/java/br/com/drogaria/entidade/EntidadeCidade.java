package br.com.drogaria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity(name = "TB_CIDADE")
public class EntidadeCidade extends EntidadeGenerica {

	@Column(name = "CL_NOME", nullable = false, length = 50)
	private String nome;

	@ManyToOne
	@JoinColumn(nullable = false, name = "FK_ID_ESTADO")
	private EntidadeEstado estado;

	// Getters e Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EntidadeEstado getEstado() {
		return estado;
	}

	public void setEstado(EntidadeEstado estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
	    return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}
}
