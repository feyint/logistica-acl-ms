package com.logistica.commonacl.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EntidadGeneral implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal id;

	@Column(name = "FECHA_ACTIVIDAD")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date fechaActividad;

	@Size(max = 200)
	@Column(name = "USUARIO_DATA")
	private String usuarioData;

	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
        @ColumnDefault("CURRENT_TIMESTAMP")
	private Date fechaCreacion;

	@Size(max = 30)
	@Column(name = "ORIGEN_DATA")
	private String origenData;

	@Transient
	private BigDecimal mobilId;

	@Transient
	private BigDecimal webId;

	public EntidadGeneral() {
	}

	public EntidadGeneral(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Date getFechaActividad() {
		return fechaActividad;
	}

	public void setFechaActividad(Date fechaActividad) {
		this.fechaActividad = fechaActividad;
	}

	public String getUsuarioData() {
		return usuarioData;
	}

	public void setUsuarioData(String usuarioData) {
		this.usuarioData = usuarioData;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getOrigenData() {
		return origenData;
	}

	public void setOrigenData(String origenData) {
		this.origenData = origenData;
	}

	public BigDecimal getMobilId() {
		return mobilId;
	}

	public void setMobilId(BigDecimal mobilId) {
		this.mobilId = mobilId;
	}

	public BigDecimal getWebId() {
		return webId;
	}

	public void setWebId(BigDecimal webId) {
		this.webId = webId;
	}
}
