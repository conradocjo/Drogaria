package br.com.drogaria.util;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class RelatorioJasper {
	/**
	 * Este é o método responsável por gerar e disponibilizar o download do
	 * relatório PDF
	 */
	public void gerarRelatorio(Map<String, Object> parametros, String caminho, List<?> dados, String nomeArquivo) {
		try {
			
			String caminhoRelatorio = FacesContext.getCurrentInstance().getExternalContext().getRealPath(caminho);
			
			File arquivo = new File(caminhoRelatorio);
			
			JRBeanCollectionDataSource fonteDeDados = new JRBeanCollectionDataSource(dados, false);
			
			JasperPrint paginaQueSeraExibida = JasperFillManager.fillReport(arquivo.getPath(), parametros, fonteDeDados);
			
			HttpServletResponse respostaHttp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

			respostaHttp.addHeader("content-disposition", "inline;filename=" + nomeArquivo);
			
			ServletOutputStream fluxoDeSaida = respostaHttp.getOutputStream();
			
			JasperExportManager.exportReportToPdfStream(paginaQueSeraExibida, fluxoDeSaida);
			
			FacesContext.getCurrentInstance().responseComplete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
