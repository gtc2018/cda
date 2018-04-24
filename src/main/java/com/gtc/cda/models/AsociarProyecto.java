package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidad Asociar Proyetos. Ésta clase contiene todos los atributos de la
 * entidad asociar proyectos.
 * 
 * @author Dirección Calidad
 *
 */
@Entity
@Table(name = "asociar_proyectos")
@Access(AccessType.FIELD)
public class AsociarProyecto extends ParentEntity {

	private static final long serialVersionUID = 2369437860906179169L;

	@Column(name = "empleado_id", nullable = false, length = 20)
	private String empleadoId;
	
	@Transient
	private String NombreEmpleado;
	
	@Transient
	private String ApellidoEmpleado;
	
	@Transient
	private String FotoEmpleado;
	
	@Transient
	private String proyectosInvolucrado;

	
	@Column(name = "proyecto_id", nullable = false, length = 20)
	private String proyectoId;

	@Column(name = "fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;

	@Column(name = "usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;

	@Column(name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;

	@Column(name = "usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;

	//private List<AsociarProyecto> listaAsociarProyecto = new ArrayList<AsociarProyecto>();

	public AsociarProyecto() {

	}

	public AsociarProyecto(String empleadoId, String proyectoId, String fechaCreacion,
			String usuarioCreacion, String fechaModificacion, String usuarioModificacion) {
		super();
		this.empleadoId = empleadoId;
		this.proyectoId = proyectoId;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		
	}	

	public String getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(String empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(String proyectoId) {
		this.proyectoId = proyectoId;
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
	public String getNombreEmpleado() {
		return NombreEmpleado;
	}

	@Transient
	public void setNombreEmpleado(String nombreEmpleado) {
		NombreEmpleado = nombreEmpleado;
	}

	@Transient
	public String getApellidoEmpleado() {
		return ApellidoEmpleado;
	}

	@Transient
	public void setApellidoEmpleado(String apellidoEmpleado) {
		ApellidoEmpleado = apellidoEmpleado;
	}

	@Transient
	public String getFotoEmpleado() {
		return FotoEmpleado;
	}

	@Transient
	public void setFotoEmpleado(String fotoEmpleado) {
		FotoEmpleado = fotoEmpleado;
	}

	@Transient
	public String getProyectosInvolucrado() {
		return proyectosInvolucrado;
	}
    
	@Transient
	public void setProyectosInvolucrado(String proyectosInvolucrado) {
		this.proyectosInvolucrado = proyectosInvolucrado;
	}


	

}
