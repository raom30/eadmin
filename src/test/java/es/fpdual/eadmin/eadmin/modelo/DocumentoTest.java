package es.fpdual.eadmin.eadmin.modelo;


import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoTest {
	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private Documento doc1;

	@Before
	public void inicializarCadaTest() {
		doc1 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO);

	}

	@Test
	public void comprobarGetter() {

		assertTrue(doc1.getPublico().equals(DOCUMENTO_PUBLICO));
		assertTrue(doc1.getEstado().equals(EstadoDocumento.ACTIVO));

	}



}
