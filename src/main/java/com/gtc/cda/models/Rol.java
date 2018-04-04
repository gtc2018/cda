package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Access(AccessType.FIELD)
public class Rol extends ParentEntity {

	private static final long serialVersionUID = -4420691149495131780L;
	
	
	
	@Column(name="descripcion", nullable = false, length = 100)
	private String descripcion;
	
	
	
	@Column(name="fecha_creacion", nullable = false, length = 25)
	private String fechaCreacion;
	
	@Column(name="usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;
	
	@Column(name="fecha_modificacion", nullable = false, length = 25)
	private String fechaModificacion;
	
	@Column(name="usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;
		
	
	
	
	public String getDescripcion() {
		return descripcion;
	}
	
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

	public String getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	
	
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	
	
	
	

}
