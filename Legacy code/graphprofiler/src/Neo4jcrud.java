public class Neo4jcrud {

    //CREATE operation on Neo4j. It returns to indicate that is has complete its cycle.
    static boolean create(){
        //do something
        if(Dataholder.databases_allowed){
            if(Dataholder.neo4j_script_test){
                //run the database
                Neo4jDB neo4j = new Neo4jDB( "bolt://localhost:7687", "profiler", "profiler" );
                boolean tmp = neo4j.createANode(Dataholder.round + "" + Dataholder.indicatorN + "" + Dataholder.countAddition);
                //System.out.println("Creating a node on Neo4j");
                return true;
            } else {
                //print a statement
                System.out.println("Creating a node on Neo4j");
                return true;
            }
        } else {
            //print a statement
            System.out.println("Creating a node on Neo4j");
            return true;
        }
//        Neo4jDB neo4j = new Neo4jDB( "bolt://localhost:7687", "profiler", "profiler" );
//        neo4j.createANodeTest("Creating a node on Neo4j");
//        System.out.println("Creating a node on Neo4j");
//        return true;
    }

    //CREATE operation on Neo4j. It returns to indicate that is has complete its cycle.
    static boolean createOneNode(){
        //do something
        if(Dataholder.databases_allowed){
            if(Dataholder.neo4j_script_test){
                //run the database
                Neo4jDB neo4j = new Neo4jDB( "bolt://localhost:7687", "profiler", "profiler" );
                boolean tmp = neo4j.createANode("toUpdateit");
                //System.out.println("Creating a node on Neo4j");
                return true;
            } else {
                //print a statement
                System.out.println("Creating a node on Neo4j");
                return true;
            }
        } else {
            //print a statement
            System.out.println("Creating a node on Neo4j");
            return true;
        }
//        Neo4jDB neo4j = new Neo4jDB( "bolt://localhost:7687", "profiler", "profiler" );
//        neo4j.createANodeTest("Creating a node on Neo4j");
//        System.out.println("Creating a node on Neo4j");
//        return true;
    }

    //UPDATE operation on Neo4j. It returns to indicate that is has complete its cycle.
    static boolean update(){
        if(Dataholder.databases_allowed){
            if(Dataholder.neo4j_script_test){
                //run the database
                Neo4jDB neo4j = new Neo4jDB( "bolt://localhost:7687", "profiler", "profiler" );
                String msg = "toUpdateit";
                boolean tmp = neo4j.updateANode(msg);
                return true;
            } else {
                //print a statement
                System.out.println("Updating a node on Neo4j");
                return true;
            }
        } else {
            //print a statement
            System.out.println("Updating a node on Neo4j");
            return true;
        }

    }

    //DELETE operation on Neo4j. It returns to indicate that is has complete its cycle.
    static boolean delete(){
        if(Dataholder.databases_allowed){
            if(Dataholder.neo4j_script_test){
                //run the database
                Neo4jDB neo4j = new Neo4jDB( "bolt://localhost:7687", "profiler", "profiler" );
                boolean tmp = neo4j.deleteANode(Dataholder.round + "" + Dataholder.indicatorN + "" + Dataholder.countDeletion);
                //System.out.println("(DB)Deleting a node on Neo4j");
                return true;
            } else {
                //print a statement
                System.out.println("Deleting a node on Neo4j");
                return true;
            }
        } else {
            //print a statement
            System.out.println("Deleting a node on Neo4j");
            return true;
        }
    }

    //DELETE operation on Neo4j. It returns to indicate that is has complete its cycle.
    static boolean deleteOne(){
        if(Dataholder.databases_allowed){
            if(Dataholder.neo4j_script_test){
                //run the database
                Neo4jDB neo4j = new Neo4jDB( "bolt://localhost:7687", "profiler", "profiler" );
                boolean tmp = neo4j.deleteANode("toUpdateit");
                //System.out.println("(DB)Deleting a node on Neo4j");
                return true;
            } else {
                //print a statement
                System.out.println("Deleting a node on Neo4j");
                return true;
            }
        } else {
            //print a statement
            System.out.println("Deleting a node on Neo4j");
            return true;
        }
    }
}
