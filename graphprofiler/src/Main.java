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
                System.out.println("Running " + crud + " operation on the GraphDB #" + x);
            } else if(graphDatabse.equalsIgnoreCase("orientdb")){
                //run orientdb script
                System.out.println("Running " + crud + " operation on the OrientDB #" + x);
            } else {
                //run neo4j script
                System.out.println("Running " + crud + " operation on the Neo4j #" + x);
            }
        }
    }
}
