public class Dataholder {

    //Variables for configuration of the system
    //Intervals
    static boolean million_allowed = false; //if true the system uses 1 million intervals as well
    static boolean N100k_allowed = false; //if true the system uses 100k intervals as well
    static boolean N10k_allowed = false; //if true the system uses 10k intervals as well
    static boolean N1000_allowed = false; //if true the system uses 1000 intervals as well
    static boolean N100_allowed = false; //if true the system uses 100 intervals as well


    //Access to databases
    static boolean databases_allowed = true; //when true allows connection to the databases
    static boolean neo4j_script_test = false; //only for the CRUD part. the scripts will run with print statement
    static boolean graphdb_script_test = true; //only for the CRUD part. the scripts will run with print statement
    static boolean orientdb_script_test = false; //only for the CRUD part. the scripts will run with print statement

    //Global Variables
    static int round = 0;
    static int indicatorN = 0;
    static int countAddition = 0;
    static int countDeletion = 0;
    static int countUpdate = 0;

}
