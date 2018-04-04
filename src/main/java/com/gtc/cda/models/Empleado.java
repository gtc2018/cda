package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="empleados")
@Access(AccessType.FIELD)
public class Empleado extends ParentEntity {

	
	private static final long serialVersionUID = 1861714197594497953L;
	
	@Column(name="cliente_id", nullable = false, length = 20 )
	private Long clienteId;
	
	
	@Column(name="rol_id", nullable = false, length = 20 )
	private Long rolId;
	
	@Column(name="cargo_id", nullable = false, length = 20 )
	private Long cargoId;
	
	@Column(name="tipo_empleado", nullable = false, length = 30 )
	private String tipoEmpleado;
	
	@Column(name="tipo_documento", nullable = false, length = 5 )
	private String tipoDocumento;
	
	@Column(name="numero_documento", nullable = false, length = 20 )
	private Long numeroDocumento;
	
	@Column(name="nombres", nullable = false, length = 100 )
	private String nombres;
	
	@Column(name="apellidos", nullable = false, length = 100 )
	private String apellidos;
	
	@Column(name="email", nullable = false, length = 100 )
	private String email;
	
	@Column(name="direccion", nullable = false, length = 100 )
	private String direccion;
	
	@Column(name="telefono", nullable = false, length = 14 )
	private String telefono;
	
	@Column(name="celular", nullable = false, length = 14 )
	private String celular;
	
	@Column(name="sueldo", nullable = false)
	private Double sueldo;
	
	@Column(name="sexo", nullable = false, length = 5)
	private String sexo;
	
	@Column(name="ciudad", nullable = false, length = 60)
	private String ciudad;
	
	@Column(name="estado", nullable = false, length = 5)
	private String estado;
	
	@Column(name="foto", nullable = false, length = 255)
	private String foto;
	
	@Column(name="estado_eliminacion", nullable = false, length = 5)
	private String estadoEliminacion;
	
	@Column(name="fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;
	
	@Column(name="usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;
	
	@Column(name="fecha_modificacion", nullable = false, length = 20 )
	private String fechaModificacion;
	
	@Column(name="usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}
	
	

	public Long getCargoId() {
		return cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEstadoEliminacion() {
		return estadoEliminacion;
	}

	public void setEstadoEliminacion(String estadoEliminacion) {
		this.estadoEliminacion = estadoEliminacion;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
		

}
