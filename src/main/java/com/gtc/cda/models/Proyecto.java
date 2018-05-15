package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "proyectos")
@Access(AccessType.FIELD)
public class Proyecto extends ParentEntity {

	private static final long serialVersionUID = 8234224536518540417L;
	
	@Column(name="cliente_id", nullable = false, length = 20)
	private Long clienteId;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name="descripcion", nullable = false, length = 300)
	private String descripcion;
	
	@Column(name="tipo", nullable = false, length = 50)
	private String tipo;
	
	@Column(name="url_carpeta", nullable = false, length = 20)
	private String urlCarpeta;
	
	@Column(name="fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column(name="usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;
	
	@Column(name="fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;
	
	@Column(name="usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;
	
	

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getUrlCarpeta() {
		return urlCarpeta;
	}

	public void setUrlCarpeta(String urlCarpeta) {
		this.urlCarpeta = urlCarpeta;
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
