package es.fpdual.eadmin.eadmin.modelo.builder;

import java.util.Date;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class DocumentoBuilder {

	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Date fechaUltimaActualizacion;
	protected Boolean publico;
	protected EstadoDocumento estado;

	public Documento construir() {
		return new Documento(codigo, nombre, fechaCreacion, fechaUltimaActualizacion, publico, estado);

	}

	public DocumentoBuilder conCodigo(Integer codigo) {
		this.codigo = codigo;
		return this; 
	}

	public DocumentoBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public DocumentoBuilder conFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}

	public DocumentoBuilder conFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
		return this;
	}

	public DocumentoBuilder conPublico(Boolean publico) {
		this.publico = publico;
		return this;
	}

	public DocumentoBuilder conEstado(EstadoDocumento estado) {
		this.estado = estado;
		return this;
	}
	
	public DocumentoBuilder clonar(Documento documento) {
		this.codigo = documento.getCodigo();
		this.nombre = documento.getNombre();
		this.fechaCreacion = documento.getFechaCreacion();
		this.fechaUltimaActualizacion = documento.getFechaUltimaActualizacion();
		this.publico = documento.getPublico();
		this.estado = documento.getEstado();
		return this;
	}

}
