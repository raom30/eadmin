package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class DocumentoContableTest {
	
	private static final BigDecimal IMPORTE = new BigDecimal(2.05);
	private static final Date FECHA_ULTIMA_MOFICACION = new Date();
	private static final String DNI_INTERESADO = "15404154E";
	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private DocumentoContable docC1;
	
	@Before
	public void inicializarCadaTest() {
		docC1 = new DocumentoContable(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION,FECHA_ULTIMA_MOFICACION, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO,IMPORTE,DNI_INTERESADO);

	}
	@Test
	public void ComprobamosLosGetterNuevos(){
		assertTrue(docC1.getImporte().equals(IMPORTE));
		assertTrue(docC1.getDniInteresado().equals(DNI_INTERESADO));
	}


}
