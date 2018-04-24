package com.gtc.cda.common;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

public class Archivo {
	
	public String decodeBase64(String file, String url) throws IOException {
		System.out.println("===========ARCHIVO DE CODIFICADO===================");
		System.out.println(file);

		if (file != null) {

			byte[] decodedFile = DatatypeConverter.parseBase64Binary(file);
			FileOutputStream fileOutputStream = new FileOutputStream(url);
			fileOutputStream.write(decodedFile);
			fileOutputStream.flush();
			fileOutputStream.close();

			return "Opercion Exitosa";
		} else {
			return "Error";
		}
	}

}
