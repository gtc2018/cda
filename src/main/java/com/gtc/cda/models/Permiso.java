package com.gtc.cda.models;

import java.util.List;
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
@Table(name = "permisos")
/*
 * Definicion Procedimiento Almacenado
 * 
 * @NamedStoredProcedureQuery( name = "getMenuSession", // name of stored
 * procedure in the persistence unit procedureName = "getMenuSession", //name of
 * stored procedure in the database parameters = //Parameters of the stored
 * procedure {
 * 
 * @StoredProcedureParameter(// A parameter, mode = ParameterMode.IN, name=
 * "rol", type = String.class) } )//Fin definicion del procedimiento Almacenado.
 */
@Access(AccessType.FIELD)
public class Permiso extends ParentEntity {

	private static final long serialVersionUID = -2787594519303851712L;

	@Column(name = "rol_id", nullable = false, length = 20)
	private String rolId;
	
	@Transient
	private String menu_id;
	
	
	
	@Column(name = "crear", nullable = false, length = 2)
	private String crear;

	@Column(name = "editar", nullable = false, length = 2)
	private String editar;

	@Column(name = "eliminar", nullable = false, length = 2)
	private String eliminar;

	@Column(name = "leer", nullable = false, length = 2)
	private String leer;
	
		
	@Column(name = "estado", nullable = false, length = 20)
	private String estado;

	@Column(name = "fechaCreacion", nullable = false, length = 20)
	private String fechaCreacion;

	@Column(name = "usuario_creacion", nullable = false, length = 20)
	private String usuarioCreacion;

	@Column(name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;

	@Column(name = "usuario_modificacion", nullable = false, length = 20)
	private String usuarioModificacion;

	

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "menu_id" , nullable = false, referencedColumnName =  "id")
	private Menu menu;
	
	

	public Permiso() {

	}

	public Permiso(String rolId, String estado, String fechaCreacion, String usuarioCreacion,
			String fechaModificacion, String usuarioModificacion, List<Menu> listaPermiso) {
		super();
		this.rolId = rolId;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;

	}

	

	
	public String getRolId() {
		return rolId;
	}

	public void setRolId(String rolId) {
		this.rolId = rolId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
    
	@Transient
	public String getMenu_id() {
		return menu_id;
	}
	@Transient
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	
	

	public String getCrear() {
		return crear;
	}

	public void setCrear(String crear) {
		this.crear = crear;
	}

	public String getEditar() {
		return editar;
	}

	public void setEditar(String editar) {
		this.editar = editar;
	}

	public String getEliminar() {
		return eliminar;
	}

	public void setEliminar(String eliminar) {
		this.eliminar = eliminar;
	}

	public String getLeer() {
		return leer;
	}

	public void setLeer(String leer) {
		this.leer = leer;
	}
	
	
	
	

}
