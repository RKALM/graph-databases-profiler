import java.util.Scanner;

public class Main {
    static int repetititons = 10; //the number of repetitions of the operation. for accuracy
    static String crud = "create"; //create, delete or update
    static String graphDatabse = "neo4j"; //neo4j, graphdb pr orientdb
    public static Scanner in = new Scanner(System.in);

    //========== Stuff for the timers ========================
    private static Timer genericTimer = new Timer();
    private static Timer timer10N = new Timer();
    private static Timer timer100N = new Timer();
    private static Timer timer1000N = new Timer();
    private static Timer timer10000N = new Timer();
    private static Timer timer100000N = new Timer();
    private static Timer timer1000000N = new Timer();
    public static long[] times10n;
    public static long[] times100n;
    public static long[] times1000n;
    public static long[] times10000n;
    public static long[] times100000n;
    public static long[] times1000000n;

    public static void main(String args[]) {
        System.out.println("Welcome to profiler");
        System.out.println("===================");
        menu();
        run();
        displayer();
    }

    public static void menu() {
        System.out.println("How many repetitions, (for accuracy) you wish to do?");
        repetititons = Integer.parseInt(in.nextLine());
        int numberOfSamples = repetititons;
        times10n = new long[numberOfSamples];
        times100n = new long[numberOfSamples];
        times1000n = new long[numberOfSamples];
        times10000n = new long[numberOfSamples];
        times100000n = new long[numberOfSamples];
        times1000000n = new long[numberOfSamples];
        System.out.println("You decided to run " + repetititons + " repetitions");

        //Declaring the protocol
        System.out.println("Which protocol do you wish to use: ");
        System.out.println("===================");
        System.out.println("[1]Neo4j");
        System.out.println("[2]GraphDB");
        System.out.println("[3]OrientDB");
        String val = in.nextLine();
        if (val.equalsIgnoreCase("3")) {
            graphDatabse = "orientdb";
        } else if (val.equalsIgnoreCase("2")) {
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
        if (val2.equalsIgnoreCase("3")) {
            crud = "update";
        } else if (val2.equalsIgnoreCase("2")) {
            crud = "delete";
        } else {
            crud = "create";
        }
        System.out.println("You decided to run " + repetititons + " repetitions for " + graphDatabse + " database" +
                " and the " + crud + " operation");

    } //end of menu

    static void run() {
        for (int x = 0; x < repetititons; x++) {
            if (graphDatabse.equalsIgnoreCase("graphdb")) {
                //run graphdb script
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("Running " + crud + " operations on the GraphDB Round #" + x);
                System.out.println("=================================================");
                scriptGraphDB(crud, x);
            } else if (graphDatabse.equalsIgnoreCase("orientdb")) {
                //run orientdb script
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("Running " + crud + " operations on the OrientDB Round #" + x);
                System.out.println("=================================================");
                scriptOrientDB(crud, x);
            } else {
                //run neo4j script
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("=================================================");
                System.out.println("Running " + crud + " operations on the Neo4j Round #" + x);
                System.out.println("=================================================");
                scriptNeo4j(crud, x);
            }
        }
    } //end of run

    //displayer is used to display the results of the profiling to the console
    static void displayer(){
        //final test display of the arrays.
        System.out.println("Displaying the times10n array of " + graphDatabse + ": ");
        for (long x : times10n) {
            if (x >= 0) {
                System.out.println(x);
            }
        }
        System.out.println("Displaying the times100n arrayof " + graphDatabse + ": ");
        for (long x : times100n) {
            if (x >= 0) {
                System.out.println(x);
            }
        }

        System.out.println("Displaying the times1000n arrayof " + graphDatabse + ": ");
        for (long x : times1000n) {
            if (x >= 0) {
                System.out.println(x);
            }
        }

        System.out.println("Displaying the times10000n arrayof " + graphDatabse + ": ");
        for (long x : times10000n) {
            if (x >= 0) {
                System.out.println(x);
            }
        }

        System.out.println("Displaying the times100000n arrayof " + graphDatabse + ": ");
        for (long x : times100000n) {
            if (x >= 0) {
                System.out.println(x);
            }
        }
    }


    //=============================== Neo4j Scripts ========================================
    //running a specific CRUD script on Neo4j for several intervals. it should store the statistics for each one.
    static void scriptNeo4j(String operation, int Xint) {
        System.out.println("Running " + operation + " script on the Neo4j for several intervals");
        System.out.println("=================================================");
        //10N
        //timer10N.startTimer();
        //scriptNeo4jNtimes(operation, 10);
        //timer10N.stopTimer();
        //long time10n = timer10N.getTime();
        long time10n = scriptNeo4jNtimes(operation, 10);
        if (time10n < 0) {
            times10n[Xint] = 0;
        } else {
            times10n[Xint] = time10n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for Neo4j 10N is " + times10n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //100N
        long time100n = scriptNeo4jNtimes(operation, 100);
        if (time100n < 0) {
            times100n[Xint] = 0;
        } else {
            times100n[Xint] = time100n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for Neo4j 100N is " + times100n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //1000N
        long time1000n = scriptNeo4jNtimes(operation, 1000);
        if (time1000n < 0) {
            times1000n[Xint] = 0;
        } else {
            times1000n[Xint] = time1000n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for Neo4j 1000N is " + times1000n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //10000N
        long time10000n = scriptNeo4jNtimes(operation, 10000);
        if (time10000n < 0) {
            times10000n[Xint] = 0;
        } else {
            times10000n[Xint] = time10000n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for Neo4j 10000N is " + times10000n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //100000N
        long time100000n = scriptNeo4jNtimes(operation, 100000);
        if (time100000n < 0) {
            times100000n[Xint] = 0;
        } else {
            times100000n[Xint] = time100000n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for Neo4j 100000N is " + times100000n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

    }

    //running a specific CRUD operation on Neo4j for N times. it should return the time that was taken
    static long scriptNeo4jNtimes(String operation, int N) {
        Timer genericTimer2 = new Timer();
        System.out.println(" ");
        System.out.println("Running " + operation + " script on the Neo4j for " + N + " operations");
        System.out.println("===========================");
        genericTimer2.startTimer();
        for (int x = 0; x < N; x++) {
            System.out.println("Running " + operation + " operation #" + x + " on Neo4j");
        }
        genericTimer2.stopTimer();
        return genericTimer2.getTime();
    }
    //=============================== End of Neo4j Scripts ========================================


    //=============================== GraphDB Scripts ========================================
    //running a specific CRUD script on GraphDB for several intervals. it should store the statistics for each one.
    static void scriptGraphDB(String operation, int Xint) {
        System.out.println("Running " + operation + " script on the GraphDB for several intervals");
        System.out.println("=================================================");
        //10N
        long time10n = scriptGraphDBNtimes(operation, 10);
        if (time10n < 0) {
            times10n[Xint] = 0;
        } else {
            times10n[Xint] = time10n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for GraphDB 10N is " + times10n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //100N
        long time100n = scriptGraphDBNtimes(operation, 100);
        if (time100n < 0) {
            times100n[Xint] = 0;
        } else {
            times100n[Xint] = time100n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for GraphDB 100N is " + times100n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //1000N
        long time1000n = scriptGraphDBNtimes(operation, 1000);
        if (time1000n < 0) {
            times1000n[Xint] = 0;
        } else {
            times1000n[Xint] = time1000n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for GraphDB 1000N is " + times1000n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //10000N
        long time10000n = scriptGraphDBNtimes(operation, 10000);
        if (time10000n < 0) {
            times10000n[Xint] = 0;
        } else {
            times10000n[Xint] = time10000n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for GraphDB 10000N is " + times10000n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //100000N
        long time100000n = scriptGraphDBNtimes(operation, 100000);
        if (time100000n < 0) {
            times100000n[Xint] = 0;
        } else {
            times100000n[Xint] = time100000n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for GraphDB 100000N is " + times100000n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

    }

    //running a specific CRUD operation on GraphDB for N times. it should return the time that was taken
    static long scriptGraphDBNtimes(String operation, int N) {
        Timer genericTimer2 = new Timer();
        System.out.println(" ");
        System.out.println("Running " + operation + " script on the GraphDB for " + N + " operations");
        System.out.println("===========================");
        genericTimer2.startTimer();
        for (int x = 0; x < N; x++) {
            System.out.println("Running " + operation + " operation #" + x + " on GraphDB");
        }
        genericTimer2.stopTimer();
        return genericTimer2.getTime();
    }
//=============================== End of GraphDB Scripts ========================================

    //=============================== OrientDB Scripts ========================================
    //running a specific CRUD script on OrientDB for several intervals. it should store the statistics for each one.
    static void scriptOrientDB(String operation, int Xint) {
        System.out.println("Running " + operation + " script on the OrientDB for several intervals");
        System.out.println("=================================================");
        //10N
        long time10n = scriptOrientDBNtimes(operation, 10);
        if (time10n < 0) {
            times10n[Xint] = 0;
        } else {
            times10n[Xint] = time10n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for OrientDB 10N is " + times10n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //100N
        long time100n = scriptOrientDBNtimes(operation, 100);
        if (time100n < 0) {
            times100n[Xint] = 0;
        } else {
            times100n[Xint] = time100n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for OrientDB 100N is " + times100n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //1000N
        long time1000n = scriptOrientDBNtimes(operation, 1000);
        if (time1000n < 0) {
            times1000n[Xint] = 0;
        } else {
            times1000n[Xint] = time1000n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for OrientDB 1000N is " + times1000n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //10000N
        long time10000n = scriptOrientDBNtimes(operation, 10000);
        if (time10000n < 0) {
            times10000n[Xint] = 0;
        } else {
            times10000n[Xint] = time10000n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for OrientDB 10000N is " + times10000n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

        //100000N
        long time100000n = scriptOrientDBNtimes(operation, 100000);
        if (time100000n < 0) {
            times100000n[Xint] = 0;
        } else {
            times100000n[Xint] = time100000n;
        }
        System.out.println("=================================================");
        System.out.println("Recorded time for OrientDB 100000N is " + times100000n[Xint]);
        System.out.println("=================================================");
        System.out.println("");

    }

    //running a specific CRUD operation on OrientDB for N times. it should return the time that was taken
    static long scriptOrientDBNtimes(String operation, int N) {
        Timer genericTimer2 = new Timer();
        System.out.println(" ");
        System.out.println("Running " + operation + " script on the OrientDB for " + N + " operations");
        System.out.println("===========================");
        genericTimer2.startTimer();
        for (int x = 0; x < N; x++) {
            System.out.println("Running " + operation + " operation #" + x + " on OrientDB");
        }
        genericTimer2.stopTimer();
        return genericTimer2.getTime();
    }
//=============================== End of OrientDB Scripts ========================================

}