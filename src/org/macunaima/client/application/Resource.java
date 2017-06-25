package org.macunaima.client.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.macunaima.domain.Filial;

public class Resource {

	public static void setFilialId(Filial filial) {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("resources/client.properties");

			prop.setProperty("id", filial.getId());

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public static String getFilialId() {
		String return1 = null;
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("resources/client.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			return1 = prop.getProperty("id");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return return1;
	}
}
