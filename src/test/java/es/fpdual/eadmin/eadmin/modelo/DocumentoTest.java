package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.ModeloBaseAdministracionElectronicaTest.ModeloBaseAdministracionElectronicaFAKE;
import es.fpdual.eadmin.eadmin.util.AbstractoModeloBeanTest;

public class DocumentoTest extends AbstractoModeloBeanTest<Documento> {
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ULTIMA_MOFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private Documento doc1;

	@Override
	public void before() {
		this.entityA1 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_ULTIMA_MOFICACION,
				DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO);
		this.entityA2 =new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_ULTIMA_MOFICACION,
				DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO);
		this.entityB =new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_ULTIMA_MOFICACION,
				DOCUMENTO_PUBLICO, EstadoDocumento.ELIMINADO);

	}

	@Override
	public void deberiaInvocarLosMetodosGetModelo() {

		assertEquals(DOCUMENTO_PUBLICO, this.entityA1.getPublico());
		assertEquals(EstadoDocumento.ACTIVO, this.entityA1.getEstado());

	}

	@Override
	public void deberiaImprimirToString() {
		// TODO Auto-generated method stub

	}


}
