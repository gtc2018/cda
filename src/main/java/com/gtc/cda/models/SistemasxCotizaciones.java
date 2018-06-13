package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.gtc.cda.services.SistemaService;

/**
 * Entidad Sistemas por cotizaciones. Ésta clase contiene todos los atributos de la
 * entidad SistemasxCotizaciones.
 * 
 * @author Santiago Carrillo
 * 
 *
 */
@Entity
@Table(name = "sistemasxcotizaciones")
@Access(AccessType.FIELD)
public class SistemasxCotizaciones extends ParentEntity {

	private static final long serialVersionUID = 2369437860906179169L;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "sistema_id", nullable = false, referencedColumnName =  "id")
	private Sistema sistema;
	
	@Column(name = "cotizacion_id", nullable = false, length = 11)
	private int cotizacionId ;
	
	@Transient
	private String sistemaName;
	
	public int getCotizacionId() {
		return cotizacionId;
	}

	public void setCotizacionId(int cotizacionId) {
		this.cotizacionId = cotizacionId;
	}
	
	public Sistema getSistema() {
		return sistema;
	}
	
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	@Transient
	public String getSistemaName() {
		return sistema.getDescripcion();
	}

}
