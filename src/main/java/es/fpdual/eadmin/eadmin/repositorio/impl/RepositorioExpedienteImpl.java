package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

public class RepositorioExpedienteImpl implements RepositorioExpediente {

	private final List<Expediente> expedientes = new ArrayList<>();

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	@Override
	public void almacenarExpediene(Expediente expediente) {
		if (expedientes.contains(expediente)) {// si existe el documento pues no entra.
			throw new IllegalArgumentException("El expediente ya existe");
		}
		expedientes.add(expediente);

	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente)) {// si existe el documento pues no entra.
			throw new IllegalArgumentException("El documento no existe");
		}
		expedientes.set(expedientes.indexOf(expedientes), expediente);// Busca la posicion y lo cambia

	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (expedienteEncontrado.isPresent()) {// esto es lo mismo que documentoEncontrado == null
			expedientes.remove(expedienteEncontrado.get());
		}
	}

	@Override
	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream()
				.filter(e -> e.getCodigo().equals(codigoExpediente)).findFirst();

		if (expedienteEncontrado.isPresent()) {
			expedienteEncontrado.get().getListaDocumento().add(documento);
			return expedienteEncontrado.get();
		}

		return null;
	}

	@Override
	public Expediente desacionarDocumentoAlExpediente(Integer codigoExpediente, Integer codigoDocumento) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream()
				.filter(e -> e.getCodigo().equals(codigoExpediente)).findFirst();

		if (expedienteEncontrado.isPresent()) {
			localizaYEliminaElDocumentoYDevuelveElDocumento(codigoDocumento, expedienteEncontrado);
			return expedienteEncontrado.get();
		}

		return null;
	}

	private Documento localizaYEliminaElDocumentoYDevuelveElDocumento(Integer codigoDocumento, Optional<Expediente> expedienteEncontrado) {
		Optional<Documento> documentoEncontrado = expedienteEncontrado.get().getListaDocumento().stream()
				.filter(d -> d.getCodigo().equals(codigoDocumento)).findFirst();
		if (documentoEncontrado.isPresent()) {
			expedienteEncontrado.get().getListaDocumento().remove(documentoEncontrado.get());
			return documentoEncontrado.get();
		}
		return null;
	}

}
