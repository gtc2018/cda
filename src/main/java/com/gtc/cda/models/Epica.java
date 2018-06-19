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
@Table(name = "epicas")
@Access(AccessType.FIELD)
public class Epica extends ParentEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7521340058894269069L;

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "requerimientos_id", nullable = false, referencedColumnName =  "id")
	private Requerimiento requerimiento;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "proyectos_id", nullable = false, referencedColumnName =  "id")
	private Proyecto proyecto;
	
	@Column(name = "descrpcion", nullable = false, length = 100)
	private String descripcion;
	
	@Column(name = "estadoe", nullable = false, length = 5)
	private int estadoe;
	
	@Column(name = "usuario_creacion", nullable = false, length = 100)
	private String usuario_creacion;
	
	@Column(name = "fecha_creacion", nullable = false, length = 20)
	private String fecha_creacion;
	
	@Column(name = "usuario_modificacion", nullable = false, length = 100)
	private String usuario_modificacion;
	
	@Column(name = "fecha_modificacion", nullable = false, length = 20)
	private String fecha_modificacion;
	
	@Transient
	private String requerimientoId;
	
	@Transient
	private String proyectoId;

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

	public int getEstadoe() {
		return estadoe;
	}

	public void setEstadoe(int estadoe) {
		this.estadoe = estadoe;
	}

	public String getUsuario_creacion() {
		return usuario_creacion;
	}

	public void setUsuario_creacion(String usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getUsuario_modificacion() {
		return usuario_modificacion;
	}

	public void setUsuario_modificacion(String usuario_modificacion) {
		this.usuario_modificacion = usuario_modificacion;
	}

	public String getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public String getRequerimientoId() {
		return requerimientoId;
	}

	public void setRequerimientoId(String requerimientoId) {
		this.requerimientoId = requerimientoId;
	}
	
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(String proyectoId) {
		this.proyectoId = proyectoId;
	}

	public Epica() {
		
	}

	public Epica(Requerimiento requerimiento, Proyecto proyecto, String descripcion, int estadoe,
			String usuario_creacion, String fecha_creacion, String usuario_modificacion, String fecha_modificacion) {
		super();
		this.requerimiento = requerimiento;
		this.proyecto = proyecto;
		this.descripcion = descripcion;
		this.estadoe = estadoe;
		this.usuario_creacion = usuario_creacion;
		this.fecha_creacion = fecha_creacion;
		this.usuario_modificacion = usuario_modificacion;
		this.fecha_modificacion = fecha_modificacion;
	}

	
	
	

}
