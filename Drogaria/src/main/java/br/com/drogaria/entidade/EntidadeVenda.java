package br.com.drogaria.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name = "TB_VENDA")
public class EntidadeVenda extends EntidadeGenerica {

	@Column(name = "CL_HORARIO_VENDA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;

	@Column(name = "CL_VALOR_VENDA", scale = 2, precision = 7)
	private BigDecimal valorTotal;

	// Esta coluna aceita nulo. o nulo serão vendas a vista.
	@ManyToOne
	@JoinColumn(name = "FK_ID_CLIENTE")
	private EntidadeCliente cliente;

	@ManyToOne
	@JoinColumn(name = "FK_ID_FUNCIONARIO", nullable = false)
	private EntidadeFuncionario funcionario;

	// Getters e Setters

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public EntidadeFuncionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(EntidadeFuncionario funcionario) {
		this.funcionario = funcionario;
	}

	public EntidadeCliente getCliente() {
		return cliente;
	}

	public void setCliente(EntidadeCliente cliente) {
		this.cliente = cliente;
	}
}
