package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

public class RepositorioDocumentoImplTest {
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ULTIMA_MOFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private Documento doc1;
	private RepositorioDocumentoImpl repo;

	@Before
	public void inicializarCadaTest() {
		
		doc1 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION,FECHA_ULTIMA_MOFICACION
				, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO);
		
		repo = new RepositorioDocumentoImpl();
	}

	@Test
	public void comprobarAltaDeDocumento() {

		repo.altaDocumento(doc1);
		
		assertSame(doc1, repo.getDocumentos().get(0));

	}

	@Test
	public void comprobarMoficacionDeDocumento() {
		
	}

	@Test
	public void comprobarEliminacionDeDocumento() {

		this.repo.getDocumentos().add(doc1);
		
		this.repo.eliminarDocumento(doc1.getCodigo());
		
		assertTrue(this.repo.getDocumentos().isEmpty());
	}
	
	@Test
	public void comprobarEliminacionDeDocumentoCuandoNoHayDocumento() {

		//this.repo.getDocumentos().add(doc1);
		
		this.repo.eliminarDocumento(doc1.getCodigo());
		
		assertTrue(this.repo.getDocumentos().isEmpty());
	}
	
	@Test 
	public void comprobamosQueNosDevuelveUnDocumentoPorCodigo() {
		
		this.repo.getDocumentos().add(doc1);
		
		Documento resultado = this.repo.obtenerDocumentoPorCodigo(doc1.getCodigo());

		assertEquals(resultado,doc1);
		
		
	}
	@Test 
	public void comprobamosQueNoNosDevuelveUnDocumentoPorCodigo() {
		
		//this.repo.getDocumentos().add(doc1);
		
		Documento resultado = this.repo.obtenerDocumentoPorCodigo(doc1.getCodigo());

		assertNotEquals(resultado,doc1);
		
		
	}  
	
	@Test
	public void comprobamosQueNosDevulveTodosLosDocumentos() {
		
		List<Documento> lista = this.repo.getDocumentos(); 
		
		List<Documento> resultado = this.repo.obtenerTodosLosDocumentos();
		
		assertEquals(resultado, lista);
		
		
	}
	

}
