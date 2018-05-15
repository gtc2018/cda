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
@Table(name = "cotizaciones")
@Access(AccessType.FIELD)
public class Cotizacion extends ParentEntity {
	
	private static final long serialVersionUID = 2861714197594497953L;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cliente_id", nullable = false, referencedColumnName =  "id")
	private Empresa cliente;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "proyectos_id", nullable = false, referencedColumnName =  "id")
	private Proyecto proyecto;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "sistemas_id", nullable = false, referencedColumnName =  "id")
	private Sistema sistema;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "herramientas_id", nullable = false, referencedColumnName =  "id")
	private Herramienta herramienta;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "estados_id", nullable = false, referencedColumnName =  "id")
	private Estado estado;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "alcance_id", nullable = false, referencedColumnName =  "id")
	private Alcance alcance;
	
	@Column (name = "codigo_requerimiento", nullable = false, length = 100)
	private String codigoRequerimiento;
	
	@Column (name = "descripcion_requemiemiento", nullable = false, length = 15)
	private String descripcionRequerimiento;
	
	@Column (name = "valor_hora", nullable = false, length = 5)
	private String valorHora;
	
	@Column (name = "numero_recurso", nullable = false, length = 10)
	private String numeroRecurso;
	
	@Column (name = "fecha_solicitud", nullable = false, length = 20)
	private String fechaSolicitud;
	
	@Column (name = "fecha_entrega", nullable = false, length = 20)
	private String fechaEntrega;
	
	@Column (name = "horas_por_fase", nullable = false, length = 10)
	private String horasFase;
	
	@Column (name = "horas_totales_rqm", nullable = false, length = 10)
	private String horasRqm;
	
	@Column (name = "valor_total_rqm", nullable = false, length = 10)
	private String valorRqm;
	
	@Column (name = "fecha_aproximada_entrega", nullable = false, length = 300)
	private String fechaAproxEntrega;
	
	@Column (name = "valor_total_acordado", nullable = false, length = 100)
	private String valorAcordado;
	
	@Column (name = "horas_acordadas", nullable = false, length = 100)
	private String horasAcordadas;
	
	@Column (name = "fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column (name = "usuario_creacion", nullable = false, length = 100)
	private String usuarioCreacion;
	
	@Column (name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;
	
	@Column (name = "usuario_modificacion", nullable = false, length = 100)
	private String usuarioModificacion;
	
	@Transient
	private String clienteId;
	
	@Transient
	private String proyectoId;
	
	@Transient
	private String sistemaId;
	
	@Transient
	private String herramientaId;
	
	@Transient
	private String estadoId;
	
	@Transient
	private String alcanceId;

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

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Herramienta getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramienta = herramienta;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Alcance getAlcance() {
		return alcance;
	}

	public void setAlcance(Alcance alcance) {
		this.alcance = alcance;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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

	public String getCodigoRequerimiento() {
		return codigoRequerimiento;
	}

	public void setCodigoRequerimiento(String codigoRequerimiento) {
		this.codigoRequerimiento = codigoRequerimiento;
	}

	public String getDescripcionRequerimiento() {
		return descripcionRequerimiento;
	}

	public void setDescripcionRequerimiento(String descripcionRequerimiento) {
		this.descripcionRequerimiento = descripcionRequerimiento;
	}

	public String getValorHora() {
		return valorHora;
	}

	public void setValorHora(String valorHora) {
		this.valorHora = valorHora;
	}

	public String getNumeroRecurso() {
		return numeroRecurso;
	}

	public void setNumeroRecurso(String numeroRecurso) {
		this.numeroRecurso = numeroRecurso;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getHorasFase() {
		return horasFase;
	}

	public void setHorasFase(String horasFase) {
		this.horasFase = horasFase;
	}

	public String getHorasRqm() {
		return horasRqm;
	}

	public void setHorasRqm(String horasRqm) {
		this.horasRqm = horasRqm;
	}

	public String getValorRqm() {
		return valorRqm;
	}

	public void setValorRqm(String valorRqm) {
		this.valorRqm = valorRqm;
	}

	public String getFechaAproxEntrega() {
		return fechaAproxEntrega;
	}

	public void setFechaAproxEntrega(String fechaAproxEntrega) {
		this.fechaAproxEntrega = fechaAproxEntrega;
	}

	public String getValorAcordado() {
		return valorAcordado;
	}

	public void setValorAcordado(String valorAcordado) {
		this.valorAcordado = valorAcordado;
	}

	public String getHorasAcordadas() {
		return horasAcordadas;
	}

	public void setHorasAcordadas(String horasAcordadas) {
		this.horasAcordadas = horasAcordadas;
	}

	public Cotizacion() {
		
	}

	public Cotizacion(Empresa cliente, Proyecto proyecto, Sistema sistema, Herramienta herramienta, Alcance alcance, Estado estado,
			String codigoRequerimiento, String descripcionRequerimiento, String valorHora, String numeroRecurso,
			String fechaSolicitud, String fechaEntrega,
			String horasFase, String horasRqm, String valorRqm, String fechaAproxEntrega,
			String valorAcordado, String horasAcordadas, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion) {
		super();
		this.cliente = cliente;
		this.proyecto = proyecto;
		this.sistema = sistema;
		this.herramienta = herramienta;
		this.codigoRequerimiento = codigoRequerimiento;
		this.descripcionRequerimiento = descripcionRequerimiento;
		this.valorHora = valorHora;
		this.numeroRecurso = numeroRecurso;
		this.estado = estado;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaEntrega = fechaEntrega;
		this.alcance = alcance;
		this.horasFase = horasFase;
		this.horasRqm = horasRqm;
		this.valorRqm = valorRqm;
		this.fechaAproxEntrega = fechaAproxEntrega;
		this.valorAcordado = valorAcordado;
		this.horasAcordadas = horasAcordadas;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
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
	public String getSistemaId() {
		return sistemaId;
	}

	@Transient
	public void setSistemaId(String sistemaId) {
		this.sistemaId = sistemaId;
	}

	@Transient
	public String getHerramientaId() {
		return herramientaId;
	}

	@Transient
	public void setHerramientaId(String herramientaId) {
		this.herramientaId = herramientaId;
	}

	@Transient
	public String getEstadoId() {
		return estadoId;
	}

	@Transient
	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

	@Transient
	public String getAlcanceId() {
		return alcanceId;
	}

	@Transient
	public void setAlcanceId(String alcanceId) {
		this.alcanceId = alcanceId;
	}
	
}

