package es.fpdual.eadmin.eadmin.servicio.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

public class ServicioExpedienteImplTest {


	private ServicioExpedienteImpl servi;
	private Expediente exp1;
	private RepositorioExpediente repo;

	@Before
	public void inicializarCadaTest() {
		exp1 = mock(Expediente.class);
		repo = mock(RepositorioExpediente.class);
		this.servi = spy(new ServicioExpedienteImpl(repo));
	}

	@Test
	public void deberiaAlmacenarUnExpediente() {
		final Expediente expedienteModificado = mock(Expediente.class);
		doReturn(expedienteModificado).when(servi).obtenerExpedienteConFechaCorrecta(exp1);

		final Expediente resultado = this.servi.almacenarExpediene(exp1);

		verify(this.repo).almacenarExpediene(expedienteModificado);
		assertSame(resultado, expedienteModificado);

	}

	@Test
	public void deberiaModificarUnExpediente() {

		final Expediente expedienteModificado = mock(Expediente.class);
		doReturn(expedienteModificado).when(servi).obtenerExpedienteConFechaUltimaActualizacion(exp1);

		final Expediente resultado = this.servi.modificarExpediente(exp1);

		verify(this.repo).modificarExpediente(expedienteModificado);
		assertSame(resultado, expedienteModificado);

	}
}
