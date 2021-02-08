package eu.europa.ec.digit.contentmanagement.domain.neo4j.access;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.europa.ec.digit.contentmanagement.domain.api.access.DaoModuleFactory;
import eu.europa.ec.digit.contentmanagement.domain.api.access.DaoModule_i;

/**
 * 
 * @author bentsth
 */
public class TestDaoModuleFactoryNeo4jTest {
    
    @Test
    public void test() throws Exception {
        Class<? extends DaoModule_i> moduleClass = DaoModuleFactory.getDaoModuleClass();
        assertNotNull(moduleClass);
        assertEquals(DaoModuleNeo4jTestImpl.class, moduleClass);
    }

}
