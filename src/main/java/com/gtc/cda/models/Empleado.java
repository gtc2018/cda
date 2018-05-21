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
@Table(name="empleados")
@Access(AccessType.FIELD)
public class Empleado extends ParentEntity {

	
	private static final long serialVersionUID = 1861714197594497953L;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "cliente_id", nullable = false, referencedColumnName =  "id")
	private Empresa cliente;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="cargo_id", nullable = false, referencedColumnName =  "id")
	private Cargo cargo;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="areas_id", nullable = false, referencedColumnName =  "id")
	private Area area;
	
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
	
	@Column(name="otros_beneficios", nullable = false, length = 255)
	private String otrosBeneficios;
	
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
	
	@Transient
	private String imagen;
	
	@Transient
	private String cargoId;
	
	@Transient
	private String clienteId;
	
	@Transient
	private String areaId;

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getOtrosBeneficios() {
		return otrosBeneficios;
	}

	public void setOtrosBeneficios(String otrosBeneficios) {
		this.otrosBeneficios = otrosBeneficios;
	}

	public Empresa getCliente() {
		return cliente;
	}

	public void setCliente(Empresa cliente) {
		this.cliente = cliente;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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
	
	@Transient
	public String getImagen() {
		return imagen;
	}

	@Transient
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Transient
	public String getCargoId() {
		return cargoId;
	}

	@Transient
	public void setCargoId(String cargoId) {
		this.cargoId = cargoId;
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
	public String getAreaId() {
		return areaId;
	}

	@Transient
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public Empleado() {
	}
	
	public Empleado(Empresa cliente, Cargo cargo, Area area, String tipoEmpleado, String tipoDocumento, Long numeroDocumento, String nombres, String apellidos, String email,
			String direccion, String telefono, Double sueldo, String sexo, String ciudad, String estado, String foto, String otrosBeneficios, String estadoEliminacion,
			String fechaCreacion, String usuarioCreacion, String fechaModificacion, String usuarioModificacion) {
		super();
		this.cliente = cliente;
		this.cargo = cargo;
		this.area = area;
		this.tipoEmpleado = tipoEmpleado;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sueldo = sueldo;
		this.sexo = sexo;
		this.ciudad = ciudad;
		this.estado = estado;
		this.foto = foto;
		this.otrosBeneficios = otrosBeneficios;
		this.estadoEliminacion = estadoEliminacion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	
	
		

}


