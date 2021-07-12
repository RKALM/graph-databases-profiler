import java.util.Scanner;

public class Main {
    static int standarrepetitions = 10; //the statistical repetitions for accurancy. How many times the program will run.
    static int repetititons = 100; //the number of repetitions of the operation
    static String crud = "create"; //create, delete or update
    static String graphDatabse = "neo4j"; //neo4j, graphdb pr orientdb
    public static Scanner in = new Scanner( System.in);

    public static void main(String args[]){
        System.out.println("Welcome to profiler");
        System.out.println("===================");
        menu();
    }

    public static void menu(){
        System.out.println("How many repetitions you wish to do?");
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

    }
}
