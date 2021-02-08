package eu.europa.ec.digit.contentmanagement.domain.neo4j.access;

import static eu.europa.ec.digit.contentmanagement.domain.neo4j.access.EccmConstantsNeo4jImpl.*;

import java.util.Properties;

import org.apache.log4j.Logger;

import eu.europa.ec.digit.contentmanagement.domain.api.util.EccmUtils;
import eu.europa.ec.digit.contentmanagement.domain.neo4j.access.util.EmbeddedNeo4jRunner;

/**
 * 
 * @author bentsth
 */
public class DaoModuleNeo4jTestImpl extends DaoModuleNeo4jImpl {

    private static final Logger logger = Logger.getLogger(DaoModuleNeo4jTestImpl.class);


    @Override
    public void initSub() throws Exception {
        if (logger.isDebugEnabled())
            logger.debug("Starting embedded database");

        Properties props = EccmUtils.readEccmPropsFromClasspath();
        String dbPath = props.getProperty(PROP_NAME_DB_PATH);

        if (dbPath == null) {
            dbPath = "./database/" + System.currentTimeMillis();
        } else {
            if (!dbPath.endsWith("/"))
                dbPath += "/";
            dbPath += System.currentTimeMillis();
        }

        if (logger.isInfoEnabled())
            logger.info("Path: " + dbPath);

        // Start embedded database
        EmbeddedNeo4jRunner.startDatabase(dbPath);

        super.initSub();

        generateTestData();
    }
}