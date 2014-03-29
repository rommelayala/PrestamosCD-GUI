package informe;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

import programa.CD;
import programa.CDBean;
import programa.ConexionDB;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class InformePrestado {
	
	public InformePrestado(Vector<CDBean> CDs) {
		String reportName = "infJasperPrestado";
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
					"InformePrestados.pdf");

			System.out.println("Documento generado.");
			
			try {
			     File path = new File ("InformePrestados.pdf");
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