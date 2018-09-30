package br.com.drogaria.bean.fabricante;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.junit.Test;
import org.omnifaces.util.Messages;

import br.com.drogaria.entidade.EntidadeFabricante;
import br.com.drogaria.entidade.EntidadeProduto;
import br.com.drogaria.persistencia.DaoFabricante;
import br.com.drogaria.persistencia.DaoProduto;

@ManagedBean
@ViewScoped
public class BeanCadastroProduto {

	private EntidadeProduto produto;
	private EntidadeProduto produtoSelecionado;
	private EntidadeFabricante fabricanteSelecionado;
	private List<EntidadeFabricante> listaFabricantes;
	private List<EntidadeProduto> listaDeProdutos;
	DaoProduto dao = new DaoProduto();

	@PostConstruct
	public void inicializar() {
		setProduto(new EntidadeProduto());
		produtoSelecionado = new EntidadeProduto();
		fabricanteSelecionado = new EntidadeFabricante();
		setListaFabricantes(new DaoFabricante().listar(new EntidadeFabricante()));
		listaDeProdutos = dao.listar(produto);
	}

	public void remover() {
		try {
			dao.deletar(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editar() {

	}

	public void salvar() {
		produto.setFabricante(fabricanteSelecionado);
		try {
			dao.update(produto);
			Messages.addGlobalInfo("Produto" + " " + produto.getDescricao() + " gravado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao gravar produto.");
		}
	}

	// Getters e Setters

	public EntidadeProduto getProduto() {
		return produto;
	}

	public void setProduto(EntidadeProduto produto) {
		this.produto = produto;
	}

	public EntidadeProduto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(EntidadeProduto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public List<EntidadeFabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<EntidadeFabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public List<EntidadeProduto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<EntidadeProduto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public EntidadeFabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(EntidadeFabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
}
