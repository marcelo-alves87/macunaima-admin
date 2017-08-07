package org.macunaima.client.printer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;

import org.macunaima.domain.RegistroCallback;

public class Printer {

	private static boolean feedPrinter(byte[] b) {
		try {
			AttributeSet attrSet = new HashPrintServiceAttributeSet(new PrinterName("MP-4200 TH", null)); // EPSON
																											// TM-U220
																											// ReceiptE4

			DocPrintJob job = PrintServiceLookup.lookupPrintServices(null, attrSet)[0].createPrintJob();

			DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
			Doc doc = new SimpleDoc(b, flavor, null);
			PrintJobWatcher pjDone = new PrintJobWatcher(job);

			job.print(doc, null);
			pjDone.waitForDone();
		} catch (javax.print.PrintException pex) {
			System.out.println("Printer Error " + pex.getMessage());
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void print(RegistroCallback registroCallback) {
		PrinterOptions p = new PrinterOptions();

		p.resetAll();
		p.alignCenter();
		p.setText(registroCallback.nomeFilial());
		p.newLine();
		p.alignCenter();
		p.setText(registroCallback.unidade());
		p.newLine();
		p.newLine();
		p.addLineSeperator();
		p.newLine();
		p.newLine();
		p.alignCenter();
		p.setText("Cupom de Desconto");
		p.newLine();
		p.newLine();
		p.addLineSeperator();
		p.newLine();
		p.newLine();
		p.alignLeft();
		p.setText("Nome\t:" + registroCallback.nomeCliente());
		p.newLine();
		p.setText("Empresa\t: " + registroCallback.nomeEmpresa());
		p.newLine();
		p.setText("Data do Cupom\t:" + formatDate(registroCallback.getDate()));
		p.newLine();
		p.setText("Utilizações\t:" + registroCallback.getUtilizacoes());
		p.newLine();
		p.addLineSeperator();
		p.newLine();
		p.newLine();
		p.alignCenter();
		p.setText("Esse presente cupom de desconto fornece " + formatGender(registroCallback)  + " " + registroCallback.nomeCliente() + " " + registroCallback.desconto() + "% de desconto no valor a ser pago.");
		p.newLine();
		p.newLine();
		p.addLineSeperator();
		p.newLine();
		p.newLine();
		p.newLine();
		p.newLine();
		p.addLineSeperator();
		p.newLine();
		p.alignCenter();
		p.setText(registroCallback.nomeCompletoCliente());
		p.newLine();
		p.newLine();
		p.newLine();
		p.newLine();
		p.feed((byte) 3);
		p.finit();
		feedPrinter(p.finalCommandSet().getBytes());

	}

	private static String formatDate(Date date) {
		String string = "";
		if (date != null) {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			string = df.format(date);
		}
		return string;
	}
	
	private static String formatGender(RegistroCallback registroCallback) {
		if(registroCallback.gender()) {
			return "ao Sr";
		} else {
			return "a Sra";
		}
	}

}
