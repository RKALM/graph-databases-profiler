import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.ORecord;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class OrientDbDB {
    static ODatabaseSession db;
    static OrientDB orient;

    public static void startScript() {

        orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        db = orient.open("demodb", "root", "12345");

        //createSchema(db);

        //db.close();
        //orient.close();
    }

    public static void endScript() {
        db.close();
        orient.close();
    }


    public static void testScript() { //don;t use it. only for testing purposes

        OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        db = orient.open("demodb", "root", "12345");

        createSchema(db);

        createPeople(db);

        executeAQuery("alice");

        executeAnotherQuery(db);

        db.close();
        orient.close();

    }

    private static void createSchema(ODatabaseSession db) {
        OClass person = db.getClass("Person");

        if (person == null) {
            person = db.createVertexClass("Person");
        }

        if (person.getProperty("name") == null) {
            person.createProperty("name", OType.STRING);
            person.createIndex("Person_name_index", OClass.INDEX_TYPE.NOTUNIQUE, "name");
        }

        if (db.getClass("FriendOf") == null) {
            db.createEdgeClass("FriendOf");
        }

    }

    private static void createPeople(ODatabaseSession db) {
        OVertex alice = createPerson(db, "Alice", "Foo");
        OVertex bob = createPerson(db, "Bob", "Bar");
        OVertex jim = createPerson(db, "Jim", "Baz");

        OEdge edge1 = alice.addEdge(bob, "FriendOf");
        edge1.save();
        OEdge edge2 = bob.addEdge(jim, "FriendOf");
        edge2.save();
    }

    private static OVertex createPerson(ODatabaseSession db, String name, String surname) {
        OVertex result = db.newVertex("Person");
        result.setProperty("name", name);
        result.setProperty("surname", surname);
        result.save();
        return result;
    }

    public static OVertex createANode(String name) {
        OVertex result = db.newVertex("Person");
        result.setProperty("name", name);
        //result.setProperty("surname", surname);
        result.save();
        System.out.println(result); //for testing
        return result;
    }

    public static void updateANode(String name) {
        String query = "SELECT from Person WHERE name = ?";
        OResultSet rs = db.command(query, name);
        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println("name: " + item.getProperty("name"));
        }
        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
    }

    public static void deleteANodeFake(String name) {
        String query = "SELECT from Person WHERE name = ?";
        OResultSet rs = db.command(query, name);
        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println("name: " + item.getProperty("name"));
        }
        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
    }

    public static void deleteANode2(String name) {
        //String query = "DELETE VERTEX Person WHERE name = ?";
        //OResultSet rs = db.query(query, name);
        db.command(new OSQLSynchQuery<>("DELETE VERTEX Person WHERE  name='"+ name + "'")).execute();

        //rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
    }

    public static void deleteANode3(String name) {
        String query = "DELETE VERTEX from Person WHERE name = ?";
        OResultSet rs = db.command(query, name);
        System.out.println(rs); //only for testing
        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
    }

    public static void deleteANode(String name) {
        String query = "DELETE VERTEX Person WHERE name = ?";
        db.command(query, name);
        //System.out.println(rs); //only for testing
        //rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
    }

    public static void executeAQuery(String name) {
        String query = "SELECT expand(out('FriendOf').out('FriendOf')) from Person where name = ?";
        OResultSet rs = db.query(query, name);

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println("friend: " + item.getProperty("name"));
        }

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
    }

    private static void executeAnotherQuery(ODatabaseSession db) {
        String query =
                " MATCH                                           " +
                        "   {class:Person, as:a, where: (name = :name1)}, " +
                        "   {class:Person, as:b, where: (name = :name2)}, " +
                        "   {as:a} -FriendOf-> {as:x} -FriendOf-> {as:b}  " +
                        " RETURN x.name as friend                         ";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name1", "Alice");
        params.put("name2", "Jim");

        OResultSet rs = db.query(query, params);

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println("friend: " + item.getProperty("friend"));
        }

        rs.close();
    }
}
