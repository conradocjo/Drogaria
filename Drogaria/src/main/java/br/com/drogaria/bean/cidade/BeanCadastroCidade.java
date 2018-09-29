package br.com.drogaria.bean.cidade;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.drogaria.entidade.EntidadeCidade;
import br.com.drogaria.entidade.EntidadeEstado;
import br.com.drogaria.persistencia.DaoCidade;
import br.com.drogaria.persistencia.DaoEstado;

@ManagedBean
@ViewScoped
public class BeanCadastroCidade {

	private DaoCidade daoCidade;
	
	private DaoEstado daoEstado;

	private List<EntidadeCidade> listaCidade;
	
	private List<EntidadeEstado> listaEstado;
	
	private EntidadeEstado estado;
	
	private EntidadeEstado estadoSelecionado;

	private EntidadeCidade cidadeSelecionada;

	private EntidadeCidade cidade;

	@PostConstruct
	public void inicializar() {
		daoCidade = new DaoCidade();
		daoEstado = new DaoEstado();
		estado = new EntidadeEstado();
		cidade = new EntidadeCidade();
		listaCidade = daoCidade.listar(cidade);
		listaEstado = daoEstado.listar(estado);
	}

	public void salvarNovaCidade() {
		try {
			cidade.setEstado(getEstadoSelecionado());
			daoCidade.salvar(cidade);
			Messages.addGlobalInfo("Cidade " + getCidade().getNome() + " salva com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao gravar a cidade " + getCidade().getNome());
		} finally {
			listaCidade = daoCidade.listar(cidade);
			cidade = new EntidadeCidade();
		}
	}

	public void removerCidade(ActionEvent evento) {
		daoCidade = new DaoCidade();
		cidade = (EntidadeCidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
		try {
			daoCidade.deletarPorId(EntidadeCidade.class, cidade.getId());
			Messages.addGlobalInfo("Cidade " + cidade.getNome() + " deletada!!!");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao remover a cidade " + getCidade().getNome());
		} finally {
			listaCidade = daoCidade.listar(cidade);
		}
	}
	
	public void instanciarCidadeSelecionada() {
		cidadeSelecionada = new EntidadeCidade();
	}
	
	public void limparCampos() {
		cidadeSelecionada = new EntidadeCidade();
		estadoSelecionado = new EntidadeEstado();
	}
	

	public void editarCidade() {
		daoCidade = new DaoCidade();
		try {
			cidadeSelecionada.setEstado(estadoSelecionado);
			daoCidade.update(cidadeSelecionada);
			Messages.addGlobalInfo("Cidade " + cidade.getNome() + " atualizada!!!");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao atualizar a cidade " + getCidade().getNome());
		}
	}

	// Getters e Setters

	public List<EntidadeCidade> getListaCidade() {
		return listaCidade;
	}

	public void setListaCidade(List<EntidadeCidade> listaCidade) {
		this.listaCidade = listaCidade;
	}

	public DaoCidade getDaoCidade() {
		return daoCidade;
	}

	public void setDaoCidade(DaoCidade daoCidade) {
		this.daoCidade = daoCidade;
	}

	public EntidadeCidade getCidadeSelecionada() {
		return cidadeSelecionada;
	}

	public void setCidadeSelecionada(EntidadeCidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}

	public EntidadeCidade getCidade() {
		return cidade;
	}

	public void setCidade(EntidadeCidade cidade) {
		this.cidade = cidade;
	}

	public DaoEstado getDaoEstado() {
		return daoEstado;
	}

	public void setDaoEstado(DaoEstado daoEstado) {
		this.daoEstado = daoEstado;
	}

	public List<EntidadeEstado> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<EntidadeEstado> listaEstado) {
		this.listaEstado = listaEstado;
	}

	public EntidadeEstado getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(EntidadeEstado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	public EntidadeEstado getEstado() {
		return estado;
	}

	public void setEstado(EntidadeEstado estado) {
		this.estado = estado;
	}

}
