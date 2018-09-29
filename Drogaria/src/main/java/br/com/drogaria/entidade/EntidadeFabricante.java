package br.com.drogaria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity(name = "TB_FABRICANTE")
public class EntidadeFabricante extends EntidadeGenerica {

	@Column(name = "CL_DESCRICAO_FABRICANTE", length = 100, nullable = true)
	private String fabricante;
	
	//Getters e Setters
	
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
}
