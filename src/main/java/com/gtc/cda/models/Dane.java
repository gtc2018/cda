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
@Table(name = "dane")
@Access(AccessType.FIELD)
public class Dane extends ParentEntity {

	private static final long serialVersionUID = -5571572789947258639L;

//	@ManyToOne(cascade=CascadeType.REFRESH)
//	@JoinColumn(name = "PARENTID", nullable = false, referencedColumnName =  "id")
//	private Dane padre;

	@Column(name = "PARENTID", nullable = false, length = 60)
	private String padre;
	
	@Column(name = "CODE", nullable = false, length = 60)
	private String codigo;	

	@Column(name = "name", nullable = false, length = 60)
	private String descripcion;

	@Column(name = "TYPEID", nullable = false, length = 20)
	private String tipo;
	
	@Transient
	private String padreId;
	
	public Dane() {
	}		

	public Dane(String padre, String codigo, String descripcion, String tipo) {
		super();
		this.padre = padre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}

//	public Dane getPadre() {
//		return padre;
//	}
//
//	public void setPadre(Dane padre) {
//		this.padre = padre;
//	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public String getPadre() {
		return padre;
	}

	public void setPadre(String padre) {
		this.padre = padre;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Transient
	public String getPadreId() {
		return padreId;
	}

	@Transient
	public void setPadreId(String padreId) {
		this.padreId = padreId;
	}
	
	
	
	
	

}
