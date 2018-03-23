package es.fpdual.eadmin.eadmin.modelo.builder;

import java.util.Date;
import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public class ExpedienteBuilder {
	protected  Integer codigo;
	protected  String nombre;
	protected  Date fechaCreacion;
	protected  Date fechaUltimaActualizacion;
	protected  Date fechaArchivado;
	protected  Boolean publico;
	protected  EstadoExpediente estado;
	protected  List<Documento> ListaDocumento;
	
	public Expediente construir() {
		return new Expediente(codigo,nombre,fechaCreacion,fechaUltimaActualizacion,
				fechaArchivado,publico,estado,ListaDocumento);
				
	}
	
	public ExpedienteBuilder conCodigo(Integer codigo) {
		this.codigo = codigo;
		return this;
	}

	public ExpedienteBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ExpedienteBuilder conFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		return this;
	}

	public ExpedienteBuilder conFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
		return this;
	}
	public ExpedienteBuilder conFechaArchivado(Date fechaArchivado) {
		this.fechaArchivado = fechaArchivado;
		return this;
	}

	public ExpedienteBuilder conPublico(Boolean publico) {
		this.publico = publico;
		return this;
	}

	public ExpedienteBuilder conEstado(EstadoExpediente estado) {
		this.estado = estado;
		return this;
	}
	
	public ExpedienteBuilder conListaDocumento(List<Documento> ListaDocumento) {
		this.ListaDocumento = ListaDocumento;
		return this;
	}
	public ExpedienteBuilder clonar(Expediente expediente) {
		this.codigo = expediente.getCodigo();
		this.nombre = expediente.getNombre();
		this.fechaCreacion = expediente.getFechaCreacion();
		this.fechaUltimaActualizacion = expediente.getFechaUltimaActualizacion();
		this.fechaArchivado = expediente.getFechaArchivado();
		this.publico = expediente.getPublico();
		this.estado = expediente.getEstado();
		this.ListaDocumento = expediente.getListaDocumento();
		return this;
	}
}
