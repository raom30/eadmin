package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.modelo.builder.ExpedienteBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;
import es.fpdual.eadmin.eadmin.servicio.ServicioExpediente;

@Service
public class ServicioExpedienteImpl implements ServicioExpediente {

	RepositorioExpediente repositorioExpediente;

	@Autowired
	public ServicioExpedienteImpl(RepositorioExpediente repositorioExpediente) {
		this.repositorioExpediente = repositorioExpediente;
	}

	@Override
	public Expediente almacenarExpediene(Expediente expediente) {
		final Expediente expedienteModificado = obtenerDocumentoConFechaCorrecta(expediente);

		repositorioExpediente.almacenarExpediene(expedienteModificado);

		return expedienteModificado;
	}

	@Override
	public Expediente modificarExpediente(Expediente expediente) {
		repositorioExpediente.modificarExpediente(expediente);

		return expediente;
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		repositorioExpediente.eliminarExpediente(codigo);

	}

	@Override
	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento) {
		return repositorioExpediente.asociarDocumentoAlExpediente(codigoExpediente, documento);
	}

	@Override
	public Expediente desacionarDocumentoAlExpediente(Integer codigoExpediente, Integer codigo) {
		return repositorioExpediente.desacionarDocumentoAlExpediente(codigoExpediente, codigo);
		 
	}

	protected Date dameFechaActual() {

		return new Date();// Devuele la fecha actual
	}

	private Expediente obtenerDocumentoConFechaCorrecta(Expediente expediente) {
		return new ExpedienteBuilder().clonar(expediente).conFechaCreacion(dameFechaActual()).construir();
	}

}
