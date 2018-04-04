package es.fpdual.eadmin.eadmin.controlador;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;
import es.fpdual.eadmin.eadmin.servicio.impl.ServicioDocumentoImpl;

public class ContraladorEadminTest {

	
	private ControladorEadmin controladoEadmin;
	private ServicioDocumentoImpl servicioDocumento;
	private Documento doc1;
	private RepositorioDocumento repo;
	
	@Before
	public void inicializarCadaTest() {
		doc1 = mock(Documento.class);
		this.servicioDocumento = spy(new ServicioDocumentoImpl(repo));
	}

	@Test
	public void comprobarQueSeMuestranLosDocumentos() {
		ResponseEntity<List<Documento>> resultado = this.controladoEadmin.getTodoDocumento();
		
		assertEquals(servicioDocumento,resultado);
		
	}

}
