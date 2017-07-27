package org.macunaima.controller.imp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import org.macunaima.controller.RelatoriosController;

import com.jaspersoft.mongodb.MongoDbDataSource;
import com.jaspersoft.mongodb.connection.MongoDbConnection;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class RelatoriosControllerImp implements RelatoriosController {

	@Override
	public String printRelatorioFilial(Map<String, String> parameters) {
		return printRelatorio("report_Filial", parameters);
	}

	private String printRelatorio(String jrxmlName, Map<String, String> parameters) {
		String report_path = null;
		String mongoURI = "mongodb://myTester:xyz123@127.0.0.1:27017/macunaima";
		MongoDbConnection mongConnection = null;
		Map<String, Object> reportParameters = new HashMap<String, Object>();
		try {
			mongConnection = new MongoDbConnection(mongoURI, null, null);
			reportParameters.put(MongoDbDataSource.CONNECTION, mongConnection);
			if (parameters != null) {
				for (Entry<String, String> parameter : parameters.entrySet()) {
					reportParameters.put(parameter.getKey(), parameter.getValue());
				}
			}
			String fileName = UUID.randomUUID().toString();
			File temp_jasper = File.createTempFile(fileName, ".jasper");
			JasperCompileManager.compileReportToFile("reports\\" + jrxmlName + ".jrxml", temp_jasper.getAbsolutePath());
			JasperPrint print = JasperFillManager.fillReport(temp_jasper.getAbsolutePath(), reportParameters);
			File temp_pdf = File.createTempFile(fileName, ".pdf");
			JasperExportManager.exportReportToPdfFile(print, temp_pdf.getAbsolutePath());
			report_path = temp_pdf.getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (mongConnection != null) {
				mongConnection.close();
			}
		}
		return report_path;
	}

	@Override
	public String printRelatorioFiliais() {
		return printRelatorio("report_Filiais", null);
	}

}
