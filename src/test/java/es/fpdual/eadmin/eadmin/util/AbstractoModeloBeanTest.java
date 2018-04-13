package es.fpdual.eadmin.eadmin.util;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import es.fpdual.eadmin.eadmin.modelo.ModeloBaseAdministracionElectronica;

public abstract class AbstractoModeloBeanTest<T extends ModeloBaseAdministracionElectronica> {

    protected T entityA1;

    protected T entityA2;

    protected T entityB;

    public AbstractoModeloBeanTest() {
        super();
    }

    @Before
    public abstract void before();

    @Test
    public void deberiaTenerElMismoHashCode() {
        assertThat(this.entityA1.hashCode(), is(this.entityA2.hashCode()));
    }

    @Test
    public void debeberiaTenerDistintoHashCode() {
        assertThat(this.entityA1.hashCode(), is(not(this.entityB.hashCode())));
    }

    // Simétrica x.equals(y) == y.equals(x)
    @Test
    public void deberiaSerIguales() {
        assertThat(this.entityA1, is(this.entityA2));
        assertThat(this.entityA2, is(this.entityA1));
    }

    // Reflexiva x.equals(x)
    @Test
    public void debeDerIgualSiEsElMismoObjeto() {
        assertThat(this.entityA1, is(this.entityA1));
    }

    @Test
    public void deberiaSerDistintos() {
        assertThat(this.entityA1, is(not(this.entityB)));
    }

    @Test
    public void deberiaSerDistintosSiEsNulo() {
        assertFalse(this.entityA1.equals(null)); // NOSONAR solo para los test
    }

    @Test
    public void deberiaSerDistintosSiUnObjectoEsOtroTipo() {
        assertThat(this.entityA1, is(not(new Object())));
    }

    @Test
    public abstract void deberiaInvocarLosMetodosGetModelo();

    @Test
    public abstract void deberiaImprimirToString();

}
