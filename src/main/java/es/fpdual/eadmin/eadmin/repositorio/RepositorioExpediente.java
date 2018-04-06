package es.fpdual.eadmin.eadmin.repositorio;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface RepositorioExpediente {
	
	void  almacenarExpediene(Expediente expediente);
	void  modificarExpediente(Expediente expediente);
	void eliminarExpediente(Integer codigo);
	Expediente asociarDocumentoAlExpediente(Integer codigoExpediente,Documento documento);
	Expediente desacionarDocumentoAlExpediente(Integer codigoExpediente,Integer codigoDocumento);
	public abstract String escribirExpedienteFichero();

}
