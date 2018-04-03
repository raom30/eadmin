package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpedienteTest {

	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ULTIMA_MOFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final Date FECHA_ARCHIVADO = new Date();
	private final EstadoExpediente estado = EstadoExpediente.ARCHIVADO;
	private final List<Documento> ListaDocumento = new ArrayList();
	private Expediente exp1;
	
	@Before
	public void inicializarCadaTest() {
		exp1 = new Expediente(CODIGO_DOCUMENTO, 
				NOMBRE_DOCUMENTO, 
				FECHA_CREACION,
				FECHA_ULTIMA_MOFICACION, 
				FECHA_ARCHIVADO,
				DOCUMENTO_PUBLICO, 
				estado,
				ListaDocumento);

	}
	@Test
	public void comprobarGetter() {

		assertTrue(exp1.getPublico().equals(DOCUMENTO_PUBLICO));
		assertTrue(exp1.getEstado().equals(EstadoDocumento.ACTIVO));
		assertTrue(exp1.getListaDocumento().equals(ListaDocumento));
		assertTrue(exp1.getFechaArchivado().equals(FECHA_ARCHIVADO));

	}

}
