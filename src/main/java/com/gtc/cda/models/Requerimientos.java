package com.gtc.cda.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "requerimientos")
@Access(AccessType.FIELD)
public class Requerimientos extends ParentEntity {
	
	//public static final long serialVersionUID =   ;
	
	@Column(name = "cliente_id", nullable = false, length = 20)
	private String clienteId;
	
	@Column(name = "proyecto_id", nullable = false, length = 20)
	private String proyectoId;
	
	@Column(name = "numero_rq", nullable = false, length = 20)
	private String numeroRq;
	
	@Column (name = "numero_caso_prueba", nullable = false, length = 10)
	private String numeroCasoPrueba;
	
	@Column (name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@Column (name = "version", nullable = false, length = 15)
	private String version;
	
	@Column (name = "estado", nullable = false, length = 5)
	private String estado;
	
	@Column (name = "fase", nullable = false, length = 10)
	private String fase;
	
	@Column (name = "fecha_inicio", nullable = false, length= 20)
	private String fechaInicio;
	
	@Column (name = "fecha_planeada_entrega", nullable = false, length = 20)
	private String fechaPlaneadaEntrega;
	
	@Column (name = "fecha_entrega", nullable = false, length = 20)
	private String fechaEntrega;
	
	@Column (name = "numero_hallazgo_bloqueante", nullable = false, length = 10)
	private String numeroHallazgoBloqueante;
	
	@Column (name = "numero_hallazgo_funcional", nullable = false, length = 10)
	private String numeroHallazgoFuncional;
	
	@Column (name = "")
	
	

}
