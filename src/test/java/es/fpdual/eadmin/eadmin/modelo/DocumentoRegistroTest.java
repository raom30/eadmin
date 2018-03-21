package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class DocumentoRegistroTest {
	
	private static final String CODIGO_REGISTRO = "00001X";
	private static final String DNI_INTERESADO = "15404154E";
	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private DocumentoRegistro docR1;
	
	@Before
	public void inicializarCadaTest() {
		docR1 = new DocumentoRegistro(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO,CODIGO_REGISTRO,DNI_INTERESADO);

	}
	@Test
	public void comprobarGetterDocumentoRegistro() {
		assertTrue(docR1.getCodigoRegistro().equals(CODIGO_REGISTRO));
		assertTrue(docR1.getDniInteresado().equals(DNI_INTERESADO));
		
	}

}
