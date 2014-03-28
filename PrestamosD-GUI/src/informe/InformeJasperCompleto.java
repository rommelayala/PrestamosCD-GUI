package informe;
import java.util.*;
import programa.CD;
import programa.CDBean;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class InformeJasperCompleto {
	public void informe() {
		String reportName = "./informes/infJasperCompleto";
		JRBeanCollectionDataSource dataSource;
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		
		Map<String, Object> pars = new HashMap<String, Object>();
		pars.put("LOGO_URL", "./img/logo_universidades.gif");
		pars.put("P_TITULO", "Informe completo.");
		pars.put("P_SUBTITULO", "Rommel DataBase.");
		try {
			// 1-Llenar el datasource con la informacion de la base de datos o
			// de donde est???, en este caso "hardcoded"
			CD listaVector = new CD();
			Collection<CDBean> lista = (listaVector.getCDs());//
			dataSource = new JRBeanCollectionDataSource(lista);

			// 2-Compilamos el archivo XML y lo cargamos en memoria
			jasperReport = JasperCompileManager.compileReport(reportName
					+ ".jrxml");

			// 3-Llenamos el report con la informaci???n de la coleccion y
			// par???metros necesarios para la consulta
			jasperPrint = JasperFillManager.fillReport(jasperReport, pars,
					dataSource);
			// 4-Exportamos el report a pdf y lo guardamos en disco
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"InformeCompleto.pdf");

			System.out.println("Documento generado.");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}