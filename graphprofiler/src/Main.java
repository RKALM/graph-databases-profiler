import java.util.Scanner;

public class Main {
    static int repetititons = 10; //the number of repetitions
    static String crud = "create"; //create, remove or update
    static String graphDatabse = "neo4j"; //neo4j, graphdb pr orientdb
    public static Scanner in = new Scanner( System.in);

    public static void main(String args[]){
        System.out.println("Welcome to profiler");
        System.out.println("===================");
        menu();
    }

    public static void menu(){
        System.out.println("How many repetitions you wish to do?");
        repetititons = in.nextInt();
        System.out.println("You decided to run " + repetititons + " repetitions");


    }
}
