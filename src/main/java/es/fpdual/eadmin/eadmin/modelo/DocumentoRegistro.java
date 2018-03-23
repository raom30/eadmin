package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoRegistro extends Documento {
	
	private final String dniInteresado;
	private final String codigoRegistro;

	public DocumentoRegistro(Integer codigo, String nombre, Date fechaCreacion,Date fechaUltimaActualizacion, Boolean publico,
			EstadoDocumento estado, String dniInteresado, String codigoRegistro) {
		super(codigo, nombre, fechaCreacion,fechaUltimaActualizacion, publico, estado);
		this.dniInteresado = dniInteresado;
		this.codigoRegistro = codigoRegistro;
		
	}

	public String getDniInteresado() {
		return dniInteresado;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}
	

}
