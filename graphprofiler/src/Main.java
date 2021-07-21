import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static int repetititons = 10; //the number of repetitions of the operation. for accuracy
    static String crud = "create"; //create, delete or update
    static String graphDatabse = "neo4j"; //neo4j, graphdb pr orientdb
    public static Scanner in = new Scanner(System.in);
    private static final NumberFormat formatter = new DecimalFormat("#0.000000000");

    //========== Stuff for the timers ========================
    //private static Timer genericTimer = new Timer(); //legacy code
    //private static Timer timer10N = new Timer(); //legacy code

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

    //the user makes his choices
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

    //the scripts run
    static void run() {
        for (int x = 0; x < repetititons; x++) {
            Dataholder.round = x;
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
        long sum10n = 0;
        long sum100n = 0;
        long sum1000n = 0;
        long sum10000n = 0;
        long sum100000n = 0;
        long sum1000000n = 0;

        //final test display of the arrays.
        System.out.println("Displaying the times10n array of " + graphDatabse + ": ");
        for (long x : times10n) {
            if (x >= 0) {
                sum10n = sum10n + x;
                System.out.println(x);
            }
        }
        if(Dataholder.N100_allowed){
            System.out.println("Displaying the times100n arrayof " + graphDatabse + ": ");
            for (long x : times100n) {
                if (x >= 0) {
                    sum100n = sum100n + x;
                    System.out.println(x);
                }
            }

            if(Dataholder.N1000_allowed){
                System.out.println("Displaying the times1000n arrayof " + graphDatabse + ": ");
                for (long x : times1000n) {
                    if (x >= 0) {
                        sum1000n = sum1000n + x;
                        System.out.println(x);
                    }
                }

                if(Dataholder.N10k_allowed){
                    System.out.println("Displaying the times10000n arrayof " + graphDatabse + ": ");
                    for (long x : times10000n) {
                        if (x >= 0) {
                            sum10000n = sum10000n + x;
                            System.out.println(x);
                        }
                    }

                    if(Dataholder.N100k_allowed){
                        System.out.println("Displaying the times100000n arrayof " + graphDatabse + ": ");
                        for (long x : times100000n) {
                            if (x >= 0) {
                                sum100000n = sum100000n + x;
                                System.out.println(x);
                            }
                        }

                        if (Dataholder.million_allowed){
                            System.out.println("Displaying the times1000000n arrayof " + graphDatabse + ": ");
                            for (long x : times1000000n) {
                                if (x >= 0) {
                                    sum1000000n = sum1000000n + x;
                                    System.out.println(x);
                                }
                            }
                        } //if (Dataholder.million_allowed) ends here
                    } //if Dataholder.N100k_allowed ends here
                } //if Dataholder.N10k_allowed ends here
            } //if Dataholder.N1000_allowed ends here
        } //if Dataholder.N100_allowed ends here

        //finding the average times
        long avg10n = sum10n / repetititons;
        long avg100n = sum100n / repetititons;
        long avg1000n = sum1000n / repetititons;
        long avg10000n = sum10000n / repetititons;
        long avg100000n = sum100000n / repetititons;
        long avg1000000n = sum1000000n / repetititons;

        //turning the averages into seconds
        String avg10nsec = formatter.format(avg10n / 1000000000d);
        String avg100nsec = formatter.format(avg100n / 1000000000d);
        String avg1000nsec = formatter.format(avg1000n / 1000000000d);
        String avg10000nsec = formatter.format(avg10000n / 1000000000d);
        String avg100000nsec = formatter.format(avg100000n / 1000000000d);
        String avg1000000nsec = formatter.format(avg1000000n / 1000000000d);

        //Displaying the average times in nanoseconds
        System.out.println("");
        System.out.println("Database:" + graphDatabse + " Repetitions:" + repetititons + " Operations:" + crud);
        System.out.println("===========================================================");
        System.out.println("The average time of 10 " + crud + " operations is: " + avg10n + " nanoseconds");
        if(Dataholder.N100_allowed){
            System.out.println("The average time of 100 " + crud + " operations is: " + avg100n + " nanoseconds");
            if(Dataholder.N100k_allowed){
                System.out.println("The average time of 1000 " + crud + " operations is: " + avg1000n + " nanoseconds");
                if(Dataholder.N10k_allowed){
                    System.out.println("The average time of 10000 " + crud + " operations is: " + avg10000n + " nanoseconds");
                    if(Dataholder.N100k_allowed){
                        System.out.println("The average time of 100000 " + crud + " operations is: " + avg100000n + " nanoseconds");
                        if (Dataholder.million_allowed){
                            System.out.println("The average time of 1000000 " + crud + " operations is: " + avg1000000n + " nanoseconds");
                        } //if (Dataholder.million_allowed) ends here
                    } //if Dataholder.N100k_allowed ends here
                } //if Dataholder.N10k_allowed ends here
            } //if Dataholder.N1000_allowed ends here
        } //if Dataholder.N100_allowed ends here

        //Displaying the average times in nanoseconds
        System.out.println("");
        System.out.println("Database:" + graphDatabse + " Repetitions:" + repetititons + " Operations:" + crud);
        System.out.println("===========================================================");
        System.out.println("The average time of 10 " + crud + " operations is: " + avg10nsec + " seconds");
        if(Dataholder.N100_allowed){
            System.out.println("The average time of 100 " + crud + " operations is: " + avg100nsec + " seconds");
            if(Dataholder.N1000_allowed){
                System.out.println("The average time of 1000 " + crud + " operations is: " + avg1000nsec + " seconds");
                if(Dataholder.N10k_allowed){
                    System.out.println("The average time of 10000 " + crud + " operations is: " + avg10000nsec + " seconds");
                    if(Dataholder.N100k_allowed){
                        System.out.println("The average time of 100000 " + crud + " operations is: " + avg100000nsec + " seconds");
                        if (Dataholder.million_allowed){
                            System.out.println("The average time of 1000000 " + crud + " operations is: " + avg1000000nsec + " seconds");
                        } //if (Dataholder.million_allowed) ends here
                    } //if Dataholder.N100k_allowed ends here
                } //if Dataholder.N10k_allowed ends here
            } //if Dataholder.N1000_allowed ends here
        } //if Dataholder.N100_allowed ends here
    } //The displayer() ends here


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

        if(Dataholder.N100_allowed){
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

            if(Dataholder.N1000_allowed){
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

                if(Dataholder.N10k_allowed){
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

                    if(Dataholder.N100k_allowed){
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

                        //1000000N
                        if (Dataholder.million_allowed){
                            long time1000000n = scriptNeo4jNtimes(operation, 1000000);
                            if (time1000000n < 0) {
                                times1000000n[Xint] = 0;
                            } else {
                                times1000000n[Xint] = time1000000n;
                            }
                            System.out.println("=================================================");
                            System.out.println("Recorded time for Neo4j 1000000N is " + times1000000n[Xint]);
                            System.out.println("=================================================");
                            System.out.println("");
                        } //if (Dataholder.million_allowed) ends here
                    } //if Dataholder.N100k_allowed ends here
                } //if Dataholder.N10k_allowed ends here
            } //if Dataholder.N1000_allowed ends here
        } //if Dataholder.N100_allowed ends here

    } //The ScriptNeo4j ends here

    //running a specific CRUD operation on Neo4j for N times. it should return the time that was taken
    static long scriptNeo4jNtimes(String operation, int N) {
        Dataholder.indicatorN = N;
        Timer genericTimer2 = new Timer();
        System.out.println(" ");
        System.out.println("Running " + operation + " script on the Neo4j for " + N + " operations");
        System.out.println("===========================");
        genericTimer2.startTimer();
        if(operation.equalsIgnoreCase("create")){
            for (int x = 0; x < N; x++) {
                Dataholder.countAddition = x;
                Neo4jcrud.create();
            }
        } else if(operation.equalsIgnoreCase("update")){
            for (int x = 0; x < N; x++) {
                Dataholder.countUpdate = x;
                Neo4jcrud.update();
            }
        } else {
            for (int x = 0; x < N; x++) {
                Dataholder.countDeletion = x;
                Neo4jcrud.delete();
            }
        }
//        for (int x = 0; x < N; x++) {
//            System.out.println("Running " + operation + " operation #" + x + " on Neo4j");
//        }
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

        if(Dataholder.N100_allowed){
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

            if(Dataholder.N1000_allowed){
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

                if(Dataholder.N10k_allowed){
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

                    if(Dataholder.N100k_allowed){
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

                        //1000000N
                        if (Dataholder.million_allowed){
                            long time1000000n = scriptGraphDBNtimes(operation, 1000000);
                            if (time1000000n < 0) {
                                times1000000n[Xint] = 0;
                            } else {
                                times1000000n[Xint] = time1000000n;
                            }
                            System.out.println("=================================================");
                            System.out.println("Recorded time for GraphDB 1000000N is " + times1000000n[Xint]);
                            System.out.println("=================================================");
                            System.out.println("");
                        } //if (Dataholder.million_allowed) ends here
                    } //if Dataholder.N100k_allowed ends here
                } //if Dataholder.N10k_allowed ends here
            } //if Dataholder.N1000_allowed ends here
        } //if Dataholder.N100_allowed ends here

    } //The scriptGraphDB() ends here

    //running a specific CRUD operation on GraphDB for N times. it should return the time that was taken
    static long scriptGraphDBNtimes(String operation, int N) {
        Dataholder.indicatorN = N;
        Timer genericTimer2 = new Timer();
        System.out.println(" ");
        System.out.println("Running " + operation + " script on the GraphDB for " + N + " operations");
        System.out.println("===========================");
        genericTimer2.startTimer();
        if(operation.equalsIgnoreCase("create")){
            for (int x = 0; x < N; x++) {
                Dataholder.countAddition = x;
                Graphdbcrud.create();
            }
        } else if(operation.equalsIgnoreCase("update")){
            for (int x = 0; x < N; x++) {
                Dataholder.countUpdate = x;
                Graphdbcrud.update();
            }
        } else {
            for (int x = 0; x < N; x++) {
                Dataholder.countDeletion = x;
                Graphdbcrud.delete();
            }
        }
//        for (int x = 0; x < N; x++) {
//            System.out.println("Running " + operation + " operation #" + x + " on GraphDB");
//        }
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

        if(Dataholder.N100_allowed){
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

            if(Dataholder.N1000_allowed){
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

                if(Dataholder.N10k_allowed){
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

                    if(Dataholder.N100k_allowed){
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

                        //1000000N
                        if (Dataholder.million_allowed){
                            long time1000000n = scriptOrientDBNtimes(operation, 1000000);
                            if (time1000000n < 0) {
                                times1000000n[Xint] = 0;
                            } else {
                                times1000000n[Xint] = time1000000n;
                            }
                            System.out.println("=================================================");
                            System.out.println("Recorded time for OrientDB 1000000N is " + times1000000n[Xint]);
                            System.out.println("=================================================");
                            System.out.println("");
                        } //if (Dataholder.million_allowed) ends here
                    } //if Dataholder.N100k_allowed ends here
                } //if Dataholder.N10k_allowed ends here
            } //if Dataholder.N1000_allowed ends here
        } //if Dataholder.N100_allowed ends here

    } //The ScriptOrientDB() ends here

    //running a specific CRUD operation on OrientDB for N times. it should return the time that was taken
    static long scriptOrientDBNtimes(String operation, int N) {
        Dataholder.indicatorN = N;
        Timer genericTimer2 = new Timer();
        System.out.println(" ");
        System.out.println("Running " + operation + " script on the OrientDB for " + N + " operations");
        System.out.println("===========================");
        genericTimer2.startTimer();
        if(operation.equalsIgnoreCase("create")){
            for (int x = 0; x < N; x++) {
                Dataholder.countAddition = x;
                Orientdbcrud.create();
            }
        } else if(operation.equalsIgnoreCase("update")){
            for (int x = 0; x < N; x++) {
                Dataholder.countUpdate = x;
                Orientdbcrud.update();
            }
        } else {
            for (int x = 0; x < N; x++) {
                Dataholder.countDeletion = x;
                Orientdbcrud.delete();
            }
        }
//        for (int x = 0; x < N; x++) {
//            System.out.println("Running " + operation + " operation #" + x + " on OrientDB");
//        }
        genericTimer2.stopTimer();
        return genericTimer2.getTime();
    }
//=============================== End of OrientDB Scripts ========================================

}