package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {
	
	
	RepositorioDocumento repositorioDocumento;
	
	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}
	
	@Override
	public Documento altaDocumento(Documento documento) {
		
		final Documento documentoModificado = obtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.altaDocumento(documentoModificado);
		
		return documentoModificado;
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		
		
		
		repositorioDocumento.modificarDocumento(documento);
		
		return documento;
		
	}


	@Override
	public void eliminarDocumento(Integer codigo) {
		repositorioDocumento.eliminarDocumento(codigo);
		
	}


	protected Documento obtenerDocumentoConFechaCorrecta(Documento documento) {
		final Documento documentoModificado = new Documento(documento.getCodigo(),documento.getNombre(),
				dameFechaActual(),
				documento.getFechaUltimaActualizacion(),
				documento.getPublico(),
				documento.getEstado());
		return documentoModificado;
	}

	protected Date dameFechaActual() {
		
		return new Date();//Devuele la fecha actual
	}
	

}
