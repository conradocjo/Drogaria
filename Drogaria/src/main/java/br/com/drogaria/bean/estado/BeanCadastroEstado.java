package br.com.drogaria.bean.estado;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.entidade.EntidadeEstado;
import br.com.drogaria.persistencia.DaoEstado;

@ManagedBean
@ViewScoped
public class BeanCadastroEstado {

	private EntidadeEstado entidadeEstado;

	private DaoEstado daoEstado;

	private List<EntidadeEstado> listaEstado;

	private EntidadeEstado estadoSelecionado;

	@PostConstruct
	public void Inicializar() {
		entidadeEstado = new EntidadeEstado();
		daoEstado = new DaoEstado();
		listaEstado = daoEstado.listar(entidadeEstado);
	}

	public void salvarNovoEstado() throws Exception {

		try {
			daoEstado.salvar(entidadeEstado);
			Messages.addGlobalInfo("Estado " + entidadeEstado.getNome() + " gravado com sucesso!!!");

		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Não foi possível gravar a entidade  " + entidadeEstado.getNome() + " !!!");
		} finally {
			entidadeEstado = new EntidadeEstado();
			listaEstado = daoEstado.listar(entidadeEstado);
		}

	}

	public void excluirEstado() {
		try {
			entidadeEstado = new EntidadeEstado();
			daoEstado.deletarPorId(EntidadeEstado.class, estadoSelecionado.getId());
			Messages.addGlobalInfo("Estado " + estadoSelecionado.getNome() + " deletado com sucesso!!!");
		} catch (Exception e) {
			Messages.addGlobalError("Não foi possível deletar a entidade  " + estadoSelecionado.getNome() + " !!!");
			e.printStackTrace();
		} finally {
			listaEstado = daoEstado.listar(entidadeEstado);
		}
	}
	
	public void editarEstado() {
		try {
			daoEstado.update(estadoSelecionado);
			Messages.addGlobalInfo("Estado atualizado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalInfo("Não foi possivel atualizar estado!!!");
		}
	}
	

	// Getters e Setters

	public EntidadeEstado getEntidadeEstado() {
		return entidadeEstado;
	}

	public void setEntidadeEstado(EntidadeEstado entidadeEstado) {
		this.entidadeEstado = entidadeEstado;
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

}
