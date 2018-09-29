package br.com.drogaria.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name = "TB_CLIENTE")
public class EntidadeCliente extends EntidadeGenerica {

	// Temporal é a anotação para dizer que tipo de data será no banco de dados
	// (DATE, TIMESTAMP etc ...)
	@Column(name = "CL_DATA_CADASTRO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@Column(name = "CL_STATUS", nullable = false)
	private Boolean liberado;

	@OneToOne
	@JoinColumn(name = "FK_ID_PESSOA", nullable = false)
	private EntidadePessoa pessoa;

	// Getters e Setters

	public EntidadePessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EntidadePessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

}
