package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@Access(AccessType.FIELD)
public class Usuario extends ParentEntity {
	

	private static final long serialVersionUID = -7245319454543405629L;
	
	
	@Column(name="nombres", nullable = false, length = 100)
	private String nombres;
	
	@Column(name="apellidos", nullable = false, length = 100)
	private String apellidos; 
	
	@Column(name="usuario_id", nullable = false, length = 20)
	private String usuarioId; 
	
	@Column(name="empresa_id", nullable = false, length = 20)
	private String empresaId; 
	
	@Column(name="rol_id", nullable = false, length = 20)
	private String rolId; 
	
	@Column(name="email", nullable = false, length = 255)
	private String email; 
	
	@Column(name="password", nullable = false, length = 255)
	private String password; 
	
	@Column(name="estado", nullable = false, length = 20)
	private Integer estado; 
	
	@Column(name="direccion", nullable = false, length = 100)
	private String direccion; 
	
	@Column(name="telefono", nullable = false, length = 14)
	private String telefono; 
	
	@Column(name="fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion; 
	
	@Column(name="usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion; 
	
	@Column(name="fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;
	
	@Column(name="usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion; 
	
	@Column(name="imagen_usuario", nullable = false, length = 200)
	private String imagenUsuario;
	
	
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(String empresaId) {
		this.empresaId = empresaId;
	}
	public String getRolId() {
		return rolId;
	}
	public void setRolId(String rolId) {
		this.rolId = rolId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	public String getImagenUsuario() {
		return imagenUsuario;
	}
	public void setImagenUsuario(String imagenUsuario) {
		this.imagenUsuario = imagenUsuario;
	}
	
	
	
	

}
