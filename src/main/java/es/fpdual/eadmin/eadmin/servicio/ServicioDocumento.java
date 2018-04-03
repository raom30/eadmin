package es.fpdual.eadmin.eadmin.servicio;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumento {

	Documento altaDocumento(Documento documento);

	Documento modificarDocumento(Documento documento);

	void eliminarDocumento(Integer codigo);
	
	Documento obtenerDocumentoPorCodigo(Integer codigo);
	
	List<Documento> obtenerTodosLosDocumentos();

}
