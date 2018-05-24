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
public class Requerimiento extends ParentEntity {
	
	private static final long serialVersionUID = 1961714197594497953L;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "clientes_id", nullable = false, referencedColumnName =  "id")
	private Empresa cliente;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "proyectos_id", nullable = false, referencedColumnName =  "id")
	private Proyecto proyecto;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cotizaciones_id", nullable = false, referencedColumnName =  "id")
	private Cotizacion cotizacion;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "fases_id", nullable = false, referencedColumnName =  "id")
	private Fase fase;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "estados_id", nullable = false, referencedColumnName =  "id")
	private Estado estado;
	
	@Column (name = "numero_caso_prueba", nullable = false, length = 10)
	private String numeroCasoPrueba;
	
	@Column (name = "requerimientoscol", nullable = false, length = 10)
	private String adjunto;
	
	@Column (name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@Column (name = "version", nullable = false, length = 15)
	private String version;
	
	@Column (name = "numero_hallazgo_bloqueante", nullable = false, length = 10)
	private String numeroHallazgoBloqueante;
	
	@Column (name = "numero_hallazgo_funcional", nullable = false, length = 10)
	private String numeroHallazgoFuncional;
	
	@Column (name = "numero_hallazgo_presentacion", nullable = false, length = 10)
	private String numeroHallazgoPresentacion;
	
	@Column (name = "centro_costo", nullable = false, length = 10)
	private String centroCosto;
	
	@Column (name = "archivo", nullable = false, length = 300)
	private String archivo;
	
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
	
	@Column (name = "fecha_inicio", nullable = false, length= 20)
	private String fechaInicio;
	
	@Column (name = "fecha_plan_entrega", nullable = false, length = 20)
	private String fechaPlaneadaEntrega;
	
	@Column (name = "fecha_entrega", nullable = false, length = 20)
	private String fechaEntrega;
	
	@Column (name = "email_gestor_tecnico", nullable = false, length = 20)
	private String emailTecnico;
	
	@Column (name = "email_gestor_proyecto", nullable = false, length = 20)
	private String emailProyecto;
	
	@Transient
	private String clienteId;
	
	@Transient
	private String proyectoId;
	
	@Transient
	private String cotizacionId;
	
	@Transient
	private String faseId;
	
	@Transient
	private String estadoId;
	
	@Transient
	private String documento;

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

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
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

	public String getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(String adjunto) {
		this.adjunto = adjunto;
	}



	public String getEmailTecnico() {
		return emailTecnico;
	}

	public void setEmailTecnico(String emailTecnico) {
		this.emailTecnico = emailTecnico;
	}

	public String getEmailProyecto() {
		return emailProyecto;
	}

	public void setEmailProyecto(String emailProyecto) {
		this.emailProyecto = emailProyecto;
	}
	

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	@Transient
	public String getClienteId() {
		return clienteId;
	}

	@Transient
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

	@Transient
	public String getCotizacionId() {
		return cotizacionId;
	}

	@Transient
	public void setCotizacionId(String cotizacionId) {
		this.cotizacionId = cotizacionId;
	}

	@Transient
	public String getFaseId() {
		return faseId;
	}

	public void setFaseId(String faseId) {
		this.faseId = faseId;
	}

	public String getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

	public Requerimiento() {
		
	}

	public Requerimiento(Empresa cliente, Proyecto proyecto, Cotizacion cotizacion, Fase fase,
			String numeroCasoPrueba, String adjunto, String descripcion, String version, Estado estado,
			String numeroHallazgoBloqueante, String numeroHallazgoFuncional, String numeroHallazgoPresentacion,
			String centroCosto, String archivo, String gestorTecnico, String gestorProyecto,
			String fechaCreacion, String usuarioCreacion, String fechaModificacion, String usuarioModificacion,
			String fechaInicio, String fechaPlaneadaEntrega, String fechaEntrega, String emailTecnico, String emailProyecto, String documento) {
		super();
		this.cliente = cliente;
		this.proyecto = proyecto;
		this.cotizacion = cotizacion;
		this.fase = fase;
		this.numeroCasoPrueba = numeroCasoPrueba;
		this.adjunto = adjunto;
		this.descripcion = descripcion;
		this.version = version;
		this.estado = estado;
		this.numeroHallazgoBloqueante = numeroHallazgoBloqueante;
		this.numeroHallazgoFuncional = numeroHallazgoFuncional;
		this.numeroHallazgoPresentacion = numeroHallazgoPresentacion;
		this.centroCosto = centroCosto;
		this.archivo = archivo;
		this.gestorTecnico = gestorTecnico;
		this.gestorProyecto = gestorProyecto;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaInicio = fechaInicio;
		this.fechaPlaneadaEntrega = fechaPlaneadaEntrega;
		this.fechaEntrega = fechaEntrega;
		this.emailTecnico = emailTecnico;
		this.emailProyecto = emailProyecto;
		this.documento = documento;
	}

	
	
}