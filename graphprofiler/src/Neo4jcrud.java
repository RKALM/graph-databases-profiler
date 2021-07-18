public class Neo4jcrud {

    //CREATE operation on Neo4j. It returns to indicate that is has complete its cycle.
    static boolean create(){
        //do something
        Neo4jDB neo4j = new Neo4jDB( "bolt://localhost:7687", "profiler", "profiler" );
        neo4j.createANode("Creating a node on Neo4j");
        //System.out.println("Creating a node on Neo4j");
        return true;
    }

    //UPDATE operation on Neo4j. It returns to indicate that is has complete its cycle.
    static boolean update(){
        //do something
        System.out.println("Updating a node on Neo4j");
        return true;
    }

    //DELETE operation on Neo4j. It returns to indicate that is has complete its cycle.
    static boolean delete(){
        //do something
        System.out.println("Deleting a node on Neo4j");
        return true;
    }
}
