package informe;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;
import programa.CDBean;
import programa.ConexionDB;
import net.sf.jasperreports.engine.*;

public class InformeExistencias {
	
	public InformeExistencias(Vector<CDBean> CDs) {
		String reportName = "infJasperExistencias";
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		
		
		Map<String, Object> pars = new HashMap<String, Object>();

		try {
			// 1-Llenar el datasource con la informacion de la base de datos o
			
			Connection reportConex=(Connection) ConexionDB.getConexion();

			/*+Collection<CDBean> lista =CDs;
			dataSource = new JRBeanCollectionDataSource(lista);*/

			// 2-Compilamos el archivo XML y lo cargamos en memoria
			jasperReport = JasperCompileManager.compileReport(reportName
					+ ".jrxml");

			// 3-Llenamos el report con la informaci???n de la coleccion y
			// par???metros necesarios para la consulta
			jasperPrint = JasperFillManager.fillReport(jasperReport, pars,
					 reportConex);
			
			// 4-Exportamos el report a pdf y lo guardamos en disco
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"InformeExistencias.pdf");

			System.out.println("Documento generado.");
			
			try {
			     File path = new File ("InformeExistencias.pdf");
			     Desktop.getDesktop().open(path);
			}catch (IOException ex) {
			     ex.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
}