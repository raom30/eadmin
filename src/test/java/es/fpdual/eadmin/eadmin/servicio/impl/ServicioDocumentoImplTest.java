package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	private ServicioDocumentoImpl servi;
	private Documento doc1;
	private RepositorioDocumento repo;

	@Before
	public void inicializarCadaTest() {
		doc1 = mock(Documento.class);
		repo = mock(RepositorioDocumento.class);
		this.servi = spy(new ServicioDocumentoImpl(repo));
	}

	@Test
	public void deberiaAlmacenarUnDocumento() {
		final Documento documentoModificado = mock(Documento.class);
		doReturn(documentoModificado).when(servi).obtenerDocumentoConFechaCorrecta(doc1);

		final Documento resultado = this.servi.altaDocumento(doc1);

		verify(this.repo).altaDocumento(documentoModificado);
		assertSame(resultado, documentoModificado);

	}

	@Test
	public void deberiaModificarUnDocumento() {

		final Documento documentoModificado = mock(Documento.class);
		doReturn(documentoModificado).when(servi).obtenerDocumentoConFechaCorrecta(doc1);

		final Documento resultado = this.servi.modificarDocumento(doc1);

		verify(this.repo).modificarDocumento(documentoModificado);
		assertSame(resultado, documentoModificado);

	}

	@Test
	public void deberiaEliminarUnDocumento() {
		when(doc1.getCodigo()).thenReturn(1);
		// Entrena al moquito y le da el valor 1 Cuando el documento getcodigo sea 1
		this.servi.eliminarDocumento(doc1.getCodigo());
		verify(this.repo).eliminarDocumento(doc1.getCodigo());
	}

	@Test
	public void deberiaDarFechaActual() {

		assertEquals(new Date(), ((ServicioDocumentoImpl) this.servi).dameFechaActual());

	}

	@Test
	public void deberiaObtenerDocumentoConFechaCorrecta() {

	}

	@Test
	public void deberiaObtenerDocumentoPorCodido() {
		when(repo.obtenerDocumentoPorCodigo(1)).thenReturn(doc1);

		Documento resultado = servi.obtenerDocumentoPorCodigo(1);

		assertSame(resultado, doc1);
	}

	@Test
	public void deberiaDevolverTodoLosDocumentos() {

		List<Documento> lista = new ArrayList<>();

		when(repo.obtenerTodosLosDocumentos()).thenReturn(lista);

		List<Documento> resultado = servi.obtenerTodosLosDocumentos();

		assertSame(resultado, lista);
	}

}
