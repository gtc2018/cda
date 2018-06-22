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
@Table(name = "planeaciones")
@Access(AccessType.FIELD)
public class Planeacion extends ParentEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -948644242498940969L;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "clientes_id", nullable = false, referencedColumnName =  "id")
	private Empresa cliente;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "proyectos_id", nullable = false, referencedColumnName =  "id")
	private Proyecto proyecto;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "requerimientos_id", nullable = false, referencedColumnName =  "id")
	private Requerimiento requerimiento;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "epicas_id", nullable = false, referencedColumnName =  "id")
	private Epica epica;
	
	@Column (name = "titulo", nullable = false, length = 100)
	private String titulo;
	
	@Column (name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@Column (name = "fecha_inicio", nullable = false, length = 20)
	private String fechaInicio;
	
	@Column (name = "fecha_fin", nullable = false, length = 20)
	private String fechaFin;
	
	@Column (name = "fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column (name = "usuario_creacion", nullable = false, length = 100)
	private String usuarioCreacion;
	
	@Column (name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;
	
	@Column (name = "usuario_modificacion", nullable = false, length = 100)
	private String usuarioModificacion;
	
	@Column (name = "estado", nullable = false, length = 100)
	private int estado;
	
	@Transient
	private String clienteId;
	
	@Transient
	private String proyectoId;
	
	@Transient
	private String requerimientoId;
	
	@Transient
	private String epicaId;

	public Empresa getCliente() {
		return cliente;
	}

	public void setCliente(Empresa cliente) {
		this.cliente = cliente;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Epica getEpica() {
		return epica;
	}

	public void setEpica(Epica epica) {
		this.epica = epica;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
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

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(String proyectoId) {
		this.proyectoId = proyectoId;
	}

	public String getRequerimientoId() {
		return requerimientoId;
	}

	public void setRequerimientoId(String requerimientoId) {
		this.requerimientoId = requerimientoId;
	}

	public String getEpicaId() {
		return epicaId;
	}

	public void setEpicaId(String epicaId) {
		this.epicaId = epicaId;
	}
	

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Planeacion() {
		
	}

	public Planeacion(Empresa cliente, Proyecto proyecto, Requerimiento requerimiento, Epica epica, String titulo,
			String descripcion, String fechaInicio, String fechaFin, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion, int estado) {
		super();
		this.cliente = cliente;
		this.proyecto = proyecto;
		this.requerimiento = requerimiento;
		this.epica = epica;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.estado = estado;
	}

	
	
	

}
