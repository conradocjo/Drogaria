package br.com.drogaria.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.drogaria.entidade.EntidadeEstado;

public class DaoGeneric<Entidade> {

	/**
	 * o objeto abaixo será populado com informações do Persistence.xml Estas
	 * informações serão atribuidas caso o mesmo esteja vazio e o método novaFabrica
	 * irá retornar um gerenciador de entidade da unidade de persistencia
	 */

	private static EntityManagerFactory unidadePersistencia = null;

	public static EntityManager novoGerenciadorDeEntidadeDaUnidadeDePersistenciaDrogaria() {
		if (unidadePersistencia == null) {
			unidadePersistencia = Persistence.createEntityManagerFactory("drogaria");
		}
		EntityManager gerenciadorDeEntidade = unidadePersistencia.createEntityManager();

		return gerenciadorDeEntidade;
	}

	/**
	 * As classes abaixo são para fazer o CRUD de maneira genérica.
	 * 
	 * @throws Exception
	 * 
	 */

	public void salvar(Entidade entidade) throws Exception {
		EntityManager gerenciarEntidade = novoGerenciadorDeEntidadeDaUnidadeDePersistenciaDrogaria();
		try {
			gerenciarEntidade.getTransaction().begin();
			gerenciarEntidade.persist(entidade);
			gerenciarEntidade.getTransaction().commit();

		} catch (Exception e) {
			gerenciarEntidade.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			gerenciarEntidade.close();
		}
	}

	public void deletar(Entidade entidade) {
		EntityManager gerenciarEntidade = novoGerenciadorDeEntidadeDaUnidadeDePersistenciaDrogaria();
		try {
			gerenciarEntidade.getTransaction().begin();
			gerenciarEntidade.remove(entidade);
			gerenciarEntidade.getTransaction().commit();

		} catch (Exception e) {
			gerenciarEntidade.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			gerenciarEntidade.close();
		}

	}
	
	
	public void deletarPorId(Class<Entidade> classe, Long id) {
		EntityManager gerenciadorEntidade = novoGerenciadorDeEntidadeDaUnidadeDePersistenciaDrogaria();
		Object objeto = null;
		try {
			gerenciadorEntidade.getTransaction().begin();
			objeto = gerenciadorEntidade.find(classe, id);
			gerenciadorEntidade.remove(objeto);
			gerenciadorEntidade.getTransaction().commit();
		} catch (Exception e) {
			gerenciadorEntidade.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			gerenciadorEntidade.close();
		}
	}
	

	public void update(Entidade entidade) {
		EntityManager gerenciarEntidade = novoGerenciadorDeEntidadeDaUnidadeDePersistenciaDrogaria();
		try {
			gerenciarEntidade.getTransaction().begin();
			gerenciarEntidade.merge(entidade);
			gerenciarEntidade.getTransaction().commit();

		} catch (Exception e) {
			gerenciarEntidade.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			gerenciarEntidade.close();
		}

	}

	@SuppressWarnings("unchecked")
	public Entidade buscarPorID(Class<Entidade> classe, Long id) {

		EntityManager gerenciarEntidade = novoGerenciadorDeEntidadeDaUnidadeDePersistenciaDrogaria();
		Object objeto = null;
		try {
			objeto = gerenciarEntidade.find(classe, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gerenciarEntidade.close();
		}
		return (Entidade) objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar(Entidade entidade) {
		EntityManager gerenciarEntidade = novoGerenciadorDeEntidadeDaUnidadeDePersistenciaDrogaria();
		List<Entidade> listaEntidadeGenerica = new ArrayList<>();
		try {
			listaEntidadeGenerica = gerenciarEntidade.createQuery("FROM " + entidade.getClass().getName())
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEntidadeGenerica;
	}

	public Object listarPorId(Long id, Class<Entidade> entidade) {
		EntityManager gerenciarEntidade = novoGerenciadorDeEntidadeDaUnidadeDePersistenciaDrogaria();
		Object resultado = null;
		try {
			
			resultado =  gerenciarEntidade.find(entidade, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gerenciarEntidade.close();
		}
		return resultado;
	}

}
