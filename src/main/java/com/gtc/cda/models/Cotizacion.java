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
	
	@Column (name = "estado", nullable = false, length = 255)
	private String estado;
	
	@Column (name = "alcance", nullable = false, length = 255)
	private String alcance;
	
	@Column (name = "codigo_requerimiento", nullable = false, length = 100)
	private String codigoRqm;
	
	@Column (name = "descripcion_rqm", nullable = false, length = 15)
	private String descripcionRqm;
	
	@Column (name = "valor_hora", nullable = false, length = 5)
	private double valueHour;
	
	@Column (name = "numero_recurso", nullable = false, length = 10)
	private int numeroRecursos;
	
	@Column (name = "fecha_solicitud", nullable = false, length = 20)
	private String fechaSolicitud;
	
	@Column (name = "fecha_entrega", nullable = false, length = 20)
	private String fechaEntrega;
	
	@Column (name = "horas_totales_rqm", nullable = false, length = 10)
	private int horasTotal;
	
	@Column (name = "valor_total_rqm", nullable = false, length = 10)
	private double valorTotal;
	
	@Column (name = "fecha_entrega_rqm", nullable = false, length = 300)
	private String fechaEntregaRqm;
	
	@Column (name = "valor_total_acordado", nullable = false, length = 100)
	private double valorAcordado;
	
	@Column (name = "horas_acordadas", nullable = false, length = 100)
	private int horasAcordadas;
	
	@Column (name = "fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column (name = "usuario_creacion", nullable = false, length = 100)
	private String usuarioCreacion;
	
	@Column (name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;
	
	@Column (name = "usuario_modificacion", nullable = false, length = 100)
	private String usuarioModificacion;
	
	@Column (name = "consecutivo", nullable = false, length = 45)
	private String consecutivo;
	
	@Transient
	private String clienteId;
	
	@Transient
	private String proyectoId;

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getDescripcionRqm() {
		return descripcionRqm;
	}

	public void setDescripcionRqm(String descripcionRqm) {
		this.descripcionRqm = descripcionRqm;
	}



	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public String getFechaEntregaRqm() {
		return fechaEntregaRqm;
		
	}

	public void setFechaEntregaRqm(String fechaEntregaRqm) {
		this.fechaEntregaRqm = fechaEntregaRqm;
	}

	public double getValorAcordado() {
		return valorAcordado;
	}

	public void setValorAcordado(double valorAcordado) {
		this.valorAcordado = valorAcordado;
	}

	public int getHorasAcordadas() {
		return horasAcordadas;
	}
	
	
	public void setHorasAcordadas(int horasAcordadas) {
		this.horasAcordadas = horasAcordadas;
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

	public String getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getAlcance() {
		return alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	public String getCodigoRqm() {
		return codigoRqm;
	}

	public void setCodigoRqm(String codigoRqm) {
		this.codigoRqm = codigoRqm;
	}

	public double getValueHour() {
		return valueHour;
	}

	public void setValueHour(double valueHour) {
		this.valueHour = valueHour;
	}

	public int getNumeroRecursos() {
		return numeroRecursos;
	}

	public void setNumeroRecursos(int numeroRecursos) {
		this.numeroRecursos = numeroRecursos;
	}

	public int getHorasTotal() {
		return horasTotal;
	}

	public void setHorasTotal(int horasTotal) {
		this.horasTotal = horasTotal;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cotizacion() {
		
	}

	public Cotizacion(Empresa cliente, Proyecto proyecto, String estado, String alcance, String codigoRqm,
			String descripcionRqm, double valueHour, int numeroRecursos, String fechaSolicitud, String fechaEntrega,
			int horasTotal, double valorTotal, String fechaEntregaRqm, double valorAcordado, int horasAcordadas,
			String fechaCreacion, String usuarioCreacion, String fechaModificacion, String usuarioModificacion,
			String consecutivo, String clienteId, String proyectoId) {
		super();
		this.cliente = cliente;
		this.proyecto = proyecto;
		this.estado = estado;
		this.alcance = alcance;
		this.codigoRqm = codigoRqm;
		this.descripcionRqm = descripcionRqm;
		this.valueHour = valueHour;
		this.numeroRecursos = numeroRecursos;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaEntrega = fechaEntrega;
		this.horasTotal = horasTotal;
		this.valorTotal = valorTotal;
		this.fechaEntregaRqm = fechaEntregaRqm;
		this.valorAcordado = valorAcordado;
		this.horasAcordadas = horasAcordadas;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.consecutivo = consecutivo;
		this.clienteId = clienteId;
		this.proyectoId = proyectoId;
	}
	
}
	
	
	