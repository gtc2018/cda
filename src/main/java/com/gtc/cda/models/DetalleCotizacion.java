package com.gtc.cda.models;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "detalle_cotizacion")
@Access(AccessType.FIELD)
public class DetalleCotizacion extends ParentEntity {
	
	private static final long serialVersionUID = 2961714197594497953L;
	
//	@ManyToOne(cascade=CascadeType.REFRESH)
//	@JoinColumn(name = "cotizaciones_id", nullable = false, referencedColumnName =  "id")
//	private Cotizacion cotizacion;
	
	@Column (name = "cotizacion_id", nullable = false, length = 100)
	private int cotizacionId;
	
	@Column (name = "proceso", nullable = false, length = 100)
	private String proceso;
	
	@Column (name = "componente", nullable = false, length = 100)
	private String componente;
	
	@Column (name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@Column (name = "fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column (name = "usuario_creacion", nullable = false, length = 100)
	private String usuarioCreacion;
	
	@Column (name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;
	
	@Column (name = "usuario_modificacion", nullable = false, length = 100)
	private String usuarioModificacion;
	
	@OneToMany(mappedBy="detalleCotizacionId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FasesxDetalleCotizacion> fases;

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public int getCotizacionId() {
		return cotizacionId;
	}

	public void setCotizacionId(int cotizacionId) {
		this.cotizacionId = cotizacionId;
	}

	public DetalleCotizacion() {
		
	}

	public DetalleCotizacion(Cotizacion cotizacion, String proceso, String componente, String descripcion, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion) {
		super();
		this.proceso = proceso;
		this.componente = componente;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}
	
}

