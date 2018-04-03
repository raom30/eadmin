package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

public class ServicioDocumentoImplTest {

	private ServicioDocumento servi;
	private Documento doc1;
	private RepositorioDocumento repo;

	@Before
	public void inicializarCadaTest() {
		doc1 = mock(Documento.class);
		repo = mock(RepositorioDocumento.class);
		this.servi = new ServicioDocumentoImpl(repo);
	}

	@Test
	public void deberiaAlmacenarUnDocumento() { 
		
		when(doc1.getCodigo()).thenReturn(1);
		when(doc1.getFechaCreacion()).thenReturn(new Date(30/04/2008));
		when(doc1.getNombre()).thenReturn("nombre");
		
		final Documento resultado = this.servi.altaDocumento(doc1);
		
		
		verify(this.repo).altaDocumento(any());
		assertEquals(resultado.getCodigo(),doc1.getCodigo());
		assertNotEquals(resultado.getFechaCreacion(), doc1.getFechaCreacion());
		assertEquals(resultado.getNombre(),doc1.getNombre());
		
	}
	
	@Test
	public void deberiaModificarUnDocumento() {
		
		this.servi.modificarDocumento(doc1);
		
		verify(this.repo).modificarDocumento(doc1);

	}
	
	@Test
	public void deberiaEliminarUnDocumento() {
		when(doc1.getCodigo()).thenReturn(1);
		//Entrena al moquito y le da el valor 1 Cuando el documento getcodigo sea 1
		this.servi.eliminarDocumento(doc1.getCodigo());
		verify(this.repo).eliminarDocumento(doc1.getCodigo());
	}
	
	@Test
	public void deberiaDarFechaActual(){
		
		assertEquals(new Date(),((ServicioDocumentoImpl) this.servi).dameFechaActual());
		
	}
	
	@Test
	public void deberiaObtenerDocumentoConFechaCorrecta() {
		
	}
	
	
}
