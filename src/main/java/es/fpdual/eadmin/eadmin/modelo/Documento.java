package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class Documento extends ModeloBaseAdministracionElectronica {

	private final Boolean publico;
	private final EstadoDocumento estado;
	private String codigoVerificacion;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaActualizacion, Boolean publico,
			EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion);

		this.publico = publico;
		this.estado = estado;
	}
	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaActualizacion, Boolean publico,
			EstadoDocumento estado,String codigoVerificacion) {
		super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion);
 
		this.publico = publico;
		this.estado = estado;
		this.codigoVerificacion = codigoVerificacion;
	}

	public Boolean getPublico() {
		return publico;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}
	
	
	public String getCodigoVerificacion() {
		return codigoVerificacion;
	}

	@Override
	public String toString() {
		return "Documento con código " + codigo;
	}

	public String calcularCodigoVerificacion() {
		codigoVerificacion = codigo + nombre + fechaCreacion + fechaUltimaActualizacion + publico + estado;
		return DigestUtils.shaHex(codigoVerificacion); 
	}
	
	public String mostrar() {
		String cadena =  "\n Codigo :"+codigo 
				+"\n Nombre:  "+ nombre 
				+"\n Fecha Creacion: "+ fechaCreacion 
				+"\n Fecha Ultima Actualizacion: "+ fechaUltimaActualizacion 
				+"\n Publico: "+ publico 
				+"\n Estado: "+ estado 
				+"\n Codigo Verificacion: "+ codigoVerificacion ;
		return cadena;
	}
	
}
