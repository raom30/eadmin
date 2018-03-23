package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class Documento extends ModeloBaseAdministracionElectronica {

	private Boolean publico;
	private EstadoDocumento estado;
	private String codigoVerificacion;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaActualizacion, Boolean publico,
			EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion);

		this.publico = publico;
		this.estado = estado;
	}

	public Boolean getPublico() {
		return publico;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Documento con código " + codigo;
	}

	public String codigoVerificacion() {
		codigoVerificacion = codigo + nombre + fechaCreacion + fechaUltimaActualizacion + publico + estado;
		return DigestUtils.shaHex(codigoVerificacion);
	}
}
