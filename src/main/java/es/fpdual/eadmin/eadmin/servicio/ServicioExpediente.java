package es.fpdual.eadmin.eadmin.servicio;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface ServicioExpediente {
	
	Expediente  almacenarExpediene(Expediente expediente);
	Expediente  modificarExpediente(Expediente expediente);
	void eliminarExpediente(Integer codigo);
	Expediente asociarDocumentoAlExpediente(Integer codigoExpediente,Documento documento);
	Expediente desacionarDocumentoAlExpediente(Integer codigoExpediene,Integer codigoDocumento);
	
}
