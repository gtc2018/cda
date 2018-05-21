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
@Table(name = "usuarios")
@Access(AccessType.FIELD)
public class Usuario extends ParentEntity {

	private static final long serialVersionUID = -7245319454543405629L;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cliente_id", nullable = false, referencedColumnName =  "id")
	private Empresa cliente;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "empleado_id", nullable = false, referencedColumnName =  "id")
	private Empleado empleado;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "rol_id", nullable = false, referencedColumnName =  "id")
	private Rol rol;
	
	@Column(name = "username", nullable = false, length = 20)
	private String userName;
	
	@Column(name = "tipo_empleado", nullable = false, length = 20)
	private String tipoEmpleado;
	
	@Column(name = "email", nullable = false, length = 255)
	private String email;

	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@Column(name = "estado", nullable = false, length = 20)
	private Integer estado;

	@Column(name = "token", nullable = false, length = 255)
	private String token;

	@Column(name = "fecha_creacion", nullable = false, length = 20)
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
	private String rolId;
	
	@Transient
	private String empleadoId;

	public Usuario() {
	}
	
	public Usuario(Empresa cliente, Empleado empleado, Rol rol, String userName, String tipoEmpleado, String email, String password, Integer estado,
			String token, String fechaCreacion, String usuarioCreacion, String fechaModificacion, String usuarioModificacion) {
		super();
		this.cliente = cliente;
		this.empleado = empleado;
		this.rol = rol;
		this.userName = userName;
		this.tipoEmpleado = tipoEmpleado;
		this.email = email;
		this.password = password;
		this.estado = estado;
		this.token = token;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}
	
	public Empresa getCliente() {
		return cliente;
	}

	public void setCliente(Empresa cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
	public String getRolId() {
		return rolId;
	}

	@Transient
	public void setRolId(String rolId) {
		this.rolId = rolId;
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