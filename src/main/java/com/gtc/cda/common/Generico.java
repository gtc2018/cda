package com.gtc.cda.common;

import java.io.File;
import java.io.IOException;

public class Generico {
	
	/**
	 * Metodo crear carpeta.
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public  boolean createFolder(String url) throws IOException {

		File file = new File(url);
		if (!file.isDirectory()) {
			if (file.mkdirs()) {
				return true;
			}

		} else {
			return false;
		}
		return false;

	}

}
