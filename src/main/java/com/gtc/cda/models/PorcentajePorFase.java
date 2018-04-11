package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="porcentaje_por_fases")
@Access(AccessType.FIELD)
public class PorcentajePorFase extends ParentEntity {

	
	private static final long serialVersionUID = 1861714197594497953L;
	
	@Column(name="cliente_id", nullable = false, length = 20 )
	private Long clienteId;
		
	@Column(name="etapa", nullable = false, length = 100 )
	private String etapa;
	
	
	
	@Column(name="porcentaje", nullable = false, length = 4 )
	private Long porcentaje;
	
	@Column(name="fecha_creacion", length = 20 )
	private String fechaCreacion;
	
	@Column(name="usuario_creacion", length = 20 )
	private String usuarioCreacion;
	
	@Column(name="fecha_modificacion", length = 20 )
	private String fechaModificacion;
	
	@Column(name="usuario_modificacion", length = 20 )
	private String usuarioModiciacion;

	// Set y Get
	
	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
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

	public String getUsuarioModiciacion() {
		return usuarioModiciacion;
	}

	public void setUsuarioModiciacion(String usuarioModiciacion) {
		this.usuarioModiciacion = usuarioModiciacion;
	}


}
