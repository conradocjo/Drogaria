package br.com.drogaria.teste;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Persistence;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.entidade.EntidadeCidade;
import br.com.drogaria.entidade.EntidadeCliente;
import br.com.drogaria.entidade.EntidadeEstado;
import br.com.drogaria.entidade.EntidadeFabricante;
import br.com.drogaria.entidade.EntidadePessoa;
import br.com.drogaria.entidade.EntidadeProduto;
import br.com.drogaria.entidade.EntidadeUsuario;
import br.com.drogaria.persistencia.DaoCidade;
import br.com.drogaria.persistencia.DaoCliente;
import br.com.drogaria.persistencia.DaoEstado;
import br.com.drogaria.persistencia.DaoFabricante;
import br.com.drogaria.persistencia.DaoPessoa;
import br.com.drogaria.persistencia.DaoProduto;

public class Teste {

	@Ignore
	@Test
	public void testFactory() {
		Persistence.createEntityManagerFactory("drogaria");

	}

	@Ignore
	@Test
	public void novoEstado() throws Exception {
		EntidadeEstado estado = new EntidadeEstado();
		DaoEstado novaTransacaoBancoDeDados = new DaoEstado();

		estado.setNome("São Paulo");
		estado.setSigla("SP");

		novaTransacaoBancoDeDados.salvar(estado);

	}

	@Ignore
	@Test
	public void salvarNovaCidade() throws Exception {
		EntidadeCidade cidade = new EntidadeCidade();
		DaoCidade daoCidade = new DaoCidade();
		DaoEstado daoEstado = new DaoEstado();

		try {
			EntidadeEstado estado = (EntidadeEstado) daoEstado.listarPorId(1L, EntidadeEstado.class);
			cidade.setEstado(estado);
			cidade.setNome("TesteApagar");

			daoCidade.salvar(cidade);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Ignore
	@Test
	public void excluirCidade() {
		DaoCidade dao = new DaoCidade();
		dao.deletarPorId(EntidadeCidade.class, 16L);
	}

	@Ignore
	@Test
	public void editarCidade() {
		EntidadeCidade cidade = new EntidadeCidade();
		DaoCidade dao = new DaoCidade();

		cidade = dao.buscarPorID(EntidadeCidade.class, 11L);
		System.out.println(cidade.getNome() + " / " + cidade.getEstado().getNome());
		cidade.setNome("Guarapuava");
		dao.update(cidade);
		System.out.println(cidade.getNome() + " / " + cidade.getEstado().getNome());
	}

	/**
	 * O debaixo ta funcionando
	 */

	@Ignore
	@Test
	public void listarEstado() {
		Class<EntidadeEstado> et;
		EntidadeEstado novaEt = new EntidadeEstado();
		DaoEstado daoEstado = new DaoEstado();

		List<EntidadeEstado> list = daoEstado.listar(novaEt);

		EntidadeEstado listaEstado = (EntidadeEstado) daoEstado.listarPorId(1L, EntidadeEstado.class);

		System.out.println(listaEstado.getNome() + " / " + listaEstado.getSigla());

		for (EntidadeEstado entidadeEstado : list) {
			System.out.println(entidadeEstado.getNome() + " / " + entidadeEstado.getSigla());
		}
	}

	@Ignore
	@Test
	public void novaCidade() throws Exception {
		DaoCidade gravarNovaCidade = new DaoCidade();
		EntidadeCidade novaCidade = new EntidadeCidade();
		DaoEstado pesquisarPorEstado = new DaoEstado();
		EntidadeEstado estadots = new EntidadeEstado();

		List<EntidadeEstado> estadoTeste = pesquisarPorEstado.listar(estadots);

		for (EntidadeEstado entidadeEstado : estadoTeste) {
			System.out.println(entidadeEstado.getNome());
			novaCidade.setEstado(entidadeEstado);
		}
		novaCidade.setNome("Sao Sebastião do anta");

		gravarNovaCidade.salvar(novaCidade);

	}

	@Ignore
	@Test
	public void novousuario() {
		EntidadeUsuario usuario = new EntidadeUsuario();

		usuario.setAtivo(true);
	}

	@Ignore
	@Test
	public void novaPessoa() throws Exception {
		DaoCidade daoc = new DaoCidade();
		DaoPessoa daop = new DaoPessoa();

		EntidadePessoa novaPessoa = new EntidadePessoa();
		EntidadeCidade cidade = new EntidadeCidade();

		cidade = (EntidadeCidade) daoc.listarPorId(new Long("12"), EntidadeCidade.class);

		novaPessoa.setBairro("Bairro x");
		novaPessoa.setCelular("99999999");
		novaPessoa.setTelefone("999999999");
		novaPessoa.setCep("99999999");
		novaPessoa.setCidade(cidade);
		novaPessoa.setComplemento("Casa");
		novaPessoa.setCpf("777777777");
		novaPessoa.setEmail("fulano@teste.com");
		novaPessoa.setNome("Fulano De Oliveira");
		novaPessoa.setNumero((short) 18);
		novaPessoa.setRg("77777777");
		novaPessoa.setRua("Rua Dos Cabrito");

		daop.salvar(novaPessoa);

	}

	@Ignore
	@Test
	public void cadastrarNovoProduto() throws Exception {
		EntidadeProduto novoProduto = new EntidadeProduto();
		DaoProduto daoProduto = new DaoProduto();
		String descricao = "Capitopril 50mg";
		BigDecimal preco = new BigDecimal(6.70);
		Short quantidade = new Short((short) 5);
		DaoFabricante daoFabricante = new DaoFabricante();
		EntidadeFabricante fabricante = new EntidadeFabricante();

		fabricante = (EntidadeFabricante) daoFabricante.listarPorId(new Long("22"), EntidadeFabricante.class);

		novoProduto.setDescricao(descricao);
		novoProduto.setPreco(preco);
		novoProduto.setQuantidade(quantidade);
		novoProduto.setFabricante(fabricante);

		daoProduto.salvar(novoProduto);
	}

	@Ignore
	@Test
	public void cadastrarFabricante() throws Exception {
		EntidadeFabricante fabricante = new EntidadeFabricante();
		DaoFabricante dao = new DaoFabricante();
		fabricante.setFabricante("ChalengeEverythingLife");
		dao.salvar(fabricante);
	}

	@Ignore
	@Test
	public void gravarCliente() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Boolean liberado = true;
		DaoCliente daoc = new DaoCliente();
		EntidadeCliente cliente = new EntidadeCliente();
		DaoPessoa daop = new DaoPessoa();
		cliente.setDataCadastro(format.parse("10/08/2018"));
		cliente.setLiberado(liberado);
		cliente.setPessoa(daop.buscarPorID(EntidadePessoa.class, 30L));
		try {
			daoc.salvar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	https://www.youtube.com/watch?v=70ec9IMIKyg&index=31&list=PL_GwGUsBlNyfI0W3ggfffhBdJUqB4981Z - > Parei aqui
	
	
}
