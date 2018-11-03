package br.com.drogaria.servicos;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.drogaria.entidade.EntidadeEstado;
import br.com.drogaria.persistencia.DaoEstado;

@Path("/teste")
public class ResourcesTeste {
	
	@GET
	public String testerino() {
		return "Teste ok!";
	}
	
	@GET
	@Path("/estados")
	@Produces(MediaType.APPLICATION_JSON)
	public String listarEstado() {
		DaoEstado dao = new DaoEstado();
		String json = null;
		Gson gson = new Gson();
		try {
			List<EntidadeEstado> estados = dao.listar(new EntidadeEstado());
			json = gson.toJson(estados);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
