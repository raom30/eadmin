package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends ModeloBaseAdministracionElectronica {


	private Boolean publico;
	private EstadoDocumento estado;
	private String codigoVerificacion;

	public Documento(Integer codigo, String nombre, Date fechaCreacion,Date fechaUltimaActualizacion, Boolean publico, EstadoDocumento estado) {
		super(codigo,nombre,fechaCreacion,fechaUltimaActualizacion);

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
		return "Documento con código " + codigo ;
	}
	public String codigoVerificacion() {
		String cadena = codigo + nombre + fechaCreacion +
				fechaUltimaActualizacion + publico + estado;
		return cadena;
				
	}
}
