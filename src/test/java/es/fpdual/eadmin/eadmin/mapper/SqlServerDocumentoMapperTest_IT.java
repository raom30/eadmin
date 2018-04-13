package es.fpdual.eadmin.eadmin.mapper;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-configuracion/eadmin-persistencia.xml",
		"classpath:spring-configuracion/eadmin-sqlserver-persistencia.xml" })
@Rollback
public class SqlServerDocumentoMapperTest_IT extends BaseDocumentoMapperTest {

}
