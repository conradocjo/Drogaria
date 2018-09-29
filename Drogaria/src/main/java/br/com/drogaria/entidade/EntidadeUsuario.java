package br.com.drogaria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity(name = "TB_USUARIO")
public class EntidadeUsuario extends EntidadeGenerica {

	@Column(name = "CL_SENHA", length = 32, nullable = false)
	private String senha;

	@Column(name = "CL_TIPO_USUARIO", nullable = false)
	private Character tipo;

	@Column(name = "CL_ATIVO", nullable = false)
	private Boolean ativo;

	@OneToOne
	@JoinColumn(name = "FK_ID_PESSOA", nullable = false)
	private EntidadePessoa pessoa;

	// Getters e Setters

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public EntidadePessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EntidadePessoa pessoa) {
		this.pessoa = pessoa;
	}

}
