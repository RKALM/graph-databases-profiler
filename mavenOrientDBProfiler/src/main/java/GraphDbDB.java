//package org.graphdb.rdf4j.tutorial;

import org.eclipse.rdf4j.model.impl.SimpleLiteral;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryEvaluationException;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.query.Update;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class GraphDbDB {
    static RepositoryConnection repositoryConnection = null;
    static String additionID = "genericid"; //its used as an identifier. Same as the message which,
    static String deletionID = "genericid"; //its used as an identifier. Same as the message which,
    // (for some reason), is not centralized

    private static Logger logger =
            LoggerFactory.getLogger(GraphDbDB.class);
    // Why This Failure marker
    private static final Marker WTF_MARKER =
            MarkerFactory.getMarker("WTF");

    // GraphDB
    private static final String GRAPHDB_SERVER =
            "http://localhost:7200/";
    private static final String REPOSITORY_ID = "PersonData";

    private static String strInsert;
    private static String strQuery;

    static {
        /*strInsert =
                "INSERT DATA {"
                        + "<http://dbpedia.org/resource/" + additionID + "> <http://xmlns.com/foaf/0.1/name> \""
                        + additionID + "\" ."
                        + "}";*/

        strQuery =
                "SELECT ?name FROM DEFAULT WHERE {" +
                        "?s <http://xmlns.com/foaf/0.1/name> ?name .}";
    }

    private static RepositoryConnection getRepositoryConnection() {
        Repository repository = new HTTPRepository(
                GRAPHDB_SERVER, REPOSITORY_ID);
        repository.initialize();
        RepositoryConnection repositoryConnection =
                repository.getConnection();
        return repositoryConnection;
    }

    private static void insert(
            RepositoryConnection repositoryConnection) {
        repositoryConnection.begin();
        additionID = "test" + Dataholder.round + "" + Dataholder.indicatorN + "" + Dataholder.countAddition
                + "";
        strInsert =
                "INSERT DATA {"
                        + "<http://dbpedia.org/resource/" + additionID + "> <http://xmlns.com/foaf/0.1/name> \""
                        + additionID + "\" ."
                        + "}";
        System.out.println(strInsert);
        Update updateOperation = repositoryConnection
                .prepareUpdate(QueryLanguage.SPARQL, strInsert);
        updateOperation.execute();

        try {
            repositoryConnection.commit();
        } catch (Exception e) {
            if (repositoryConnection.isActive())
                repositoryConnection.rollback();
        }
    }

    private static void query(
            RepositoryConnection repositoryConnection) {

        TupleQuery tupleQuery = repositoryConnection
                .prepareTupleQuery(QueryLanguage.SPARQL, strQuery);
        TupleQueryResult result = null;
        try {
            result = tupleQuery.evaluate();
            while (result.hasNext()) {
                BindingSet bindingSet = result.next();

                SimpleLiteral name =
                        (SimpleLiteral)bindingSet.getValue("name");
                logger.trace("name = " + name.stringValue());
            }
        }
        catch (QueryEvaluationException qee) {
            logger.error(WTF_MARKER,
                    qee.getStackTrace().toString(), qee);
        } finally {
            result.close();
        }
    }

    private static void delete(
            RepositoryConnection repositoryConnection) {
        repositoryConnection.begin();
        deletionID = "test" + Dataholder.round + "" + Dataholder.indicatorN + "" + Dataholder.countDeletion
                + "";
        strInsert =
                "DELETE DATA {"
                        + "<http://dbpedia.org/resource/" + deletionID + "> <http://xmlns.com/foaf/0.1/name> \""
                        + deletionID + "\" ."
                        + "}";
        System.out.println(strInsert);
        Update updateOperation = repositoryConnection
                .prepareUpdate(QueryLanguage.SPARQL, strInsert);
        updateOperation.execute();

        try {
            repositoryConnection.commit();
        } catch (Exception e) {
            if (repositoryConnection.isActive())
                repositoryConnection.rollback();
        }
    }

    public static void testScript() {
        RepositoryConnection repositoryConnection = null;
        try {
            repositoryConnection = getRepositoryConnection();

            insert(repositoryConnection);
            query(repositoryConnection);

        } catch (Throwable t) {
            logger.error(WTF_MARKER, t.getMessage(), t);
        } finally {
            repositoryConnection.close();
        }
    }//testscript ends here

    public static void startScript() {
        //RepositoryConnection repositoryConnection = null;
        try {
            repositoryConnection = getRepositoryConnection();

            //insert(repositoryConnection);
            //query(repositoryConnection);

        } catch (Throwable t) {
            logger.error(WTF_MARKER, t.getMessage(), t);
            Dataholder.graphdb_script_test = false;
        }
    }//startscript ends here


    public static void endScript() {
        repositoryConnection.close();
    }//endscript ends here

    public static void createANode() {
        //RepositoryConnection repositoryConnection = null;
        try {
            repositoryConnection = getRepositoryConnection();
            //additionID = "\"test" + Dataholder.round + "" + Dataholder.indicatorN + "" + Dataholder.countAddition + "\"";
            insert(repositoryConnection);
            query(repositoryConnection);

        } catch (Throwable t) {
            logger.error(WTF_MARKER, t.getMessage(), t);
        } finally {
            repositoryConnection.close();
        }
    }//createANode ends here

    public static void deleteANode() {
        //RepositoryConnection repositoryConnection = null;
        try {
            repositoryConnection = getRepositoryConnection();
            //additionID = "\"test" + Dataholder.round + "" + Dataholder.indicatorN + "" + Dataholder.countAddition + "\"";
            delete(repositoryConnection);
            query(repositoryConnection);

        } catch (Throwable t) {
            logger.error(WTF_MARKER, t.getMessage(), t);
        } finally {
            repositoryConnection.close();
        }
    }//deleteANode ends here
}

