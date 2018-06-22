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

@Entity
@Table(name = "epicasxrequerimientos")
@Access(AccessType.FIELD)
public class EpicasxRequerimiento extends ParentEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7232792175312795806L;
	
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "epicas_id", nullable = false, referencedColumnName =  "id")
	private Epica epica;
	
	@Column(name = "requerimientos_id", nullable = false, length = 11)
	private int requerimientoId;
	
	@Transient
	private String epicaDescripcion;

	public Epica getEpica() {
		return epica;
	}

	public void setEpica(Epica epica) {
		this.epica = epica;
	}

	public int getRequerimientoId() {
		return requerimientoId;
	}

	public void setRequerimientoId(int requerimientoId) {
		this.requerimientoId = requerimientoId;
	}

	public String getEpicaDescripcion() {
		return epicaDescripcion;
	}

	public void setEpicaDescripcion(String epicaDescripcion) {
		this.epicaDescripcion = epicaDescripcion;
	}

	
	
	public EpicasxRequerimiento() {
	}

	public EpicasxRequerimiento(Epica epica, int requerimientoId, String epicaDescripcion) {
		super();
		this.epica = epica;
		this.requerimientoId = requerimientoId;
		this.epicaDescripcion = epicaDescripcion;
	}
	
	
	

}
