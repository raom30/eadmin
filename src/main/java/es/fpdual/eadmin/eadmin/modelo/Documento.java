package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends ModeloBaseAdministracionElectronica {


	private Boolean publico;
	private EstadoDocumento estado;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado) {
		super(codigo,nombre,fechaCreacion);

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
	
}
