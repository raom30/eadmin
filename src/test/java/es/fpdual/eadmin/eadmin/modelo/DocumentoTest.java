package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

		assertTrue(doc1.getCodigo().equals(CODIGO_DOCUMENTO));
		assertTrue(doc1.getNombre().equals(NOMBRE_DOCUMENTO));
		assertTrue(doc1.getFechaCreacion().equals(FECHA_CREACION));
		assertTrue(doc1.getPublico().equals(DOCUMENTO_PUBLICO));
		assertTrue(doc1.getEstado().equals(EstadoDocumento.ACTIVO));

	}

	@Test
	public void deberiDevolverVerdaderoSiNoTieneIgualCodigo() {

		final Documento doc2 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO);
		assertTrue(doc1.equals(doc2));

	}

	@Test
	public void deberiDevolverFalseSiNoTieneIgualCodigo() {

		final Documento doc2 = new Documento(5, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO);
		assertFalse(doc1.equals(doc2));

	}

	@Test
	public void deberiDevolverFalseSiNoEntraEnElIf() {

		assertFalse(doc1.equals("hola"));

	}

	@Test
	public void deberiaDevolverHashCodeDelCodigo() {
		final int resultado = doc1.hashCode();
		assertEquals(CODIGO_DOCUMENTO.hashCode(), resultado);

	}

}
