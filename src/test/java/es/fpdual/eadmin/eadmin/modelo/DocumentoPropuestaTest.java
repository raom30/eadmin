package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoPropuestaTest {
	
	private static final Integer CODIGO_PROPUESTA = 000005;
	private static final Integer EJERCICIO = 5;
	private static final String GRUPO_POLITICO = "X";
	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private DocumentoPropuesta docP1;
	
	@Before
	public void inicializarCadaTest() {
		docP1 = new DocumentoPropuesta(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO,CODIGO_PROPUESTA,EJERCICIO,GRUPO_POLITICO);

	}	
	@Test
	public void comprobarGetterPropuesta() {
		assertTrue(docP1.getCodigoPropuesta().equals(CODIGO_PROPUESTA));
		assertTrue(docP1.getEjercicio().equals(EJERCICIO));
		assertTrue(docP1.getGrupoPolitico().equals(GRUPO_POLITICO));
		
	}

}
