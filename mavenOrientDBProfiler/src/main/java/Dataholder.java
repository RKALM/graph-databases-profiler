import java.text.SimpleDateFormat;
import java.util.Date;

public class Dataholder {

    //Variables for configuration of the system
    //Special features
    static boolean analyzer_allowed = false;

    //Intervals
    static boolean million_allowed = false; //if true the system uses 1 million intervals as well
    static boolean N100k_allowed = false; //if true the system uses 100k intervals as well
    static boolean N10k_allowed = false; //if true the system uses 10k intervals as well
    static boolean N1000_allowed = false; //if true the system uses 1000 intervals as well
    static boolean N100_allowed = false; //if true the system uses 100 intervals as well


    //Access to databases
    static boolean databases_allowed = false; //when true allows connection to the databases
    static boolean neo4j_script_test = false; //only for the CRUD part. the scripts will run with print statement
    static boolean graphdb_script_test = false; //only for the CRUD part. the scripts will run with print statement
    static boolean orientdb_script_test = false; //only for the CRUD part. the scripts will run with print statement

    //Global Variables
    static int round = 0;
    static int indicatorN = 0;
    static int countAddition = 0;
    static int countDeletion = 0;
    static int countUpdate = 0;
    static String customSeed = "yolo1";
    static String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    static String dateSeed = date.replace("-", "");

    //Dataholders
    static Neo4jDB neo4j;

}
