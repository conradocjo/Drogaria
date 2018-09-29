package br.com.drogaria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity(name = "TB_PESSOA")
public class EntidadePessoa extends EntidadeGenerica {

	@Column(name = "CL_NOME", length = 60, nullable = false)
	private String nome;

	@Column(name = "CL_CPF", length = 14, nullable = false)
	private String cpf;

	@Column(name = "CL_RG", length = 12, nullable = false)
	private String rg;

	@Column(name = "CL_RUA", length = 60, nullable = false)
	private String rua;

	@Column(name = "CL_NUMERO", length = 6, nullable = true)
	private Short numero;

	@Column(name = "CL_BAIRRO", length = 20, nullable = true)
	private String bairro;

	@Column(name = "CL_CEP", length = 12, nullable = false)
	private String cep;

	@Column(name = "CL_COMPLEMENTO", length = 12, nullable = false)
	private String complemento;

	@Column(name = "CL_TELEFONE", length = 9, nullable = true)
	private String telefone;

	@Column(name = "CL_CELULAR", length = 10, nullable = true)
	private String celular;

	@Column(name = "CL_EMAIL", length = 50, nullable = true)
	private String email;

	@ManyToOne
	@JoinColumn(nullable = false, name = "FK_ID_CIDADE")
	private EntidadeCidade cidade;

	// Getters e Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Short getNumero() {
		return numero;
	}

	public void setNumero(Short numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EntidadeCidade getCidade() {
		return cidade;
	}

	public void setCidade(EntidadeCidade cidade) {
		this.cidade = cidade;
	}
}
