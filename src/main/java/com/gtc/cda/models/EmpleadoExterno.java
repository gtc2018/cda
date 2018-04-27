package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "empleados_externos")
@Access(AccessType.FIELD)
public class EmpleadoExterno extends ParentEntity {

	
	private static final long serialVersionUID = -1641829859077620633L;
	
	
	@Column(name = "cliente_id", nullable = false, length = 20)
	private String clienteId;
	
	@Column(name = "cargo_id", nullable = false, length = 20)
	private String cargoId;
	
	@Column(name = "tipo_empleado", nullable = false, length = 20)
	private String tipoEmpleado;
	
	@Column(name = "nombres", nullable = false, length = 100)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false, length = 100)
	private String apellidos;
	
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "sexo", nullable = false, length = 2)
	private String sexo;
	
	@Column(name = "fecha_nacimiento", nullable = false, length = 20)
	private String fechaNacimiento;
	
	@Column(name = "estado", nullable = false, length = 5)
	private int estado;
	
	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;
	
	@Column(name = "telefono", nullable = false, length = 14)
	private String telefono;
	
	@Column(name = "extension", nullable = false, length = 10)
	private String extension;
	
	@Column(name = "fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column(name = "usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;
	
	@Column(name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;
	
	@Column(name = "usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;
	
	@Column(name = "foto_empleado", nullable = false, length = 200)
	private String fotoEmpleado;

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getCargoId() {
		return cargoId;
	}

	public void setCargoId(String cargoId) {
		this.cargoId = cargoId;
	}

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
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

	public String getFotoEmpleado() {
		return fotoEmpleado;
	}

	public void setFotoEmpleado(String fotoEmpleado) {
		this.fotoEmpleado = fotoEmpleado;
	}
	
	public EmpleadoExterno() {
		
	}

	public EmpleadoExterno(String clienteId, String cargoId, String tipoEmpleado, String nombres, String apellidos,
			String email, String sexo, String fechaNacimiento, int estado, String direccion, String telefono,
			String extension, String fechaCreacion, String usuarioCreacion, String fechaModificacion,
			String usuarioModificacion, String fotoEmpleado) {
		super();
		this.clienteId = clienteId;
		this.cargoId = cargoId;
		this.tipoEmpleado = tipoEmpleado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
		this.direccion = direccion;
		this.telefono = telefono;
		this.extension = extension;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.fotoEmpleado = fotoEmpleado;
	}
	
	

}
