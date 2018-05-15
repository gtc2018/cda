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
@Table(name = "involucrados")
@Access(AccessType.FIELD)
public class Involucrado extends ParentEntity {
	
	private static final long serialVersionUID = 2961714197594497953L;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "empleados_id", nullable = false, referencedColumnName =  "id")
	private Empleado empleado;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "requerimientos_id", nullable = false, referencedColumnName =  "id")
	private Requerimiento requerimiento;
	
	@Column (name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@Column (name = "fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column (name = "usuario_creacion", nullable = false, length = 100)
	private String usuarioCreacion;
	
	@Column (name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;
	
	@Column (name = "usuario_modificacion", nullable = false, length = 100)
	private String usuarioModificacion;
	
	@Transient
	private String empleadoId;
	
	@Transient
	private String requerimientoId;

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
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

	public Involucrado() {
		
	}

	public Involucrado(Empleado empleado, Requerimiento requerimiento, String componente, String descripcion, String horaAnalisis, String horaDiseño,
			String horaDesarrollo, String horaPrueba, String horaDocumentacion, String totalHora, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion) {
		super();
		this.empleado = empleado;
		this.requerimiento = requerimiento;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	@Transient
	public String getEmpleadoId() {
		return empleadoId;
	}

	@Transient
	public void setEmpleadoId(String empleadoId) {
		this.empleadoId = empleadoId;
	}

	@Transient
	public String getRequerimientoId() {
		return requerimientoId;
	}

	@Transient
	public void setRequerimientoId(String requerimientoId) {
		this.requerimientoId = requerimientoId;
	}
	
}

