package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
@Access(AccessType.FIELD)
public class Empresa extends ParentEntity {

	
	private static final long serialVersionUID = 5189702709640035487L;
	
	@Column(name="descripcion", nullable = false, length = 100 )
	private String descripcion;
	
	@Column(name="tipo_cliente", nullable = false, length = 60)
	private String tipoCliente;
	
	@Column(name="url_carpeta", nullable = false, length = 100)
	private String urlCarpeta;
	
	@Column(name="tipo_documento", nullable = false, length = 60)
	private String tipoDocumento;
	
	@Column(name="numero_documento", nullable = false, length = 20)
	private String numeroDocumento;
	
	@Column(name="nombre_contacto", nullable = false, length = 100)
	private String nombreContacto;
	
	@Column(name="email", nullable = false, length = 255)
	private String email;
	
	@Column(name="telefono", nullable = false, length = 14)
	private String telefono;
	
	@Column(name="direccion", nullable = false, length = 100)
	private String direccion;
	
	@Column(name="estado", nullable = false, length = 5)
	private Integer estado;
	
	@Column(name="fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column(name="usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;
	
	@Column(name="fecha_modificacion", nullable = false, length = 20 )
	private String fechaModificacion;
	
	@Column(name="usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;
	
	@Column(name="imagen_empresa", nullable = false, length = 200)
	private String imagenEmpresa;
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
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
	public String getImagenEmpresa() {
		return imagenEmpresa;
	}
	public void setImagenEmpresa(String imagenEmpresa) {
		this.imagenEmpresa = imagenEmpresa;
	}
	
		
	public String getTipoCliente() {
		return tipoCliente;
	}
	
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getUrlCarpeta() {
		return urlCarpeta;
	}
	public void setUrlCarpeta(String urlCarpeta) {
		this.urlCarpeta = urlCarpeta;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	

}
