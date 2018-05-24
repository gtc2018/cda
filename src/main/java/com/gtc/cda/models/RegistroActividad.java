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
@Table(name = "registro_actividades")
@Access(AccessType.FIELD)
public class RegistroActividad extends ParentEntity {
	
	private static final long serialVersionUID = 1031266207613698056L;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "clientes_id", nullable = false, referencedColumnName =  "id")
	private Empresa cliente;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "empleados_id", nullable = false, referencedColumnName =  "id")
	private Empleado empleado;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "proyectos_id", nullable = false, referencedColumnName =  "id")
	private Proyecto proyecto;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "requerimientos_id", nullable = false, referencedColumnName =  "id")
	private Requerimiento requerimiento;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "areas_id", nullable = false, referencedColumnName =  "id")
	private Area area;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "fases_id", nullable = false, referencedColumnName =  "id")
	private Fase fase;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "tareas_id", nullable = false, referencedColumnName =  "id")
	private Tarea tarea;
	
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@Column(name = "hora_inicio", nullable = false, length = 100)
	private String horaInicio;
	
	@Column(name = "hora_fin", nullable = false, length = 100)
	private String horaFin;
	
	@Column(name = "duracion", nullable = false, length = 100)
	private String duracion;
	
	@Column(name = "fecha_trabajo", nullable = false, length = 100)
	private String fechaTrabajo;
	
	@Column(name = "dia_total", nullable = false, length = 100)
	private String diaTotal;
	
	@Column(name = "fecha_creacion", nullable = false, length = 20)
	private String fechaCreacion;

	@Column(name = "usuario_creacion", nullable = false, length = 100)
	private String usuarioCreacion;

	@Column(name = "fecha_modificacion", nullable = false, length = 20)
	private String fechaModificacion;

	@Column(name = "usuario_modificacion", nullable = false, length = 100)
	private String usuarioModificacion;
	
	@Transient
	private String clienteId;
	
	@Transient
	private String empleadoId;
	
	@Transient
	private String proyectoId;
	
	@Transient
	private String requerimientoId;
	
	@Transient
	private String areaId;
	
	@Transient
	private String faseId;
	
	@Transient
	private String tareaId;
	
	public RegistroActividad() {
		
	}

	public RegistroActividad(Empresa cliente, Empleado empleado, Proyecto proyecto, Requerimiento requerimiento, Area area, 
			Fase fase, Tarea tarea, String descripcion, String horaInicio, String horaFin, String duracion, String fechaTrabajo,
			String diaTotal, String fechaCreacion, String usuarioCreacion, String fechaModificacion,
			String usuarioModificacion) {
		super();
		this.cliente = cliente;
		this.empleado = empleado;
		this.proyecto = proyecto;
		this.requerimiento = requerimiento;
		this.area = area;
		this.fase = fase;
		this.tarea = tarea;
		this.descripcion = descripcion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.duracion = duracion;
		this.fechaTrabajo = fechaTrabajo;
		this.diaTotal = diaTotal;
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

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getFechaTrabajo() {
		return fechaTrabajo;
	}

	public void setFechaTrabajo(String fechaTrabajo) {
		this.fechaTrabajo = fechaTrabajo;
	}

	public String getDiaTotal() {
		return diaTotal;
	}

	public void setDiaTotal(String diaTotal) {
		this.diaTotal = diaTotal;
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
	public String getEmpleadoId() {
		return empleadoId;
	}

	@Transient
	public void setEmpleadoId(String empleadoId) {
		this.empleadoId = empleadoId;
	}

	@Transient
	public String getProyectoId() {
		return proyectoId;
	}

	@Transient
	public void setProyectoId(String proyectoId) {
		this.proyectoId = proyectoId;
	}

	@Transient
	public String getRequerimientoId() {
		return requerimientoId;
	}

	@Transient
	public void setRequerimientoId(String requerimientoId) {
		this.requerimientoId = requerimientoId;
	}

	@Transient
	public String getAreaId() {
		return areaId;
	}

	@Transient
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	@Transient
	public String getFaseId() {
		return faseId;
	}

	@Transient
	public void setFaseId(String faseId) {
		this.faseId = faseId;
	}

	@Transient
	public String getTareaId() {
		return tareaId;
	}

	@Transient
	public void setTareaId(String tareaId) {
		this.tareaId = tareaId;
	}

	

}
