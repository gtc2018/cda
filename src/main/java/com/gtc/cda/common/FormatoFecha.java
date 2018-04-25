package com.gtc.cda.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class FormatoFecha {
	
	public final String FORMATO_YYYY_MM_DD = "yyyy-MM-dd HH:mm:ss";

	public String fecha(String formato, Date fecha) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(formato, new Locale("es", "CO"));
		String FechaFormat = format.format(fecha);
		Date fech = new Date();
		System.out.println("**************HOY ES: **********"+fech);
		System.out.println("**************FECHA FORMATEADA.**********"+FechaFormat);
		return FechaFormat;
	}

}
