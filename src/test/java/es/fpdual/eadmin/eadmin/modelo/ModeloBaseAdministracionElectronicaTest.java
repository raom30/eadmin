package es.fpdual.eadmin.eadmin.modelo;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.util.AbstractoModeloBeanTest;

public class ModeloBaseAdministracionElectronicaTest
		extends AbstractoModeloBeanTest<ModeloBaseAdministracionElectronica> {

	class ModeloBaseAdministracionElectronicaFAKE extends ModeloBaseAdministracionElectronica {

		public ModeloBaseAdministracionElectronicaFAKE(Integer codigo, String nombre, Date fechaCreacion,
				Date fechaUltimaActualizacion) {
			super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion);
		}

	}

	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final Date FECHA_ULTIMA_MOFICACION = new Date();
	private ModeloBaseAdministracionElectronicaFAKE docMBAE1;

	@Override
	public void before() {
		this.entityA1 = new ModeloBaseAdministracionElectronicaFAKE(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION,
				FECHA_ULTIMA_MOFICACION);
		this.entityA2 = new ModeloBaseAdministracionElectronicaFAKE(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION,
				FECHA_ULTIMA_MOFICACION);
		this.entityB = new ModeloBaseAdministracionElectronicaFAKE(CODIGO_DOCUMENTO, "nombre2", FECHA_CREACION,
				FECHA_ULTIMA_MOFICACION);

	}

	@Override
	public void deberiaInvocarLosMetodosGetModelo() {
		assertEquals(CODIGO_DOCUMENTO, this.entityA1.getCodigo());
		assertEquals(NOMBRE_DOCUMENTO, this.entityA1.getNombre());
		assertEquals(FECHA_CREACION, this.entityA1.getFechaCreacion());
		assertEquals(FECHA_ULTIMA_MOFICACION, this.entityA1.getFechaUltimaActualizacion());

	}

	@Override
	public void deberiaImprimirToString() {
		// TODO Auto-generated method stub

	}


}
