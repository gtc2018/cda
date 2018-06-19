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
@Table(name = "in_house")
@Access(AccessType.FIELD)
public class InHouse extends ParentEntity {

	private static final long serialVersionUID = -5571572789947258639L;

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "clientes_id", nullable = false, referencedColumnName =  "id")
	private Empresa cliente;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "empleados_id", nullable = false, referencedColumnName =  "id")
	private Empleado empleado;

	@Column(name = "observacion", nullable = false, length = 60)
	private String observacion;
	
	@Column(name = "costo", nullable = false, length = 60)
	private String costo;

	@Column(name = "desde", nullable = false, length = 20)
	private String desde;
	
	@Column(name = "hasta", nullable = false, length = 20)
	private String hasta;
	
	@Column(name = "fechaCreacion", nullable = false, length = 20)
	private String fechaCreacion;

	@Column(name = "usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;

	@Column(name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;

	@Column(name = "usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;
	
	@Transient
	private String clienteId;
	
	@Transient
	private String empleadoId;
	
	public InHouse() {
	}		

	public Empresa getCliente() {
		return cliente;
	}
	
	public InHouse(Empresa cliente, Empleado empleado, String observacion,
			String costo, String desde, String hasta, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion) {
		super();
		this.cliente = cliente;
		this.empleado = empleado;
		this.costo = costo;
		this.observacion = observacion;
		this.desde = desde;
		this.hasta = hasta;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getDesde() {
		return desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public String getHasta() {
		return hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
	}

	public void setCliente(Empresa cliente) {
		this.cliente = cliente;
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
	public String getClienteId() {
		return clienteId;
	}

	@Transient
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	@Transient
	public String getEmpleadoId() {
		return empleadoId;
	}

	@Transient
	public void setEmpleadoId(String empleadoId) {
		this.empleadoId = empleadoId;
	}	
	

}
