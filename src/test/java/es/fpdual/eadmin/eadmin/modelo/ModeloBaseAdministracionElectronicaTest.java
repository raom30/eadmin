package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ModeloBaseAdministracionElectronicaTest {
	
	class ModeloBaseAdministracionElectronicaFAKE extends ModeloBaseAdministracionElectronica {

		public ModeloBaseAdministracionElectronicaFAKE(Integer codigo, String nombre, Date fechaCreacion,Date fechaUltimaActualizacion) {
			super(codigo, nombre, fechaCreacion,fechaUltimaActualizacion);
		}

	}

	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final Date FECHA_ULTIMA_MOFICACION = new Date();
	private ModeloBaseAdministracionElectronicaFAKE docMBAE1;

	@Before
	public void inicializarCadaTest() {
		docMBAE1 = new ModeloBaseAdministracionElectronicaFAKE(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION,FECHA_ULTIMA_MOFICACION);

	}

	@Test
	public void comprobarGetterModeloBase() {
		assertTrue(docMBAE1.getCodigo().equals(CODIGO_DOCUMENTO));
		assertTrue(docMBAE1.getNombre().equals(NOMBRE_DOCUMENTO));
		assertTrue(docMBAE1.getFechaCreacion().equals(FECHA_CREACION));
		assertTrue(docMBAE1.getFechaUltimaActualizacion().equals(FECHA_ULTIMA_MOFICACION));
	}

	@Test
	public void deberiDevolverVerdaderoSiNoTieneIgualCodigo() {

		final ModeloBaseAdministracionElectronicaFAKE doc2 = new ModeloBaseAdministracionElectronicaFAKE(
				CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION,FECHA_ULTIMA_MOFICACION);
		assertTrue(docMBAE1.equals(doc2));

	}

	@Test
	public void deberiDevolverFalseSiNoTieneIgualCodigo() {

		final ModeloBaseAdministracionElectronicaFAKE doc2 = new ModeloBaseAdministracionElectronicaFAKE(5,
				NOMBRE_DOCUMENTO, FECHA_CREACION,FECHA_ULTIMA_MOFICACION);
		assertFalse(docMBAE1.equals(doc2));

	}

	@Test
	public void deberiDevolverFalseSiNoEntraEnElIf() {

		assertFalse(docMBAE1.equals("hola"));

	}

	@Test
	public void deberiaDevolverHashCodeDelCodigo() {
		final int resultado = docMBAE1.hashCode();
		assertEquals(CODIGO_DOCUMENTO.hashCode(), resultado);

	}

}
