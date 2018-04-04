package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "areas")
@Access(AccessType.FIELD)
public class Area extends ParentEntity {

	private static final long serialVersionUID = -5571572789947258639L;

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cliente_id", nullable = false, referencedColumnName =  "id")
	private Empresa cliente;

	@Column(name = "descripcion", nullable = false, length = 60)
	private String descripcion;	

	@Column(name = "fechaCreacion", nullable = false, length = 20)
	private String fechaCreacion;

	@Column(name = "usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;

	@Column(name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;

	@Column(name = "usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;
	
	public Area() {
	}		

	public Empresa getCliente() {
		return cliente;
	}

	public Area(Empresa cliente, String descripcion, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion) {
		super();
		this.cliente = cliente;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	public void setCliente(Empresa cliente) {
		this.cliente = cliente;
	}

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
