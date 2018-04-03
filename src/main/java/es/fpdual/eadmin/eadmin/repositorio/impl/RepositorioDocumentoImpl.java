package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private final List<Documento> documentos = new ArrayList<>();

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {

		if (documentos.contains(documento)) {// si existe el documento pues no entra.
			throw new IllegalArgumentException("El documento ya existe");
		}
		documentos.add(documento);
		System.out.println("Insertado");
	} 

	@Override
	public void modificarDocumento(Documento documento) {

		if (!documentos.contains(documento)) {// si existe el documento pues no entra.
			throw new IllegalArgumentException("El documento no existe");
		}
		documentos.set(documentos.indexOf(documentos), documento);// Busca la posicion y lo cambia

	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {// esto es lo mismo que documentoEncontrado == null
			documentos.remove(documentoEncontrado.get());
		}

	}

	@Override 
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo))
		.findFirst();
		
		if (documentoEncontrado.isPresent()) {
			return documentoEncontrado.get();
		}
		return null;
		
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
	
		return documentos;
	}

}
