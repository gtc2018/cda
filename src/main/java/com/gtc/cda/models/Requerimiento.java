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
@Table(name = "requerimientos")
@Access(AccessType.FIELD)
public class Requerimiento extends ParentEntity{
	
	
	private static final long serialVersionUID = 4484173925408325716L;
	

	@Column(name = "cliente_id", nullable = false, length = 20)
	private String clienteId;
	
	//@Column(name = "proyecto_id", nullable = false, length = 20)
	@Transient
	private String proyectoId;
	
	@Column(name = "numero_rq", nullable = false, length = 20)
	private String numeroRq;
	
	@Column (name = "numero_caso_prueba", nullable = false, length = 10)
	private String numeroCasoPrueba;
	
	@Column (name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@Column (name = "version", nullable = false, length = 15)
	private String version;
	
	@Column (name = "estado", nullable = false, length = 5)
	private String estado;
	
	@Column (name = "fase", nullable = false, length = 10)
	private String fase;
	
	@Column (name = "fecha_inicio", nullable = false, length= 20)
	private String fechaInicio;
	
	@Column (name = "fecha_planeada_entrega", nullable = false, length = 20)
	private String fechaPlaneadaEntrega;
	
	@Column (name = "fecha_entrega", nullable = false, length = 20)
	private String fechaEntrega;
	
	@Column (name = "numero_hallazgo_bloqueante", nullable = false, length = 10)
	private String numeroHallazgoBloqueante;
	
	@Column (name = "numero_hallazgo_funcional", nullable = false, length = 10)
	private String numeroHallazgoFuncional;
	
	@Column (name = "numero_hallazgo_presentacion", nullable = false, length = 10)
	private String numeroHallazgoPresentacion;
	
	@Column (name = "centro_costo", nullable = false, length = 10)
	private String centroCosto;
	
	@Column (name = "observacion", nullable = false, length = 300)
	private String observacion;
	
	@Column (name = "gestor_tecnico", nullable = false, length = 100)
	private String gestorTecnico;
	
	@Column (name = "gestor_proyecto", nullable = false, length = 100)
	private String gestorProyecto;
	
	@Column (name = "fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column (name = "usuario_creacion", nullable = false, length = 100)
	private String usuarioCreacion;
	
	@Column (name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;
	
	@Column (name = "usuario_modificacion", nullable = false, length = 100)
	private String usuarioModificacion;
	
	/*@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cliente_id" , nullable = false, referencedColumnName =  "id")
	private Empresa empresa;*/
	
	
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "proyecto_id" , nullable = false, referencedColumnName =  "id")
	private Proyecto proyecto;

	
	
	public String getClienteId() {
		return clienteId;
	}
	
	
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	
	@Transient
	public String getProyectoId() {
		return proyectoId;
	}

	@Transient
	public void setProyectoId(String proyectoId) {
		this.proyectoId = proyectoId;
	}


	public String getNumeroRq() {
		return numeroRq;
	}

	public void setNumeroRq(String numeroRq) {
		this.numeroRq = numeroRq;
	}

	public String getNumeroCasoPrueba() {
		return numeroCasoPrueba;
	}

	public void setNumeroCasoPrueba(String numeroCasoPrueba) {
		this.numeroCasoPrueba = numeroCasoPrueba;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaPlaneadaEntrega() {
		return fechaPlaneadaEntrega;
	}

	public void setFechaPlaneadaEntrega(String fechaPlaneadaEntrega) {
		this.fechaPlaneadaEntrega = fechaPlaneadaEntrega;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getNumeroHallazgoBloqueante() {
		return numeroHallazgoBloqueante;
	}

	public void setNumeroHallazgoBloqueante(String numeroHallazgoBloqueante) {
		this.numeroHallazgoBloqueante = numeroHallazgoBloqueante;
	}

	public String getNumeroHallazgoFuncional() {
		return numeroHallazgoFuncional;
	}

	public void setNumeroHallazgoFuncional(String numeroHallazgoFuncional) {
		this.numeroHallazgoFuncional = numeroHallazgoFuncional;
	}

	public String getNumeroHallazgoPresentacion() {
		return numeroHallazgoPresentacion;
	}

	public void setNumeroHallazgoPresentacion(String numeroHallazgoPresentacion) {
		this.numeroHallazgoPresentacion = numeroHallazgoPresentacion;
	}

	public String getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(String centroCosto) {
		this.centroCosto = centroCosto;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getGestorTecnico() {
		return gestorTecnico;
	}

	public void setGestorTecnico(String gestorTecnico) {
		this.gestorTecnico = gestorTecnico;
	}

	public String getGestorProyecto() {
		return gestorProyecto;
	}

	public void setGestorProyecto(String gestorProyecto) {
		this.gestorProyecto = gestorProyecto;
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
	
	/*public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}*/
	


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Requerimiento() {
		
	}

	public Requerimiento(String clienteId, String proyectoId, String numeroRq, String numeroCasoPrueba,
			String descripcion, String version, String estado, String fase, String fechaInicio,
			String fechaPlaneadaEntrega, String fechaEntrega, String numeroHallazgoBloqueante,
			String numeroHallazgoFuncional, String numeroHallazgoPresentacion, String centroCosto, String observacion,
			String gestorTecnico, String gestorProyecto, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion) {
		super();
		this.clienteId = clienteId;
		this.proyectoId = proyectoId;
		this.numeroRq = numeroRq;
		this.numeroCasoPrueba = numeroCasoPrueba;
		this.descripcion = descripcion;
		this.version = version;
		this.estado = estado;
		this.fase = fase;
		this.fechaInicio = fechaInicio;
		this.fechaPlaneadaEntrega = fechaPlaneadaEntrega;
		this.fechaEntrega = fechaEntrega;
		this.numeroHallazgoBloqueante = numeroHallazgoBloqueante;
		this.numeroHallazgoFuncional = numeroHallazgoFuncional;
		this.numeroHallazgoPresentacion = numeroHallazgoPresentacion;
		this.centroCosto = centroCosto;
		this.observacion = observacion;
		this.gestorTecnico = gestorTecnico;
		this.gestorProyecto = gestorProyecto;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}
	
	
	
	

}

