package model;
import java.sql.Connection;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JRException;
import java.util.Map;
public abstract class JasperReportX {
	private static JasperReport report;
	private static JasperPrint reportFilled;
	private static JasperViewer viewer;
	public static void crearReport (Connection conexion, String path){
		try{
			report = (JasperReport) JRLoader.loadObjectFromFile(path);
			reportFilled= JasperFillManager.fillReport(report, null, conexion);
		}catch(JRException ex){
			ex.printStackTrace();
		}
	}
	
	public static void crearReport (Connection conexion, String path, Map parametros){
		try{
			report = (JasperReport) JRLoader.loadObjectFromFile(path);
			reportFilled= JasperFillManager.fillReport(report, parametros, conexion);
		}catch(JRException ex){
			ex.printStackTrace();
		}
	}
	
	public static void showViewer(){
		viewer = new JasperViewer(reportFilled, false);
		viewer.setVisible(true);
	}
	
	public static void exportToPDF(String destination){
		try{
			JasperExportManager.exportReportToPdfFile(reportFilled, destination);
		}catch(JRException ex){
			ex.printStackTrace();
		}
	}
}
