package es.fpdual.eadmin.eadmin.mapper;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.util.Utilidades;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

	@Autowired
	private DocumentoMapper mapper;
	Documento doc1;


	@Before
	public void inicializarEnCadaTest() {
		doc1 = new Documento(1, "Documento1", Utilidades.asDate(LocalDate.of(2015, 1, 2)), Utilidades.asDate(LocalDate.of(2015, 1, 2)), true, EstadoDocumento.ACTIVO);
		
	}

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {

		int resultado = mapper.insertarDocumento(doc1);

		assertThat(resultado, is(1));
	}

	@Test
	public void deberiaActualizarTodosLosCamposDeUnDocumento() throws Exception {
		//DECLARACION
		Documento documentoActualizado = new Documento(1, "Documento2",Utilidades.asDate(LocalDate.of(2015, 1, 2)),Utilidades.asDate(LocalDate.of(2015, 1, 2)), false,
				EstadoDocumento.APROBADO);
		//ENTRENAMIENTO
		mapper.insertarDocumento(doc1);
		//PRUEBA
		int resultado = mapper.actualizarDocumento(documentoActualizado);

		//VERIFICACION
		Documento documentoModificado = this.mapper.mostrarDocumento(1);
		assertThat(documentoModificado, is(documentoActualizado));
	}

	@Test
	public void deberiaEliminarUnDocumento() throws Exception {
		//DECLARACION
		
		//ENTRENAMIENTO
		mapper.insertarDocumento(doc1);
		
		//PRUEBA
		int resultado = mapper.eliminarDocumento(doc1);
		
		//VERIFICACION
		assertThat(resultado, is(1));

	}
	
	@Test
	public void deberiaMostrarUnDocumento() throws Exception{
		mapper.insertarDocumento(doc1);
		Documento resultado = mapper.mostrarDocumento(1);
		assertThat(resultado, is(doc1));
		
	}
}
