package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {
	
	private List<Documento> documentos = new ArrayList<>();

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {
		
		if(documentos.contains(documento)) {//si existe el documento pues no entra.
			throw new IllegalArgumentException("El documento ya existe");
		}
		documentos.add(documento);
		
	}

	@Override
	public void modificarDocumento(Documento documento) {
		
		if(!documentos.contains(documento)) {//si existe el documento pues no entra.
			throw new IllegalArgumentException("El documento no existe");
		}
		documentos.set(documentos.indexOf(documentos), documento);//Busca la posicion y lo cambia
		
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo)).findFirst();
		
		if(documentoEncontrado.isPresent()) {//esto es lo mismo que documentoEncontrado == null
			documentos.remove(documentoEncontrado.get());
		}
		
	}

}
