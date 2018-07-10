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
@Table(name = "documento_proyecto")
@Access(AccessType.FIELD)
public class DocumentoProyecto extends ParentEntity {

	private static final long serialVersionUID = -5571572789947258639L;

	//Variables y columnas
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "proyectos_id", nullable = false, referencedColumnName =  "id")
	private Proyecto proyecto;

	@Column(name = "archivo", nullable = false, length = 300)
	private String archivo;
	
	@Column(name = "descripcion", nullable = false, length = 45)
	private String descripcion;

	@Column(name = "nombre", nullable = false, length = 20)
	private String nombre;
	
	@Column(name = "fechaCreacion", nullable = false, length = 20)
	private String fechaCreacion;

	@Column(name = "usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;

	@Column(name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;

	@Column(name = "usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;
	
	@Transient
	private String proyectoId;
	
	@Transient
	private String docBits;
	
	public DocumentoProyecto() {
	}		


	public DocumentoProyecto(Proyecto proyecto, String descripcion,
			String nombre, String archivo, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion) {
		super();
		this.proyecto = proyecto;
		this.nombre = nombre;
		this.archivo = archivo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	//Set y Get *********************************************

	public String getArchivo() {
		return archivo;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@Transient
	public String getProyectoId() {
		return proyectoId;
	}

	@Transient
	public void setProyectoId(String proyectoId) {
		this.proyectoId = proyectoId;
	}


	@Transient
	public String getDocBits() {
		return docBits;
	}

	@Transient
	public void setDocBits(String docBits) {
		this.docBits = docBits;
	}
	
	
	
	

}
