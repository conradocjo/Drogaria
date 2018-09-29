package br.com.drogaria.bean.fabricante;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.entidade.EntidadeFabricante;
import br.com.drogaria.persistencia.DaoFabricante;

@ManagedBean
@ViewScoped
public class BeanCadastroFabricante extends BeanFabricante {

	private EntidadeFabricante fabricante;

	private DaoFabricante daoFabricante;

	private EntidadeFabricante fabricanteSelecionado;

	private List<EntidadeFabricante> listaFabricante;

	@PostConstruct
	public void inicializar() {
		fabricante = new EntidadeFabricante();
		daoFabricante = new DaoFabricante();
		listaFabricante = daoFabricante.listar(fabricante);
	}

	public void cadastrarNovoFabricante() {
		try {
			Messages.addGlobalInfo("Fabricante " + getFabricante().getFabricante() + " cadastrado!!!");
			daoFabricante.salvar(fabricante);
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao adicionar fabricante " + getFabricante().getFabricante() + " !!!");
			e.printStackTrace();
		} finally {
			fabricante = new EntidadeFabricante();
			listaFabricante = daoFabricante.listar(fabricante);
		}
	}

	public void deletarFabricante() {
		try {
			daoFabricante.deletarPorId(EntidadeFabricante.class, fabricanteSelecionado.getId());
			Messages.addGlobalInfo("Fabricante " + getFabricanteSelecionado().getFabricante() + " deletado !!!");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao deletar " + getFabricanteSelecionado().getFabricante());
			e.printStackTrace();
		} finally {
			listaFabricante = daoFabricante.listar(fabricante);
		}
	}

	public void editarFabricante() {
		try {
			daoFabricante.update(fabricanteSelecionado);
			Messages.addGlobalInfo("Fabricante " + getFabricanteSelecionado().getFabricante() + " salvo !!!");
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao deletar " + getFabricanteSelecionado().getFabricante());
			e.printStackTrace();
		} finally {
			listaFabricante = daoFabricante.listar(fabricante);
		}
	}

	// Getters e Setters

	public EntidadeFabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(EntidadeFabricante fabricante) {
		this.fabricante = fabricante;
	}

	public DaoFabricante getDaoFabricante() {
		return daoFabricante;
	}

	public void setDaoFabricante(DaoFabricante daoFabricante) {
		this.daoFabricante = daoFabricante;
	}

	public EntidadeFabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(EntidadeFabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}

	public List<EntidadeFabricante> getListaFabricante() {
		return listaFabricante;
	}

	public void setListaFabricante(List<EntidadeFabricante> listaFabricante) {
		this.listaFabricante = listaFabricante;
	}

}
