package br.com.drogaria.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity(name = "TB_PRODUTO")
public class EntidadeProduto extends EntidadeGenerica {

	@Column(name = "CL_DESCRICAO_DO_PRODUTO", nullable = true, length = 80)
	private String descricao;

	@Column(name = "CL_QUANTIDADE", nullable = false)
	private Short quantidade;

	// precision 6 casas, scale duas casas decimais após a vírgula
	@Column(name = "CL_PRECO", precision = 6, scale = 2)
	private BigDecimal preco;

	// Many to one seria a anotação que diz que tenho muitos produtos por fabricante
	// e digo que esta coluna é uma foreign key
	@ManyToOne
	@JoinColumn(name = "FK_ID_FABRICANTE", nullable = false)
	private EntidadeFabricante fabricante;

	// Getters e Setters

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EntidadeFabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(EntidadeFabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
