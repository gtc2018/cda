package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "epicas")
@Access(AccessType.FIELD)
public class Epica extends ParentEntity{
	
	@Column(name = "descrpcion", nullable = false, length = 100)
	private String descripcion;
	
	@Column(name = "estadoe", nullable = false, length = 5)
	private int estadoe;
	
	@Column(name = "usuario_creacion", nullable = false, length = 100)
	private String usuario_creacion;
	
	@Column(name = "fecha_creacion", nullable = false, length = 20)
	private String fecha_creacion;
	
	@Column(name = "usuario_modificacion", nullable = false, length = 100)
	private String usuario_modificacion;
	
	@Column(name = "fecha_modificacion", nullable = false, length = 20)
	private String fecha_modificacion;
	
	@Column(name = "requerimientos_id", nullable = false, length = 11)
	private String requerimientosId;

}
