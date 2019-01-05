package Services;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;



public class RelatorioServices implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String FOLDER_RELATORIOS = "/relatorios";
	private static final String SUBREPORT_DIR = "SUBREPORT_DUR";
	private static String SEPARATOR = File.separator;
	private static String caminhoArquivoRelatorio = null;
	private JRExporter exporter = null;
	private String caminhoSubReport_dir = "";
	private File arquivoGerado = null;
	
	@SuppressWarnings("deprecation")
	public String gerarRelatorio(List<?> listaDadosBeanCollection, HashMap parametrosRelatorio, String nomeRelatorioJasper, 
				String nomeRelatorioSaida, ServletContext servletContext) throws Exception {
		
		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listaDadosBeanCollection);
		String caminhoRelatorio = servletContext.getRealPath(FOLDER_RELATORIOS);
		File file = new File(caminhoRelatorio + SEPARATOR + nomeRelatorioJasper + ".jasper");
		if(caminhoRelatorio == null
				|| (caminhoRelatorio != null && caminhoRelatorio.isEmpty())
				|| !file.exists()){
			caminhoRelatorio = this.getClass().getResource(FOLDER_RELATORIOS).getPath();
			SEPARATOR = "";
		}
		parametrosRelatorio.put("REPORT_PARAMETERS_IMG", caminhoRelatorio);

		String caminhoArquivoJasper = caminhoRelatorio + SEPARATOR + nomeRelatorioJasper + ".jasper";
		
		JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivoJasper);
		
		caminhoSubReport_dir = caminhoRelatorio + SEPARATOR;
		parametrosRelatorio.put(SUBREPORT_DIR, caminhoSubReport_dir);
		
		JasperPrint impressJasper = JasperFillManager.fillReport(relatorioJasper, parametrosRelatorio, jrbcds);
		
		exporter = new JRPdfExporter();
		
		caminhoArquivoRelatorio = caminhoRelatorio + SEPARATOR + nomeRelatorioSaida + ".pdf";
		
		arquivoGerado = new File(caminhoArquivoRelatorio);
		
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, impressJasper);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
		
		exporter.exportReport();
		arquivoGerado.deleteOnExit();
		
		return caminhoArquivoRelatorio;
	}
}
