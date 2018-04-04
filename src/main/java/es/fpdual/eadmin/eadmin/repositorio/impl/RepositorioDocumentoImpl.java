package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.EadminApplication;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private final List<Documento> documentos = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);
	private static final RepositorioDocumentoImpl rdi = new RepositorioDocumentoImpl();
	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {
		
		logger.info("Entrado en el metodo : "+rdi.getNombreMetodo());
		if (documentos.contains(documento)) {// si existe el documento pues no entra.
			throw new IllegalArgumentException("El documento ya existe");
		}
		documentos.add(documento);
		logger.info("{} creado correctamente",documento.toString());

		logger.info("Saliendo del metodo : "+rdi.getNombreMetodo());

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
			logger.info("El Documento {} eliminado correctamente",documentoEncontrado);
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
		logger.info("Entrado en el metodo : "+rdi.getNombreMetodo());
		for(Documento d: documentos) {
			logger.info(d.mostrar());
		}
		logger.info("Saliendo del metodo : "+rdi.getNombreMetodo());
		return documentos;
	}
	public String getNombreMetodo(){
	      //Retorna el nombre del metodo desde el cual se hace el llamado
	      return new Exception().getStackTrace()[1].getMethodName();
	   }

}
