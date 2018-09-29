package br.com.drogaria.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity(name = "TB_ITEM_VENDA")
public class EntidadeItemVenda extends EntidadeGenerica {

	@Column(name = "CL_QUANTIDADE_DE_PRODUTO")
	private Short quantidade;

	@Column(name = "CL_VALOR_PARCIAL", precision = 7, scale = 2)
	private BigDecimal valorParcial;

	@ManyToOne
	@JoinColumn(name = "FK_ID_PRODUTO", nullable = false)
	private EntidadeProduto produto;

	@OneToOne
	@JoinColumn(name = "FK_ID_VENDA", nullable = false)
	private EntidadeVenda venda;

	// Getters e Setters

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}

	public EntidadeProduto getProduto() {
		return produto;
	}

	public void setProduto(EntidadeProduto produto) {
		this.produto = produto;
	}

	public EntidadeVenda getVenda() {
		return venda;
	}

	public void setVenda(EntidadeVenda venda) {
		this.venda = venda;
	}

}
