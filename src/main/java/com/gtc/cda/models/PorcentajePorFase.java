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
@Table(name="porcentaje_por_fases")
@Access(AccessType.FIELD)
public class PorcentajePorFase extends ParentEntity {

	
	private static final long serialVersionUID = 1861714197594497953L;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "clientes_id", nullable = false, referencedColumnName =  "id")
	private Empresa cliente;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "fases_id", nullable = false, referencedColumnName =  "id")
	private Fase fases;
	
	@Column(name="porcentaje", nullable = false, length = 4 )
	private Long porcentaje;
	
	@Column(name="fecha_creacion", length = 20 )
	private String fechaCreacion;
	
	@Column(name="usuario_creacion", length = 20 )
	private String usuarioCreacion;
	
	@Column(name="fecha_modificacion", length = 20 )
	private String fechaModificacion;
	
	@Column(name="usuario_modificacion", length = 20 )
	private String usuarioModificacion;
	
	@Transient
	private String clienteId;
	
	@Transient
	private String fasesId;
	
	public PorcentajePorFase() {
	}	

	// Set y Get
	
	public Empresa getCliente() {
		return cliente;
	}

	public PorcentajePorFase(Empresa cliente, Fase fases, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion) {
		super();
		this.cliente = cliente;
		this.fases = fases;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	public void setCliente(Empresa cliente) {
		this.cliente = cliente;
	}

	public Long getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Long porcentaje) {
		this.porcentaje = porcentaje;
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

	public Fase getFases() {
		return fases;
	}

	public void setFases(Fase fases) {
		this.fases = fases;
	}

	@Transient
	public String getFasesId() {
		return fasesId;
	}

	@Transient
	public void setFasesId(String fasesId) {
		this.fasesId = fasesId;
	}

}
