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
@Table(name = "detalle_cotizacion")
@Access(AccessType.FIELD)
public class DetalleCotizacion extends ParentEntity {
	
	private static final long serialVersionUID = 2961714197594497953L;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cotizaciones_id", nullable = false, referencedColumnName =  "id")
	private Cotizacion cotizacion;
	
	@Column (name = "proceso", nullable = false, length = 100)
	private String proceso;
	
	@Column (name = "componente", nullable = false, length = 100)
	private String componente;
	
	@Column (name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@Column (name = "hora_analisis", nullable = false, length = 100)
	private String horaAnalisis;
	
	@Column (name = "hora_diseño", nullable = false, length = 100)
	private String horaDiseño;
	
	@Column (name = "hora_desarrollo", nullable = false, length = 100)
	private String horaDesarrollo;
	
	@Column (name = "hora_prueba", nullable = false, length = 100)
	private String horaPrueba;
	
	@Column (name = "hora_documentacion", nullable = false, length = 100)
	private String horaDocumentacion;
	
	@Column (name = "total_hora", nullable = false, length = 100)
	private String totalHora;
	
	@Column (name = "fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column (name = "usuario_creacion", nullable = false, length = 100)
	private String usuarioCreacion;
	
	@Column (name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;
	
	@Column (name = "usuario_modificacion", nullable = false, length = 100)
	private String usuarioModificacion;
	
	@Transient
	private String cotizacionId;

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

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

	public String getHoraAnalisis() {
		return horaAnalisis;
	}

	public void setHoraAnalisis(String horaAnalisis) {
		this.horaAnalisis = horaAnalisis;
	}

	public String getHoraDiseño() {
		return horaDiseño;
	}

	public void setHoraDiseño(String horaDiseño) {
		this.horaDiseño = horaDiseño;
	}

	public String getHoraDesarrollo() {
		return horaDesarrollo;
	}

	public void setHoraDesarrollo(String horaDesarrollo) {
		this.horaDesarrollo = horaDesarrollo;
	}

	public String getHoraPrueba() {
		return horaPrueba;
	}

	public void setHoraPrueba(String horaPrueba) {
		this.horaPrueba = horaPrueba;
	}

	public String getHoraDocumentacion() {
		return horaDocumentacion;
	}

	public void setHoraDocumentacion(String horaDocumentacion) {
		this.horaDocumentacion = horaDocumentacion;
	}

	public String getTotalHora() {
		return totalHora;
	}

	public void setTotalHora(String totalHora) {
		this.totalHora = totalHora;
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

	public DetalleCotizacion() {
		
	}

	public DetalleCotizacion(Cotizacion cotizacion, String proceso, String componente, String descripcion, String horaAnalisis, String horaDiseño,
			String horaDesarrollo, String horaPrueba, String horaDocumentacion, String totalHora, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion) {
		super();
		this.cotizacion = cotizacion;
		this.proceso = proceso;
		this.componente = componente;
		this.descripcion = descripcion;
		this.horaAnalisis = horaAnalisis;
		this.horaDiseño = horaDiseño;
		this.horaDesarrollo = horaPrueba;
		this.horaDocumentacion = horaDocumentacion;
		this.totalHora = totalHora;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	@Transient
	public String getCotizacionId() {
		return cotizacionId;
	}

	@Transient
	public void setCotizacionId(String cotizacionId) {
		this.cotizacionId = cotizacionId;
	}
	
}

