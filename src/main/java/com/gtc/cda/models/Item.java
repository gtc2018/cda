package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/* 
 * 
 * 
 */


@Entity
@Table(name = "items")
@Access(AccessType.FIELD)
public class Item extends ParentEntity {

	private static final long serialVersionUID = -5571572789947258639L;

	@Column(name = "crear", nullable = false, length = 100)
	private String crear;

	@Column(name = "editar", nullable = false, length = 100)
	private String editar;

	@Column(name = "eliminar", nullable = false, length = 100)
	private String eliminar;

	@Column(name = "leer", nullable = false, length = 100)
	private String leer;

	@Column(name = "fechaCreacion", nullable = false, length = 20)
	private String fechaCreacion;

	@Column(name = "usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;

	@Column(name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;

	@Column(name = "usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;

	/**
	 * Relacion tabla Item permisos.
	 */
	
	public Item() {

	}

	public Item(String crear, String editar, String eliminar, String leer, String url, String icono,
			String fechaCreacion, String usuarioCreacion, String fechaModificacion, String usuarioModificacion
			) {
		super();
		this.crear = crear;
		this.editar = editar;
		this.eliminar = eliminar;
		this.leer = leer;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		
	}

	public String getCrear() {
		return crear;
	}

	public void setCrear(String crear) {
		this.crear = crear;
	}

	public String getEditar() {
		return editar;
	}

	public void setEditar(String editar) {
		this.editar = editar;
	}

	public String getEliminar() {
		return eliminar;
	}

	public void setEliminar(String eliminar) {
		this.eliminar = eliminar;
	}

	public String getLeer() {
		return leer;
	}

	public void setLeer(String leer) {
		this.leer = leer;
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
