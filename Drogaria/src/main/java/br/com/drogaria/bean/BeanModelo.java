package br.com.drogaria.bean;

import java.util.List;
import java.util.Map;

import br.com.drogaria.util.RelatorioJasper;

public class BeanModelo {

	public void gerarRelatorioPDF(Map<String, Object> parametros, String caminho, List<?> dados, String nomeArquivo) {
		RelatorioJasper relatorio = new RelatorioJasper();
		try {
			relatorio.gerarRelatorio(parametros, caminho, dados, nomeArquivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
