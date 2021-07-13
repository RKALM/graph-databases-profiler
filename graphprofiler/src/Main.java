import java.util.Scanner;

public class Main {
    static int repetititons = 10; //the number of repetitions of the operation. for accuracy
    static String crud = "create"; //create, delete or update
    static String graphDatabse = "neo4j"; //neo4j, graphdb pr orientdb
    public static Scanner in = new Scanner( System.in);

    public static void main(String args[]){
        System.out.println("Welcome to profiler");
        System.out.println("===================");
        menu();
        run();
    }

    public static void menu(){
        System.out.println("How many repetitions, (for accuracy) you wish to do?");
        repetititons = Integer.parseInt(in.nextLine());
        System.out.println("You decided to run " + repetititons + " repetitions");

        //Declaring the protocol
        System.out.println("Which protocol do you wish to use: ");
        System.out.println("===================");
        System.out.println("[1]Neo4j");
        System.out.println("[2]GraphDB");
        System.out.println("[3]OrientDB");
        String val = in.nextLine();
        if(val.equalsIgnoreCase("3")){
            graphDatabse = "orientdb";
        } else if(val.equalsIgnoreCase("2")){
            graphDatabse = "graphdb";
        } else {
            graphDatabse = "neo4j";
        }
        System.out.println("[1]Neo4j");
        System.out.println("[2]GraphDB");
        System.out.println("[3]OrientDB");

        //Declaring the CRUD operation
        System.out.println("Which protocol do you wish to use: ");
        System.out.println("===================");
        System.out.println("[1]Create");
        System.out.println("[2]Delete");
        System.out.println("[3]Update");
        String val2 = in.nextLine();
        if(val2.equalsIgnoreCase("3")){
            crud = "update";
        } else if(val2.equalsIgnoreCase("2")){
            crud = "delete";
        } else {
            crud = "create";
        }
        System.out.println("You decided to run " + repetititons + " repetitions for " + graphDatabse + " database" +
                " and the " + crud + " operation");

    } //end of menu

    static void run(){
        for(int x = 0; x<repetititons; x++){
            if(graphDatabse.equalsIgnoreCase("graphdb")){
                //run graphdb script
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("Running " + crud + " operations on the GraphDB Round #" + x);
                System.out.println("=================================================");
                scriptGraphDB(crud);
            } else if(graphDatabse.equalsIgnoreCase("orientdb")){
                //run orientdb script
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("Running " + crud + " operations on the OrientDB Round #" + x);
                System.out.println("=================================================");
                scriptOrientDB(crud);
            } else {
                //run neo4j script
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("Running " + crud + " operations on the Neo4j Round #" + x);
                System.out.println("=================================================");
                scriptNeo4j(crud);
            }
        }
    } //end of run


    //=============================== Neo4j Scripts ========================================
    //running a specific CRUD script on Neo4j for several intervals. it should store the statistics for each one.
    static void scriptNeo4j(String operation){
        System.out.println("Running " + operation + " script on the Neo4j for several intervals");
        System.out.println("=================================================");
        scriptNeo4jNtimes(operation, 10);
        scriptNeo4jNtimes(operation, 100);

    }

    //running a specific CRUD operation on Neo4j for N times. it should return the time that was taken
    static void scriptNeo4jNtimes(String operation, int N){
        System.out.println(" ");
        System.out.println("Running " + operation + " script on the Neo4j for " + N + " operations");
        System.out.println("===========================");
        for(int x= 0; x<N; x++){
            System.out.println("Running " + operation + " operation #" + x + " on Neo4j");
        }
    }
    //=============================== End of Neo4j Scripts ========================================


    //=============================== GraphDB Scripts ========================================
    //running a specific CRUD script on GraphDB for several intervals. it should store the statistics for each one.
    static void scriptGraphDB(String operation){
        System.out.println("Running " + operation + " script on the GraphDB for several intervals");
        System.out.println("=================================================");
        scriptGraphDBNtimes(operation, 10);
        scriptGraphDBNtimes(operation, 100);

    }

    //running a specific CRUD operation on GraphDB for N times. it should return the time that was taken
    static void scriptGraphDBNtimes(String operation, int N){
        System.out.println(" ");
        System.out.println("Running " + operation + " script on the GraphDB for " + N + " operations");
        System.out.println("===========================");
        for(int x= 0; x<N; x++){
            System.out.println("Running " + operation + " operation #" + x + " on GraphDB");
        }
    }
    //=============================== End of GraphDB Scripts ========================================

    //=============================== OrientDB Scripts ========================================
    //running a specific CRUD script on OrientDB for several intervals. it should store the statistics for each one.
    static void scriptOrientDB(String operation){
        System.out.println("Running " + operation + " script on the OrientDB for several intervals");
        System.out.println("=================================================");
        scriptOrientDBNtimes(operation, 10);
        scriptOrientDBNtimes(operation, 100);

    }

    //running a specific CRUD operation on OrientDB for N times. it should return the time that was taken
    static void scriptOrientDBNtimes(String operation, int N){
        System.out.println(" ");
        System.out.println("Running " + operation + " script on the OrientDB for " + N + " operations");
        System.out.println("===========================");
        for(int x= 0; x<N; x++){
            System.out.println("Running " + operation + " operation #" + x + " on OrientDB");
        }
    }
    //=============================== End of OrientDB Scripts ========================================


}
