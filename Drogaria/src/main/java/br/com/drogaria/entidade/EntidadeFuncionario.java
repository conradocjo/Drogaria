package br.com.drogaria.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name = "TB_FUNCIONARIO")
public class EntidadeFuncionario extends EntidadeGenerica {

	@Column(name = "CL_CARTEIRA_TRABALHO", nullable = false)
	private String carteiraTrabalho;

	@Column(name = "CL_DATA_DA_ADMISSAO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@OneToOne
	@JoinColumn(name = "FK_ID_PESSOA", nullable = false)
	private EntidadePessoa pessoa;

	// Getters e Setters

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public EntidadePessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EntidadePessoa pessoa) {
		this.pessoa = pessoa;
	}

}
