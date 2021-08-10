public class Graphdbcrud {

    //CREATE operation on GraphDB. It returns to indicate that is has complete its cycle.
    static boolean create(){
        if(Dataholder.databases_allowed){
            if(Dataholder.graphdb_script_test){
                //run the database
                //System.out.println("(DB) Creating a node on GraphDB");
                GraphDbDB.createANode();
                return true;
            } else {
                //print a statement
                System.out.println("Creating a node on GraphDB");
                return true;
            }
        } else {
            //print a statement
            System.out.println("Creating a node on GraphDB");
            return true;
        }

    }

    //UPDATE operation on GraphDB. It returns to indicate that is has complete its cycle.
    static boolean update(){
        if(Dataholder.databases_allowed){
            if(Dataholder.graphdb_script_test){
                //run the database
                //System.out.println("(DB) Updating a node on GraphDB");
                GraphDbDB.deleteANode();
                GraphDbDB.updateANode();
                return true;
            } else {
                //print a statement
                System.out.println("Updating a node on GraphDB");
                return true;
            }
        } else {
            //print a statement
            System.out.println("Updating a node on GraphDB");
            return true;
        }
    }

    //DELETE operation on GraphDB. It returns to indicate that is has complete its cycle.
    static boolean delete(){
        if(Dataholder.databases_allowed){
            if(Dataholder.graphdb_script_test){
                //run the database
                //System.out.println("(DB) Deleting a node on GraphDB");
                GraphDbDB.deleteANode();
                return true;
            } else {
                //print a statement
                System.out.println("Deleting a node on GraphDB");
                return true;
            }
        } else {
            //print a statement
            System.out.println("Deleting a node on GraphDB");
            return true;
        }
    }
}
