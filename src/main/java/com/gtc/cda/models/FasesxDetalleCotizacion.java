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
@Table(name="fasesxdetalle_cotizacion")
@Access(AccessType.FIELD)
public class FasesxDetalleCotizacion extends ParentEntity {
	
	private static final long serialVersionUID = -6130448812585321500L;
	
	@Column(name = "detalle_cotizacion_id", nullable = false, length = 100)
	private int detalleCotizacionId;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "fase_id", nullable = false, referencedColumnName =  "id")
	private Fase fase;
	
	@Column(name = "horas", nullable = false, length = 100)
	private int horas;
	
	@Transient
	private String FaseName;

	public int getDetalleCotizacionId() {
		return detalleCotizacionId;
	}

	public void setDetalleCotizacionId(int detalleCotizacionId) {
		this.detalleCotizacionId = detalleCotizacionId;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	@Transient
	public String getFaseName() {
		return fase.getDescripcion();
	}

	
	

}
